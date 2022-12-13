package com.example.mangrove

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.mangrove.compose.BottomNavigationBar
import com.example.mangrove.compose.NavigationOnDifferentPages
import com.example.mangrove.compose.ProductScreen
import com.example.mangrove.compose.ProfileScreen
import com.example.mangrove.ui.theme.MangroveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MangroveTheme {
                // A surface container using the 'background' color from the theme
                myprojectMainfunction()
            }
        }
    }
}
@Composable
fun newmain()
{
    var productvariable by remember{ mutableStateOf(true) }
    if (productvariable)
    {
        ProfileScreen({productvariable=false})
    }
    else
    {
        ProductScreen()
    }

}

@Composable
fun myprojectMainfunction() {
    val navController = rememberNavController()
    Scaffold(
        //topBar = {topBarcompose()},
        bottomBar = { BottomNavigationBar(navController) },
        content = {
            NavigationOnDifferentPages(navController = navController)
        },
        backgroundColor = MaterialTheme.colors.primary
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MangroveTheme  {
        myprojectMainfunction()
    }
}