package net.ezra.ui.dashboard



import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CardColors
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.Firebase
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import net.ezra.navigation.ROUTE_LOGIN

import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.firestore
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT_US
import net.ezra.navigation.ROUTE_ADD_PRODUCT
import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_ANCHOR
import net.ezra.navigation.ROUTE_ANSWER
import net.ezra.navigation.ROUTE_DASHBOARD
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_SEARCH
import net.ezra.navigation.ROUTE_TERMS


private var progressDialog: ProgressDialog? = null
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable

fun DashboardScreen(navController: NavHostController) {
    /*
    var school by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    val currentUser = FirebaseAuth.getInstance().currentUser
    val firestore = FirebaseFirestore.getInstance()
    var user: User? by remember { mutableStateOf(null) }
    var isLoading by remember { mutableStateOf(true) }
    var studentCount by remember { mutableIntStateOf(0) }
    var currentPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var loading by remember { mutableStateOf(false) }

    val firestores = Firebase.firestore


    val context = LocalContext.current

    BackHandler {
        navController.popBackStack()

    }


    // Fetch user details from Firestore
    LaunchedEffect(key1 = currentUser?.uid) {
        if (currentUser != null) {
            val userDocRef = firestore.collection("users").document(currentUser.uid)
            userDocRef.get()
                .addOnSuccessListener { document ->
                    if (document.exists()) {
                        user = document.toObject<User>()
                    }
                    isLoading = false
                }
                .addOnFailureListener { e ->
                    // Handle failure
                    isLoading = false
                }
        }
    }

    LaunchedEffect(Unit) {
        firestores.collection("Students")
            .get()
            .addOnSuccessListener { result ->
                studentCount = result.size()
            }
            .addOnFailureListener { exception ->
                // Handle failures
            }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Dashboard", color = Color.White, fontSize = 30.sp)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xff0FB06A),
                    titleContentColor = Color.White,
                ),
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, "backIcon",tint = Color.White)
                    }
                },



            )
        }, content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xff9AEDC9)),
//                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {


//                            Dashboard starts here

                            val dashboardItems = listOf(
                                DashboardItemData(
                                    title = "Profile",
                                    icon = Icons.Default.AccountCircle,
                                    badgeCount = 0,
                                    onClick = {
                                        // Navigate to profile screen
                                    }
                                ),
                                DashboardItemData(
                                    title = "Settings",
                                    icon = Icons.Default.Settings,
                                    badgeCount = 3,
                                    onClick = {
                                        // Navigate to settings screen
                                    }
                                ),
                                DashboardItemData(
                                    title = "Students",
                                    icon = Icons.Default.Person,
                                    badgeCount = 4,
                                    onClick = {
                                        // Navigate to messages screen
                                    }
                                ),
                                // Add more dashboard items as needed
                            )



                            LazyVerticalGrid(
                                columns = GridCells.Fixed(2),
                                modifier = Modifier.padding(16.dp)
                            ) {
                                items(dashboardItems) { item ->
                                    DashboardItem(item)
                                }
                            }






//                            Dashboard ends here





            }

        })

}











@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DashboardItem(item: DashboardItemData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        backgroundColor = Color.White,
        onClick = item.onClick
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = "Dashboard Icon",
                tint = Color.Black,
                modifier = Modifier.size(36.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = item.title,
                style = MaterialTheme.typography.subtitle1,
                color = Color.Black
            )
            // Add a badge if the badge count is greater than 0
            if (item.badgeCount > 0) {
                Badge(count = item.badgeCount)
            }
        }
    }
}
@Composable
fun Badge(count: Int) {
    Box(
        modifier = Modifier
            .padding(start = 8.dp)
            .size(20.dp)
            .clip(CircleShape)
            .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = count.toString(),
            style = MaterialTheme.typography.caption,
            color = Color.White
        )
    }
}
data class DashboardItemData(
    val title: String,
    val icon: ImageVector,
    val badgeCount: Int,
    val onClick: () -> Unit
)
data class User(
    val userId: String = "",
    val school: String = "",
    val name: String = ""
)

fun saveUserDetails(user: User, param: (Any) -> Unit) {
    val firestore = FirebaseFirestore.getInstance()
    firestore.collection("users").document(user.userId)
        .set(user, SetOptions.merge())
        .addOnSuccessListener {

            progressDialog?.dismiss()
            // Success message or navigation
        }
        .addOnFailureListener {

            progressDialog?.dismiss()
            // Handle failure
        }
}

 */
//    Scaffold(
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = {
//                    androidx.compose.material3.Text(text = "ARTICLES")
//                },
//                navigationIcon = {
//                    androidx.compose.material3.IconButton(onClick = {
//                        navController.navigate(ROUTE_HOME) {
//                            popUpTo(ROUTE_SEARCH) { inclusive = true }
//                        }
//                    }) {
//                        androidx.compose.material3.Icon(
//                            Icons.AutoMirrored.Filled.ArrowBack,
//                            "backIcon",
//                            tint = Color.White
//                        )
//                    }
//
//                },
//                actions = {
//                    androidx.compose.material3.IconButton(onClick = {
//                        navController.navigate(ROUTE_ADD_STUDENTS) {
//                            popUpTo(ROUTE_DASHBOARD) { inclusive = true }
//                        }
//
//                    }) {
//                        androidx.compose.material3.Icon(
//                            imageVector = Icons.Filled.Add,
//                            contentDescription = null,
//                            tint = Color.White
//                        )
//                    }
//                },
//
//
//                colors = topAppBarColors(
//                    containerColor = Color(0xff0505562),
//                    titleContentColor = Color.White,
//                ),
//            )
//        },
//
//        content = {
//            LazyColumn {
//                item {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xffaa918c)),
//                    ) {
//                        androidx.compose.material3.Card(
////                   onClick = {
////           navController.navigate(ROUTE_ABOUT_US) {
////                popUpTo(ROUTE_HOME) { inclusive = true }
////            }
////                   },
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(200.dp)
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.flamingtorch), // Replace with your coffee cup image
//                                contentDescription = "acquaint",
//                                modifier = Modifier
//                                    .fillMaxWidth()
//
//                            )
//
//
//                        }
//                    }
//                }
//            }
//
//        },
//    )
//}

    data class Screen(val title: String, val icon: Int)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ResourceAsColor")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun HomeScreen(navController: NavHostController,/*openWebsite: (String) -> Unit,onNavigateToWebsite: (String) -> Unit*/) {

        var isDrawerOpen by remember { mutableStateOf(false) }



            }

        Scaffold(
            topBar = {
            CenterAlignedTopAppBar(
                title = {
                    androidx.compose.material3.Text(text = "ARTICLES")
                },
                navigationIcon = {
                    androidx.compose.material3.IconButton(onClick = {
                        navController.navigate(ROUTE_HOME) {
                            popUpTo(ROUTE_SEARCH) { inclusive = true }
                        }
                    }) {
                        androidx.compose.material3.Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            "backIcon",
                            tint = Color.White
                        )
                    }

                },
                actions = {
                    androidx.compose.material3.IconButton(onClick = {
                        navController.navigate(ROUTE_ADD_PRODUCT) {
                            popUpTo(ROUTE_DASHBOARD) { inclusive = true }
                        }

                    }) {
                        androidx.compose.material3.Icon(
                            imageVector = Icons.Filled.Add,
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

                                }
                        ) {


                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color(0xffaa918c)),

                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Card(
                                    modifier = Modifier
                                    ,
                                    onClick = {
                                        navController.navigate(ROUTE_ADD_PRODUCT)
                                    },

                                    ) {
                                    Text(style = androidx.compose.material.MaterialTheme.typography.h5,
                                        text = "Add Your Article")
                                }

                                LazyRow {
                                    item { 
                                        Row {
                                            Card(
                                                modifier = Modifier

                                                ,
                                                onClick = {
                                                    navController.navigate(ROUTE_ABOUT_US)
                                                },

                                                ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.jesusisanswer), // Jesus is my anchor
                                                    contentDescription = "acquaint",
                                                    modifier = Modifier
                                                )
                                            }
                                            Spacer(modifier = Modifier.width(10.dp))
                                            Card(
                                                modifier = Modifier

                                                ,
                                                onClick = {
                                                    navController.navigate(ROUTE_ABOUT_US)
                                                },

                                                ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.image7), // Jesus is my anchor
                                                    contentDescription = "acquaint",
                                                    modifier = Modifier
                                                )
                                            }
                                        }
                                    }
                                }
                                Card(
                                ) {

                                    Image(
                                        painter = painterResource(id = R.drawable.loveimage2), // Jesus is my anchor
                                        contentDescription = "acquaint",
                                        modifier = Modifier
                                    )
                                }
                                Text( style = androidx.compose.material.MaterialTheme.typography.h6,
                                    text = "Many years ago, I witnessed something I would like to forget—a face-slapping, eye-gouging, hair-pulling confrontation between two “Christian” women in the foyer of a church, where I happened to be preaching. (It had nothing to do with my sermon, in case you’re wondering.) A rare display of animosity? Thankfully, yes. A rare attitude of heart? Regrettably, no. The “spirit” of envy, bitterness, malice, and resentment, which gave rise to that unfortunate confrontation, is all too common among us. While far subtler than any public “smack-down,” it’s just as damaging. It destroys relationships, divides churches, and dishonors Christ. Surely, it ought not to be so among those who call themselves Christians. , “An envious Christian, a malicious Christian, a cold and hard-hearted Christian, is the greatest absurdity and contradiction. It is as if one should speak of dark brightness, or a false truth!”[1]1 Corinthians 13, entitled Charity and Its Fruits: Christian Love as Manifested in the Heart and Life. In this article, I want to use his treatise to highlight three valuable lessons on true Christian love. I pray the Lord will use this brief study to heighten our appreciation of this vital subject.")
                                Text( style = androidx.compose.material.MaterialTheme.typography.h5,
                                    text = "The Need for True Christian Love")
                                Text( style = androidx.compose.material.MaterialTheme.typography.h6,
                                    text = "The first lesson concerns the need for true Christian love. Paul writes, “If I speak in the tongues of men and of angels, but have not love, I am a noisy gong or a clanging cymbal. And if I have prophetic powers, and understand all mysteries and all knowledge, and if I have all faith, so as to remove mountains, but have not love, I am nothing. If I give away all I have, and if I deliver up my body to be burned, but have not love, I gain nothing” (1 Cor. 1:1–3).Based on these verses, Edwards affirms that “excellent privileges” (such as those mentioned in vv. 1–2) and “excellent performances” (such as those mentioned in v. 3) are nothing without love (“charity” as he calls it).[2] In his estimation, these “privileges” and “performances” are the greatest experiences known to man, yet they’re completely worthless when detached from love. From this basic premise, he derives the following doctrine: “That all the virtue that is saving, and that distinguishes true Christians from others, is summed up in Christian love.”[3] By way of clarification, he adds, “Let a man have what he will, and do what he will, it signifies nothing without charity; which surely implies that charity is the great thing, and that everything which has not charity in some way contained or implied in it, is nothing, and that this charity is the life and soul of all religion, without which all things that wear the name of virtues are empty and vain.”[4]Given the fact that love is “the life and soul of all religion,” we ought to be profoundly concerned with ensuring that our love is sincere. Paul declares, “Let love be genuine” (Rom. 12:9). The term “genuine” is anupokritos—without a mask. In Greek drama plays, actors wore masks to depict emotions. But an actor might actually have been feeling something entirely different from the emotion displayed by his mask. The mask might have been sad, when he was happy. The mask might have been happy, when he was sad. When it comes to love, Paul’s point is that we must not wear masks. We must not give people the impression that we love them (kind words, warm hugs, beautiful smiles, firm handshakes), when in reality we feel quite different. We must not deceive ourselves into thinking that externals will “mask” what lurks inside. We must avoid the peril of hiding behind excellent “privileges” and “performances.” In short, we must make certain that there is a correlation between our hearts and our actions. If not, we are nothing more than hypocrites, void of saving grace.")
                                Text( style = androidx.compose.material.MaterialTheme.typography.h5,
                                    text = "The Nature of True Christian Love")
                                Text( style = androidx.compose.material.MaterialTheme.typography.h6,
                                    text = "The first problem is a housing issue. “Now the sons of the prophets said to Elisha, ‘See, the place where we dwell under your charge is too small for us’” (2 Kings 6:1). I get this. Several years ago, with our kids getting older, our house felt cramped, so we moved to a larger one. I wouldn’t deem our housing needs worthy of inclusion in Holy Scripture. Maybe the sons of the prophets felt similarly. But here’s their story — in the Bible. Apparently, the small problems of small people matter to God.In this case, the sons of the prophets come to Elisha not just with a problem, but with a proposed solution. “‘Let us go to the Jordan and each of us get there a log, and let us make a place for us to dwell there.’ And he answered, ‘Go’” (2 Kings 6:2). Sometimes God meets our needs through miraculous means (he’ll do that in this very story). Other times he helps us through our own activity. Elisha doesn’t make a new house appear out of thin air. Instead, the sons of the prophets mount a logging expedition and build a house.God often works this way. According to Jesus, God feeds the birds of the air — but as one of my seminary professors used to say, you don’t see birds lying on their backs, waiting for God to drop worms into their beaks. He feeds them through their own worm-finding efforts. Yes, God can provide manna from heaven and bread by raven (1 Kings 17:3–6), but his normal means of provision is our own hard work (2 Thessalonians 3:10). Ask God for his help. Give him your burden. Surrender your problem. He wants you to ask. The second problem involves a lost axe head. “But as one was felling a log, his axe head fell into the water, and he cried out, ‘Alas, my master! It was borrowed’” (2 Kings 6:5). Of course, this is a tiny issue in the grand sweep of things. But when a problem happens to us, we don’t feel that way about it. When it’s our injured leg, our dented car, our negative job review, our extended sickness, the comparatively small problem can feel big. The unnamed man in verse 5 “cried out” — a term connoting real distress. He cries out, “Alas!” He can’t afford to replace that borrowed axe head.Yes, it’s a relatively small problem — but not to him. Will God even notice? Look what happens next.")
                                Text( style = androidx.compose.material.MaterialTheme.typography.h5,
                                    text = "Small Miracle")
                                Text( style = androidx.compose.material.MaterialTheme.typography.h6,
                                    text = "The second lesson concerns the nature of true Christian love. What does it look like? Paul writes, “Love is patient and kind; love does not envy or boast; it is not arrogant or rude. It does not insist on its own way; it is not irritable or resentful” (1 Cor. 13:4–5). Based on these verses, Edwards identifies seven marks of love.First, love is patient. “[It] will dispose us meekly to bear the evil that is received from others, or the injuries that others may do to us.”[5] We see such an attitude of heart in Moses, who endured (among other things) Israel’s murmuring, Korah’s rebellion, and Miriam’s resentment (Ex. 15:24; 16:2; 17:2–3; Num. 11:1; 12:1; 14:2; 16:1–3; Deut. 1:27). How was he able to do it? Simply put, he knew who he was before God. He recognized his smallness before God’s greatness and his sinfulness before God’s holiness. He knew that anything short of damnation was a mercy. This stirred in him the realization that his worst circumstance was still better than what he deserved. And this made him “very meek, more than all people who were on the face of the earth” (Num. 12:3). For this reason, he was able to “bear” the evil he received from others. Edwards remarks, “A humble spirit disinclines us to indulge resentment of injuries; for he that is little and unworthy in his own eyes, will not think so much of an injury offered to him as he that has high thoughts of himself.[6] Second, love is kind. “[It] will dispose us freely to do good to others.”[7] In other words, we will be concerned for their well-being. (1) Mindful of the body, we will seek to alleviate people’s physical suffering. There is disease; love compels us to build hospitals. There’s sickness; love compels us to provide medicine. There’s famine; love compels us to distribute food. There’s crime; love compels us to provide protection. There’s injustice; love compels us to intervene. There’s grief; love compels us to comfort. (2) Mindful of the soul, we will seek to alleviate people’s spiritual suffering. We’re like Christ who “had compassion” for the multitudes “because they were harassed and helpless, like sheep without a shepherd” (Matt. 9:36). We know the cross is the only answer for their sin. Therefore, we proclaim the gospel—“the power of God for salvation to everyone who believes” (Rom. 1:16). To sum up, Edwards comments, “Let our benevolence and beneficence be universal, constant, free, habitual, and according to our opportunities and ability; for this is essential to true piety, and required by the commands of God.”[8]Third, love does not envy. “[It] is the very opposite of the envious spirit.”[9] According to Edwards, “[Envy] is a disposition natural in men, that they love to be uppermost; and this disposition is directly crossed, when they see others above them.”[10] There are two important components to this definition. (1) The desire to be “uppermost” is a natural disposition; we all desire to be honored, esteemed, and admired. (2) Envy is experienced when others cross our desire to be “uppermost.” If we fail to mortify envy, malice, bitterness, and resentment will take hold. They will fester. Eventually, they will strike out. We see it in the case of Cain and Abel. God was pleased with Abel’s sacrifice, but not with Cain’s sacrifice. Cain was envious. His desire to be uppermost was crossed. “Cain was very angry and his face fell” (Gen. 4:5). As a result, he killed his brother with his own hands. We see it again in the case of Joseph and his brothers. Joseph had several dreams, depicting the fact that his brothers would bow down to him some day. They were envious. Their desire to be uppermost was crossed. “They hated him even more for his dreams and for his words” (Gen. 37:8). Most of them wanted to kill him, but they settled for selling him into slavery. We see it again in the case of David and Saul. The women sang, “Saul has slain his thousands, and David his ten thousands.” Saul hated it. He was envious. His desire to be uppermost was crossed. “Saul eyed David from that day on” (1 Sam. 18:9). As a result, he tried to kill him. In each of these instances, envy spawned murderous intent. But true Christian love is the exact opposite. “A Christian spirit,” says Edwards, “disposes us to feel content with our own condition, and with the estate which God has given us among men, and to a quietness and satisfaction of spirit with regard to the allotments and distributions of stations and possessions which God, in his wise and kind providence, has made to ourselves and others.[11]Fourth, love does not boast; it is not arrogant or rude. “[It] is a humble spirit.”[12] Edwards defines humility as “a habit of mind and heart corresponding to our comparative unworthiness and vileness before God, or a sense of our own comparative meanness in his sight, with the disposition to a behavior answerable thereto.”[13] (1) There is natural humility.[14] Adam and Eve possessed this before the fall. What is it? It arises when we perceive our littleness as creatures before God. When we compare ourselves to His natural excellence, we see our littleness. We are weak in comparison to His power. We are foolish in comparison to His wisdom. We are ignorant in comparison to His knowledge. We are small in comparison to His sovereignty. (2) There is moral humility.[15] Adam and Eve did not possess this before the fall. What is it? It arises when we perceive our vileness as sinners before God. When we compare ourselves to His moral excellence, we see our sinfulness. We recognize that we are without moral virtues adequate to commend ourselves to God. As a result, we are aware of our utter dependence upon God’s grace. We cry with Isaiah, “Woe is me! For I am lost; for I am a man of unclean lips, and I dwell in the midst of a people of unclean lips; for my eyes have seen the King, the LORD of hosts!” (Isa. 6:5). In such a condition, who of us can boast? Fifth, love does not insist on its own way. “[It] is the opposite of a selfish spirit.”[16] In a state of innocence (before the fall), man loved happiness.[17] He viewed God as his chief happiness (i.e., the greatest good). He loved God and, therefore, his affections were well-directed. In a state of apostasy (since the fall), man still loves happiness. However, he no longer views God as his happiness. He no longer loves God and, therefore, his affections are ill-directed. In other words, man seeks happiness in himself: he pursues “the honor that consists in a man’s being set up higher in the world than his neighbors;” he chases “his own worldly ease and convenience;” and he gratifies “his own bodily appetites and lusts.”[18] However, in a state of renewal (after the new birth), man’s love of happiness is again well-directed, in that it is set upon God. Edwards explains, “The change that takes place in a man, when he is converted and sanctified, is not that his love for happiness is diminished, but only that it is regulated with respect to its exercises and influences, and the courses and objects it leads to.”[19] Because our pursuit of happiness is “regulated,” we are no longer governed by selfishness. Sixth, love is not irritable. “[It] is the opposite of an angry or wrathful spirit or disposition.”[20] According to Edwards, there are four occasions, when anger is sinful.[21] (1) It is sinful in its “nature” when it is an expression of pride or frustration. (2) It is sinful in its “occasion” when it is based on an error in judgment. (3) It is sinful in its “objective” when it is marked by a loss of control; that is, it is oversteps the bounds of reason. (4) It is sinful in its “measure” when it is out of proportion to its cause. Edwards makes the point that true Christian love rectifies all these. In a word, it is “contrary to anger,” because its essential nature is “good-will.”[22] Seventh, love is not resentful. “[It] is the opposite of a censorious spirit.”[23] We manifest a “censorious spirit” when we pass judgment on others, while ignoring our own sin. Because of pride, we are particularly susceptible to this offense. By way of remedy, Edwards proposes that we take a long, hard look at the depths of our own sin. When we feel the weight of it, we will be less likely to vilify or malign others. Edwards explains, “If men were humbly sensible of their own failings, they would not be very forward or pleased in judging others, for the censure passed upon others would rest on themselves.”[24]")
                                Text( style = androidx.compose.material.MaterialTheme.typography.h5,
                                    text = "The Origin of True Christian Love")
                                Text( style = androidx.compose.material.MaterialTheme.typography.h6,
                                    text = "The third (and final) lesson concerns the origin of true Christian love. Where does it come from? To answer that, we must understand how love works. In a word, we love whatever we perceive to be good (i.e., pleasurable). By way of example, I love heavenly-hash ice cream, because it tastes good. I love Gabriel’s Oboe, because it sounds good. I love hiking, because it feels good. I love lilac, because it smells good. I love autumn, because it looks good. My physical senses find these things pleasurable; thus, I deem them to be good. Consequently, I love them. On a greater level, I love my wife. I deem her to be good—emotionally, physically, relationally, etc. Therefore, I’m drawn to her.On a far greater level, I love God. Like the body, the soul has its senses. It too is drawn to what it perceives to be pleasurable. For the Christian, this is God—the fountain of all that is good, right, and true. “A spiritual view of divine things,” says Edwards, “always excites love in the soul, and draws forth the heart in love to every proper object. True discoveries of the divine character dispose us to love God as the supreme good; they unite the heart in love to Christ.”[25] And so, I love God, because He is good. I see His goodness in His being: holiness. I see His goodness in His deeds: faithfulness. I see His goodness in His words: truthfulness. I see His goodness in His condemnation of sinners: righteousness. I see His goodness in His justification of sinners: loving-kindness. Moreover, I see all these facets of God’s goodness wonderfully displayed at the cross. There, I see God’s holiness; the Lord Jesus, in whom there is no sin. There, I see God’s faithfulness; the Lord Jesus, fulfilling God’s promise to provide salvation, crush Satan, and conquer death. There, I see God’s truthfulness; the Lord Jesus, confirming everything God has ever said about me. There, I see God’s righteousness; the Lord Jesus, suffering the wrath of God’s offended justice. There, I see God’s loving-kindness; the Lord Jesus, securing God’s mercy for all who believe.By the work of the Holy Spirit, God’s goodness is impressed upon my soul. It causes me to love Him. I desire Him, and I delight in Him. According to Edwards, such love for God causes “a man to honor [God], to worship and adore him, and heartily to acknowledge his greatness and glory and dominion.”[26] Furthermore, it inclines “the soul to flow out in love to God’s people, and to all mankind.”[27] In other words, love for God necessarily gives rise to love for others. They are inseparable companions.All of that to say, if we want to love others more, we must love God more. This means we must pray continually for “strength to comprehend with all the saints what is the breadth and length and height and depth, and to know the love of Christ that surpasses knowledge” (Eph. 3:18–19). When we abound in His love, we (as the church) will be a family of believers characterized by compassion, kindness, humility, meekness, and patience (Col. 3:12). Moreover, we will “put on love, which binds everything together in perfect harmony (Col. 3:14).")
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(200.dp)
                                    ,
                                    onClick = {
                                        navController.navigate(ROUTE_SEARCH)
                                    },

                                    ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.image7), // Jesus is my anchor
                                        contentDescription = "acquaint",
                                        modifier = Modifier
                                    )
                                }






                            }
                        }
                    }
                }
                                  },
            )
}
