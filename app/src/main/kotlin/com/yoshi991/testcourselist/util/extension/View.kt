package com.yoshi991.testcourselist.util.extension

import android.view.View
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(@StringRes resId: Int) {
    Snackbar.make(this, resId, Snackbar.LENGTH_SHORT).show()
}
