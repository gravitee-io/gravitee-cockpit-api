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
package io.gravitee.cockpit.api.command.legacy.bridge;

import io.gravitee.cockpit.api.command.legacy.CockpitReplyType;
import io.gravitee.exchange.api.command.CommandStatus;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeoffrey HAEYAERT (jeoffrey.haeyaert at graviteesource.com)
 * @author GraviteeSource Team
 */
public class BridgeMultiReply extends BridgeReply {

  private List<BridgeSimpleReply> replies;

  public BridgeMultiReply() {
    this(null, null, new ArrayList<>());
  }

  public BridgeMultiReply(
    final String commandId,
    final CommandStatus commandStatus,
    final List<BridgeSimpleReply> replies
  ) {
    super(CockpitReplyType.BRIDGE_MULTI_REPLY, commandId, commandStatus);
    this.replies = replies;
  }

  public List<BridgeSimpleReply> getReplies() {
    return replies;
  }

  public void setReplies(List<BridgeSimpleReply> replies) {
    this.replies = replies;
  }
}
