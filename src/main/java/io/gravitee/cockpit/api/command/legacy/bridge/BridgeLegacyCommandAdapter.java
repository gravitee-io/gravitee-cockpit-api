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

import io.gravitee.cockpit.api.command.legacy.CockpitCommandType;
import io.gravitee.cockpit.api.command.v1.bridge.BridgeCommandPayload;
import io.gravitee.exchange.api.command.CommandAdapter;
import io.reactivex.rxjava3.core.Single;

public class BridgeLegacyCommandAdapter
  implements
    CommandAdapter<BridgeCommand, io.gravitee.cockpit.api.command.v1.bridge.BridgeCommand, BridgeReply> {

  @Override
  public String supportType() {
    return CockpitCommandType.BRIDGE_COMMAND.name();
  }

  @Override
  public Single<io.gravitee.cockpit.api.command.v1.bridge.BridgeCommand> adapt(
    final BridgeCommand command
  ) {
    return Single.fromCallable(() -> {
      BridgeCommandPayload bridgeCommandPayload = BridgeCommandPayload
        .builder()
        .target(command.getTarget())
        .environmentId(command.getEnvironmentId())
        .operation(command.getOperation())
        .organizationId(command.getOrganizationId())
        .content(command.getPayload().getContent())
        .timeoutMillis(command.getTimeoutMillis())
        .build();
      return new io.gravitee.cockpit.api.command.v1.bridge.BridgeCommand(
        command.getId(),
        bridgeCommandPayload
      );
    });
  }
}
