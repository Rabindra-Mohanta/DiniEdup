package alkusi.mahato.diniedup.navigation

import alkusi.mahato.diniedup.presentation.auth.Auth
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.LoginSignUp.route) {

        composable(route = Screen.LoginSignUp.route) {
            Auth()
        }

    }
}
