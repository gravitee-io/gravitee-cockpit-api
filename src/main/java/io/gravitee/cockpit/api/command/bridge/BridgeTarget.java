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
package io.gravitee.cockpit.api.command.bridge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeoffrey HAEYAERT (jeoffrey.haeyaert at graviteesource.com)
 * @author GraviteeSource Team
 */
public class BridgeTarget implements Serializable {

  /**
   * The scopes of the installations to target. Optional if an <code>environmentId</code> is specified.
   * For now, it can be 'APIM' or 'AM'
   */
  private List<String> scopes;

  /**
   * The identifier of the environment to target. Optional if a list of valid <code>scopes</code> is specified.
   */
  private String environmentId;

  public BridgeTarget() {
    this(new ArrayList<>());
  }

  public BridgeTarget(BridgeTarget other) {
    this.scopes =
      other.scopes == null ? new ArrayList<>() : new ArrayList<>(other.scopes);
    this.environmentId = other.environmentId;
  }

  public BridgeTarget(List<String> scopes) {
    this.scopes = scopes;
  }

  public BridgeTarget(String environmentId) {
    this();
    this.environmentId = environmentId;
  }

  public List<String> getScopes() {
    return scopes;
  }

  public void setScopes(List<String> scopes) {
    this.scopes = scopes;
  }

  public String getEnvironmentId() {
    return environmentId;
  }

  public void setEnvironmentId(String environmentId) {
    this.environmentId = environmentId;
  }

  @Override
  public String toString() {
    return (
      "BridgeTarget{" +
      "scopes=" +
      scopes +
      ", environmentId='" +
      environmentId +
      '\'' +
      '}'
    );
  }
}
