package alkusi.mahato.diniedup.presentation

import alkusi.mahato.diniedup.navigation.SetupNavGraph
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import alkusi.mahato.diniedup.presentation.ui.theme.DiniEdupTheme
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Note
import androidx.compose.material.icons.filled.OndemandVideo
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.EditNote
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Logout
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Note
import androidx.compose.material.icons.outlined.OndemandVideo
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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


