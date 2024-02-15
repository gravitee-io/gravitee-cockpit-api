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
package io.gravitee.cockpit.api.command.v1.organization;

import io.gravitee.cockpit.api.command.model.accesspoint.AccessPoint;
import io.gravitee.exchange.api.command.Payload;
import java.util.List;
import lombok.Builder;

/**
 * @author Guillaume LAMIRAND (guillaume.lamirand at graviteesource.com)
 * @author GraviteeSource Team
 */
@Builder
public record OrganizationCommandPayload(
  String id,
  String cockpitId,
  List<String> hrids,
  String name,
  String description,
  List<AccessPoint> accessPoints,
  String license
)
  implements Payload {}
