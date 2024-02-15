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
package io.gravitee.cockpit.api.command.v1.hello;

import static io.gravitee.exchange.api.command.CommandStatus.ERROR;
import static io.gravitee.exchange.api.command.CommandStatus.SUCCEEDED;

import io.gravitee.cockpit.api.command.v1.CockpitCommandType;
import io.gravitee.cockpit.api.command.v1.CockpitReply;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Guillaume LAMIRAND (guillaume.lamirand at graviteesource.com)
 * @author GraviteeSource Team
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HelloReply extends CockpitReply<HelloReplyPayload> {

  public HelloReply() {
    super(CockpitCommandType.HELLO);
  }

  public HelloReply(final String commandId, final String errorDetails) {
    super(CockpitCommandType.HELLO, commandId, ERROR);
    this.errorDetails = errorDetails;
  }

  public HelloReply(
    final String commandId,
    final HelloReplyPayload helloReplyPayload
  ) {
    super(CockpitCommandType.HELLO, commandId, SUCCEEDED);
    this.payload = helloReplyPayload;
  }
}
