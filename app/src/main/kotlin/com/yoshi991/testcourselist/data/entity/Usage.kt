package com.yoshi991.testcourselist.data.entity

import androidx.annotation.StringRes
import com.yoshi991.testcourselist.R

data class Usage(
    val courseId: String,
    val progress: Int
) {
    val status: UsageStatus
        get() = when (progress) {
            0 -> UsageStatus.NOT_STARTED
            100 -> UsageStatus.MASTERED
            else -> UsageStatus.IN_PROGRESS
        }
}

enum class UsageStatus(@StringRes val resId: Int) {
    NOT_STARTED(R.string.usage_status_not_started),
    IN_PROGRESS(R.string.usage_status_in_progress),
    MASTERED(R.string.usage_status_mastered)
}
