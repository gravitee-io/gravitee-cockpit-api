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
package io.gravitee.cockpit.api.command.v1.organization;

import io.gravitee.cockpit.api.command.v1.CockpitCommandType;
import io.gravitee.cockpit.api.command.v1.CockpitReply;
import io.gravitee.exchange.api.command.CommandStatus;
import io.gravitee.exchange.api.command.Payload;

/**
 * @author Guillaume LAMIRAND (guillaume.lamirand at graviteesource.com)
 * @author GraviteeSource Team
 */
public class OrganizationReply extends CockpitReply<Payload> {

  public OrganizationReply() {
    super(CockpitCommandType.ORGANIZATION);
  }

  public OrganizationReply(final String commandId, final String errorDetails) {
    super(CockpitCommandType.ORGANIZATION, commandId, CommandStatus.ERROR);
    this.errorDetails = errorDetails;
  }

  public OrganizationReply(final String commandId) {
    super(CockpitCommandType.ORGANIZATION, commandId, CommandStatus.SUCCEEDED);
  }
}
