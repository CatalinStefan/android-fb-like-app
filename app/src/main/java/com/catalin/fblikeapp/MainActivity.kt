package com.catalin.fblikeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.catalin.fblikeapp.data.Shortcut
import com.catalin.fblikeapp.data.getRandomItems
import com.catalin.fblikeapp.ui.theme.FbLikeAppTheme
import kotlinx.coroutines.launch

sealed class Destination(val route: String) {
    object Home : Destination("home")
    object Notifications : Destination("notifications")
    object Detail : Destination("detail/{itemId}") {
        fun createRoute(itemId: Int) = "detail/$itemId"
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FbLikeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    FbScaffold(navController = navController)
                }
            }
        }
    }
}

@Composable
fun FbScaffold(navController: NavHostController) {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val onDrawerIconClick: () -> Unit = {
        scope.launch { scaffoldState.drawerState.open() }
    }
    val ctx = LocalContext.current

    val randomItems = remember { mutableStateOf(getRandomItems(10)) }
    val shortcuts = remember { mutableStateOf(Shortcut.getShortcuts()) }

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = { FbBottomNav(navController, onDrawerIconClick) },
        drawerContent = { NavigationDrawer(randomItems.value, shortcuts.value) }
    ) { padding ->
        val stdModifier = Modifier
            .padding(bottom = padding.calculateBottomPadding())
            .background(Color(0xFFcccccc))
        NavHost(navController = navController, startDestination = Destination.Home.route) {
            composable(Destination.Home.route) {
                HomeScreen(
                    navController = navController,
                    modifier = stdModifier
                )
            }
            composable(Destination.Notifications.route) {
                NotificationsScreen(modifier = stdModifier)
            }
            composable(Destination.Detail.route,
                deepLinks = listOf(
                    navDeepLink { uriPattern = "https://www.fblikeapp.com/{itemId}" }
                    )
            ) {
                val itemId = it.arguments?.getString("itemId")
                if (itemId == null)
                    Toast.makeText(ctx, "Id is required", Toast.LENGTH_SHORT).show()
                else
                    ItemDetailScreen(itemId.toInt(), modifier = stdModifier)
            }
        }

    }
}










