package com.jammes.smartquizai.core

import com.jammes.smartquizai.Questions

interface QuestionsRepository {

    fun getRandomQuestions(): List<Questions>

    fun getSingleQuestion(): Questions

}