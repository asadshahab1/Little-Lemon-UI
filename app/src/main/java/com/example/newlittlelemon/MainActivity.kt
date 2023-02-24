//package com.example.newlittlelemon
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material.Button
//import androidx.compose.material.ButtonDefaults
//import androidx.compose.material.Text
//import androidx.compose.material.TextField
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            LoginScreen()
//        }
//    }
//}
//
//@Composable
//fun LoginScreen() {
//    var username by remember{
//        mutableStateOf("")
//    }
//    var password by remember{
//        mutableStateOf("")
//    }
//    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
//        Image(painter = painterResource(id = R.drawable.littlelemonlogo), contentDescription = "Logo")
//        TextField(value = username, onValueChange = {username = it}, label = {Text("Username")}, modifier = Modifier.padding(10.dp))
//        TextField(value = password, onValueChange = {password = it}, label = { Text(text = "Password")},modifier=Modifier.padding(10.dp))
//        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF495E57)), modifier = Modifier.padding(10.dp)) {
//            Text(text = "Login", color = Color(0xFFEDEFEE))
//
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    LoginScreen()
//}