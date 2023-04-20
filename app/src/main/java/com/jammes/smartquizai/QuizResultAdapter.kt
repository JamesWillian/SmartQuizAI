package com.jammes.smartquizai

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jammes.smartquizai.databinding.QuizResultsBinding

class QuizResultAdapter(
    private val viewModel: QuizQuestionsViewModel
): RecyclerView.Adapter<QuizResultAdapter.QuizResultViewHolder>() {

    class QuizResultViewHolder(
        private val binding: QuizResultsBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(question: QuizQuestions) {
            binding.questionTextView.text = question.question
            binding.resultTextView.text = question.explanation

            binding.root.setBackgroundColor(if (question.correctAnswer == question.pickedAnswer) {
                ContextCompat.getColor(binding.root.context, R.color.teal_200)
            } else {
                ContextCompat.getColor(binding.root.context, R.color.purple_200)
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizResultViewHolder {
        val binding = QuizResultsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuizResultViewHolder(binding)
    }

    override fun getItemCount() =
        viewModel.stateUiStateAsLiveData().value!!.index

    override fun onBindViewHolder(holder: QuizResultViewHolder, position: Int) {
        holder.bind(viewModel.stateUiStateAsLiveData().value!!.quizQuestionsList[position])

    }
}