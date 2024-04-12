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
package io.gravitee.cockpit.api.command.v1.bridge;

import io.gravitee.exchange.api.command.Payload;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Guillaume LAMIRAND (guillaume.lamirand at graviteesource.com)
 * @author GraviteeSource Team
 */
public record BridgeReplyPayload(
  boolean singleTarget,
  List<BridgeReplyContent> contents
)
  implements Payload {
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @Data
  public static class BridgeReplyContent implements Payload {

    private String installationId;
    private String organizationId;
    private String environmentId;
    private String content;
    private boolean error;
  }
}
