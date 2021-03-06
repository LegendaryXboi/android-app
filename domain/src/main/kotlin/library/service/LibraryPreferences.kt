/*
 * Copyright (C) 2018 The Tachiyomi Open Source Project
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package tachiyomi.domain.library.service

import tachiyomi.core.prefs.Preference
import tachiyomi.core.prefs.PreferenceStore
import tachiyomi.domain.library.model.Category
import tachiyomi.domain.library.model.LibraryFilter
import tachiyomi.domain.library.model.LibrarySort
import tachiyomi.domain.library.model.LibrarySorting
import tachiyomi.domain.library.model.deserialize
import tachiyomi.domain.library.model.deserializeList
import tachiyomi.domain.library.model.serialize

class LibraryPreferences(private val preferenceStore: PreferenceStore) {

  fun lastSorting(): Preference<LibrarySorting> {
    return preferenceStore.getObject(
      key = "last_sorting",
      defaultValue = LibrarySorting(LibrarySort.Title, true),
      serializer = { it.serialize() },
      deserializer = { LibrarySorting.deserialize(it) }
    )
  }

  fun filters(): Preference<List<LibraryFilter>> {
    return preferenceStore.getObject(
      key = "filters",
      defaultValue = emptyList(),
      serializer = { it.serialize() },
      deserializer = { LibraryFilter.deserializeList(it) }
    )
  }

  fun lastUsedCategory(): Preference<Long> {
    return preferenceStore.getLong("last_used_category", Category.ALL_ID)
  }

  fun defaultCategory(): Preference<Long> {
    return preferenceStore.getLong("default_category", Category.UNCATEGORIZED_ID)
  }

  fun quickCategories(): Preference<Boolean> {
    return preferenceStore.getBoolean("quick_categories", false)
  }

}
