package com.jammes.smartquizai

import java.util.UUID

data class QuizQuestions(
    val id: String = UUID.randomUUID().toString(),
    val question: String,
    val answers: List<String>,
    val correctAnswer: Int,
    var pickedAnswer: Int? = null,
    val explanation: String
)
