package com.jammes.smartquizai

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jammes.smartquizai.core.QuestionsRepository

class QuizQuestionsViewModel(private val repository: QuestionsRepository): ViewModel() {

    var correctAnswers = 0
    val currentQuizList = mutableListOf<QuizQuestions>()

    fun clearQuizUiState() {
        correctAnswers = 0
        currentQuizList.clear()
    }

    fun nextQuestion(answerIndex: Int) {
        refreshQuizQuestionList(answerIndex)
    }

    private fun newQuestion(): QuizQuestions {
        val newQuestion = repository.getSingleQuestion()

        currentQuizList.add(
            QuizQuestions(
                question = newQuestion.question,
                answers = newQuestion.answers,
                correctAnswer = newQuestion.correctAnswer,
                explanation = newQuestion.explanation
            )
        )

        return currentQuizList[currentQuizList.lastIndex]
    }

    private fun refreshQuizQuestionList(pickedAnswer: Int) {
        liveUiState.value?.let { currentUiState ->
            currentQuizList[currentQuizList.lastIndex].pickedAnswer = pickedAnswer

            //Incrementa a quantidade de respostas corretas
            if (currentQuizList[currentQuizList.lastIndex].correctAnswer == currentQuizList[currentQuizList.lastIndex].pickedAnswer) {
                correctAnswers = ++correctAnswers
            }

            //Atualiza a UiState com uma nova pergunta aleatoria
            liveUiState.value = currentUiState.copy(
                currentQuestion = newQuestion()
            )

        }
    }

    fun stateUiStateAsLiveData(): LiveData<UiState> {
        return liveUiState
    }

    private val liveUiState: MutableLiveData<UiState> by lazy {
        MutableLiveData<UiState>(
            UiState(
                currentQuestion = newQuestion()
            )
        )
    }

    data class UiState(
        val currentQuestion: QuizQuestions
    )

    @Suppress("UNCHECKED_CAST")
    class Factory(private val repository: QuestionsRepository) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return QuizQuestionsViewModel(repository) as T
        }
    }

}
