package alkusi.mahato.diniedup.presentation.home.components.data

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(val title:String,val selectedIcon:ImageVector,val unselectedIcon: ImageVector,val hasNotification:Boolean,val badgeCount:Int? = null)