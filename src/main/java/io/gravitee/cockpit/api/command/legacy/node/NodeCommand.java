/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.cockpit.api.command.legacy.node;

import io.gravitee.cockpit.api.command.legacy.CockpitCommand;
import io.gravitee.cockpit.api.command.legacy.CockpitCommandType;
import io.gravitee.cockpit.api.command.v1.node.NodeCommandPayload;

public class NodeCommand extends CockpitCommand<NodeCommandPayload> {

  public NodeCommand() {
    super(CockpitCommandType.NODE_COMMAND);
  }

  public NodeCommand(final String commandId) {
    super(CockpitCommandType.NODE_COMMAND);
    this.id = commandId;
  }
}
