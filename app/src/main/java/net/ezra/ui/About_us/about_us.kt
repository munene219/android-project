package net.ezra.ui.About_us



import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
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
import net.ezra.navigation.ROUTE_ABOUT_US
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_SEARCH
import net.ezra.ui.about.AboutScreen


@Composable
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun AboutusScreen(navController: NavHostController) {
    BackHandler {
        navController.popBackStack()

    }
    androidx.compose.material3.Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    androidx.compose.material3.Text(text = "Faith")
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

                                painter = painterResource(id = R.drawable.jesusisanswer), // Jesus is my anchor
                                contentDescription = "acquaint",
                                modifier = Modifier
                                    .fillParentMaxWidth()
                                    .fillMaxSize()

                            )
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h5,
                            text = "“Fake! Fake! Toy, toy, toy!” jeered Danny and Lynn as I showed them Big Dog, one of my stuffed animals. I was about six years old, so they were about ten and twelve. I had claimed that my animals were real. They told me to grow up and stop being a baby. My response was to fetch another animal, the one I called Big Bear. I figured if I told them enough about him, they’d have to believe me. They only taunted more, “Fake! Fake!” I can still feel the humiliation.But I also remember my belief. Of course I understood my toys were not real, not the way the family boxer was real. But I also knew there is more to the world than what our immediate senses comprehend. I knew imagination and faith reveal more than what skeptics see. And in days when our culture clashes over what is reality and how to describe it, that matters."
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h6,
                            text = " After moving to a new home more than fourteen times in my life, and living out of boxes and a suitcase, I’ve come to realize that my life is anything but stable. The inconsistency has not been terrible, but sometimes it’s nice to have a constant in your life—something to hold you steady when everything seems to be twirling around and around. We search for this everywhere. We look to people, hobbies, places, and even ourselves for stability. But people fail us, activities come to an end, memories fade, and our own hearts deceive us."
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h5,
                            text = "‘No World but Mine’"
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h6,
                            text = "The fight over what is real runs through a thrilling scene from C.S. Lewis’s The Silver Chair. English schoolchildren Jill and Eustace are sent to the magical realm of Narnia by the great lion, Aslan, to rescue the lost Prince Rilian. He has been captured by the Witch-Queen of the Underland, a dank, stale region beneath the beautiful lands and skies of Narnia. Just when the children have found Rilian and set him free, the Witch appears. But rather than subdue them physically, the Witch attempts to enchant them so they will never even desire to flee her dim, shadowy realm.The Witch throws a magic powder in the glowing fireplace. She strums a stringed instrument with “a steady, monotonous thrumming.” Then she begins to define reality for them. The world of twentieth-century England (from which they came) was just imaginary. Narnia — with its talking animals, shining stars, bright sunlight, and vivid colors — was merely a fantasy. “There never was such a world,” says the Witch. The children repeat back her words. Then she asserts, “There never was any world but mine” (630). They parrot her again. They settle into the lie, and feel relief to stop fighting her spell. They are almost lost."
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h5,
                            text = "Modern Spells"
                        )
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h6,
                            text = "“There never was any world but mine.” Is anyone casting a spell over you with these words? They tell you that your antiquated Christian beliefs place you “on the wrong side of history.” The thrumming enchantment makes you wonder, “What if that’s so?” The Witch-Queen calmly, but constantly, repeats her lies. She tells you what every educated and enlightened person knows:The world was not created out of nothing by some personal God. With nothing above us, we determine our own meaning.An embryo inside a woman’s womb is not a person yet. “It” is just part of her body and under her sovereign control.The underlying motivation in every individual or group is power. If from the majority group, you can never stop being an oppressor. If from a minority group, you ever remain a victim.You can, however, always determine your gender identity no matter your biological sex. To oppose any process of “transitioning” is hateful and leads to others’ depression and even suicide.What I need is to be freed from any person, morality, or group that impedes my expression of me. I do not need to be liberated from myself; I need to be liberated into myself.“These are simple truths,” today’s Witch-Queen says as she throws more powder on the fire. “Opposing them forfeits your right to speak, work, or advance. There never was any world but mine.”"
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
                            text = "Open His Eyes"
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h6,
                            text = "Long ago, Elisha the prophet warned the king of Israel about the plans of the king of Syria. His supernatural knowledge saved Israel’s king from war and destruction. So, the king of Syria sought to capture Elisha. One night, his army and chariots surrounded the city where the prophet resided. Early in the morning, Elisha’s servant looked out upon the siege and panicked.The servant said, “Alas, my master! What shall we do?” He said, “Do not be afraid, for those who are with us are more than those who are with them.” Then Elisha prayed and said, “O Lord, please open his eyes that he may see.” So the Lord opened the eyes of the young man, and he saw, and behold, the mountain was full of horses and chariots of fire all around Elisha. (2 Kings 6:15–17)Earthly eyes saw only earthly things. Fierce Syrian warriors and chariots surrounded the city. But the eyes of faith, as the Spirit enabled, saw much more of reality. The Lord’s army, vast and powerful, protected the prophet in his city. God’s angelic host had chariots of fire! The king of Syria was not in charge of reality. Much more happens in the world than meets the eye. The sovereign God still reigns and works out all things according to his purpose.Is that a fantasy? The eyes of faith, opened by the Spirit, see the greater picture. Hebrews 12:1 tells us that “we are surrounded by so great a cloud of witnesses,” all those who have gone before us in faithfulness. The supposed “real world” of today’s unbelief sags under a dull sameness and a tedious imprisonment to self. The vision of Scripture reveals a more glorious reality."
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h5,
                            text = "Grim Stories Licked Hollow"
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        androidx.compose.material.Text(
                            style = androidx.compose.material.MaterialTheme.typography.h6,
                            text = "When we take our side with those saints who have gone before us, we may be shunned or scorned by today’s sophisticates. So be it. Think of the company we get to keep. Watching, cheering our path are Mary Magdalene and Athanasius, John Calvin and Christina Rossetti, and (still with us) Joni Eareckson Tada and John Piper.Countless others through the centuries join us. All of us are connected by the testimony of faith in Jesus. This wondrous multitude licks hollow the grim story attempting to capture our culture. How dim, how lonely is any worldview that revolves around me as the center. God has so much more.Why would I ever go it alone, pretending to be a sovereign self, spinning around nothingness? Rather, acknowledging God’s sovereignty, I am taken into the company of all the saints and all the glory of creation. We walk now by faith, not by physical sight. But the gift of faith opens us to the spiritual vision of God’s glorious reality.I still have Big Dog. He sits on top of our dresser. Every now and then as I pass by, I pat him and speak to him. I know he’s not real. I also know that imagination and faith reveal sights that can’t be seen by this world. I know the God who entered the world in skin and bone, died utterly, and then rose again in this very world to an everlasting life.The world may say, “Fake! Toy!” But I say, “True! True! Real, real, real!”"
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

