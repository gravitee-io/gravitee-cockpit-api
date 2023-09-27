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
package io.gravitee.cockpit.api;

import io.gravitee.cockpit.api.command.Command;
import io.gravitee.cockpit.api.command.Payload;
import io.gravitee.cockpit.api.command.Reply;
import io.gravitee.common.service.Service;
import io.reactivex.rxjava3.core.Single;

/**
 * @author Jeoffrey HAEYAERT (jeoffrey.haeyaert at graviteesource.com)
 * @author GraviteeSource Team
 */
public interface CockpitConnector extends Service<CockpitConnector> {
  /**
   * Returns <code>true</code> when the current instance is PRIMARY.
   *
   * @return boolean
   */
  boolean isPrimary();

  /**
   * Send a command to the Cockpit server.
   *
   * @param command the command to send.
   * @see #registerOnConnectListener(Runnable)
   * @see #registerOnReadyListener(Runnable)
   */
  Single<Reply> sendCommand(Command<? extends Payload> command);

  /**
   * Register a listener which will be called when websocket is successfully connected to Cockpit server.
   *
   * @param runnable the action to execute.
   * @see #registerOnReadyListener(Runnable)
   */
  void registerOnConnectListener(Runnable runnable);

  /**
   * Register a listener which will be called when websocket is disconnected from Cockpit server.
   *
   * @param runnable the action to execute.
   */
  void registerOnDisconnectListener(Runnable runnable);

  /**
   * Register a listener which will be called when Cockpit server indicates the installation is allowed to send command (basically, it means that the installation is ACCEPTED).
   *
   * @param runnable the action to execute.
   */
  void registerOnReadyListener(Runnable runnable);

  /**
   * Register a listener which will be called when Cockpit server indicates this installation instance is PRIMARY.
   *
   * @param runnable the action to execute.
   */
  void registerOnPrimary(Runnable runnable);

  /**
   * Register a listener which will be called when Cockpit server indicates this installation instance is REPLICA.
   *
   * @param runnable the action to execute.
   */
  void registerOnReplica(Runnable runnable);
}
