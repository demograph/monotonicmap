/*
 * Copyright 2017 Merlijn Boogerd
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

package com.github.mboogerd.mmap.util

import org.reactivestreams.{ Subscriber, Subscription }

/**
 *
 */
final class CancellingSubscriber[T] extends Subscriber[T] {
  override def onError(t: Throwable): Unit = ()
  override def onSubscribe(s: Subscription): Unit = s.cancel()
  override def onComplete(): Unit = ()
  override def onNext(t: T): Unit = ()
}
object CancellingSubscriber {
  def apply[T]: CancellingSubscriber[T] = new CancellingSubscriber[T]
}
