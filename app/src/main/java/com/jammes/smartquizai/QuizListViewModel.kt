package com.jammes.smartquizai

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jammes.smartquizai.core.QuestionsRepository
import com.jammes.smartquizai.core.QuizRepository

class QuizListViewModel(
    private val repostitory: QuizRepository
): ViewModel() {

    private val quizListUiState: MutableLiveData<QuizUiState> by lazy {
        MutableLiveData<QuizUiState>(QuizUiState(QuizList = repostitory.getQuizList()))
    }

    fun stateOnceAndStream(): LiveData<QuizUiState> {
        return quizListUiState
    }

    class QuizUiState(
        val QuizList: List<QuizItem>
    )

    @Suppress("UNCHECKED_CAST")
    class Factory(private val repository: QuizRepository) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return QuizListViewModel(repository) as T
        }
    }
}