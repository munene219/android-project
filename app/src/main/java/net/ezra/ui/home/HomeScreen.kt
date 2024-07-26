package net.ezra.ui.home






import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_ABOUT_US
import net.ezra.navigation.ROUTE_ADD_PRODUCT
import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_ANCHOR
import net.ezra.navigation.ROUTE_ANCHOR1
import net.ezra.navigation.ROUTE_ANSWER
import net.ezra.navigation.ROUTE_DASHBOARD
import net.ezra.navigation.ROUTE_FAITH
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_KNOWING_JESUS
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_REGISTER
import net.ezra.navigation.ROUTE_SEARCH
import net.ezra.navigation.ROUTE_STUDENTLIST
import net.ezra.navigation.ROUTE_TERMS
import net.ezra.navigation.ROUTE_TESTCASE

import net.ezra.navigation.ROUTE_VIEW_PROD
import net.ezra.navigation.ROUTE_VIEW_STUDENTS
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import net.ezra.navigation.ROUTE_UPDATE_PRODUCT


data class Screen(val title: String, val icon: Int)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ResourceAsColor")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController,/*openWebsite: (String) -> Unit,onNavigateToWebsite: (String) -> Unit*/) {

    var isDrawerOpen by remember { mutableStateOf(false) }

    val callLauncher: ManagedActivityResultLauncher<Intent, ActivityResult> =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) { _ ->

        }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.apen))
                },
                navigationIcon = @Composable {
                    if (!isDrawerOpen) {
                        IconButton(onClick = { isDrawerOpen = true }) {
                            Icon(
                                Icons.Default.Menu,
                                contentDescription = "Menu",
                                tint = Color.White
                            )
                        }
                    }
                },

                actions = {
                    IconButton(onClick = {
                        navController.navigate(ROUTE_LOGIN) {
                            popUpTo(ROUTE_HOME) { inclusive = true }
                        }

                    }) {
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xff0505562),
                    titleContentColor = Color.White,

                    )

            )
        },

        content = @Composable {
            LazyColumn (
                modifier = Modifier

            ){
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                if (isDrawerOpen) {
                                    isDrawerOpen = false
                                }
                            }
                    ) {


                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color(0xffaa918c)),

                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.height(60.dp))
                            Image(
                                painter = painterResource(id = R.drawable.folowingjesus), // Replace with your coffee cup image
                                contentDescription = "acquaint",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                            )
                            androidx.compose.material.Text(
                                "Plug In Today",
                                style = androidx.compose.material.MaterialTheme.typography.h5
                            )
                            Text(
                                "Choose a plan to start with",

                                )
                            Spacer(modifier = Modifier.height(5.dp))
                            LazyRow {
                                item {
                                    Card(
                                        onClick = {
                                            navController.navigate(ROUTE_TERMS)
                                        },
                                    ) {
                                        Image(

                                            painter = painterResource(id = R.drawable.image1), // Jesus is my anchor
                                            contentDescription = "acquaint",
                                            modifier = Modifier

                                        )
                                    }
                                    Spacer(modifier = Modifier.width(15.dp))
                                    Card(
                                        onClick = {
                                            navController.navigate(ROUTE_ABOUT) {
                                                popUpTo(ROUTE_LOGIN) { inclusive = true }
                                            }
                                        },
                                    ) {
                                        Image(

                                            painter = painterResource(id = R.drawable.image11), // Jesus is my anchor
                                            contentDescription = "acquaint",
                                            modifier = Modifier

                                        )
                                    }
                                    Spacer(modifier = Modifier.width(15.dp))
                                    Card(
                                        onClick = {
                                            navController.navigate(ROUTE_ABOUT_US) {
                                                popUpTo(ROUTE_LOGIN) { inclusive = true }
                                            }
                                        },
                                    ) {
                                        Image(

                                            painter = painterResource(id = R.drawable.image7), // Jesus is my anchor
                                            contentDescription = "acquaint",
                                            modifier = Modifier

                                        )
                                    }
                                    Spacer(modifier = Modifier.width(15.dp))
                                    Card(
                                        onClick = {
                                            navController.navigate(ROUTE_SEARCH) {
                                                popUpTo(ROUTE_LOGIN) { inclusive = true }
                                            }
                                        },
                                    ) {
                                        Image(

                                            painter = painterResource(id = R.drawable.image10), // Jesus is my anchor
                                            contentDescription = "acquaint",
                                            modifier = Modifier

                                        )
                                    }
                                    /*
                                    Spacer(modifier = Modifier.width(10.dp))

                                    Card(
                                        onClick = {
                                            navController.navigate(ROUTE_TESTCASE) {
                                                popUpTo(ROUTE_LOGIN) { inclusive = true }
                                            }
                                        },
                                    ) {
                                        Image(

                                            painter = painterResource(id = R.drawable.image2), // Jesus is my anchor
                                            contentDescription = "acquaint",
                                            modifier = Modifier

                                        )
                                    }
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Card(
                                        onClick = {
                                            navController.navigate(ROUTE_STUDENTLIST) {
                                                popUpTo(ROUTE_LOGIN) { inclusive = true }
                                            }
                                        },
                                    ) {
                                        Image(

                                            painter = painterResource(id = R.drawable.image8), // Jesus is my anchor
                                            contentDescription = "acquaint",
                                            modifier = Modifier

                                        )
                                    }
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Card(
                                        onClick = {
                                            navController.navigate(ROUTE_REGISTER) {
                                                popUpTo(ROUTE_LOGIN) { inclusive = true }
                                            }
                                        },
                                    ) {
                                        Image(

                                            painter = painterResource(id = R.drawable.image4), // Jesus is my anchor
                                            contentDescription = "acquaint",
                                            modifier = Modifier

                                        )
                                    }
*/
                                }
                            }
                            Text(text = "Pick a plan ad learn more about it")
                            androidx.compose.material.Text(
                                "Well Vast Articles",
                                style = androidx.compose.material.MaterialTheme.typography.h5
                            )
                            Card(
                                onClick = {
                                    navController.navigate(ROUTE_DASHBOARD) {
                                        popUpTo(ROUTE_HOME) { inclusive = true }
                                    }
                                },
                            ) {
                                Image(

                                    painter = painterResource(id = R.drawable.lovelikejesus), // Jesus is my anchor
                                    contentDescription = "acquaint",
                                    modifier = Modifier

                                )
                            }
                            Text(text = "Get to read well vast and elaborate articles which answer questions you might have and help during the growth process")

                            androidx.compose.material.Text(
                                "Testimonials",
                                style = androidx.compose.material.MaterialTheme.typography.h4
                            )



                            androidx.compose.material.Text(
                                "Events",
                                style = androidx.compose.material.MaterialTheme.typography.h4
                            )
                            Card(
                                onClick = {
                                    navController.navigate(ROUTE_ADD_STUDENTS) {
                                        popUpTo(ROUTE_HOME) { inclusive = true }
                                    }
                                },
                            ) {
                            Image(
                                painter = painterResource(id = R.drawable.plugin1), // Replace with your coffee cup image
                                contentDescription = "testimony picture",
                                modifier = Modifier
                                    .width(200.dp)
                                    .fillMaxHeight()
                                    .height(220.dp)
                            )
                        }
                            Text(
                                "Get to know about events that are close to you",
                            )
                            Text(text = " plug in as you interact with people")


                            androidx.compose.material.Text(
                                "Testimonials",
                                style = androidx.compose.material.MaterialTheme.typography.h4
                            )
                            Card(
                                onClick = {
                                    navController.navigate(ROUTE_STUDENTLIST) {
                                        popUpTo(ROUTE_HOME) { inclusive = true }
                                    }
                                },
                            ) {
                                Image(

                                    painter = painterResource(id = R.drawable.loveimage3), // Jesus is my anchor
                                    contentDescription = "acquaint",
                                    modifier = Modifier
                                        .width(220.dp)
                                )
                            }
                            Text(
                                "Read and submit a testimony",
                            )
                            Text(
                                "Share your encounter",
                            )
                            androidx.compose.material.Text(
                                "Questions",
                                style = androidx.compose.material.MaterialTheme.typography.h4
                            )
                            Row {
                                Card(
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier.padding(8.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.questionmark),
                                        contentDescription = "Testimony picture",
                                        modifier = Modifier
                                        ,
                                        contentScale = ContentScale.Crop
                                    )
                                }
                                Button(onClick = { /*onNavigateToWebsite("https://www.gotquestions.org") */}) {
                                    Text("Ask here")
                                }
                            }
                            Text(
                                text = "Ask any questions you may have",
                                // style = MaterialTheme.typography.h6,
                                modifier = Modifier.padding(8.dp)
                            )
                            Spacer(modifier = Modifier.height(16.dp))

                            Spacer(modifier = Modifier.height(30.dp))
                            Text(
                                text = "Start With Us Now",
                                //style = MaterialTheme.typography.h6,
                                modifier = Modifier.padding(8.dp)
                            )

                           /* // MainActivity.kt
                            Button(onClick = { openWebsite("https://www.gotquestions.org") }) {
                                Text("Go to GotQuestions.org")
                            }
                            class MainActivity : AppCompatActivity() {

                                override fun onCreate(savedInstanceState: Bundle?) {
                                    super.onCreate(savedInstanceState)

                                    // Create a LinearLayout
                                    val layout = LinearLayout(this).apply {
                                        orientation = LinearLayout.VERTICAL
                                        layoutParams = LinearLayout.LayoutParams(
                                            ViewGroup.LayoutParams.MATCH_PARENT,
                                            ViewGroup.LayoutParams.MATCH_PARENT
                                        )
                                    }

                                    // Create a Button

                                    val buttonOpenWebsite = Button(this).apply {
                                        text = "https://www.gotquestions.org"
                                        layoutParams = LinearLayout.LayoutParams(
                                            ViewGroup.LayoutParams.WRAP_CONTENT,
                                            ViewGroup.LayoutParams.WRAP_CONTENT
                                        )
                                    }

                                    buttonOpenWebsite.setOnClickListener {
                                        openWebsite()
                                    }
                                        }




                                fun openWebsite() {
                                    val url = "https://www.gotquestions.org/"
                                    val intent = Intent(Intent.ACTION_VIEW).apply {
                                        data = Uri.parse(url)
                                    }
                                    startActivity(intent)
                                }
                            }
*/
                            // MainActivity.kt


                            class MainActivity : ComponentActivity() {

                                override fun onCreate(savedInstanceState: Bundle?) {
                                    super.onCreate(savedInstanceState)
                                    setContent {

                                    }
                                }

                                private fun openWebsite(url: String) {
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                    startActivity(intent)
                                }

                                @Composable
                                fun AppNavigator() {
                                    val navController = rememberNavController()

                                    NavHost(navController, startDestination = "mainScreen") {
                                        composable("mainScreen") {
                                            MainScreen(
                                                onNavigateToWebsite = { url ->
                                                    navController.navigate("openWebsite/$url")
                                                }
                                            )
                                        }
                                        composable(
                                            "openWebsite/{url}",
                                            arguments = listOf(navArgument("url") { type = NavType.StringType })
                                        ) { backStackEntry ->
                                            val url = backStackEntry.arguments?.getString("url")
                                            url?.let { openWebsite(it) }
                                            // Optionally, navigate back to the main screen after opening the website
                                            navController.popBackStack()
                                        }
                                    }
                                }

                                @Composable
                                fun MainScreen(onNavigateToWebsite: (String) -> Unit) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(16.dp)
                                    ) {

                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(30.dp))
                            androidx.compose.material.Text(
                                "Start With Us Now",
                                style = androidx.compose.material.MaterialTheme.typography.h6
                            )



                            /*
                            redirect to dailpad

                            Text(
                                text = stringResource(id = R.string.call),
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .padding(16.dp)
                                    .clickable {

                                        val intent = Intent(Intent.ACTION_DIAL)
                                        intent.data = Uri.parse("tel:+25459568620")

                                        callLauncher.launch(intent)
                                    }
                            )


                            Text(
                                text = stringResource(id = R.string.developer),
                                fontSize = 20.sp,
                            )

                            Spacer(modifier = Modifier.height(15.dp))

                            Text(
                                modifier = Modifier

                                    .clickable {
                                        navController.navigate(ROUTE_LOGIN) {
                                            popUpTo(ROUTE_HOME) { inclusive = true }
                                        }
                                    },
                                text = "Login Here",
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )



                            Text(
                                modifier = Modifier

                                    .clickable {
                                        navController.navigate(ROUTE_ADD_PRODUCT) {
                                            popUpTo(ROUTE_HOME) { inclusive = true }
                                        }
                                    },
                                text = "Add Products",
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            Text(
                                modifier = Modifier

                                    .clickable {
                                        navController.navigate(ROUTE_ADD_STUDENTS) {
                                            popUpTo(ROUTE_HOME) { inclusive = true }
                                        }
                                    },
                                text = "Add Students",
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            Text(
                                modifier = Modifier

                                    .clickable {
                                        navController.navigate(ROUTE_VIEW_PROD) {
                                            popUpTo(ROUTE_HOME) { inclusive = true }
                                        }
                                    },
                                text = "view Products",
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )



                            Spacer(modifier = Modifier.height(15.dp))


                            Text(
                                text = "You're welcome",
                                fontSize = 30.sp,
                                color = Color.White
                            )
                            */



                        }

                    }

                }
            }

        },

        bottomBar = { BottomBar(navController = navController) },







    )

    AnimatedDrawer(
        isOpen = isDrawerOpen,
        onClose = { isDrawerOpen = false },
    )
}



@Composable
fun AnimatedDrawer(isOpen: Boolean, onClose: () -> Unit) {
    val drawerWidth = remember { Animatable(if (isOpen) 250f else 0f) }
    val context = LocalContext.current
    LaunchedEffect(isOpen) {
        drawerWidth.animateTo(if (isOpen) 250f else 0f, animationSpec = tween(durationMillis = 300))
    }
    LaunchedEffect(onClose){
        return@LaunchedEffect
    }

    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .width(drawerWidth.value.dp)
        ,
        color = Color.LightGray,
//        elevation = 16.dp
    ) {
        Column {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Go to login"

            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "About us",

            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "My profile",

                )




//            Spacer(modifier = Modifier.height(16.dp))
//            Text(text = stringResource(id = R.string.developer))

        }
    }
}






@Composable
fun BottomBar(navController: NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 10.dp,
        backgroundColor = Color(0xff0505562)


    ) {
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home, "",tint = Color.White)
        },
            label = { Text(
                text = "Home",
                color =  Color.White) },
            selected = (selectedIndex.value == 2),
            onClick = {

                navController.navigate(ROUTE_HOME) {
                    popUpTo(ROUTE_HOME) { inclusive = true }
                }

            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Add, "",tint = Color.White)
        },
            label = { Text(
                text = "Add Plan",
                color =  Color.White) },
            selected = (selectedIndex.value == 2),
            onClick = {

                navController.navigate(ROUTE_ANCHOR) {
                    popUpTo(ROUTE_HOME) { inclusive = true }
                }

            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Menu, "",tint = Color.White)
        },
            label = { Text(
                text = "Articles",
                color =  Color.White) },
            selected = (selectedIndex.value == 2),
            onClick = {

                navController.navigate(ROUTE_VIEW_PROD) {
                    popUpTo(ROUTE_HOME) { inclusive = true }
                }

            })

    }
}



