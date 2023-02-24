package com.example.newlittlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.newlittlelemon.DishRepository.Dishes
import com.example.newlittlelemon.ui.theme.cloud
import com.example.newlittlelemon.ui.theme.green
import com.example.newlittlelemon.ui.theme.yellow

@Composable
fun MenuListScreen(navController: NavHostController?) {

    Column {
        UpperPanel()
        MenuLowerPanel(navController)
    }

}

@Composable
private fun UpperPanel() {
    Column(
        modifier = Modifier
            .background(green)
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.title),
            fontSize = 40.sp,
            fontWeight = Bold,
            color = yellow
        )

    }
    Text(
        text = stringResource(id = R.string.order_for_takeaway),
        fontSize = 24.sp,
        fontWeight = Bold,
        color = cloud,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

@Composable
private fun MenuLowerPanel(navController: NavHostController?) {
    Column {
        LazyRow {
            items(Categories) { category ->
                MenuCategory(category)
            }
        }
        Divider(
            modifier = Modifier.padding(8.dp),
            color = yellow,
            thickness = 1.dp
        )
        LazyColumn {
            items(Dishes) { Dish ->
                MenuDish(navController = navController,Dish)
            }
        }
    }
}

@Composable
fun MenuCategory(category: String) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
        shape = RoundedCornerShape(40),
        modifier = Modifier.padding(5.dp)
    ) {
        Text(
            text = category
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MenuDish(navController: NavHostController? = null, Dish: Dish) {
    Card(onClick = {navController?.navigate(DishDetail.route+"/${Dish.id}")}) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column {
                Text(
                    text = Dish.name, fontSize = 18.sp, fontWeight = Bold, style = MaterialTheme.typography.h2
                )
                Text(
                    text = Dish.description,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                        .fillMaxWidth(.75f),
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = "$"+Dish.price.toString(), color = Color.Gray, fontWeight = Bold, style = MaterialTheme.typography.body2
                )
            }
            Image(
                painter = painterResource(id = Dish.image),
                contentDescription = "",
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
            )
        }
    }
    Divider(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        color = Color.LightGray,
        thickness = 1.dp
    )
}

val Categories = listOf(
    "Lunch",
    "Dessert",
    "A La Carte",
    "Mains",
    "Specials"
)

data class Dish(
    val id: Int,
    val name: String,
    val price: Double,
    val description: String,
    val image: Int
)
object DishRepository{
val Dishes = listOf(
    Dish(
        1,
        "Greek Salad",
        12.99,
        "The famous greek salad of crispy lettuce, peppers, olives and our Chicago...",
        R.drawable.greeksalad
    ),
    Dish(
        2,
        "Bruschetta",
        5.99,
        "Our Bruschetta is made from grilled bread that has been smeared with garlic...",
        R.drawable.bruschetta
    ),
    Dish(3,
        "Lemon Dessert",
        9.99,
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.lemondessert
    ),
//    Dish(4,
//    "Grilled FIsh",
//    19.99,
//        "Fish marinated in fresh orange and lemon juice. Grilled with orange and lemon wedges.",
//        R.drawable.grilledfish
//    ),
//    Dish(5,
//    "Pasta",
//    8.99,
//        "Penne with fried aubergines, cherry tomatoes, tomato sauce, fresh chilli, garlic, basil & salted ricotta cheese.",
//    R.drawable.pasta),
//    Dish(6,
//    "Lasagne",
//    7.99,
//    "Oven-baked layers of pasta stuffed with Bolognese sauce, béchamel sauce, ham, Parmesan & mozzarella cheese .",
//    R.drawable.lasagne)


)
fun getDishId(id: Int) = Dishes.firstOrNull { it.id == id }}