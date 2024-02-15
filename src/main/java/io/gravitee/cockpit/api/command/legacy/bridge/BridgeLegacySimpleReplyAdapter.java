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

import io.gravitee.cockpit.api.command.legacy.CockpitReplyType;
import io.gravitee.cockpit.api.command.v1.bridge.BridgeReply;
import io.gravitee.cockpit.api.command.v1.bridge.BridgeReplyPayload;
import io.gravitee.exchange.api.command.ReplyAdapter;
import io.reactivex.rxjava3.core.Single;
import java.util.List;

public class BridgeLegacySimpleReplyAdapter
  implements ReplyAdapter<BridgeSimpleReply, BridgeReply> {

  @Override
  public String supportType() {
    return CockpitReplyType.BRIDGE_SIMPLE_REPLY.name();
  }

  @Override
  public Single<io.gravitee.cockpit.api.command.v1.bridge.BridgeReply> adapt(
    final BridgeSimpleReply reply
  ) {
    return Single.just(
      new io.gravitee.cockpit.api.command.v1.bridge.BridgeReply(
        reply.getCommandId(),
        new BridgeReplyPayload(
          List.of(
            BridgeReplyPayload.BridgeReplyContent
              .builder()
              .environmentId(reply.getEnvironmentId())
              .organizationId(reply.getOrganizationId())
              .installationId(reply.getInstallationId())
              .content(reply.getPayloadAsString())
              .build()
          )
        )
      )
    );
  }
}
