package ir.mslx.navigation.navigation


sealed class Screens(val route: String){
    object loading: Screens("loading")
    object Profile: Screens("profile")
}