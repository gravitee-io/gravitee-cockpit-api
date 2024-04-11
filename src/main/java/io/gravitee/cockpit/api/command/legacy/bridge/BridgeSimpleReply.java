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
package io.gravitee.cockpit.api.command.legacy.bridge;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.gravitee.cockpit.api.command.legacy.CockpitReplyType;
import io.gravitee.exchange.api.command.CommandStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Jeoffrey HAEYAERT (jeoffrey.haeyaert at graviteesource.com)
 * @author GraviteeSource Team
 */
@Getter
@Setter
public class BridgeSimpleReply extends BridgeReply {

  /**
   * The identifier of the installation the reply is coming from.
   */
  private String installationId;

  /**
   * The identifier of the organization the reply is coming from.
   */
  private String organizationId;

  /**
   * The identifier of the environment the reply is coming from.
   */
  private String environmentId;

  /**
   * The payload of the reply.
   */
  @JsonProperty("payload")
  private String payloadAsString;

  public BridgeSimpleReply() {
    this(null, null);
  }

  public BridgeSimpleReply(String commandId, CommandStatus commandStatus) {
    this(commandId, commandStatus, null);
  }

  public BridgeSimpleReply(String commandId) {
    super(
      CockpitReplyType.BRIDGE_SIMPLE_REPLY,
      commandId,
      CommandStatus.SUCCEEDED
    );
  }

  public BridgeSimpleReply(
    String commandId,
    CommandStatus commandStatus,
    String message
  ) {
    super(CockpitReplyType.BRIDGE_SIMPLE_REPLY, commandId, commandStatus);
    this.message = message;
  }
}
