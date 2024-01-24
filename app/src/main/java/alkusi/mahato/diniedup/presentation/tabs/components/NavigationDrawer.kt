package alkusi.mahato.diniedup.presentation.tabs.components
import alkusi.mahato.diniedup.R
import alkusi.mahato.diniedup.presentation.NavigationItem
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Logout
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
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable()
@Preview
fun NavigationDrawer() {
    val items = listOf(
        NavigationItem(
            "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home
        ),
        NavigationItem(
            "Videos",
            selectedIcon = Icons.Filled.OndemandVideo,
            unselectedIcon = Icons.Outlined.OndemandVideo
        ),
        NavigationItem(
            "Messages",
            selectedIcon = Icons.Filled.Message,
            unselectedIcon = Icons.Outlined.Message
        ),
        NavigationItem(
            "Courses",
            selectedIcon = Icons.Filled.EditNote,
            unselectedIcon = Icons.Outlined.EditNote
        ),
        NavigationItem(
            "Test Series",
            selectedIcon = Icons.Filled.Note,
            unselectedIcon = Icons.Outlined.Note
        ),
        NavigationItem(
            "Settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings
        ),
        NavigationItem(
            "Logout",
            selectedIcon = Icons.Filled.Logout,
            unselectedIcon = Icons.Outlined.Logout
        )
    )

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    val scope = rememberCoroutineScope()
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    ModalNavigationDrawer(drawerContent = {
        ModalDrawerSheet {
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Image(painter = painterResource(id = R.drawable.logo), contentDescription = stringResource(id = R.string.txt_image),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .padding(start = 10.dp)
                        .clip(CircleShape) )
                Column(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                    Text(text = "Rabindra Mohanta", fontSize = 18.sp)
                    Text(text = "Student", fontSize = 13.sp)
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
            items.forEachIndexed { index, navigationItem ->
                NavigationDrawerItem(
                    label = { Text(text = navigationItem.title) },
                    selected = index == selectedItemIndex,
                    onClick = {
                        selectedItemIndex = index
                        scope.launch {
                            drawerState.close()
                        }
                    }, icon = {
                        Icon(
                            imageVector = if (index == selectedItemIndex) {
                                navigationItem.selectedIcon
                            } else navigationItem.unselectedIcon,
                            contentDescription = navigationItem.title
                        )
                    },
                    badge = {
                        navigationItem.badgeCount?.let {
                            Text(text = it.toString())
                        }

                    }, modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
            }

        }
    }, gesturesEnabled = false ,drawerState = drawerState) {

    }


}