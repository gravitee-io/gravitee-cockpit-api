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
package io.gravitee.cockpit.api.command.legacy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.gravitee.exchange.api.command.CommandStatus;
import io.gravitee.exchange.api.command.Payload;
import io.gravitee.exchange.api.command.Reply;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Guillaume LAMIRAND (guillaume.lamirand at graviteesource.com)
 * @author GraviteeSource Team
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public abstract class CockpitReply<P extends Payload> extends Reply<P> {

  /**
   * An optional message that can be use to give some details about the status (ex: in case of error).
   */
  protected String message;

  protected CockpitReply(final CockpitReplyType type) {
    super(type.name());
  }

  protected CockpitReply(
    CockpitReplyType type,
    String commandId,
    CommandStatus commandStatus
  ) {
    super(type.name(), commandId, commandStatus);
  }
}
