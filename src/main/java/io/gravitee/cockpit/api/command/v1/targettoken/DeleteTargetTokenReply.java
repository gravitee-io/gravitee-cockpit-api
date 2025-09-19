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
package io.gravitee.cockpit.api.command.v1.targettoken;

import io.gravitee.cockpit.api.command.v1.CockpitCommandType;
import io.gravitee.cockpit.api.command.v1.CockpitReply;
import io.gravitee.exchange.api.command.CommandStatus;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DeleteTargetTokenReply
  extends CockpitReply<DeleteTargetTokenReplyPayload> {

  public DeleteTargetTokenReply() {
    super(CockpitCommandType.DELETE_TARGET_TOKEN);
  }

  public DeleteTargetTokenReply(String commandId, CommandStatus status) {
    super(CockpitCommandType.DELETE_TARGET_TOKEN, commandId, status);
    this.payload = new DeleteTargetTokenReplyPayload();
  }

  public DeleteTargetTokenReply(String commandId, String errorDetails) {
    super(
      CockpitCommandType.DELETE_TARGET_TOKEN,
      commandId,
      CommandStatus.ERROR
    );
    this.errorDetails = errorDetails;
  }
}
