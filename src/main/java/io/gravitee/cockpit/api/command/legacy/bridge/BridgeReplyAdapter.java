/*
 * Copyright © 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.cockpit.api.command.legacy.bridge;

import io.gravitee.cockpit.api.command.v1.CockpitCommandType;
import io.gravitee.cockpit.api.command.v1.bridge.BridgeReplyPayload;
import io.gravitee.exchange.api.command.CommandStatus;
import io.gravitee.exchange.api.command.ReplyAdapter;
import io.reactivex.rxjava3.core.Single;
import java.util.List;

public class BridgeReplyAdapter
  implements
    ReplyAdapter<io.gravitee.cockpit.api.command.v1.bridge.BridgeReply, BridgeReply> {

  @Override
  public String supportType() {
    return CockpitCommandType.BRIDGE.name();
  }

  @Override
  public Single<BridgeReply> adapt(
    final String targetId,
    final io.gravitee.cockpit.api.command.v1.bridge.BridgeReply reply
  ) {
    return Single.fromCallable(() -> {
      BridgeReplyPayload replyPayload = reply.getPayload();
      if (
        replyPayload != null &&
        replyPayload.contents() != null &&
        !replyPayload.contents().isEmpty()
      ) {
        if (replyPayload.singleTarget()) {
          BridgeReplyPayload.BridgeReplyContent bridgeReplyContent =
            replyPayload.contents().get(0);
          return createSimpleReplyFrom(reply, bridgeReplyContent);
        } else {
          List<BridgeSimpleReply> simpleReplies = replyPayload
            .contents()
            .stream()
            .map(bridgeReplyContent ->
              createSimpleReplyFrom(reply, bridgeReplyContent)
            )
            .toList();
          return new BridgeMultiReply(
            reply.getCommandId(),
            reply.getCommandStatus(),
            simpleReplies
          );
        }
      }
      return new BridgeSimpleReply(
        reply.getCommandId(),
        reply.getCommandStatus(),
        reply.getErrorDetails()
      );
    });
  }

  private BridgeSimpleReply createSimpleReplyFrom(
    final io.gravitee.cockpit.api.command.v1.bridge.BridgeReply reply,
    final BridgeReplyPayload.BridgeReplyContent bridgeReplyContent
  ) {
    BridgeSimpleReply bridgeSimpleReply;
    if (bridgeReplyContent.isError()) {
      bridgeSimpleReply =
        new BridgeSimpleReply(
          reply.getCommandId(),
          CommandStatus.ERROR,
          "Unable to build to Bridge Reply"
        );
    } else {
      bridgeSimpleReply = new BridgeSimpleReply(reply.getCommandId());
    }
    bridgeSimpleReply.setInstallationId(bridgeReplyContent.getInstallationId());
    bridgeSimpleReply.setEnvironmentId(bridgeReplyContent.getEnvironmentId());
    bridgeSimpleReply.setOrganizationId(bridgeReplyContent.getOrganizationId());
    bridgeSimpleReply.setPayloadAsString(bridgeReplyContent.getContent());
    return bridgeSimpleReply;
  }
}
