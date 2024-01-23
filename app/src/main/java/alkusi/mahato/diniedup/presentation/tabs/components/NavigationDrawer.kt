package alkusi.mahato.diniedup.presentation.tabs.components

import alkusi.mahato.diniedup.presentation.NavigationItem
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable()
fun NavigationDrawer()
{
    val items = listOf(
        NavigationItem("Home", selectedIcon = Icons.Filled.Home, unselectedIcon = Icons.Outlined.Home)
        , NavigationItem("Videos", selectedIcon = Icons.Filled.OndemandVideo, unselectedIcon = Icons.Outlined.OndemandVideo),
        NavigationItem("Messages", selectedIcon = Icons.Filled.Message, unselectedIcon = Icons.Outlined.Message),
        NavigationItem("Courses", selectedIcon = Icons.Filled.EditNote, unselectedIcon = Icons.Outlined.EditNote),
        NavigationItem("Test Series", selectedIcon = Icons.Filled.Note, unselectedIcon = Icons.Outlined.Note),
        NavigationItem("Settings", selectedIcon = Icons.Filled.Settings, unselectedIcon = Icons.Outlined.Settings),
        NavigationItem("Logout", selectedIcon = Icons.Filled.Logout, unselectedIcon = Icons.Outlined.Logout)
    )

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    ModalNavigationDrawer(drawerContent = { ModalDrawerSheet {
        Spacer(modifier = Modifier.height(16.dp))
        items.forEachIndexed { index, navigationItem ->
            NavigationDrawerItem(
                label = { Text(text = navigationItem.title) },
                selected = index == selectedItemIndex,
                onClick = { selectedItemIndex = index
                    scope.launch {
                        drawerState.close()
                    }
                }, icon = { Icon(imageVector = if(index == selectedItemIndex){navigationItem.selectedIcon} else navigationItem.unselectedIcon, contentDescription = navigationItem.title ) },
                badge = {
                    navigationItem.badgeCount?.let {
                        Text(text = it.toString())}

                }, modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
        }

    } },drawerState = drawerState) {
        Scaffold(topBar = { TopAppBar(title = { Text(text = "Todo App") }, navigationIcon = { IconButton(
            onClick = { scope.launch {drawerState.open()  } }) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")

        }
        })
        }) {

        }
    }
}