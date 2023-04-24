package com.jammes.smartquizai

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jammes.smartquizai.databinding.QuizItemBinding

class QuizListAdapter(): RecyclerView.Adapter<QuizListAdapter.QuizListViewHolder>() {

    class QuizListViewHolder(
        private val binding: QuizItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(quiz: QuizItem) {

            binding.titleTextView.text = quiz.title
            binding.dificultTextView.text = "Nível: ${quiz.questionDificult}"

            binding.startButtom.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_quizQuestionsFragment)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizListViewHolder {
        val binding = QuizItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuizListViewHolder(binding)
    }

    override fun getItemCount() = 7

    override fun onBindViewHolder(holder: QuizListViewHolder, position: Int) {
        holder.bind(asyncListDifer.currentList[position])
    }

    private val asyncListDifer: AsyncListDiffer<QuizItem> = AsyncListDiffer(this, DiffCallback)

    fun updateQuizList(quiz: List<QuizItem>) {
        asyncListDifer.submitList(quiz)
    }

    object DiffCallback: DiffUtil.ItemCallback<QuizItem>() {
        override fun areItemsTheSame(oldItem: QuizItem, newItem: QuizItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: QuizItem, newItem: QuizItem): Boolean {
            TODO("Not yet implemented")
        }

    }
}