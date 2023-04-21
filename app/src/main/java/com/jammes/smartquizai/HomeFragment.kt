package com.jammes.smartquizai

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jammes.smartquizai.databinding.FragmentHomeBinding
import com.jammes.smartquizai.dummy.MockQuestions

class HomeFragment: Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: QuizQuestionsViewModel by activityViewModels {
        QuizQuestionsViewModel.Factory(MockQuestions)
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

        binding.startButtom.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_quizQuestionsFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.clearQuizUiState()
    }
}