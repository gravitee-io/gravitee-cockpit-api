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
package io.gravitee.cockpit.api.command.organization;

import io.gravitee.cockpit.api.command.Payload;
import io.gravitee.cockpit.api.command.accesspoint.AccessPoint;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Jeoffrey HAEYAERT (jeoffrey.haeyaert at graviteesource.com)
 * @author GraviteeSource Team
 */
@Getter
@Setter
public class OrganizationPayload implements Payload {

  private String id;

  private String cockpitId;

  private List<String> hrids;

  private String name;

  private String description;

  private List<AccessPoint> accessPoints;

  private String license;
}
