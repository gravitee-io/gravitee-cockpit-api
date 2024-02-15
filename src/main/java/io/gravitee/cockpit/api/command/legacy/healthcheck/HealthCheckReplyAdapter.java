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
package io.gravitee.cockpit.api.command.legacy.healthcheck;

import io.gravitee.cockpit.api.command.v1.CockpitCommandType;
import io.gravitee.exchange.api.command.ReplyAdapter;
import io.reactivex.rxjava3.core.Single;

public class HealthCheckReplyAdapter
  implements
    ReplyAdapter<io.gravitee.cockpit.api.command.v1.node.healthcheck.NodeHealthCheckReply, HealthCheckReply> {

  @Override
  public String supportType() {
    return CockpitCommandType.NODE_HEALTHCHECK.name();
  }

  @Override
  public Single<HealthCheckReply> adapt(
    final io.gravitee.cockpit.api.command.v1.node.healthcheck.NodeHealthCheckReply reply
  ) {
    return Single.fromCallable(() -> {
      HealthCheckReply healthCheckReply = new HealthCheckReply(
        reply.getCommandId(),
        reply.getCommandStatus()
      );
      healthCheckReply.setMessage(reply.getErrorDetails());
      return healthCheckReply;
    });
  }
}
