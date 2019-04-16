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

abstract class CharacterClass(val name: String, val description: String, val hitDie: Dices, val proficiencies: List<Skills>?,
                              var levels: Int = 1, val classFeatures: List<ClassFeature>)

class Wizard: CharacterClass("Wizard", "This is a magic user", Dices.d6, null, 1, listOf())

class ClassFeature(val name: String, val description: String, val levelRequirement: Int, val proficiencies: List<Skills>)

class CharacterClassLevelTracker(var level: Int = 1, var experience: Long = 0, val characterClassLevels: MutableList<CharacterClass>,
                                 var prodiciencyBonus: Int = 0)



