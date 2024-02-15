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
package io.gravitee.cockpit.api.command.v1.bridge;

import io.gravitee.exchange.api.command.Payload;
import java.io.Serializable;
import java.util.List;
import lombok.Builder;

/**
 * @author Guillaume LAMIRAND (guillaume.lamirand at graviteesource.com)
 * @author GraviteeSource Team
 */
@Builder
public record BridgeCommandPayload(
  /*
   * The identifier of the installation the command is coming from.
   */
  String installationId,

  /*
   * The identifier of the organization the command is coming from.
   */
  String organizationId,

  /*
   * The identifier of the environment the command is coming from (optional).
   */
  String environmentId,

  /*
   * An operation name which can give information about the nature of the payload.
   */
  String operation,

  /*
   * The target environment or installation scopes.
   */
  BridgeTarget target,

  /*
   * The timeout in millisecond. Default is 10000 ms (10 sec).
   */
  Long timeoutMillis,

  /*
   * The content of the command.
   */
  String content
)
  implements Payload {
  public BridgeCommandPayload {
    if (timeoutMillis == null) timeoutMillis = 10000L;
  }

  public record BridgeTarget(
    /*
     * The scopes of the installations to target. Optional if an <code>environmentId</code> is specified.
     * For now, it can be 'APIM' or 'AM'
     */
    List<String> scopes,
    /*
     * The identifier of the environment to target. Optional if a list of valid <code>scopes</code> is specified.
     */
    String environmentId
  )
    implements Serializable {}
}
