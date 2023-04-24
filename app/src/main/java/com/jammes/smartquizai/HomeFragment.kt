package com.jammes.smartquizai

import android.os.Bundle
import android.system.Os
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jammes.smartquizai.databinding.FragmentHomeBinding
import com.jammes.smartquizai.dummy.MockQuestions
import com.jammes.smartquizai.dummy.MockQuiz

class HomeFragment: Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: QuizListAdapter
    private val viewModel: QuizQuestionsViewModel by activityViewModels {
        QuizQuestionsViewModel.Factory(MockQuestions)
    }
    private val quizViewModel: QuizListViewModel by viewModels {
        QuizListViewModel.Factory(MockQuiz)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = QuizListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.quizRecycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.quizRecycleView.adapter = adapter

        quizViewModel.stateOnceAndStream()
            .observe(viewLifecycleOwner) {
                bindUiState(it)
            }
    }

    fun bindUiState(uiState: QuizListViewModel.QuizUiState) {
        adapter.updateQuizList(uiState.QuizList)
    }

    override fun onResume() {
        super.onResume()
        viewModel.clearQuizUiState()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}