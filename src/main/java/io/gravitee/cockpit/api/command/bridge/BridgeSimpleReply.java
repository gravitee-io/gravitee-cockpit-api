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

import io.gravitee.cockpit.api.command.CommandStatus;

/**
 * @author Jeoffrey HAEYAERT (jeoffrey.haeyaert at graviteesource.com)
 * @author GraviteeSource Team
 */
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
  private String payload;

  public BridgeSimpleReply() {
    this(null, null);
  }

  public BridgeSimpleReply(String commandId, CommandStatus commandStatus) {
    this(commandId, commandStatus, null);
  }

  public BridgeSimpleReply(
    String commandId,
    CommandStatus commandStatus,
    String message
  ) {
    super(Type.BRIDGE_SIMPLE_REPLY, commandId, commandStatus);
    this.message = message;
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

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }
}
