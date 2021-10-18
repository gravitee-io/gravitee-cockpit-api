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
package io.gravitee.cockpit.api.command.designer;

import io.gravitee.cockpit.api.command.Payload;

public class DeployModelPayload implements Payload {

  public enum DeploymentMode {
    API_DOCUMENTED,
    API_MOCKED,
    API_PUBLISHED,
  }

  private String modelId;

  private String userId;

  private String swaggerDefinition;

  private String organizationId;

  private String environmentId;

  private DeploymentMode mode = DeploymentMode.API_DOCUMENTED;

  public String getModelId() {
    return modelId;
  }

  public void setModelId(String modelId) {
    this.modelId = modelId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getSwaggerDefinition() {
    return swaggerDefinition;
  }

  public void setSwaggerDefinition(String swaggerDefinition) {
    this.swaggerDefinition = swaggerDefinition;
  }

  public DeploymentMode getMode() {
    return mode;
  }

  public void setMode(DeploymentMode mode) {
    this.mode = mode;
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
}
