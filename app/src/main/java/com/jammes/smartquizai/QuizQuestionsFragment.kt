package com.jammes.smartquizai

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jammes.smartquizai.databinding.FragmentQuizQuestionsBinding
import com.jammes.smartquizai.dummy.MockQuestions

class QuizQuestionsFragment: Fragment() {

    private var _binding: FragmentQuizQuestionsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: QuizQuestionsViewModel by activityViewModels {
        QuizQuestionsViewModel.Factory(MockQuestions)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizQuestionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel
            .stateUiStateAsLiveData()
            .observe(viewLifecycleOwner) { uiState ->
                bindUiState(uiState)
            }

        binding.radioGroup.setOnCheckedChangeListener { _, i ->

            val group = binding.radioGroup
            val index = group.indexOfChild(group.findViewById<RadioButton>(i))

            if (index != -1) {
                viewModel.nextQuestion(index)
            }
        }

    }

    private fun bindUiState(uiState: QuizQuestionsViewModel.UiState) {

        val index = viewModel.currentQuizList.lastIndex

        //Se for a ultima pergunta, chama a tela do resultado
        if (index == 10) {
            findNavController().navigate(R.id.action_quizQuestionsFragment_to_quizResultFragment)
        } else {

            val newQuestion = uiState.currentQuestion

            binding.textViewQuestion.text = "${index+1}. ${newQuestion.question}"
            binding.radioButtonQ1.text = newQuestion.answers[0]
            binding.radioButtonQ2.text = newQuestion.answers[1]
            binding.radioButtonQ3.text = newQuestion.answers[2]
            binding.radioButtonQ4.text = newQuestion.answers[3]
            binding.radioButtonQ5.text = newQuestion.answers[4]

            binding.radioGroup.clearCheck()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
