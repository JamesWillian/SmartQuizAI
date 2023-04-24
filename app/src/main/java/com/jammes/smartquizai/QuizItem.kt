package com.jammes.smartquizai

import java.util.*

data class QuizItem(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val questionDificult: String
)