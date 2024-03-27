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
package io.gravitee.cockpit.api.command.v1.environment;

import io.gravitee.cockpit.api.command.v1.CockpitCommand;
import io.gravitee.cockpit.api.command.v1.CockpitCommandType;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DisableEnvironmentCommand
  extends CockpitCommand<DisableEnvironmentCommandPayload> {

  public DisableEnvironmentCommand() {
    super(CockpitCommandType.DISABLE_ENVIRONMENT);
  }

  public DisableEnvironmentCommand(
    final DisableEnvironmentCommandPayload payload
  ) {
    this();
    this.payload = payload;
  }
}
