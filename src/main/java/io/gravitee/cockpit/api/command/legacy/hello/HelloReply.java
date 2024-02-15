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
package io.gravitee.cockpit.api.command.legacy.hello;

import io.gravitee.cockpit.api.command.legacy.CockpitReply;
import io.gravitee.cockpit.api.command.legacy.CockpitReplyType;
import io.gravitee.exchange.api.command.CommandStatus;
import io.gravitee.exchange.api.command.Payload;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Jeoffrey HAEYAERT (jeoffrey.haeyaert at graviteesource.com)
 * @author GraviteeSource Team
 */
@Getter
@Setter
public class HelloReply extends CockpitReply<Payload> {

  private String installationId;

  private String installationStatus;

  private String defaultEnvironmentCockpitId;

  private String defaultOrganizationCockpitId;

  public HelloReply() {
    this(null, null);
  }

  public HelloReply(String commandId, CommandStatus commandStatus) {
    super(CockpitReplyType.HELLO_REPLY, commandId, commandStatus);
  }

  @Override
  public boolean stopOnErrorStatus() {
    return true;
  }
}
