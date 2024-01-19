package alkusi.mahato.diniedup.navigation

import alkusi.mahato.diniedup.common.DiniConstants

sealed class Screen(val route:String)
{
    object LoginSignUp :Screen(DiniConstants.LOGIN_SIGNUP)
}