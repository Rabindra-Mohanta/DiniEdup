package alkusi.mahato.diniedup.presentation.tabs.components

import alkusi.mahato.diniedup.R
import alkusi.mahato.diniedup.common.DiniConstants
import alkusi.mahato.diniedup.presentation.course.components.CourseScreen
import alkusi.mahato.diniedup.presentation.home.components.HomeScreen
import alkusi.mahato.diniedup.presentation.home.components.data.BottomNavigationItem
import alkusi.mahato.diniedup.presentation.live.components.Live
import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Note
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LiveTv
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Note
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable()
@Preview(showBackground = true)
fun BottomTabs() {

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(DiniConstants.ZERO_INT)
    }
    val items = listOf(
        BottomNavigationItem(
            title = stringResource(id = R.string.txt_home),
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNotification = false
        ),
        BottomNavigationItem(
            title = stringResource(id = R.string.txt_course),
            selectedIcon = Icons.Filled.Note,
            unselectedIcon = Icons.Outlined.Note,
            hasNotification = false
        ),
        BottomNavigationItem(
            title = stringResource(id = R.string.txt_live),
            selectedIcon = Icons.Filled.LiveTv,
            unselectedIcon = Icons.Outlined.LiveTv,
            hasNotification = false
        ),
        BottomNavigationItem(
            title = stringResource(id = R.string.txt_menu),
            selectedIcon = Icons.Filled.Menu,
            unselectedIcon = Icons.Outlined.Menu,
            hasNotification = false)
    )
    Scaffold(bottomBar = {
        NavigationBar {
            items.forEachIndexed { index, item ->
                NavigationBarItem(selected = selectedItemIndex == index, onClick = {
                    selectedItemIndex = index
                }, label = { Text(text = item.title) }, alwaysShowLabel = true, icon = {
                    BadgedBox(badge = {
                        if (item.badgeCount != null) {
                            Badge {
                                Text(text = item.badgeCount.toString())
                            }
                        } else if (item.hasNotification) {
                            Badge()
                        }
                    }) {
                        Icon(
                            imageVector = if (index == selectedItemIndex) {
                                item.selectedIcon
                            } else item.unselectedIcon,
                            contentDescription = item.title
                        )
                    }
                })
            }

        }
    }, floatingActionButton = {
        SmallFloatingActionButton(
            onClick = { },
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = stringResource(id = R.string.txt_image)
            )
        }
    }) {

        when (selectedItemIndex) {
            DiniConstants.ZERO_INT -> HomeScreen()
            DiniConstants.ONE_INT -> CourseScreen()
            DiniConstants.TWO_INT -> Live()
            DiniConstants.THREE_INT ->  NavigationDrawer()
            else -> HomeScreen()
        }


    }
}
