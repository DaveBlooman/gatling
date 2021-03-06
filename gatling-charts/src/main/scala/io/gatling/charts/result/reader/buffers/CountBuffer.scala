/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.charts.result.reader.buffers

import io.gatling.core.result.IntVsTimePlot

class CountBuffer(buckets: Array[Int]) {
  val counts: Array[Int] = Array.fill(buckets.length)(0)

  def update(bucketNumber: Int): Unit = {
    counts(bucketNumber) = counts(bucketNumber) + 1
  }

  def distribution: Iterable[IntVsTimePlot] =
    counts.view.zipWithIndex
      .map { case (count, bucketNumber) => IntVsTimePlot(buckets(bucketNumber), count) }
}
