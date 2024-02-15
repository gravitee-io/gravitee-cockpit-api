/*
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
package io.gravitee.cockpit.api.command.v1.node;

import io.gravitee.exchange.api.command.Payload;
import java.util.List;
import lombok.Builder;

/**
 * @author Guillaume LAMIRAND (guillaume.lamirand at graviteesource.com)
 * @author GraviteeSource Team
 */
@Builder
public record NodeCommandPayload(
  /*
   * The node ID
   */
  String nodeId,
  /*
   * The installation ID
   */
  String installationId,

  /*
   * The name of the node
   */
  String name,

  /*
   * The type of application.
   * Can be one of the following gio-apim-apis, gio-am-management, gio-am-gateway, gio-apim-gateway
   */
  String application,

  /*
   * The version of the node
   */
  String version,

  /*
   * The tenant of the node
   */
  String tenant,

  /*
   * The zone of the node
   */
  String zone,

  /*
   * The list of sharding tags the node is associated to
   */
  List<String> shardingTags,

  /*
   * The list of plugins of the node
   */
  List<NodePlugin> plugins,

  /*
   * The version of the JDK
   */
  String jdkVersion,

  /*
   * The date when the node status changed.
   */
  long evaluatedAt,

  Status status
)
  implements Payload {
  @Builder
  public record NodePlugin(
    /*
     * The name of the plugin
     */
    String name,

    /*
     * The version of the plugin
     */
    String version
  ) {}

  public enum Status {
    STARTED,
    STOPPED,
  }
}
