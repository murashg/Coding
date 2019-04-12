package com.example.thecoralconche.Character

class AbilityScore (val strength: AbilitySubScore, val dexterity: AbilitySubScore,
                    val constitution: AbilitySubScore, val intelligence: AbilitySubScore,
                    val wisdom: AbilitySubScore, val charisma: AbilitySubScore)

class AbilitySubScore(val baseScore: Int = 0, val racialBonus: Int = 0, var abilityImprovements: Int = 0,
                      var miscBonus: Int = 0, var setScore: Int? = null,
                      var total: Int = setScore ?: baseScore+racialBonus+abilityImprovements+miscBonus,
                      var modifier: Int = (total-10)/2)

open abstract class AbilityScoreImprovment(val name: AbilityScoreAttributes? = null, val amount: Int? = null)

class RacialBonus(): AbilityScoreImprovment()
class FeatImprovment(): AbilityScoreImprovment()
