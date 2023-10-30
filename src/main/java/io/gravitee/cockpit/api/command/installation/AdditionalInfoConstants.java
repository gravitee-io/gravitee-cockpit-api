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
package io.gravitee.cockpit.api.command.installation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Guillaume LAMIRAND (guillaume.lamirand at graviteesource.com)
 * @author GraviteeSource Team
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AdditionalInfoConstants {

  @Deprecated(forRemoval = true)
  public static final String INSTALLATION_TYPE = "INSTALLATION_TYPE";

  @Deprecated(forRemoval = true)
  public static final String INSTALLATION_TYPE_TRIAL = "trial";

  @Deprecated(forRemoval = true)
  public static final String INSTALLATION_TYPE_ONPREM = "onprem";

  @Deprecated(forRemoval = true)
  public static final String LEGACY_AUTH_PATH_DEFAULT =
    "/auth/cockpit?token={token}";

  @Deprecated(forRemoval = true)
  public static final String API_URL = "API_URL";

  @Deprecated(forRemoval = true)
  public static final String UI_URL = "UI_URL";

  // Authentication
  public static final String AUTH_BASE_URL = "AUTH_BASE_URL";
  public static final String AUTH_PATH = "AUTH_PATH";
}
