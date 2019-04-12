package com.example.thecoralconche.Character

import com.example.thecoralconche.Objects.Dices

class Character (var name: String,
                 val race: Race,
                 var age: Int,
                 var hitpoints: Int,
                 val characterClassLevelTracker: CharacterClassLevelTracker,
                 val abilityScore: AbilityScore,
                 val background: Background,
                 val equipment: MutableList<Equipment>,
                 var currency: Int,
                 val proficiencies: MutableList<Skills>,
                 var walkingSpeed: Int,
                 val initiative: Int = abilityScore.dexterity.modifier,
                 var armorClass: Int,
                 val spells: MutableList<Spell>
)

abstract class CharacterClass(val name: String, val description: String, val hitDie: Dices, val proficiencies: List<Skills>,
                              val )

class CharacterClassLevelTracker(var level: Int = 1, var experience: Long = 0, val characterClassLevels: MutableList<CharacterClass>,
                                 var prodiciencyBonus: Int = 0)



