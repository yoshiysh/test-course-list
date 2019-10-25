package com.yoshi991.testcourselist.data.entity

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

enum class UsageStatus {
    NOT_STARTED,
    IN_PROGRESS,
    MASTERED
}
