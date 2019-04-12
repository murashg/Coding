package com.example.thecoralconche.Character

abstract class Feat(val description: String, val abilityScoreIncrease: List<AbilityScoreImprovment>? = null,
                    val proficiencies: List<Skills>? = null)

class Actor: Feat("You are skilled at Acting",listOf(FeatImprovment()))