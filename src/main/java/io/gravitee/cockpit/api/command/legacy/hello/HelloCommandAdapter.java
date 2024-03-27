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
package io.gravitee.cockpit.api.command.legacy.hello;

import io.gravitee.cockpit.api.command.legacy.CockpitCommandType;
import io.gravitee.cockpit.api.command.v1.hello.HelloCommandPayload;
import io.gravitee.exchange.api.command.CommandAdapter;
import io.reactivex.rxjava3.core.Single;

public class HelloCommandAdapter
  implements
    CommandAdapter<HelloCommand, io.gravitee.cockpit.api.command.v1.hello.HelloCommand, HelloReply> {

  @Override
  public String supportType() {
    return CockpitCommandType.HELLO_COMMAND.name();
  }

  @Override
  public Single<io.gravitee.cockpit.api.command.v1.hello.HelloCommand> adapt(
    final HelloCommand command
  ) {
    return Single.fromCallable(() -> {
      HelloCommandPayload legacyPayload = command.getPayload();
      return new io.gravitee.cockpit.api.command.v1.hello.HelloCommand(
        command.getId(),
        HelloCommandPayload
          .builder()
          .node(legacyPayload.getNode())
          .defaultOrganizationId(legacyPayload.getDefaultOrganizationId())
          .defaultEnvironmentId(legacyPayload.getDefaultEnvironmentId())
          .installationType(legacyPayload.getInstallationType())
          .trial(legacyPayload.isTrial())
          .accessPointsTemplate(legacyPayload.getAccessPointsTemplate())
          .additionalInformation(legacyPayload.getAdditionalInformation())
          .build()
      );
    });
  }
}
