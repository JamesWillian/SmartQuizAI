package com.jammes.smartquizai.core

import com.jammes.smartquizai.QuizItem

interface QuizRepository {

    fun getQuizList(): List<QuizItem>
}