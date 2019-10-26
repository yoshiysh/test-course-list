package com.yoshi991.testcourselist.util.extension

import android.content.res.Resources

val Int.dp
    get() = (Resources.getSystem().displayMetrics.density * this).toInt()
