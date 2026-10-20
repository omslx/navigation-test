package ir.mslx.navigation.ui.screen

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ir.mslx.navigation.ui.theme.Background
import ir.mslx.navigation.ui.theme.Muted
import ir.mslx.navigation.ui.theme.Pink
import ir.mslx.navigation.ui.theme.Purple
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun LoadingScreen(onLoadingFinished: () -> Unit){
    LaunchedEffect(Unit) {
        delay(6000.milliseconds)
        onLoadingFinished()
    }
    val transition = rememberInfiniteTransition(label = "loading")

    val rotation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1800,
                easing = FastOutSlowInEasing
            )
        ),
        label = "rotation"
    )

    val pulse by transition.animateFloat(
        initialValue = 0.45f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .offset(x = 80.dp, y = (-150).dp)
                .size(240.dp)
                .blur(100.dp)
                .background(
                    Purple.copy(alpha = 0.20f * pulse),
                    CircleShape
                )
        )

        Box(
            modifier = Modifier
                .offset(x = (-90).dp, y = 130.dp)
                .size(200.dp)
                .blur(100.dp)
                .background(
                    Pink.copy(alpha = 0.13f * pulse),
                    CircleShape
                )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Canvas(
                modifier = Modifier.size(92.dp)
            ) {
                val stroke = 3.dp.toPx()
                val inset = stroke / 2

                drawCircle(
                    color = Color.White.copy(alpha = 0.07f),
                    style = androidx.compose.ui.graphics.drawscope.Stroke(
                        width = stroke
                    )
                )

                drawArc(
                    brush = Brush.sweepGradient(
                        colors = listOf(
                            Color.Transparent,
                            Purple,
                            Pink,
                            Color.Transparent
                        )
                    ),
                    startAngle = rotation,
                    sweepAngle = 245f,
                    useCenter = false,
                    topLeft = Offset(inset, inset),
                    size = androidx.compose.ui.geometry.Size(
                        size.width - stroke,
                        size.height - stroke
                    ),
                    style = androidx.compose.ui.graphics.drawscope.Stroke(
                        width = stroke,
                        cap = StrokeCap.Round
                    )
                )
            }

            Spacer(Modifier.height(36.dp))

            Text(
                text = "Testing Navigation",
                color = Color.White.copy(alpha = pulse),
                fontSize = 27.sp,
                fontWeight = FontWeight.Light,
                letterSpacing = 5.sp
            )

            Spacer(Modifier.height(12.dp))

            Text(
                text = "ENTERING THE VOID",
                color = Muted,
                fontSize = 10.sp,
                letterSpacing = 3.sp
            )

            Spacer(Modifier.height(42.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    Modifier
                        .size(5.dp)
                        .clip(CircleShape)
                        .background(Purple.copy(alpha = pulse))
                )

                Spacer(Modifier.width(10.dp))

                Text(
                    text = "INITIALIZING EXPERIENCE",
                    color = Color.White.copy(alpha = 0.65f),
                    fontSize = 9.sp,
                    letterSpacing = 1.8.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

        Text(
            text = "DESIGNED FOR THE DARK",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp),
            color = Color.White.copy(alpha = 0.25f),
            fontSize = 9.sp,
            letterSpacing = 2.sp
        )
    }
}