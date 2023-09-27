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
package io.gravitee.cockpit.api.command.monitoring;

import java.io.Serializable;
import java.util.List;

/**
 * @author Lorie Pisicchio (lorie.pisicchio at graviteesource.com)
 * @author GraviteeSource Team
 */
public class JvmInfo implements Serializable {

  public long timestamp = -1;
  public long uptime;
  public Mem mem;
  public Threads threads;
  public List<GarbageCollector> gc;

  public Threads getThreads() {
    return threads;
  }

  public void setThreads(Threads threads) {
    this.threads = threads;
  }

  public List<GarbageCollector> getGc() {
    return gc;
  }

  public void setGc(List<GarbageCollector> gc) {
    this.gc = gc;
  }

  public static class Mem implements Serializable {

    public long heapCommitted;
    public long heapUsed;
    public long heapMax;
    public long nonHeapCommitted;
    public long nonHeapUsed;

    public MemoryPool[] pools = new MemoryPool[0];
  }

  public static class MemoryPool implements Serializable {

    public String name;
    public long used;
    public long max;

    public long peakUsed;
    public long peakMax;

    public MemoryPool() {}

    public MemoryPool(
      String name,
      long used,
      long max,
      long peakUsed,
      long peakMax
    ) {
      this.name = name;
      this.used = used;
      this.max = max;
      this.peakUsed = peakUsed;
      this.peakMax = peakMax;
    }

    public String getName() {
      return this.name;
    }

    public long getUsed() {
      return used;
    }

    public long getMax() {
      return max;
    }

    public long getPeakUsed() {
      return peakUsed;
    }

    public long getPeakMax() {
      return peakMax;
    }
  }

  public static class Threads implements Serializable {

    public int count;
    public int peakCount;

    public int getCount() {
      return count;
    }

    public int getPeakCount() {
      return peakCount;
    }
  }

  public static class GarbageCollector implements Serializable {

    public String name;
    public long collectionCount;
    public long collectionTime;

    public String getName() {
      return this.name;
    }

    public long getCollectionTime() {
      return collectionTime;
    }

    public long getCollectionCount() {
      return this.collectionCount;
    }
  }
}
