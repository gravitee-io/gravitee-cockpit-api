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
package io.gravitee.cockpit.api.command.monitoring;

import java.io.Serializable;

/**
 * @author Lorie Pisicchio (lorie.pisicchio at graviteesource.com)
 * @author GraviteeSource Team
 */
public class Monitor implements Serializable {

  private JvmInfo jvmInfo;
  private OsInfo osInfo;
  private ProcessInfo processInfo;

  public JvmInfo getJvmInfo() {
    return jvmInfo;
  }

  public void setJvmInfo(JvmInfo jvmInfo) {
    this.jvmInfo = jvmInfo;
  }

  public OsInfo getOsInfo() {
    return osInfo;
  }

  public void setOsInfo(OsInfo osInfo) {
    this.osInfo = osInfo;
  }

  public ProcessInfo getProcessInfo() {
    return processInfo;
  }

  public void setProcessInfo(ProcessInfo processInfo) {
    this.processInfo = processInfo;
  }
}
