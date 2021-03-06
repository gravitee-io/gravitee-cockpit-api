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
package io.gravitee.cockpit.api.command.echo;

import io.gravitee.cockpit.api.command.CommandStatus;
import io.gravitee.cockpit.api.command.Reply;
import java.util.Map;

public class EchoReply extends Reply {

  private Map<String, String> content;

  public EchoReply() {
    super(Type.ECHO_REPLY);
  }

  public EchoReply(String commandId, CommandStatus commandStatus) {
    super(Type.ECHO_REPLY, commandId, commandStatus);
  }

  public Map<String, String> getContent() {
    return content;
  }

  public void setContent(Map<String, String> content) {
    this.content = content;
  }
}
