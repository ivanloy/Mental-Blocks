package com.ivanloy.mentalblocks

enum class Elements(val id : Int, val intCode : Int) {
    EMPTY(0, 0xFFFFFFFF.toInt()),
    FIRE(1, 0xFFef9a9a.toInt()),
    WATER(2, 0xFF90CAF9.toInt()),
    FOREST(3, 0xFFA5D6A7.toInt())
}