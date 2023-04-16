package com.jammes.smartquizai

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jammes.smartquizai.core.QuestionsRepository

class QuizQuestionsViewModel(private val repository: QuestionsRepository): ViewModel() {

    private var index = 0

    fun pickAnswer(answerIndex: Int) {
        if (index < 9) {
            refreshQuizQuestionList()
        }
    }

    private fun refreshQuizQuestionList() {
        liveUiState.value?.let { currentUiState ->
            liveUiState.value = currentUiState.copy(

                index = index++
            )
        }
    }

    fun stateUiStateAsLiveData(): LiveData<UiState> {
        return liveUiState
    }

    private val liveUiState: MutableLiveData<UiState> by lazy {
        MutableLiveData<UiState>(
            UiState(
                quizQuestionsList = repository.getRandomQuestions().map { question ->
                    QuizQuestions(
                        question = question.question,
                        answers = question.answers,
                        correctAnswer = question.correctAnswer,
                        explanation = question.explanation) },
                index = index
            )
        )
    }

    data class UiState(
        val quizQuestionsList: List<QuizQuestions>,
        val index: Int
    )

    @Suppress("UNCHECKED_CAST")
    class Factory(private val repository: QuestionsRepository) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return QuizQuestionsViewModel(repository) as T
        }
    }

}
