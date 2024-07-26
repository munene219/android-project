package net.ezra.navigation

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import net.ezra.ui.About_us.AboutusScreen
import net.ezra.ui.SplashScreen
import net.ezra.ui.about.AboutScreen
import net.ezra.ui.auth.LoginScreen
import net.ezra.ui.auth.SignUpScreen
import net.ezra.ui.dashboard.DashboardScreen
//import net.ezra.ui.auth.SignupScreen
import net.ezra.ui.home.HomeScreen
import net.ezra.ui.pages.AnchorScreen
import net.ezra.ui.pages.AnswerScreen
import net.ezra.ui.pages.FaithScreen
import net.ezra.ui.pages.KnowingJesusScreen
import net.ezra.ui.pages.LoveScreen
import net.ezra.ui.pages.PrayScreen
import net.ezra.ui.pages.PurposeCreationScreen
import net.ezra.ui.pages.RisenScreen
import net.ezra.ui.products.AddProductScreen
import net.ezra.ui.products.ProductDetailScreen
import net.ezra.ui.products.ProductListScreen
import net.ezra.ui.students.AddStudents
import net.ezra.ui.students.Search
import net.ezra.ui.students.Test
import net.ezra.ui.terms.TermsScreen
import net.ezra.navigation.ROUTE_ANCHOR1
import net.ezra.ui.Anchor1.Anchor1Screen
import net.ezra.ui.products.UpdateProductScreen

//import net.ezra.ui.question.QuestionScreen


@SuppressLint("ComposableDestinationInComposeScope")
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_LOGIN


) {


    BackHandler {
        navController.popBackStack()

        }
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {


        composable(ROUTE_HOME) {
            HomeScreen(navController = navController)//openWebsite = { url -> openWebsite(url = url) })
                }


                composable (ROUTE_ABOUT) {
                    AboutScreen(navController)
                }

                    composable (ROUTE_ADD_STUDENTS) {
                    AddStudents(navController)
                }

                        composable (ROUTE_SPLASH) {
                    SplashScreen(navController)
                }

//        composable(ROUTE_VIEW_STUDENTS) {
//           Students(navController = navController, viewModel = viewModel() )
//        }

                        composable (ROUTE_SEARCH) {
                    Search(navController)
                }

                        composable (ROUTE_DASHBOARD) {
                    DashboardScreen(navController)
                }

                        composable (ROUTE_REGISTER) {
                    SignUpScreen(navController = navController) {

                    }
                }

                        composable (ROUTE_LOGIN) {
                    LoginScreen(navController = navController) {}
                }

                        composable (ROUTE_ADD_PRODUCT) {
                    AddProductScreen(navController = navController) {}
                }

                        composable (ROUTE_VIEW_PROD) {
                    ProductListScreen(navController = navController, products = listOf())
                }

                        composable (ROUTE_TERMS) {
                    TermsScreen(navController)
                }
                        composable (ROUTE_ABOUT_US) {
                    AboutusScreen(navController)



                    composable(ROUTE_ANCHOR) {
                        AnchorScreen(navController = navController) {}
                    }
                    composable(ROUTE_PRAY) {
                        PrayScreen(navController)
                    }
                    composable(ROUTE_LOVE) {
                        LoveScreen(navController)
                    }
                    composable(ROUTE_KNOWING_JESUS) {
                        KnowingJesusScreen(navController)
                    }
                    composable(ROUTE_PURPOSE_CREATION) {
                        PurposeCreationScreen(navController)
                    }
                    composable(ROUTE_FAITH) {
                        FaithScreen(navController)
                    }
                    composable(ROUTE_ANSWER) {
                        AnswerScreen(navController)
                    }
                    composable(ROUTE_RISEN) {
                        RisenScreen(navController)
                    }
                     composable(ROUTE_UPDATE_PRODUCT) {
                                UpdateProductScreen(navController)
                            }



                    composable(ROUTE_ANCHOR1) {
                        Anchor1Screen(navController = navController)
                    }
//            composable(ROUTE_QUESTION) {
//                QuestionScreen(navController=navController)
//            }
//            composable(ROUTE_TESTIMONIALS) {
//                TestimonialScreen(navController=navController)
//            }
                    composable(ROUTE_TESTCASE) {
                        Test(navController = navController)
                    }






                    composable("productDetail/{productId}") { backStackEntry ->
                        val productId = backStackEntry.arguments?.getString("productId") ?: ""
                        ProductDetailScreen(navController, productId)
                    }
                    //            private fun openWebsite(url: String) {
//                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                startActivity(intent)
//            }
//            NavHost(navController, startDestination = "mainScreen") {
//                composable("mainScreen") {
//                    HomeScreen(
//                        onNavigateToWebsite = { url ->
//                            navController.navigate("openWebsite/$url")
//                        }
//                    )
//                }
//                    fun openWebsite() {
//                        val url = "https://www.gotquestions.org/"
//                        val intent = Intent(Intent.ACTION_VIEW).apply {
//                            data = Uri.parse(url)
//                        }
//                        startActivity(intent)
//                    }
//                }
//                        composable (
//                        "openWebsite/{url}", arguments = listOf(navArgument("url") { type = NavType.StringType })) { backStackEntry ->
//                    val url = backStackEntry.arguments?.getString("url")
//                    url?.let { openWebsite(it) }
//                    // Optionally, navigate back to the main screen after opening the website
//                    navController.popBackStack()
//                }
//            }
//







































    }

fun openWebsite(it: String) {

}
}
}