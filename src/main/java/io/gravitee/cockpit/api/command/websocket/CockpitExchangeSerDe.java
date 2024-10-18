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
package io.gravitee.cockpit.api.command.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.gravitee.cockpit.api.command.v1.CockpitCommandType;
import io.gravitee.cockpit.api.command.v1.scoring.request.ScoringRequestCommand;
import io.gravitee.cockpit.api.command.v1.scoring.request.ScoringRequestReply;
import io.gravitee.cockpit.api.command.v1.scoring.response.ScoringResponseCommand;
import io.gravitee.cockpit.api.command.v1.scoring.response.ScoringResponseReply;
import io.gravitee.cockpit.api.command.v1.specgen.request.SpecGenRequestCommand;
import io.gravitee.cockpit.api.command.v1.specgen.request.SpecGenRequestReply;
import io.gravitee.exchange.api.command.Command;
import io.gravitee.exchange.api.command.Reply;
import io.gravitee.exchange.api.websocket.command.DefaultExchangeSerDe;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Guillaume LAMIRAND (guillaume.lamirand at graviteesource.com)
 * @author GraviteeSource Team
 */
public class CockpitExchangeSerDe extends DefaultExchangeSerDe {

  private static final Map<String, Class<? extends Command<?>>> COMMAND_TYPES =
    new HashMap<>();
  private static final Map<String, Class<? extends Reply<?>>> REPLY_TYPES =
    new HashMap<>();

  static {
    // Legacy
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitCommandType.BRIDGE_COMMAND.name(),
      io.gravitee.cockpit.api.command.legacy.bridge.BridgeCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitCommandType.DELETE_MEMBERSHIP_COMMAND.name(),
      io.gravitee.cockpit.api.command.legacy.membership.DeleteMembershipCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitCommandType.DEPLOY_MODEL_COMMAND.name(),
      io.gravitee.cockpit.api.command.legacy.designer.DeployModelCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitCommandType.DISABLE_ENVIRONMENT_COMMAND.name(),
      io.gravitee.cockpit.api.command.legacy.environment.DisableEnvironmentCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitCommandType.DISABLE_ORGANIZATION_COMMAND.name(),
      io.gravitee.cockpit.api.command.legacy.organization.DisableOrganizationCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitCommandType.ENVIRONMENT_COMMAND.name(),
      io.gravitee.cockpit.api.command.legacy.environment.EnvironmentCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitCommandType.HEALTHCHECK_COMMAND.name(),
      io.gravitee.cockpit.api.command.legacy.healthcheck.HealthCheckCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitCommandType.HELLO_COMMAND.name(),
      io.gravitee.cockpit.api.command.legacy.hello.HelloCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitCommandType.INSTALLATION_COMMAND.name(),
      io.gravitee.cockpit.api.command.legacy.installation.InstallationCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitCommandType.MEMBERSHIP_COMMAND.name(),
      io.gravitee.cockpit.api.command.legacy.membership.MembershipCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitCommandType.NODE_COMMAND.name(),
      io.gravitee.cockpit.api.command.legacy.node.NodeCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitCommandType.ORGANIZATION_COMMAND.name(),
      io.gravitee.cockpit.api.command.legacy.organization.OrganizationCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitCommandType.UNLINK_INSTALLATION_COMMAND.name(),
      io.gravitee.cockpit.api.command.legacy.installation.UnlinkInstallationCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitCommandType.USER_COMMAND.name(),
      io.gravitee.cockpit.api.command.legacy.user.UserCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitCommandType.V4_API_COMMAND.name(),
      io.gravitee.cockpit.api.command.legacy.v4api.V4ApiCommand.class
    );

    // V1
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.BRIDGE.name(),
      io.gravitee.cockpit.api.command.v1.bridge.BridgeCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.DEPLOY_MODEL.name(),
      io.gravitee.cockpit.api.command.v1.designer.DeployModelCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.DISABLE_ENVIRONMENT.name(),
      io.gravitee.cockpit.api.command.v1.environment.DisableEnvironmentCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.DISABLE_ORGANIZATION.name(),
      io.gravitee.cockpit.api.command.v1.organization.DisableOrganizationCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.DELETE_MEMBERSHIP.name(),
      io.gravitee.cockpit.api.command.v1.membership.DeleteMembershipCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.ENVIRONMENT.name(),
      io.gravitee.cockpit.api.command.v1.environment.EnvironmentCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.HELLO.name(),
      io.gravitee.cockpit.api.command.v1.hello.HelloCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.INSTALLATION.name(),
      io.gravitee.cockpit.api.command.v1.installation.InstallationCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.MEMBERSHIP.name(),
      io.gravitee.cockpit.api.command.v1.membership.MembershipCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.NODE.name(),
      io.gravitee.cockpit.api.command.v1.node.NodeCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.NODE_HEALTHCHECK.name(),
      io.gravitee.cockpit.api.command.v1.node.healthcheck.NodeHealthCheckCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.ORGANIZATION.name(),
      io.gravitee.cockpit.api.command.v1.organization.OrganizationCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.UNLINK_INSTALLATION.name(),
      io.gravitee.cockpit.api.command.v1.installation.UnlinkInstallationCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.USER.name(),
      io.gravitee.cockpit.api.command.v1.user.UserCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.UNLINK_INSTALLATION.name(),
      io.gravitee.cockpit.api.command.v1.installation.UnlinkInstallationCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.V4_API.name(),
      io.gravitee.cockpit.api.command.v1.v4api.V4ApiCommand.class
    );
    COMMAND_TYPES.put(
      CockpitCommandType.SCORING_REQUEST.name(),
      ScoringRequestCommand.class
    );
    COMMAND_TYPES.put(
      CockpitCommandType.SCORING_RESPONSE.name(),
      ScoringResponseCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.DELETE_ENVIRONMENT.name(),
      io.gravitee.cockpit.api.command.v1.environment.DeleteEnvironmentCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.DELETE_ORGANIZATION.name(),
      io.gravitee.cockpit.api.command.v1.organization.DeleteOrganizationCommand.class
    );
    COMMAND_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.SPEC_GEN_REQUEST.name(),
      SpecGenRequestCommand.class
    );

    // Legacy
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitReplyType.BRIDGE_SIMPLE_REPLY.name(),
      io.gravitee.cockpit.api.command.legacy.bridge.BridgeSimpleReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitReplyType.BRIDGE_MULTI_REPLY.name(),
      io.gravitee.cockpit.api.command.legacy.bridge.BridgeMultiReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitReplyType.DEPLOY_MODEL_REPLY.name(),
      io.gravitee.cockpit.api.command.legacy.designer.DeployModelReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitReplyType.DELETE_MEMBERSHIP_REPLY.name(),
      io.gravitee.cockpit.api.command.legacy.membership.DeleteMembershipReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitReplyType.DISABLE_ENVIRONMENT_REPLY.name(),
      io.gravitee.cockpit.api.command.legacy.environment.DisableEnvironmentReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitReplyType.DISABLE_ORGANIZATION_REPLY.name(),
      io.gravitee.cockpit.api.command.legacy.organization.DisableOrganizationReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitReplyType.ENVIRONMENT_REPLY.name(),
      io.gravitee.cockpit.api.command.legacy.environment.EnvironmentReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitReplyType.HEALTHCHECK_REPLY.name(),
      io.gravitee.cockpit.api.command.legacy.healthcheck.HealthCheckReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitReplyType.HELLO_REPLY.name(),
      io.gravitee.cockpit.api.command.legacy.hello.HelloReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitReplyType.INSTALLATION_REPLY.name(),
      io.gravitee.cockpit.api.command.legacy.installation.InstallationReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitReplyType.MEMBERSHIP_REPLY.name(),
      io.gravitee.cockpit.api.command.legacy.membership.MembershipReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitReplyType.NODE_REPLY.name(),
      io.gravitee.cockpit.api.command.legacy.node.NodeReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitReplyType.ORGANIZATION_REPLY.name(),
      io.gravitee.cockpit.api.command.legacy.organization.OrganizationReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitReplyType.UNLINK_INSTALLATION_REPLY.name(),
      io.gravitee.cockpit.api.command.legacy.installation.UnlinkInstallationReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitReplyType.USER_REPLY.name(),
      io.gravitee.cockpit.api.command.legacy.user.UserReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.legacy.CockpitReplyType.V4_API_REPLY.name(),
      io.gravitee.cockpit.api.command.legacy.v4api.V4ApiReply.class
    );

    // V1
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.BRIDGE.name(),
      io.gravitee.cockpit.api.command.v1.bridge.BridgeReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.DEPLOY_MODEL.name(),
      io.gravitee.cockpit.api.command.v1.designer.DeployModelReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.DELETE_MEMBERSHIP.name(),
      io.gravitee.cockpit.api.command.v1.membership.DeleteMembershipReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.DISABLE_ENVIRONMENT.name(),
      io.gravitee.cockpit.api.command.v1.environment.DisableEnvironmentReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.DISABLE_ORGANIZATION.name(),
      io.gravitee.cockpit.api.command.v1.organization.DisableOrganizationReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.ENVIRONMENT.name(),
      io.gravitee.cockpit.api.command.v1.environment.EnvironmentReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.HELLO.name(),
      io.gravitee.cockpit.api.command.v1.hello.HelloReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.INSTALLATION.name(),
      io.gravitee.cockpit.api.command.v1.installation.InstallationReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.MEMBERSHIP.name(),
      io.gravitee.cockpit.api.command.v1.membership.MembershipReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.NODE.name(),
      io.gravitee.cockpit.api.command.v1.node.NodeReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.NODE_HEALTHCHECK.name(),
      io.gravitee.cockpit.api.command.v1.node.healthcheck.NodeHealthCheckReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.ORGANIZATION.name(),
      io.gravitee.cockpit.api.command.v1.organization.OrganizationReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.USER.name(),
      io.gravitee.cockpit.api.command.v1.user.UserReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.UNLINK_INSTALLATION.name(),
      io.gravitee.cockpit.api.command.v1.installation.UnlinkInstallationReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.V4_API.name(),
      io.gravitee.cockpit.api.command.v1.v4api.V4ApiReply.class
    );
    REPLY_TYPES.put(
      CockpitCommandType.SCORING_REQUEST.name(),
      ScoringRequestReply.class
    );
    REPLY_TYPES.put(
      CockpitCommandType.SCORING_RESPONSE.name(),
      ScoringResponseReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.DELETE_ENVIRONMENT.name(),
      io.gravitee.cockpit.api.command.v1.environment.DeleteEnvironmentReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.DELETE_ORGANIZATION.name(),
      io.gravitee.cockpit.api.command.v1.organization.DeleteOrganizationReply.class
    );
    REPLY_TYPES.put(
      io.gravitee.cockpit.api.command.v1.CockpitCommandType.SPEC_GEN_REQUEST.name(),
      SpecGenRequestReply.class
    );
  }

  public CockpitExchangeSerDe(final ObjectMapper objectMapper) {
    super(objectMapper, COMMAND_TYPES, REPLY_TYPES);
  }
}
