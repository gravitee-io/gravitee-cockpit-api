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
package io.gravitee.cockpit.api.command.node;

import io.gravitee.cockpit.api.command.Payload;
import java.util.List;

public class NodePayload implements Payload {

  public String getApplication() {
    return application;
  }

  public void setApplication(String application) {
    this.application = application;
  }

  public enum Status {
    STARTED,
    STOPPED,
  }

  /**
   * The node ID
   */
  private String nodeId;

  /**
   * The name of the node
   */
  private String name;

  /**
   * The type of application.
   * Can be one of the following gio-apim-apis, gio-am-management, gio-am-gateway, gio-apim-gateway
   */
  private String application;

  /**
   * The version of the node
   */
  private String version;

  /**
   * The tenant of the node
   */
  private String tenant;

  /**
   * The zone of the node
   */
  private String zone;

  /**
   * The list of sharding tags the node is associated to
   */
  private List<String> shardingTags;

  /**
   * The list of plugins of the node
   */
  private List<NodePlugin> plugins;

  /**
   * The version of the JDK
   */
  private String jdkVersion;

  /**
   * The date when the node status changed.
   */
  private long evaluatedAt;

  private Status status;

  public String getNodeId() {
    return nodeId;
  }

  public void setNodeId(String nodeId) {
    this.nodeId = nodeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getTenant() {
    return tenant;
  }

  public void setTenant(String tenant) {
    this.tenant = tenant;
  }

  public String getZone() {
    return zone;
  }

  public void setZone(String zone) {
    this.zone = zone;
  }

  public List<String> getShardingTags() {
    return shardingTags;
  }

  public void setShardingTags(List<String> shardingTags) {
    this.shardingTags = shardingTags;
  }

  public List<NodePlugin> getPlugins() {
    return plugins;
  }

  public void setPlugins(List<NodePlugin> plugins) {
    this.plugins = plugins;
  }

  public String getJdkVersion() {
    return jdkVersion;
  }

  public void setJdkVersion(String jdkVersion) {
    this.jdkVersion = jdkVersion;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public long getEvaluatedAt() {
    return evaluatedAt;
  }

  public void setEvaluatedAt(long evaluatedAt) {
    this.evaluatedAt = evaluatedAt;
  }
}
