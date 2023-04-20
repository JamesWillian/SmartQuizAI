package com.jammes.smartquizai

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.jammes.smartquizai.databinding.FragmentQuizResultBinding
import com.jammes.smartquizai.dummy.MockQuestions

class QuizResultFragment: Fragment() {

    private var _binding: FragmentQuizResultBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: QuizResultAdapter

    private val viewModel: QuizQuestionsViewModel by activityViewModels {
        QuizQuestionsViewModel.Factory(MockQuestions)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = QuizResultAdapter(viewModel)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.resultRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.resultRecyclerView.adapter = adapter

        binding.correctAnswersTextView.text = "${viewModel.correctAnswers} de 10"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}