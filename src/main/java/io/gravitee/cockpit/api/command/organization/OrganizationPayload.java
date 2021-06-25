/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.cockpit.api.command.organization;

import io.gravitee.cockpit.api.command.Payload;
import java.util.List;

/**
 * @author Jeoffrey HAEYAERT (jeoffrey.haeyaert at graviteesource.com)
 * @author GraviteeSource Team
 */
public class OrganizationPayload implements Payload {

  private String id;

  private String cockpitId;

  private List<String> hrids;

  private String name;

  private String description;

  private List<String> domainRestrictions;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<String> getDomainRestrictions() {
    return domainRestrictions;
  }

  public void setDomainRestrictions(List<String> domainRestrictions) {
    this.domainRestrictions = domainRestrictions;
  }

  public List<String> getHrids() {
    return hrids;
  }

  public void setHrids(List<String> hrids) {
    this.hrids = hrids;
  }

  public String getCockpitId() {
    return cockpitId;
  }

  public void setCockpitId(String cockpitId) {
    this.cockpitId = cockpitId;
  }
}
