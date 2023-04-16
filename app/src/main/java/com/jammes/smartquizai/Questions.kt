package com.jammes.smartquizai

data class Questions(
    val question: String,
    val answers: List<String>,
    val correctAnswer: Int,
    val explanation: String
)
