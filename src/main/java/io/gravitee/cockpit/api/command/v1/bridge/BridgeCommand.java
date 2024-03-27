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
package io.gravitee.cockpit.api.command.v1.bridge;

import io.gravitee.cockpit.api.command.v1.CockpitCommand;
import io.gravitee.cockpit.api.command.v1.CockpitCommandType;
import io.gravitee.cockpit.api.command.v1.hello.HelloCommandPayload;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Guillaume LAMIRAND (guillaume.lamirand at graviteesource.com)
 * @author GraviteeSource Team
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BridgeCommand extends CockpitCommand<BridgeCommandPayload> {

  public BridgeCommand() {
    super(CockpitCommandType.BRIDGE);
  }

  public BridgeCommand(final BridgeCommandPayload payload) {
    this();
    this.payload = payload;
  }

  public BridgeCommand(
    final String commandId,
    final BridgeCommandPayload payload
  ) {
    this();
    this.id = commandId;
    this.payload = payload;
  }
}
