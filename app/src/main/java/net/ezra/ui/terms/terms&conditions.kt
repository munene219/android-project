package net.ezra.ui.terms

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import net.ezra.R
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_SEARCH

@Composable
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

fun TermsScreen(navController: NavController, ) {
        BackHandler {
            navController.popBackStack()

        }
        androidx.compose.material3.Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        androidx.compose.material3.Text(text = "Anchor")
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.navigate(ROUTE_HOME) {
                                popUpTo(ROUTE_SEARCH) { inclusive = true }
                            }
                        }) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                "backIcon",
                                tint = Color.White
                            )
                        }
                    },


                    colors = topAppBarColors(
                        containerColor = Color(0xff0505562),
                        titleContentColor = Color.White,
                    ),
                )
            },

            content = {
                LazyColumn {
                    item {
                        Column(
                            modifier = Modifier
                                .background(Color(0xffaa918c)),
                        ) {
                            androidx.compose.material3.Card(
//                   onClick = {
//           navController.navigate(ROUTE_ABOUT_US) {
//                popUpTo(ROUTE_HOME) { inclusive = true }
//            }
//                   },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                            ){
                                Text( style = androidx.compose.material.MaterialTheme.typography.h4,
                                    text = "Jesus is My Anchor")
                                Image(

                                    painter = painterResource(id = R.drawable.image1), // Jesus is my anchor
                                    contentDescription = "acquaint",
                                    modifier = Modifier
                                        .fillParentMaxWidth()
                                        .fillMaxSize()

                                )
                            }
                            Spacer(modifier = Modifier.height(5.dp))
                            androidx.compose.material.Text(
                                text = "Scripture: Hebrews 13:5–9",
                                style = androidx.compose.material.MaterialTheme.typography.h5
                            )
                            androidx.compose.material.Text(
                                style = androidx.compose.material.MaterialTheme.typography.h5,
                                text = "Key Verse: “Jesus Christ is the same yesterday and today and forever.” (Hebrews 13:8)"
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            androidx.compose.material.Text(
                                style = androidx.compose.material.MaterialTheme.typography.h6,
                                text = " After moving to a new home more than fourteen times in my life, and living out of boxes and a suitcase, I’ve come to realize that my life is anything but stable. The inconsistency has not been terrible, but sometimes it’s nice to have a constant in your life—something to hold you steady when everything seems to be twirling around and around. We search for this everywhere. We look to people, hobbies, places, and even ourselves for stability. But people fail us, activities come to an end, memories fade, and our own hearts deceive us."
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            androidx.compose.material.Text(
                                style = androidx.compose.material.MaterialTheme.typography.h6,
                                text = "There are days when I begin to panic, as I become overwhelmed by all the changes and chaos in my life. It takes me a while to collect my thoughts and remind myself that sometimes craziness is okay and that just because I’m going 1000 miles a minute doesn’t mean things are out of control. In these moments, I am thankful that I have an anchor—something that keeps me steady in the whirlwind of life. The anchor is not my family, though they are wonderful. It’s not my friends, though I wouldn’t be here without them. It’s not my dreams, my career, my education, my income, or my health. The only constant in my life is Jesus. Jesus is my anchor!"
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            androidx.compose.material.Text(
                                style = androidx.compose.material.MaterialTheme.typography.h6,
                                text = "Jesus is the only unshakable, unmovable, unending, unbreakable constant in my life. His Word, truth, presence, and control have never changed. There were times when I felt as though Jesus had simply walked away, but that was only because I assumed Jesus would do what the rest of the world had done. But Jesus has never left me. He is the only part of my life that is the same yesterday, today, and forever."
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            androidx.compose.material.Text(
                                style = androidx.compose.material.MaterialTheme.typography.h5,
                                text = "Consider"
                            )
                            androidx.compose.material.Text(
                                style = androidx.compose.material.MaterialTheme.typography.h6,
                                text = "What in your life have you tried to use as your anchor? What would it look like if you allowed Jesus to be a constant in your life of frequent changes?"
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            androidx.compose.material.Text(
                                style = androidx.compose.material.MaterialTheme.typography.h5,
                                text = "Practice"
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            androidx.compose.material.Text(
                                style = androidx.compose.material.MaterialTheme.typography.h6,
                                text = "Using a pen or marker, draw an anchor somewhere on your fingers or hand or arm (like a temporary tattoo) where you can see it. Until it washes off, let it remind you that Jesus is your anchor. The next time you begin to crack under the pressures of life, the next time you feel like there is nothing holding you steady and strong, or like the waves are crashing over you, sending you far out to sea, remember this truth: Jesus is your anchor"
                            )


                        }
                    }
                }

            },
        )

    }





