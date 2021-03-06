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
package io.gravitee.cockpit.api.command;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.gravitee.cockpit.api.command.alert.notification.AlertNotificationCommand;
import io.gravitee.cockpit.api.command.alert.trigger.create.AlertTriggerCommand;
import io.gravitee.cockpit.api.command.alert.trigger.list.ListAlertTriggersCommand;
import io.gravitee.cockpit.api.command.bridge.BridgeCommand;
import io.gravitee.cockpit.api.command.echo.EchoCommand;
import io.gravitee.cockpit.api.command.environment.EnvironmentCommand;
import io.gravitee.cockpit.api.command.goodbye.GoodbyeCommand;
import io.gravitee.cockpit.api.command.healthcheck.HealthCheckCommand;
import io.gravitee.cockpit.api.command.hello.HelloCommand;
import io.gravitee.cockpit.api.command.installation.InstallationCommand;
import io.gravitee.cockpit.api.command.membership.DeleteMembershipCommand;
import io.gravitee.cockpit.api.command.membership.MembershipCommand;
import io.gravitee.cockpit.api.command.monitoring.MonitoringCommand;
import io.gravitee.cockpit.api.command.node.NodeCommand;
import io.gravitee.cockpit.api.command.organization.OrganizationCommand;
import io.gravitee.cockpit.api.command.unknown.UnknownCommand;
import io.gravitee.cockpit.api.command.user.UserCommand;
import io.gravitee.common.utils.UUID;
import java.io.Serializable;

/**
 * @author Jeoffrey HAEYAERT (jeoffrey.haeyaert at graviteesource.com)
 * @author GraviteeSource Team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.EXISTING_PROPERTY,
  property = "type",
  defaultImpl = UnknownCommand.class
)
@JsonSubTypes(
  {
    @JsonSubTypes.Type(
      value = OrganizationCommand.class,
      name = "ORGANIZATION_COMMAND"
    ),
    @JsonSubTypes.Type(
      value = EnvironmentCommand.class,
      name = "ENVIRONMENT_COMMAND"
    ),
    @JsonSubTypes.Type(value = UserCommand.class, name = "USER_COMMAND"),
    @JsonSubTypes.Type(
      value = MembershipCommand.class,
      name = "MEMBERSHIP_COMMAND"
    ),
    @JsonSubTypes.Type(
      value = DeleteMembershipCommand.class,
      name = "DELETE_MEMBERSHIP_COMMAND"
    ),
    @JsonSubTypes.Type(
      value = InstallationCommand.class,
      name = "INSTALLATION_COMMAND"
    ),
    @JsonSubTypes.Type(value = HelloCommand.class, name = "HELLO_COMMAND"),
    @JsonSubTypes.Type(value = GoodbyeCommand.class, name = "GOODBYE_COMMAND"),
    @JsonSubTypes.Type(value = EchoCommand.class, name = "ECHO_COMMAND"),
    @JsonSubTypes.Type(value = NodeCommand.class, name = "NODE_COMMAND"),
    @JsonSubTypes.Type(
      value = HealthCheckCommand.class,
      name = "HEALTHCHECK_COMMAND"
    ),
    @JsonSubTypes.Type(
      value = MonitoringCommand.class,
      name = "MONITORING_COMMAND"
    ),
    @JsonSubTypes.Type(value = BridgeCommand.class, name = "BRIDGE_COMMAND"),
    @JsonSubTypes.Type(
      value = AlertTriggerCommand.class,
      name = "ALERT_TRIGGER_COMMAND"
    ),
    @JsonSubTypes.Type(
      value = ListAlertTriggersCommand.class,
      name = "LIST_ALERT_TRIGGERS_COMMAND"
    ),
    @JsonSubTypes.Type(
      value = AlertNotificationCommand.class,
      name = "ALERT_NOTIFICATION_COMMAND"
    ),
  }
)
public abstract class Command<T extends Payload> implements Serializable {

  public static final String COMMAND_PREFIX = "command: ";
  public static final String REPLY_PREFIX = "reply: ";
  public static final String PING_PONG_PREFIX = "ping_pong: ";

  public static final String PRIMARY_MESSAGE = "primary: true";
  public static final String REPLICA_MESSAGE = "replica: true";

  protected String id;

  protected T payload;

  protected Type type;

  public enum Type {
    UNKNOWN_COMMAND,
    ORGANIZATION_COMMAND,
    ENVIRONMENT_COMMAND,
    HELLO_COMMAND,
    GOODBYE_COMMAND,
    USER_COMMAND,
    MEMBERSHIP_COMMAND,
    DELETE_MEMBERSHIP_COMMAND,
    INSTALLATION_COMMAND,
    ECHO_COMMAND,
    NODE_COMMAND,
    HEALTHCHECK_COMMAND,
    MONITORING_COMMAND,
    BRIDGE_COMMAND,
    ALERT_TRIGGER_COMMAND,
    LIST_ALERT_TRIGGERS_COMMAND,
    ALERT_NOTIFICATION_COMMAND,
  }

  public Command(Type type) {
    this.id = UUID.random().toString();
    this.type = type;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public T getPayload() {
    return payload;
  }

  public void setPayload(T payload) {
    this.payload = payload;
  }

  public Type getType() {
    return type;
  }
}
