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
package io.gravitee.cockpit.api.command.hello;

import io.gravitee.cockpit.api.command.CommandStatus;
import io.gravitee.cockpit.api.command.Reply;

/**
 * @author Jeoffrey HAEYAERT (jeoffrey.haeyaert at graviteesource.com)
 * @author GraviteeSource Team
 */
public class HelloReply extends Reply {

  private String installationId;

  private String installationStatus;

  private String defaultEnvironmentCockpitId;

  private String defaultOrganizationCockpitId;

  public HelloReply() {
    this(null, null);
  }

  public HelloReply(String commandId, CommandStatus commandStatus) {
    super(Type.HELLO_REPLY, commandId, commandStatus);
  }

  @Override
  public boolean stopOnErrorStatus() {
    return true;
  }

  public String getInstallationId() {
    return installationId;
  }

  public void setInstallationId(String installationId) {
    this.installationId = installationId;
  }

  public String getInstallationStatus() {
    return installationStatus;
  }

  public void setInstallationStatus(String installationStatus) {
    this.installationStatus = installationStatus;
  }

  public String getDefaultEnvironmentCockpitId() {
    return defaultEnvironmentCockpitId;
  }

  public void setDefaultEnvironmentCockpitId(
    String defaultEnvironmentCockpitId
  ) {
    this.defaultEnvironmentCockpitId = defaultEnvironmentCockpitId;
  }

  public String getDefaultOrganizationCockpitId() {
    return defaultOrganizationCockpitId;
  }

  public void setDefaultOrganizationCockpitId(
    String defaultOrganizationCockpitId
  ) {
    this.defaultOrganizationCockpitId = defaultOrganizationCockpitId;
  }
}
