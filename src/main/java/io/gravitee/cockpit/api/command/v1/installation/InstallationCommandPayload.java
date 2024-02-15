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
package io.gravitee.cockpit.api.command.v1.installation;

import io.gravitee.exchange.api.command.Payload;
import java.util.HashMap;
import java.util.Map;
import lombok.Builder;

/**
 * @author Guillaume LAMIRAND (guillaume.lamirand at graviteesource.com)
 * @author GraviteeSource Team
 */
@Builder
public record InstallationCommandPayload(
  /*
   * The cockpit installation id.
   */
  String id,

  /*
   * The identifier of the installation in the target system.
   */
  String externalId,

  /*
   * The scope of this installation (AM, APIM, ...).
   */
  String scope,

  /*
   * The status of the installation in a Cockpit perspective (pending, accepted, rejected, ...).
   * The status influences possible actions such as creating an organization or environment on that installation.
   */
  String status,

  /*
   * The common name of the installation (ex: 'APIM installation for performance tests').
   */
  String name,

  /*
   * A short description of the installation.
   */
  String description,

  /*
   * Additional information about this installation.
   */
  Map<String, String> additionalInformation
)
  implements Payload {
  public InstallationCommandPayload {
    if (additionalInformation == null) additionalInformation = new HashMap<>();
  }
}
