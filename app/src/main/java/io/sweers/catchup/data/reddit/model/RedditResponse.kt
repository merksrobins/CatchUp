/*
 * Copyright (c) 2017 Zac Sweers
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.sweers.catchup.data.reddit.model

import com.google.auto.value.AutoValue
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

@AutoValue
abstract class RedditResponse {

  abstract fun data(): RedditListing

  @AutoValue.Builder
  interface Builder {
    fun data(listing: RedditListing): Builder

    fun build(): RedditResponse
  }

  companion object {
    @JvmStatic
    fun jsonAdapter(moshi: Moshi): JsonAdapter<RedditResponse> {
      return AutoValue_RedditResponse.MoshiJsonAdapter(moshi)
    }

    fun builder(): Builder {
      return `$AutoValue_RedditResponse`.Builder()
    }
  }
}
