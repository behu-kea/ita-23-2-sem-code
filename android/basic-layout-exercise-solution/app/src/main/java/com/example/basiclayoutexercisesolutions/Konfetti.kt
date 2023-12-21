package com.example.basiclayoutexercisesolutions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import nl.dionsegijn.konfetti.compose.KonfettiView
import nl.dionsegijn.konfetti.core.Angle
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit

class Konfetti : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var position by remember {
                mutableStateOf(2f)
            }

            val myList = remember { mutableStateListOf<Party>() }

            Button(onClick = {
                // Trigger confetti by adding a Party
                println("asdsd")
                position = 5f;
            }) {
                Text(
                    text = "Spray confetti" + position.toString())
            }
            
            KonfettiView(
                modifier = Modifier.fillMaxSize(),
                parties = listOf(Party(
                    speed = 0f,
                    maxSpeed = 30f,
                    damping = 0.9f,
                    spread = 360,
                    colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
                    emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100),
                    position = Position.Absolute(position, 1f)
                ))
            )
        }
    }
}

@Composable
fun PartyAnimation(
    modifier: Modifier = Modifier,
    duration: Int
) {
    KonfettiView(
        modifier = modifier,
        parties = listOf(
            Party(
                speed = 0f,
                timeToLive = (duration * 1000).toLong(),
                maxSpeed = 30f,
                damping = 0.9f,
                angle = Angle.TOP,
                spread = 360,
                colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
                emitter = Emitter(duration = 1000, TimeUnit.MILLISECONDS).max(500),
                position = Position.Relative(0.5, 0.3)
            )
        )
    )
}