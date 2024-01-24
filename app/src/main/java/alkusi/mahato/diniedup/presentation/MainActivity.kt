package alkusi.mahato.diniedup.presentation

import alkusi.mahato.diniedup.navigation.SetupNavGraph
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import alkusi.mahato.diniedup.presentation.ui.theme.DiniEdupTheme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint

data class NavigationItem(val title:String,val selectedIcon:ImageVector,val unselectedIcon:ImageVector,val badgeCount:Int?=null)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiniEdupTheme {
                Surface(  modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    SetupNavGraph(navController = navController)
                }

            }
        }
    }
}


