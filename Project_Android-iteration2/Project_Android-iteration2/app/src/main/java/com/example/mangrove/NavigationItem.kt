package com.example.mangrove

sealed class NavigationItem(var route: String,var icon: Int, var name: String )
{
    object  Home : NavigationItem("Home", R.drawable.ic_baseline_home_24,"Home")
    object  Search : NavigationItem("search", R.drawable.ic_baseline_search_24,"Search")
    object  Post : NavigationItem("Post", R.drawable.ic_baseline_post_add_24,"Post")
    object  Profile : NavigationItem("profile", R.drawable.ic_baseline_person_24,"Profile")
}
