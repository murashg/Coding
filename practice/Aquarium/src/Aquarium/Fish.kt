package Aquarium

class Fish(val friendly: Boolean = true, volumeNeeded: Int) {
    val size: Int

    init {
        if (friendly) size = volumeNeeded else size = volumeNeeded * 2
    }
}
fun makeDefaultFish() = Fish(friendly = true, volumeNeeded = 2)