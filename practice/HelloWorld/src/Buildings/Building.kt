package Buildings

class Building<out T: BaseBuildingMaterial>(val buildingMaterial: T){
    val baseMaterialsNeeded = 100
    val actualMaterialNeeded = buildingMaterial.numberNeeded * baseMaterialsNeeded

    fun build(){
        println("$actualMaterialNeeded ${buildingMaterial::class.simpleName} required")
    }
}

fun <T: BaseBuildingMaterial> isSmallBuilding(building: Building<T>){
    val smallBuilding = building.actualMaterialNeeded < 500
    println("${
        when {
            smallBuilding -> "small"
            else -> "large"
        }
    } building")
}

fun main(){
    val hut = Building(Wood())
    hut.build()
    Building(Brick()).build()
    Building(BaseBuildingMaterial()).build()
    val steel = BaseBuildingMaterial(15)
    val tower = Building(steel)
    tower.build()
    isSmallBuilding(hut)
    isSmallBuilding(tower)

}