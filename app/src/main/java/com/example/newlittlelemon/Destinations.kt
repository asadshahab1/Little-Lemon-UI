package com.example.newlittlelemon

interface AnotherDestination{
    val route: String
}

object Home:AnotherDestination{
    override val route: String = "Home"
}

object DishDetail: AnotherDestination{
    override val route: String = "Details"
    const val argDishId = "dishId"
}