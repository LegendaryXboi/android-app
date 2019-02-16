/*
 * Copyright (C) 2018 The Tachiyomi Open Source Project
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package tachiyomi.ui.screens.category

import android.view.ViewGroup
import kotlinx.android.synthetic.main.category_item.*
import tachiyomi.domain.category.Category
import tachiyomi.ui.R
import tachiyomi.ui.adapter.BaseViewHolder
import tachiyomi.ui.util.inflate
import tachiyomi.ui.widget.TextOvalDrawable

class CategoryHolder(
  parent: ViewGroup
) : BaseViewHolder(parent.inflate(R.layout.category_item)) {

  fun bind(category: Category) {
    category_text.text = category.name

    val initial = category.name.firstOrNull()?.toUpperCase()?.toString() ?: ""
    val drawable = TextOvalDrawable(
      text = initial,
      backgroundColor = TextOvalDrawable.Colors.getColor(initial)
    )

    category_icon.setImageDrawable(drawable)
  }

}