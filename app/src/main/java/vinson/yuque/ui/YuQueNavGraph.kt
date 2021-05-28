package vinson.yuque.ui

import androidx.compose.material.BackdropScaffoldState
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import vinson.yuque.ui.home.HomeScreen
import vinson.yuque.ui.login.LoginScreen

object MainDestinations{
    const val HOME_ROUTE = "home"
    const val LOGIN_ROUTE = "login"
}

@Composable
fun YuQueNavGraph(
    navController: NavHostController = rememberNavController(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    startDestination: String = MainDestinations.LOGIN_ROUTE
){
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable(MainDestinations.HOME_ROUTE) {
            HomeScreen()
        }
        composable(MainDestinations.LOGIN_ROUTE) {
            LoginScreen()
        }
    }
}