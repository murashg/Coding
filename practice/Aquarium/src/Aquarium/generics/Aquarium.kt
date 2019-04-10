package Aquarium.generics


open class WaterSupply(var needsProcessed: Boolean)

class TapWater : WaterSupply(true){
    fun addChemicalCleaners(){needsProcessed = false}
}

class TapWaterCleaner: Cleaner<TapWater>{
    override fun clean(waterSupply: TapWater){
        waterSupply.addChemicalCleaners()
    }
}

class FishStoreWater : WaterSupply(false)
class LakeWater : WaterSupply(true){
    fun filter(){needsProcessed = false}
}
//non-null WaterSupply
class Aquarium<out T: WaterSupply>(val waterSupply: T){
    fun addWater(cleaner: Cleaner<T>){
        if (waterSupply.needsProcessed){
            cleaner.clean(waterSupply)
        }

        //check(!waterSupply.needsProcessed){"Water supply needs processed"}
        println("adding water from $waterSupply")


    }
}
//star projection and reified ("real types")
inline fun <reified R : WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R
inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T

interface Cleaner<in T: WaterSupply>{
    fun clean(waterSupply: T)
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

fun genericExample() {
    val aquarium = Aquarium(TapWater())
    aquarium.waterSupply.addChemicalCleaners()

    val aquarium2 = Aquarium(LakeWater())
    aquarium2.waterSupply.filter()
    //aquarium2.addWater() //throws error if not filtered
    val cleaner = TapWaterCleaner()
    val aquarium3 = Aquarium(TapWater())
    aquarium3.addWater(cleaner)
}

fun main(){
    genericExample()
}