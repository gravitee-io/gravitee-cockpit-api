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
package io.gravitee.cockpit.api.command.hello;

import io.gravitee.cockpit.api.command.Node;
import io.gravitee.cockpit.api.command.Payload;
import io.gravitee.cockpit.api.command.accesspoint.AccessPoint;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Jeoffrey HAEYAERT (jeoffrey.haeyaert at graviteesource.com)
 * @author GraviteeSource Team
 */
@NoArgsConstructor
@Getter
@Setter
public class HelloPayload implements Payload {

  /**
   * Contains all necessary information about the node.
   */
  private Node node;

  /**
   * The default organization identifier, <code>null</code> if there is no default organization defined.
   */
  private String defaultOrganizationId;

  /**
   * The default environment identifier, <code>null</code> if there is no default organization defined.
   */
  private String defaultEnvironmentId;

  /**
   * The type of the installation.
   */
  private String installationType;
  /**
   * Flag indicating if he installation is a trial.
   */
  private boolean trial;

  /**
   * In case of a multi-tenant installation, this defines the access points template used to initialize organizations and environments
   */
  private Map<AccessPoint.Type, List<AccessPoint>> accessPointsTemplate =
    new EnumMap<>(AccessPoint.Type.class);

  /**
   * Additional information.
   */
  private Map<String, String> additionalInformation = new HashMap<>();
}
