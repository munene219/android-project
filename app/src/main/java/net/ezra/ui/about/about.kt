package net.ezra.ui.about

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_SEARCH


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AboutScreen(navController: NavHostController) {
    BackHandler {
        navController.popBackStack()

    }
    androidx.compose.material3.Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    androidx.compose.material3.Text(text = "love")
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

                            Image(

                                painter = painterResource(id = R.drawable.image11), // Jesus is my anchor
                                contentDescription = "acquaint",
                                modifier = Modifier
                                    .fillParentMaxWidth()
                                    .fillMaxSize()

                            )
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h5,
                            text = "Romans 10:13 (NKJV) says,Whoever calls on the name of the Lord shall be saved.'"
                        )
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h6,
                            text = " Most of us probably think of this as a salvation scripture—and it is. Jesus is our Savior, and one day we'll be in Heaven with Him. But He is not just our Savior ultimately. Jesus is our Savior in any situation we're going through."
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h6,
                            text = " It doesn't matter how depressed we are or how far we think we are from the Lord. When we need help, we should call upon Jesus. Doing this will change the way we feel. It will change everything about us.")
                        Spacer(modifier = Modifier.height(2.dp))
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h6,
                            text = "But, I've gotten myself into this situation, and I have to get myself out. No! Jesus is the answer, no matter what we've gotten ourselves into. Our Savior loves us, and He already took care of our situation 2,000 years ago. All we have to do is call on His Name. John 14:13–14 (NKJV) says, \"Whatever you ask in My name, that I will do, that the Father may be glorified in the Son. If you ask anything in My name, I will do it.\" Jesus' Name is the answer to all of our problems. That Name opens up everything we need."   )
                        Spacer(modifier = Modifier.height(2.dp))
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h5,
                            text = "Call on Him"
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h6,
                            text = "Even when we're facing the worst possible circumstances,Jesus is still the answer. I think there is no better example of this than when Paul and Silas found themselves in jail in Acts chapter 16. They were ministering in the district of Macedonia because Paul had a vision of a man there saying, \"Come and help us\" (v. 9). Paul and Silas were where God wanted them, but they weren't making a lot of people happy. They found themselves beaten with rods and thrown into prison (vv. 22–23).So here they were, in jail. And I'm not talking about a jail with cable TV. I'm talking about a dungeon. They were chained to the wall and were probably hurting from being beaten. To make things worse, there was a possibility they'd be killed in the morning. They were in a bad situation.But when most people would be griping and complaining, Acts 16:25 (NKJV) says, \"At midnight Paul and Silas were praying and singing hymns to God.\" Paul and Silas weren't focused on their situation. They were praying and singing praises to God! They knew that if they called upon the Name of Jesus, they would be saved. And they were!Acts 16:26 (NKJV) says, \"Suddenly there was a great earthquake, so that the foundations of the prison were shaken; and immediately all the doors were opened and everyone's chains were loosed.\" Notice that it wasn't just Paul and Silas who were saved—everyone around them was saved as well. Two guys changed the lives of many people because they knew they could trust their Lord." )
                        Spacer(modifier = Modifier.height(5.dp))
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h5,
                            text = "Know the Word"
                        )
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h6,
                            text = "Maybe you're not physically beaten like Paul and Silas were. But perhaps you feel mentally beaten up. Maybe you feel like there is no hope and no one to help you. Right in the middle of everything you're going through—when it looks as if there's no way out—Jesus is still the answer! But you've got to know what the Word says.My grandfather, Kenneth E. Hagin, always said the number one reason people don't get their needs met is that they don't know the Word. When we're facing trials—when we're depressed and going through bad stuff—we have to know that Jesus is the answer. We have to understand that He wants to help us. Jesus didn't die on the cross and bring us this far to let us down. He is the answer! He shed His blood so we could be saved. He took the stripes on His back so we could be healed (Isa. 53:5). He came so that we could have life and have it more abundantly (John 10:10).Sometimes we go through tough times and it looks as if we're not going to make it. Sometimes we face mountains, and sometimes we're in the valley.Whatever you're facing today, call upon Jesus. He is always there. He will never leave you nor forsake you. He is for you, and He has already provided a way out. Just call on Him and you will be saved! He is always the answer!"
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h5,
                            text = "On Aslan’s Side"
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h6,
                            text = "Almost, the children and Prince Rilian succumb to the enchantment. After all, they cannot now see Narnia. Perhaps their memories are only remnants of dreams. But they have with them one more companion on the quest to rescue the prince. Puddleglum, an odd creature called a Marsh-wiggle, is, as his name implies, a rather dour realist. But his gloomy personality makes him more resistant to enchantment.Just before it is too late, Puddleglum rouses himself with great effort and moves toward the fireplace. He stamps one of his hard bare feet into the flames. The terrible pain clears his head. He has also put out much of the fire, dampening the aroma of the magic powder. The Witch rages. But the children start to come back to themselves.Then Puddleglum confronts the Witch-Queen with some of the great lines in English literature.“One word, Ma’am,” he said, coming back from the fire; limping, because of the pain. “One word. . . . Suppose we have only dreamed, or made up, all those things — trees and grass and sun and moon and stars and Aslan himself. Suppose we have. Then all I can say is that, in that case, the made-up things seem a good deal more important than the real ones. Suppose this black pit of a kingdom of yours is the only world. Well, it strikes me as a pretty poor one. And that’s a funny thing, when you come to think of it. We’re just babies making up a game, if you’re right. But four babies playing a game can make a play-world which licks your real world hollow. That’s why I’m going to stand by the play world. I’m on Aslan’s side even if there isn’t any Aslan to lead it. I’m going to live as like a Narnian as I can even if there isn’t any Narnia.” “Four babies playing a game can make a play-world which licks your real world hollow.” What we see through the imagination of faith (grounded in the revealed word of Scripture) is far more interesting and wondrous than all the seemingly sophisticated posturing of the self-centered world."
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h5,
                            text = "FAITH NUGGET"
                        )
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h5,
                            text = "Just Trust"
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h6,
                            text = "Proverbs 3:5–6 (NKJV) says, \"Trust in the Lord with all your heart, and lean not on your own understanding; In all your ways acknowledge Him, and He shall direct your paths.\" In other words, when you're in the middle of a situation, quit trying to figure it out and start leaning on the Lord. You may not understand everything, but you can trust Him. You can put your faith in Him, because He cannot—and will not—let you down."
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h5,
                            text = "God's Not Mad"
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h6,
                            text = "One of my favorite scriptures is John 3:16: \"For God so loved the world . . .You're in the world, so that means He loves you!"
                        )
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h6,
                            text = "Well, Brother Craig, that verse is just about sinners.No! God loves you. He loves everyone."
                        )
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h6,
                            text = "\"Even when I mess up?\" Yes. Even when you mess up! Some people have the idea that when we mess up, God gets mad at us. But He doesn't. He still loves us."
                        )
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h6,
                            text = "Now, there may be some things we do that don't please God. There have been times when my kids did things I didn't really want them to do. Those things didn't please me, but they also didn't make me love them any less.\n" +
                                    "\n"
                        )
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h6,
                            text = "God's the same way. Even when we mess up—even when we do things that may not please Him—He loves us anyhow. No matter where you are today—no matter where you find yourself—call upon the Name of Jesus and return to your Heavenly Father. He loves you. He is for you. And He wants you back.\n" +
                                    "\n" +
                                    " "
                        )


                    }
                }
            }

        },
    )




}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    AboutScreen(rememberNavController())
}

