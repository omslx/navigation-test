package ir.mslx.navigation.ui.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.Modifier.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.mslx.navigation.ui.theme.ProfileBackground
import ir.mslx.navigation.ui.theme.ProfileCard
import ir.mslx.navigation.ui.theme.ProfileMuted
import ir.mslx.navigation.ui.theme.ProfilePink
import ir.mslx.navigation.ui.theme.ProfilePurple


@Composable
fun ProfileScreen(
    onEditProfile: () -> Unit = {},
    onSettings: () -> Unit = {},
    onNotifications: () -> Unit = {},
    onPrivacy: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ProfileBackground)
    ) {
        // Ambient background glow
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(x = 100.dp, y = (-100).dp)
                .size(250.dp)
                .background(
                    Brush.radialGradient(
                        listOf(
                            ProfilePurple.copy(alpha = 0.17f),
                            Color.Transparent
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 28.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text(
                        text = "YOUR SPACE",
                        color = ProfilePurple,
                        fontSize = 10.sp,
                        letterSpacing = 3.sp
                    )

                    Text(
                        text = "Profile",
                        color = Color.White,
                        fontSize = 29.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Surface(
                    onClick = onSettings,
                    shape = RoundedCornerShape(16.dp),
                    color = ProfileCard,
                    border = androidx.compose.foundation.BorderStroke(
                        1.dp,
                        Color.White.copy(alpha = 0.08f)
                    )
                ) {
                    Text(
                        text = "⚙",
                        modifier = Modifier.padding(
                            horizontal = 16.dp,
                            vertical = 12.dp
                        ),
                        color = Color.White,
                        fontSize = 21.sp
                    )
                }
            }

            // User profile card
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(28.dp))
                    .background(
                        Brush.linearGradient(
                            listOf(
                                Color(0xFF21162D),
                                Color(0xFF14121A),
                                Color(0xFF101015)
                            )
                        )
                    )
                    .border(
                        1.dp,
                        Color.White.copy(alpha = 0.09f),
                        RoundedCornerShape(28.dp)
                    )
                    .padding(22.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Default Material icon as avatar
                Box(
                    modifier = Modifier
                        .size(112.dp)
                        .background(
                            Brush.linearGradient(
                                listOf(ProfilePurple, ProfilePink)
                            ),
                            CircleShape
                        )
                        .padding(3.dp)
                        .background(
                            Color(0xFF17121F),
                            CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "●",
                        color = Color(0xFFE5C9FF),
                        fontSize = 52.sp
                    )
                }

                Spacer(Modifier.height(18.dp))

                Text(
                    text = "Amin Ahmadi",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(Modifier.height(6.dp))

                Text(
                    text = "@mslx",
                    color = ProfilePurple,
                    fontSize = 14.sp
                )

                Spacer(Modifier.height(12.dp))

                Text(
                    text = "Developer • Tech Enthusiast",
                    color = ProfileMuted,
                    fontSize = 12.sp
                )

                Spacer(Modifier.height(22.dp))

                Button(
                    onClick = onEditProfile,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ProfilePurple,
                        contentColor = Color(0xFF100B16)
                    )
                ) {
                    Text(
                        text = "EDIT PROFILE",
                        modifier = Modifier.padding(vertical = 5.dp),
                        letterSpacing = 2.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Statistics
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                StatCard(
                    value = "12",
                    label = "PROJECTS",
                    modifier = Modifier.weight(1f)
                )

                StatCard(
                    value = "8",
                    label = "SKILLS",
                    modifier = Modifier.weight(1f)
                )

                StatCard(
                    value = "4y",
                    label = "EXPERIENCE",
                    modifier = Modifier.weight(1f)
                )
            }

            // About section
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                SectionTitle("About me")

                Text(
                    text = "Building things with code. Interested in Android, " +
                            "backend engineering and networking.",
                    color = ProfileMuted,
                    fontSize = 14.sp,
                    lineHeight = 23.sp
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SkillChip("Kotlin")
                    SkillChip("Java")
                    SkillChip("Android")
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    SkillChip("Backend")
                    SkillChip("Networking")
                }
            }

            // Settings section
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                SectionTitle("Account")

                ProfileOption(
                    icon = "✦",
                    title = "Personal information",
                    subtitle = "Manage your account details",
                    onClick = onEditProfile
                )

                ProfileOption(
                    icon = "♧",
                    title = "Notifications",
                    subtitle = "Manage your preferences",
                    onClick = onNotifications
                )

                ProfileOption(
                    icon = "◇",
                    title = "Privacy & security",
                    subtitle = "Keep your account secure",
                    onClick = onPrivacy
                )
            }

            Text(
                text = "DESIGNED FOR THE DARK",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                color = Color.White.copy(alpha = 0.25f),
                fontSize = 9.sp,
                letterSpacing = 2.sp
            )
        }
    }
}

@Composable
private fun StatCard(
    value: String,
    label: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(ProfileCard)
            .border(
                1.dp,
                Color.White.copy(alpha = 0.06f),
                RoundedCornerShape(20.dp)
            )
            .padding(vertical = 20.dp, horizontal = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = value,
            color = Color(0xFFE3C8FF),
            fontSize = 23.sp,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = label,
            color = ProfileMuted,
            fontSize = 9.sp,
            letterSpacing = 1.sp
        )
    }
}

@Composable
private fun SectionTitle(title: String) {
    Text(
        text = title,
        color = Color.White,
        fontSize = 19.sp,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
private fun SkillChip(text: String) {
    Surface(
        shape = RoundedCornerShape(50),
        color = Color(0xFF201629),
        border = androidx.compose.foundation.BorderStroke(
            1.dp,
            ProfilePurple.copy(alpha = 0.25f)
        )
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(
                horizontal = 13.dp,
                vertical = 9.dp
            ),
            color = Color(0xFFDCC3FF),
            fontSize = 11.sp
        )
    }
}

@Composable
private fun ProfileOption(
    icon: String,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(18.dp),
        color = ProfileCard,
        border = androidx.compose.foundation.BorderStroke(
            1.dp,
            Color.White.copy(alpha = 0.06f)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(13.dp))
                    .background(ProfilePurple.copy(alpha = 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = icon,
                    color = ProfilePurple,
                    fontSize = 22.sp
                )
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = subtitle,
                    color = ProfileMuted,
                    fontSize = 11.sp
                )
            }

            Text(
                text = "›",
                color = ProfileMuted,
                fontSize = 25.sp
            )
        }
    }
}