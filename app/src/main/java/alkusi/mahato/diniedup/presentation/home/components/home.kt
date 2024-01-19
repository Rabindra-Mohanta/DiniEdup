package alkusi.mahato.diniedup.presentation.home.components

import alkusi.mahato.diniedup.presentation.home.components.data.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable



@OptIn(ExperimentalMaterial3Api::class)
@Composable()
fun home()
{
    val items = listOf(BottomNavigationItem(title = "Home", selectedIcon = Icons.Filled.Home, unselectedIcon = Icons.Outlined.Home,hasNotification = false ))
    Scaffold(bottomBar = { NavigationBar {

    }} ) {

    }
}