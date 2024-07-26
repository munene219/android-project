package net.ezra.ui.home1

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_REGISTER
import net.ezra.navigation.ROUTE_VIEW_PROD

@Composable
fun HomeScreen(navController: NavHostController,) {
LazyColumn {
    item {
        androidx.compose.material3.Card(
            onClick = {
                navController.navigate(ROUTE_REGISTER) {
                    popUpTo(ROUTE_VIEW_PROD) { inclusive = true }
                }
            },
        ) {
            androidx.compose.material.Text(
                "Please login to explore more",
                style = androidx.compose.material.MaterialTheme.typography.h5
            )
        }
        androidx.compose.material3.Card(
            onClick = {
                navController.navigate(ROUTE_REGISTER) {
                    popUpTo(ROUTE_VIEW_PROD) { inclusive = true }
                }
            },
        ) {
            androidx.compose.material.Text(
                "Please login to explore more",
                style = androidx.compose.material.MaterialTheme.typography.h5
            )
        }
        androidx.compose.material3.Card(
            onClick = {
                navController.navigate(ROUTE_REGISTER) {
                    popUpTo(ROUTE_VIEW_PROD) { inclusive = true }
                }
            },
        ) {
            androidx.compose.material.Text(
                "Please login to explore more",
                style = androidx.compose.material.MaterialTheme.typography.h5
            )
        }
        androidx.compose.material3.Card(
            onClick = {
                navController.navigate(ROUTE_REGISTER) {
                    popUpTo(ROUTE_VIEW_PROD) { inclusive = true }
                }
            },
        ) {
            androidx.compose.material.Text(
                "Please login to explore more",
                style = androidx.compose.material.MaterialTheme.typography.h5
            )
        }

    }
}
}