import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.racetracker.R
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun RaceTrackerApp() {
    val playerOne = remember {
        RaceParticipant(
            name = "Player 1",
            progressIncrement = 1,
            progressDelayMillis = 300L
        )
    }
    val playerTwo = remember {
        RaceParticipant(
            name = "Player 2",
            progressIncrement = 2,
            progressDelayMillis = 300L
        )
    }
    var raceInProgress by remember { mutableStateOf(false) }

    if (raceInProgress) {
        LaunchedEffect(playerOne, playerTwo) {
            coroutineScope {
                launch { playerOne.run() }
                launch { playerTwo.run() }
            }
            raceInProgress = false
        }
    }

    RaceTrackerScreen(
        playerOne = playerOne,
        playerTwo = playerTwo,
        isRunning = raceInProgress,
        onRunStateChange = { raceInProgress = it },
        onReset = {
            playerOne.reset()
            playerTwo.reset()
        }
    )
}

@Composable
fun RaceTrackerScreen(
    playerOne: RaceParticipant,
    playerTwo: RaceParticipant,
    isRunning: Boolean,
    onRunStateChange: (Boolean) -> Unit,
    onReset: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Run a Race",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Player 1 Card
        PlayerCard(
            participant = playerOne,
            iconTint = Color(0xFF6200EE), // Purple
            progressColor = Color(0xFF6200EE)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Player 2 Card
        PlayerCard(
            participant = playerTwo,
            iconTint = Color(0xFF03DAC6), // Teal
            progressColor = Color(0xFF03DAC6)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Controls
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { onRunStateChange(!isRunning) },
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(if (isRunning) "Pause" else "Start")
            }

            OutlinedButton(
                onClick = onReset,
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Reset")
            }
        }
    }
}

@Composable
fun PlayerCard(
    participant: RaceParticipant,
    iconTint: Color,
    progressColor: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_walk),
            contentDescription = participant.name,
            tint = iconTint,
            modifier = Modifier.size(48.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = participant.name,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        LinearProgressIndicator(
            progress = participant.progressFactor,
            color = progressColor,
            trackColor = progressColor.copy(alpha = 0.2f),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(12.dp)
                .clip(RoundedCornerShape(6.dp))
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "${participant.currentProgress}%",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}