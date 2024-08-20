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
package io.gravitee.cockpit.api.command.v1.scoring.response;

import io.gravitee.cockpit.api.command.v1.CockpitCommandType;
import io.gravitee.cockpit.api.command.v1.CockpitReply;
import io.gravitee.exchange.api.command.CommandStatus;
import io.gravitee.exchange.api.command.Payload;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class ScoringResponseReply extends CockpitReply<Payload> {

  public ScoringResponseReply() {
    super(CockpitCommandType.SCORING_RESPONSE);
  }

  public ScoringResponseReply(String commandId, CommandStatus commandStatus) {
    super(CockpitCommandType.SCORING_RESPONSE, commandId, commandStatus);
  }

  public ScoringResponseReply(String commandId, String errorDetails) {
    super(CockpitCommandType.SCORING_RESPONSE, commandId, CommandStatus.ERROR);
    this.errorDetails = errorDetails;
  }
}
