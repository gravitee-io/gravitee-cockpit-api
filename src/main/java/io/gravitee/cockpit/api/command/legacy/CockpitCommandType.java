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
package io.gravitee.cockpit.api.command.legacy;

public enum CockpitCommandType {
  BRIDGE_COMMAND,
  DELETE_MEMBERSHIP_COMMAND,
  DEPLOY_MODEL_COMMAND,
  DISABLE_ORGANIZATION_COMMAND,
  DISABLE_ENVIRONMENT_COMMAND,
  ENVIRONMENT_COMMAND,
  HEALTHCHECK_COMMAND,
  HELLO_COMMAND,
  INSTALLATION_COMMAND,
  MEMBERSHIP_COMMAND,
  NODE_COMMAND,
  ORGANIZATION_COMMAND,
  UNLINK_INSTALLATION_COMMAND,
  USER_COMMAND,
  V4_API_COMMAND,
}
