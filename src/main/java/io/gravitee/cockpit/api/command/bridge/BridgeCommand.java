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

import io.gravitee.cockpit.api.command.Command;

/**
 * @author Jeoffrey HAEYAERT (jeoffrey.haeyaert at graviteesource.com)
 * @author GraviteeSource Team
 */
public class BridgeCommand extends Command<BridgePayload> {

  /**
   * The identifier of the installation the command is coming from.
   */
  private String installationId;

  /**
   * The identifier of the organization the command is coming from.
   */
  private String organizationId;

  /**
   * The identifier of the environment the command is coming from (optional).
   */
  private String environmentId;

  /**
   * An operation name which can give information about the nature of the payload.
   */
  private String operation;

  /**
   * The target environment or installation scopes.
   */
  private BridgeTarget target;

  /**
   * The timeout in millisecond. Default is 10000 ms (10 sec).
   */
  private long timeoutMillis = 10000;

  public BridgeCommand() {
    super(Type.BRIDGE_COMMAND);
  }

  public BridgeCommand(BridgeCommand other) {
    this();
    this.installationId = other.installationId;
    this.organizationId = other.organizationId;
    this.environmentId = other.environmentId;
    this.operation = other.operation;
    this.target = new BridgeTarget(other.target);
    this.payload = other.payload;
  }

  @Override
  public String toString() {
    return (
      "BridgeCommand{" +
      "id='" +
      id +
      '\'' +
      ", type=" +
      type +
      ", installationId='" +
      installationId +
      '\'' +
      ", organizationId='" +
      organizationId +
      '\'' +
      ", environmentId='" +
      environmentId +
      '\'' +
      ", operation='" +
      operation +
      '\'' +
      ", target=" +
      target +
      '}'
    );
  }

  public String getInstallationId() {
    return installationId;
  }

  public void setInstallationId(String installationId) {
    this.installationId = installationId;
  }

  public String getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
  }

  public String getEnvironmentId() {
    return environmentId;
  }

  public void setEnvironmentId(String environmentId) {
    this.environmentId = environmentId;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public BridgeTarget getTarget() {
    return target;
  }

  public void setTarget(BridgeTarget target) {
    this.target = target;
  }

  public long getTimeoutMillis() {
    return timeoutMillis;
  }

  public void setTimeoutMillis(long timeoutMillis) {
    this.timeoutMillis = timeoutMillis;
  }
}
