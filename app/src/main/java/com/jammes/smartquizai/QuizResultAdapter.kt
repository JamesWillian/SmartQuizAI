package com.jammes.smartquizai

import android.view.LayoutInflater
import android.view.View
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
            val pickedAnswer = binding.pickedAnswerTextView
            val correctAnswer = binding.correctAnswerTextView

            binding.questionTextView.text = question.question
            pickedAnswer.text = question.answers[question.pickedAnswer!!]
            correctAnswer.text = question.explanation

            if (question.correctAnswer == question.pickedAnswer) {
                pickedAnswer.setTextColor(ContextCompat.getColor(binding.root.context, R.color.dartmouth_green))
                correctAnswer.visibility = View.GONE
            } else {
                pickedAnswer.setTextColor(ContextCompat.getColor(binding.root.context, R.color.falu_red))
                correctAnswer.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizResultViewHolder {
        val binding = QuizResultsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuizResultViewHolder(binding)
    }

    override fun getItemCount() = viewModel.currentQuizList.lastIndex

    override fun onBindViewHolder(holder: QuizResultViewHolder, position: Int) {
        holder.bind(viewModel.currentQuizList[position])

    }
}