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

public enum CockpitReplyType {
  IGNORED_REPLY,
  ORGANIZATION_REPLY,
  ENVIRONMENT_REPLY,
  HELLO_REPLY,
  GOODBYE_REPLY,
  USER_REPLY,
  MEMBERSHIP_REPLY,
  DELETE_MEMBERSHIP_REPLY,
  INSTALLATION_REPLY,
  UNLINK_INSTALLATION_REPLY,
  ECHO_REPLY,
  NODE_REPLY,
  HEALTHCHECK_REPLY,
  BRIDGE_SIMPLE_REPLY,
  BRIDGE_MULTI_REPLY,
  MONITORING_REPLY,
  ALERT_TRIGGER_REPLY,
  LIST_ALERT_TRIGGERS_REPLY,
  ALERT_NOTIFICATION_REPLY,
  DEPLOY_MODEL_REPLY,
  V4_API_REPLY,
  DISABLE_ORGANIZATION_REPLY,
  DISABLE_ENVIRONMENT_REPLY,
}
