package com.jammes.smartquizai.dummy

import com.jammes.smartquizai.Questions
import com.jammes.smartquizai.core.QuestionsRepository

object MockQuestions: QuestionsRepository {

    val questionList = listOf(
        Questions(
            "Qual é o nome completo de Rony Weasley?",
            listOf("Ronald Bilius Weasley",
                   "Ronald Arthur Weasley",
                   "Ronald William Weasley",
                   "Ronald Charles Weasley",
                   "Ronald Fredrick Weasley"),
            0,
            "A resposta correta é: Ronald Bilius Weasley."
        ),

        Questions(
            "Em que casa da Escola de Magia e Bruxaria de Hogwarts Harry Potter foi classificado?",
            listOf("Lufa-Lufa",
                "Sonserina",
                "Grifinória",
                "Corvinal",
                "Nenhuma das opções"),
            2,
            "A resposta correta é: Grifinória."
        ),

        Questions(
            "Onde fica a plataforma 9 3/4, que leva os alunos para o Expresso de Hogwarts?",
            listOf("No Aeroporto de Heathrow",
                "Na Estação King's Cross",
                "Na Estação Victoria",
                "Na Estação Paddington",
                "Nenhuma das opções"),
            1,
            "A resposta correta é: Na Estação King's Cross."
        ),

        Questions(
            "Quem é o diretor da Escola de Magia e Bruxaria de Hogwarts durante a maior parte da série Harry Potter?",
            listOf("Alvo Dumbledore",
                "Severus Snape",
                "Horácio Slughorn",
                "Minerva McGonagall",
                "Dolores Umbridge"),
            0,
            "A resposta correta é: Alvo Dumbledore."
        ),

        Questions(
            "Qual das criaturas abaixo é conhecida por sua habilidade em produzir ouro puro?",
            listOf("Centauros",
                "Hipogrifos",
                "Elfos domésticos",
                "Fênix",
                "Duendes"),
            4,
            "A resposta correta é: Duendes."
        ),

        Questions(
            "Qual é o nome completo de Hermione Granger?",
            listOf("Hermione Jane Granger",
                "Hermione Jean Granger",
                "Hermione Elizabeth Granger",
                "Hermione Isabella Granger",
                "Hermione Lily Granger"),
            1,
            "A resposta correta é: Hermione Jean Granger."
        ),

        Questions(
            "Qual é o nome da vassoura que Harry Potter recebeu como presente de Natal em seu primeiro ano em Hogwarts?",
            listOf("Nimbus 2001",
                "Firebolt",
                "Cleansweep One",
                "Comet Two Sixty",
                "Shooting Star"),
            0,
            "A resposta correta é: Nimbus 2001."
        ),

        Questions(
            "Qual é a função da varinha de sauco, uma das Relíquias da Morte?",
            listOf("Fazer seu dono invencível",
                "Trazer pessoas de volta dos mortos",
                "Realizar desejos",
                "Conceder a imortalidade",
                "Dar o poder de voar"),
            0,
            "A resposta correta é: Fazer seu dono invencível."
        ),

        Questions(
            "Quem é o meio-irmão de Harry Potter, filho do segundo casamento de seu pai?",
            listOf("Dudley Dursley",
                "Petunia Dursley",
                "Vernon Dursley",
                "Marvolo Gaunt",
                "Nenhum dos acima"),
            4,
            "Harry não tem meio-irmão."
        ),

        Questions(
            "Qual é o nome do elfo doméstico que serviu a família Black e acabou ajudando Harry Potter?",
            listOf("Dobby",
                "Winky",
                "Kreacher",
                "Hokey",
                "Nenhum dos acima"),
            2,
            "Kreacher era o elfo doméstico que servia a família Black e acabou ajudando Harry Potter."
        ),
    )

    override fun getRandomQuestions() = questionList.shuffled().take(10)

}