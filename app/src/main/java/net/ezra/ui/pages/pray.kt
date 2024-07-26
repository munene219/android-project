package net.ezra.ui.pages

import android.annotation.SuppressLint
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
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import net.ezra.R
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_SEARCH

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PrayScreen(navController: NavHostController,) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    androidx.compose.material3.Text(text = "Prayers")
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
            Card(
//                   onClick = {
//           navController.navigate(ROUTE_ABOUT_US) {
//                popUpTo(ROUTE_HOME) { inclusive = true }
//            }
//                   },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ){
                Spacer(modifier = Modifier.height(40.dp))
                Text( style = androidx.compose.material.MaterialTheme.typography.h4,
                    text = " No Problem Is Too Small for Prayer")

                Image(

                    painter = painterResource(id = R.drawable.image7), // Jesus is my anchor
                    contentDescription = "acquaint",
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .fillMaxSize()

                )
                Spacer(modifier = Modifier.height(5.dp))
                Text( style = androidx.compose.material.MaterialTheme.typography.h6,
                    text = "Do you ever feel too small for God, as though your worries don’t deserve his attention? As though he has more important things to do than tend to that tricky relationship, those hidden regrets, that dwindling bank account? If you’re tempted to believe such lies, consider an overlooked story in 2 Kings 6 — a story of small people, small problems, and a small miracle that can transform our understanding of God.")
                Text( style = androidx.compose.material.MaterialTheme.typography.h5,
                    text = "Small People")
                Text( style = androidx.compose.material.MaterialTheme.typography.h6,
                    text = "The story that comes just before this one is about a great man, a highflier, a Very Important Person: Naaman, the commander of Syria’s army (2 Kings 5). And the passage that immediately follows is about an even more important person: Naaman’s boss, the king of Syria himself (2 Kings 6:8–33). Both men have corner offices, fly first class, and live in gated communities. They’re big deals But not the people in this story. They’re referred to as “the sons of the prophets,” a group gathered around a prophet such as Elisha, learning from him and serving him. These are the guys who work in a cubicle, fly economy, and live where the houses are small and close together. They’re not famous or important — in fact, we’re not even told their names. And yet this passage tells their story. In between the internationally significant narratives of a great military leader and a famous political leader is an episode about no-names involved in a purely local affair. This surprising interest in small people seems to have been a recurring feature of Elisha’s ministry (see the stories in 2 Kings 4). It’s also a hallmark of the larger biblical story (notice, for example, the focus on unnamed minor characters throughout the Gospel of Mark) What’s more, the Bible doesn’t just show an interest in small people for whom things are going well — people who might be a net gain, even in their own small way. Rather, it demonstrates genuine care for small people with problems. That’s certainly the case for the sons of the prophets in 2 Kings 6. In fact, they have two problems.")
                Text( style = androidx.compose.material.MaterialTheme.typography.h5,
                    text = "Small Problems")
                Text( style = androidx.compose.material.MaterialTheme.typography.h6,
                    text = "The first problem is a housing issue. “Now the sons of the prophets said to Elisha, ‘See, the place where we dwell under your charge is too small for us’” (2 Kings 6:1). I get this. Several years ago, with our kids getting older, our house felt cramped, so we moved to a larger one. I wouldn’t deem our housing needs worthy of inclusion in Holy Scripture. Maybe the sons of the prophets felt similarly. But here’s their story — in the Bible. Apparently, the small problems of small people matter to God.In this case, the sons of the prophets come to Elisha not just with a problem, but with a proposed solution. “‘Let us go to the Jordan and each of us get there a log, and let us make a place for us to dwell there.’ And he answered, ‘Go’” (2 Kings 6:2). Sometimes God meets our needs through miraculous means (he’ll do that in this very story). Other times he helps us through our own activity. Elisha doesn’t make a new house appear out of thin air. Instead, the sons of the prophets mount a logging expedition and build a house.God often works this way. According to Jesus, God feeds the birds of the air — but as one of my seminary professors used to say, you don’t see birds lying on their backs, waiting for God to drop worms into their beaks. He feeds them through their own worm-finding efforts. Yes, God can provide manna from heaven and bread by raven (1 Kings 17:3–6), but his normal means of provision is our own hard work (2 Thessalonians 3:10). Ask God for his help. Give him your burden. Surrender your problem. He wants you to ask. The second problem involves a lost axe head. “But as one was felling a log, his axe head fell into the water, and he cried out, ‘Alas, my master! It was borrowed’” (2 Kings 6:5). Of course, this is a tiny issue in the grand sweep of things. But when a problem happens to us, we don’t feel that way about it. When it’s our injured leg, our dented car, our negative job review, our extended sickness, the comparatively small problem can feel big. The unnamed man in verse 5 “cried out” — a term connoting real distress. He cries out, “Alas!” He can’t afford to replace that borrowed axe head.Yes, it’s a relatively small problem — but not to him. Will God even notice? Look what happens next.")
                Text( style = androidx.compose.material.MaterialTheme.typography.h5,
                    text = "Small Miracle")
                Text( style = androidx.compose.material.MaterialTheme.typography.h6,
                    text = " “Then the man of God said, ‘Where did it fall?’ When he showed him the place, he cut off a stick and threw it in there and made the iron float. And he said, ‘Take it up.’ So he reached out his hand and took it” (2 Kings 6:6–7). The description of Elisha as “the man of God” reminds us that Elisha, though a prophet, is a man. He needs to ask where the axe head fell (apparently, the miracle doesn’t include actually locating it!). But the term “man of God” also reminds us that Elisha represents God, speaks for God, does miracles by the power of God. God himself, in the person of his prophet, is involved in this small miracle.Elisha throws a stick into the water; the axe head floats. We’re not told why a stick is used, but this is undoubtedly a miracle. Iron doesn’t float. As miracles go, it’s a small one. No one is raised from the dead. The fate of a nation doesn’t hang in the balance. There are few witnesses. Even the ending of the story is undramatic. “And he said, ‘Take it up.’ So he reached out his hand and took it.” That’s it. End of story.So, here’s a summary of this little story: Some small people have a couple of small problems, and God meets their needs — in one case through their own planning and effort, and in the other through a small miracle. Maybe the story doesn’t seem all that important, yet I’m glad it’s in the Bible. It demonstrates that God cares about us and our everyday problems. He acts on our behalf. If we’re attentive, we’ll see that in our own lives.")
                Text( style = androidx.compose.material.MaterialTheme.typography.h5,
                    text = "No Prayer Too Small")
                Text( style = androidx.compose.material.MaterialTheme.typography.h6,
                    text = "I’ve seen God act this way in my own life. I’m a pastor, and a few years ago, I agreed to lead a graveside service for the deceased brother of a friend who lives in town. My friend isn’t a follower of Jesus, so this seemed like a great opportunity to serve him and deepen our friendship. The service was scheduled for 1:00, but somehow, I got it into my head that it began at 1:30. That day, I drove to the cemetery and arrived at about 1:20, thinking I was early. But as I walked toward the grave, I saw many cars and a crowd of people. I looked at my notes, discovered I was in fact twenty minutes late, and felt sick to my stomach.Surprisingly, though, as I neared the grave, I saw pallbearers pulling a coffin out of a hearse and carrying it toward the grave. My friend greeted me and told me what had happened. An out-of-town funeral home had driven the coffin to the wrong cemetery in our town. A grave had been dug at that cemetery for a different funeral the same day, and they had lowered the coffin into that grave. It took time to discover the error, get the coffin out of the grave and back into the hearse, and drive it to the right place. In fact, it took them twenty minutes. Which meant I arrived right on time. I believe that was the work of God. He knew every little detail, cared for me, and prevented an unintentional offense against my friend. God did a small miracle for a small person (me).Psalm 147:3–4 says that God “heals the brokenhearted and binds up their wounds. He determines the number of the stars; he gives to all of them their names.” God does big things (like creating and naming the stars) and little things (like binding up the wounds of sad people). So, here’s an invitation: Ask God for his help. Give him your burden. Surrender your problem. He wants you to ask. He sees and cares, no matter how humble and hidden the issue. God took on flesh and came to earth as a tiny, fragile, helpless baby born to a manual laborer. By doing so, he was saying, loud and clear, “I care about small people. I was one myself.” Let’s bring our problems, big and small, to him")


                    }
                }
            }
        }

    },
    )
}