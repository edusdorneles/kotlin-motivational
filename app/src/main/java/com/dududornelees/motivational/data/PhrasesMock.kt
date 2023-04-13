package com.dududornelees.motivational.data

import com.dududornelees.motivational.infra.MotivationalConstants
import kotlin.random.Random

class Phrase(val description: String, val categoryId: Int)

class PhrasesMock {
    private val volunteer = MotivationalConstants.CATEGORY.IMAGE_VOLUNTEER
    private val emoticon = MotivationalConstants.CATEGORY.IMAGE_EMOTICON
    private val sunny = MotivationalConstants.CATEGORY.IMAGE_SUNNY

    val mListPhrase = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", emoticon),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", emoticon),
        Phrase("Quando está mais escuro, vemos mais estrelas!", emoticon),
        Phrase("Não faça a mesma coisa e espere um resultado diferente.", emoticon),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", emoticon),
        Phrase("Agora você tem maior impacto sobre o seu sucesso.", emoticon),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sunny),
        Phrase("Você perde todas as chances que você não aproveita.", sunny),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sunny),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sunny),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sunny),
        Phrase("Se você acredita, faz toda a diferença.", sunny),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sunny)
    )

    fun getPhraseByCategoryId(categoryId: Int): String {
        val phrasesFilteredByCategoryId =
            mListPhrase.filter { it.categoryId == categoryId || categoryId == volunteer }

        val phraseIndex = Random.nextInt(phrasesFilteredByCategoryId.size)
        return phrasesFilteredByCategoryId[phraseIndex].description
    }
}