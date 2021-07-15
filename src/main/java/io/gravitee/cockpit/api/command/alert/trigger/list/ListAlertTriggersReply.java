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
package io.gravitee.cockpit.api.command.alert.trigger.list;

import io.gravitee.alert.api.trigger.Trigger;
import io.gravitee.cockpit.api.command.CommandStatus;
import io.gravitee.cockpit.api.command.Reply;
import java.util.List;

/**
 * @author Ouahid KHELIFI (ouahid.khelifi at graviteesource.com)
 * @author GraviteeSource Team
 */
public class ListAlertTriggersReply extends Reply {

  /**
   * The triggers list.
   */
  private List<Trigger> triggers;

  public ListAlertTriggersReply() {
    this(null, null);
  }

  public ListAlertTriggersReply(String commandId, CommandStatus commandStatus) {
    super(Type.LIST_ALERT_TRIGGERS_REPLY, commandId, commandStatus);
  }

  public List<Trigger> getTriggers() {
    return triggers;
  }

  public void setTriggers(List<Trigger> triggers) {
    this.triggers = triggers;
  }
}
