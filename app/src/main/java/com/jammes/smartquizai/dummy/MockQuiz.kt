package com.jammes.smartquizai.dummy

import com.jammes.smartquizai.QuizItem
import com.jammes.smartquizai.core.QuizRepository

object MockQuiz: QuizRepository {

    private val quizList = listOf(
        QuizItem(
            title = "Quiz Harry Potter",
            questionDificult = "Intermediário"
        ),
        QuizItem(
            title = "Quiz Marvel",
            questionDificult = "Difícil"
        ),
        QuizItem(
            title = "Quiz Programação",
            questionDificult = "Intermediário"
        ),
        QuizItem(
            title = "Quiz Filmes Terror",
            questionDificult = "Fácil"
        ),
        QuizItem(
            title = "Quiz Futebol",
            questionDificult = "Intermediário"
        ),
        QuizItem(
            title = "Quiz Tecnologia",
            questionDificult = "Difícil"
        ),
        QuizItem(
            title = "Quiz Livros",
            questionDificult = "Fácil"
        ),
    )

    override fun getQuizList(): List<QuizItem> {
        return quizList
    }
}