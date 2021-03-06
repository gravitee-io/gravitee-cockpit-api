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
package io.gravitee.cockpit.api.command.healthcheck;

import io.gravitee.cockpit.api.command.Payload;
import java.util.List;

/**
 * @author Lorie Pisicchio (lorie.pisicchio at graviteesource.com)
 * @author GraviteeSource Team
 */
public class HealthCheckPayload implements Payload {

  /**
   * The node ID
   */
  private String nodeId;

  /**
   * The date when the health check has been executed.
   */
  private long evaluatedAt;

  private List<HealthCheckProbe> probes;

  /**
   * The global heath of the node.
   * Important to note, this flag isn't redundant with probes info and should be used instead of checking that any
   * probe is Unhealthy (because the computation can be more complex than this simple check).
   *
   * Also, can be null in case the command is sent by an old installation using a definition of HealthCheckPayload where
   * this flag doesn't exist.
   */
  private Boolean isHealthy;

  public String getNodeId() {
    return nodeId;
  }

  public void setNodeId(String nodeId) {
    this.nodeId = nodeId;
  }

  public List<HealthCheckProbe> getProbes() {
    return probes;
  }

  public void setProbes(List<HealthCheckProbe> probes) {
    this.probes = probes;
  }

  public long getEvaluatedAt() {
    return evaluatedAt;
  }

  public void setEvaluatedAt(long evaluatedAt) {
    this.evaluatedAt = evaluatedAt;
  }

  public Boolean isHealthy() {
    return isHealthy;
  }

  public void setHealthy(Boolean healthy) {
    isHealthy = healthy;
  }
}
