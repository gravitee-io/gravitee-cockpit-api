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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.gravitee.cockpit.api.command.alert.trigger.create.AlertTriggerReply;
import io.gravitee.cockpit.api.command.bridge.BridgeMultiReply;
import io.gravitee.cockpit.api.command.bridge.BridgeSimpleReply;
import io.gravitee.cockpit.api.command.echo.EchoReply;
import io.gravitee.cockpit.api.command.environment.EnvironmentReply;
import io.gravitee.cockpit.api.command.goodbye.GoodbyeReply;
import io.gravitee.cockpit.api.command.healthcheck.HealthCheckReply;
import io.gravitee.cockpit.api.command.hello.HelloReply;
import io.gravitee.cockpit.api.command.ignored.IgnoredReply;
import io.gravitee.cockpit.api.command.installation.InstallationReply;
import io.gravitee.cockpit.api.command.membership.DeleteMembershipReply;
import io.gravitee.cockpit.api.command.membership.MembershipReply;
import io.gravitee.cockpit.api.command.monitoring.MonitoringReply;
import io.gravitee.cockpit.api.command.node.NodeReply;
import io.gravitee.cockpit.api.command.organization.OrganizationReply;
import io.gravitee.cockpit.api.command.user.UserReply;
import java.io.Serializable;

/**
 * @author Jeoffrey HAEYAERT (jeoffrey.haeyaert at graviteesource.com)
 * @author GraviteeSource Team
 */
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.EXISTING_PROPERTY,
  property = "type"
)
@JsonSubTypes(
  {
    @JsonSubTypes.Type(value = IgnoredReply.class, name = "IGNORED_REPLY"),
    @JsonSubTypes.Type(
      value = OrganizationReply.class,
      name = "ORGANIZATION_REPLY"
    ),
    @JsonSubTypes.Type(
      value = EnvironmentReply.class,
      name = "ENVIRONMENT_REPLY"
    ),
    @JsonSubTypes.Type(value = UserReply.class, name = "USER_REPLY"),
    @JsonSubTypes.Type(
      value = MembershipReply.class,
      name = "MEMBERSHIP_REPLY"
    ),
    @JsonSubTypes.Type(
      value = DeleteMembershipReply.class,
      name = "DELETE_MEMBERSHIP_REPLY"
    ),
    @JsonSubTypes.Type(
      value = InstallationReply.class,
      name = "INSTALLATION_REPLY"
    ),
    @JsonSubTypes.Type(value = HelloReply.class, name = "HELLO_REPLY"),
    @JsonSubTypes.Type(value = GoodbyeReply.class, name = "GOODBYE_REPLY"),
    @JsonSubTypes.Type(value = EchoReply.class, name = "ECHO_REPLY"),
    @JsonSubTypes.Type(value = NodeReply.class, name = "NODE_REPLY"),
    @JsonSubTypes.Type(
      value = HealthCheckReply.class,
      name = "HEALTHCHECK_REPLY"
    ),
    @JsonSubTypes.Type(
      value = BridgeSimpleReply.class,
      name = "BRIDGE_SIMPLE_REPLY"
    ),
    @JsonSubTypes.Type(
      value = BridgeMultiReply.class,
      name = "BRIDGE_MULTI_REPLY"
    ),
    @JsonSubTypes.Type(
      value = MonitoringReply.class,
      name = "MONITORING_REPLY"
    ),
    @JsonSubTypes.Type(
      value = AlertTriggerReply.class,
      name = "ALERT_TRIGGER_REPLY"
    ),
  }
)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Reply implements Serializable {

  public enum Type {
    IGNORED_REPLY,
    ORGANIZATION_REPLY,
    ENVIRONMENT_REPLY,
    HELLO_REPLY,
    GOODBYE_REPLY,
    USER_REPLY,
    MEMBERSHIP_REPLY,
    DELETE_MEMBERSHIP_REPLY,
    INSTALLATION_REPLY,
    ECHO_REPLY,
    NODE_REPLY,
    HEALTHCHECK_REPLY,
    BRIDGE_SIMPLE_REPLY,
    BRIDGE_MULTI_REPLY,
    MONITORING_REPLY,
    ALERT_TRIGGER_REPLY,
  }

  /**
   * The command id the reply is related to.
   */
  protected String commandId;

  /**
   * The type of the reply (mainly used for deserialization).
   */
  protected Type type;

  /**
   * The result status of the command.
   */
  protected CommandStatus commandStatus;

  /**
   * An optional message that can be use to give some details about the status (ex: in case of error).
   */
  protected String message;

  public Reply(Type type) {
    this.type = type;
  }

  public Reply(Type type, String commandId, CommandStatus commandStatus) {
    this.type = type;
    this.commandId = commandId;
    this.commandStatus = commandStatus;
  }

  public String getCommandId() {
    return commandId;
  }

  public void setCommandId(String commandId) {
    this.commandId = commandId;
  }

  public Type getType() {
    return type;
  }

  public CommandStatus getCommandStatus() {
    return commandStatus;
  }

  public void setCommandStatus(CommandStatus commandStatus) {
    this.commandStatus = commandStatus;
  }

  public boolean stopOnErrorStatus() {
    return false;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
