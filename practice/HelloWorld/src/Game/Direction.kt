package Game

enum class Direction {
    NORTH, SOUTH, EAST, WEST, START, END
}

inline fun enumContains(name: String) = enumValues<Direction>().any { it.name == name}