package alkusi.mahato.diniedup.navigation

import alkusi.mahato.diniedup.constants.DiniConstants

sealed class Screen(val route:String)
{
    object LoginSignUp :Screen(DiniConstants.LOGIN_SIGNUP)
}