package com.example.newlittlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newlittlelemon.ui.theme.NewLittleLemonTheme

class NewMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                NewLittleLemonTheme() {

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Home.route) {
                    composable(Home.route) {
                        HomeScreen(navController)
                    }
                    composable(
                        DishDetail.route + "/{${DishDetail.argDishId}}",
                        arguments = listOf(navArgument(DishDetail.argDishId) { type = NavType.IntType })
                    ) {
                        val id = requireNotNull(it.arguments?.getInt(DishDetail.argDishId)) { "Dish id is null" }
                        DishDetails(id)
                    }
                }
            }
        }
    }}


//@Composable
//private fun AppScreen() {

//    Scaffold(topBar = {
//        TopAppBar()
//    }) {
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(it)
//        ) { MyBottom()
//        }
//    }
//}
//
//@Composable
//fun MyBottomNavigation(navController: NavController){
//    val destinationList = listOf(Home, Menu, Location)
//    val selectedIndex = rememberSaveable {
//        mutableStateOf(0)
//    }
//    BottomNavigation {
//        destinationList.forEachIndexed { index, destinations -> BottomNavigationItem(
//            selected = selectedIndex.value == index,
//            onClick = {selectedIndex.value = index
//                      navController.navigate(destinationList[index].route){popUpTo(Home.route)
//                      launchSingleTop = true} }, label = {Text(text = destinations.title)},
//        icon = { Icon(painter = painterResource(id = destinations.icon), contentDescription = "$destinations.title icon")})
//        }
//    }
//}
//@Composable
//fun MyBottom(){
//    val navController = rememberNavController()
//    Scaffold(bottomBar = {MyBottomNavigation(navController)}) {
//        Box(modifier = Modifier.padding(it)){
//            NavHost(navController = navController, startDestination = Home.route){
//                composable(Home.route){
//                    HomeScreen(navController)
//                }
//                composable(Menu.route){
//                    MenuListScreen(navController = navController)
//                }
//                composable(Location.route){
//                    LocationScreen()
//                }
//            }
//        }
//    }
//}
