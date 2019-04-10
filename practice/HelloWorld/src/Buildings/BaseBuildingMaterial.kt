package Buildings

open class BaseBuildingMaterial(var numberNeeded: Int = 1)

class Wood: BaseBuildingMaterial(4)
class Brick: BaseBuildingMaterial(8)
