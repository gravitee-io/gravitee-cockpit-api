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
package io.gravitee.cockpit.api.command.v1.scoring.request;

import io.gravitee.cockpit.api.command.v1.CockpitCommand;
import io.gravitee.cockpit.api.command.v1.CockpitCommandType;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class ScoringRequestCommand
  extends CockpitCommand<ScoringRequestCommandPayload> {

  public ScoringRequestCommand() {
    super(CockpitCommandType.SCORING_REQUEST);
  }

  public ScoringRequestCommand(ScoringRequestCommandPayload payload) {
    super(CockpitCommandType.SCORING_REQUEST);
    this.payload = payload;
  }
}
