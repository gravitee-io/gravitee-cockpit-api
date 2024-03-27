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

import io.gravitee.cockpit.api.command.legacy.CockpitCommand;
import io.gravitee.cockpit.api.command.legacy.CockpitCommandType;
import io.gravitee.cockpit.api.command.v1.bridge.BridgeCommandPayload;
import io.gravitee.cockpit.api.command.v1.designer.DeployModelCommandPayload;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Jeoffrey HAEYAERT (jeoffrey.haeyaert at graviteesource.com)
 * @author GraviteeSource Team
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BridgeCommand extends CockpitCommand<BridgePayload> {

  /**
   * The identifier of the installation the command is coming from.
   */
  private String installationId;

  /**
   * The identifier of the organization the command is coming from.
   */
  private String organizationId;

  /**
   * The identifier of the environment the command is coming from (optional).
   */
  private String environmentId;

  /**
   * An operation name which can give information about the nature of the payload.
   */
  private String operation;

  /**
   * The target environment or installation scopes.
   */
  private BridgeCommandPayload.BridgeTarget target;

  /**
   * The timeout in millisecond. Default is 10000 ms (10 sec).
   */
  private long timeoutMillis = 10000;

  public BridgeCommand() {
    super(CockpitCommandType.BRIDGE_COMMAND);
  }

  public BridgeCommand(final String commandId, final BridgePayload payload) {
    this();
    this.id = commandId;
    this.payload = payload;
  }
}
