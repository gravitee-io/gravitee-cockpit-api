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
package io.gravitee.cockpit.api.command.node;

import io.gravitee.cockpit.api.command.CommandStatus;
import io.gravitee.cockpit.api.command.Reply;

public class NodeReply extends Reply {

  public NodeReply() {
    super(Type.NODE_REPLY);
  }

  public NodeReply(String commandId, CommandStatus commandStatus) {
    super(Type.NODE_REPLY, commandId, commandStatus);
  }
}
