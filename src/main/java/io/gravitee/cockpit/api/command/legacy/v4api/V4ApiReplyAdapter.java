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
package io.gravitee.cockpit.api.command.legacy.v4api;

import io.gravitee.cockpit.api.command.legacy.CockpitReplyType;
import io.gravitee.cockpit.api.command.v1.v4api.V4ApiReplyPayload;
import io.gravitee.exchange.api.command.CommandStatus;
import io.gravitee.exchange.api.command.ReplyAdapter;
import io.reactivex.rxjava3.core.Single;

public class V4ApiReplyAdapter
  implements
    ReplyAdapter<V4ApiReply, io.gravitee.cockpit.api.command.v1.v4api.V4ApiReply> {

  @Override
  public String supportType() {
    return CockpitReplyType.V4_API_REPLY.name();
  }

  @Override
  public Single<io.gravitee.cockpit.api.command.v1.v4api.V4ApiReply> adapt(
    final String targetId,
    final V4ApiReply reply
  ) {
    return Single.fromCallable(() -> {
      if (reply.getCommandStatus() == CommandStatus.ERROR) {
        return new io.gravitee.cockpit.api.command.v1.v4api.V4ApiReply(
          reply.getCommandId(),
          reply.getMessage()
        );
      } else {
        return new io.gravitee.cockpit.api.command.v1.v4api.V4ApiReply(
          reply.getCommandId(),
          V4ApiReplyPayload
            .builder()
            .apiId(reply.getApiId())
            .apiName(reply.getApiName())
            .apiVersion(reply.getApiVersion())
            .build()
        );
      }
    });
  }
}
