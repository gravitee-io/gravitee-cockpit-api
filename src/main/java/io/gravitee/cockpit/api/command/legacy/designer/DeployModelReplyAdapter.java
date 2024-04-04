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
package io.gravitee.cockpit.api.command.legacy.designer;

import io.gravitee.cockpit.api.command.legacy.CockpitReplyType;
import io.gravitee.exchange.api.command.CommandStatus;
import io.gravitee.exchange.api.command.ReplyAdapter;
import io.reactivex.rxjava3.core.Single;

public class DeployModelReplyAdapter
  implements
    ReplyAdapter<DeployModelReply, io.gravitee.cockpit.api.command.v1.designer.DeployModelReply> {

  @Override
  public String supportType() {
    return CockpitReplyType.DEPLOY_MODEL_REPLY.name();
  }

  @Override
  public Single<io.gravitee.cockpit.api.command.v1.designer.DeployModelReply> adapt(
    final String targetId,
    final DeployModelReply reply
  ) {
    return Single.fromCallable(() -> {
      if (reply.getCommandStatus() == CommandStatus.ERROR) {
        return new io.gravitee.cockpit.api.command.v1.designer.DeployModelReply(
          reply.getCommandId(),
          reply.getMessage()
        );
      } else {
        return new io.gravitee.cockpit.api.command.v1.designer.DeployModelReply(
          reply.getCommandId()
        );
      }
    });
  }
}
