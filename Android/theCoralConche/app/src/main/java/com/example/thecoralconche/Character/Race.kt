package com.example.thecoralconche.Character

import android.util.Range
import org.intellij.lang.annotations.Language

abstract class Race (val name: String, val description: String, val abilityScoreBonus: List<RacialBonus>,
                     val heightRange: IntRange, val size: RaceSizes, val weightRange: IntRange, val speed: Int,
                     val languages: List<Languages>, val feats: List<Feat>? = null){
}

class Human : Race("Human","Humans are the most adaptable and ambitious people among the common races.  " +
        "Whatever drives them, humans are the innovators, the achievers, and the pioneers of the worlds",
    listOf(RacialBonus(AbilityScoreAttributes.STRENGTH,1), RacialBonus(AbilityScoreAttributes.DEXTERITY, 1),
        RacialBonus(AbilityScoreAttributes.CONSTITUTION, 1), RacialBonus(AbilityScoreAttributes.WISDOM, 1),
        RacialBonus(AbilityScoreAttributes.WISDOM, 1), RacialBonus(AbilityScoreAttributes.CHARISMA, 1)),
    60..74, RaceSizes.Medium, 100..250, 30, listOf(Languages.Common))