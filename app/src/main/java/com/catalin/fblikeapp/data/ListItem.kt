package com.catalin.fblikeapp.data

abstract class ListItem {
    companion object {
        private var id = 0
        fun getUUID() = id++
    }
}

fun getItem(uuid: Int): ListItem? {
    for (dessert in Dessert.getAllDesserts())
        if (dessert.id == uuid)
            return dessert
    for (fruit in Fruit.getAllFruits())
        if (fruit.id == uuid)
            return fruit
    return null
}

fun getRandomItems(amount: Int): List<ListItem> {
    val items = arrayListOf<ListItem>()
    val types = listOf(Dessert::class, Fruit::class, Person::class)
    for (i in 1..amount) {
        val item = when (types.random()) {
            Dessert::class -> { Dessert.getAllDesserts().random() }
            Fruit::class -> { Fruit.getAllFruits().random() }
            else -> Person.getPeople().random()
        }
        items.add(item)
    }
    return items
}