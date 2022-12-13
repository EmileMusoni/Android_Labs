package com.example.mangrove.compose

import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mangrove.NavigationItem
import androidx.navigation.compose.rememberNavController


@Composable

fun BottomNavigationBar(navController: NavController)
{
    val items= listOf(NavigationItem.Home,NavigationItem.Search,NavigationItem.Post, NavigationItem.Profile)
    BottomAppBar(
        backgroundColor =MaterialTheme.colors.primary
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = "Icon", modifier = Modifier.size(30.dp))},
                label ={ Text(text = item.name)},
                alwaysShowLabel = true,
                selectedContentColor = MaterialTheme.colors.onPrimary .copy(0.4f),
                unselectedContentColor = MaterialTheme.colors.onPrimary,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route)
                    {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
@Composable
fun NavigationOnDifferentPages(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            var Loginvariable by remember{ mutableStateOf(true) }
            var registervariable by remember{ mutableStateOf(true) }
            var categoryvariable by remember{ mutableStateOf(true) }

            if(Loginvariable && registervariable && categoryvariable)
            {
                HomeScreen({ Loginvariable=false},{registervariable=false},{categoryvariable=false})

            }
            else if(Loginvariable==false)
            {
                LoginProject(LocalContext.current)
            }
            else if(registervariable==false)
            {
                RegisterProject(LocalContext.current)
            }
            else if(categoryvariable==false)
            {
                PostScreen()
            }

        }
        composable(NavigationItem.Search.route) {
            SearchScreen()
        }
        composable(NavigationItem.Post.route) {
            mainFun()
        }
        composable(NavigationItem.Profile.route) {
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
    }
}