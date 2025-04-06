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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RaceParticipant(
    val name: String,
    private val maxProgress: Int = 100,
    private val progressDelayMillis: Long,
    private val progressIncrement: Int,
    private val initialProgress: Int = 0
) {
    var currentProgress by mutableStateOf(initialProgress)
        private set

    val progressFactor: Float
        get() = currentProgress.toFloat() / maxProgress.toFloat()

    suspend fun run() {
        while (currentProgress < maxProgress) {
            delay(progressDelayMillis)
            currentProgress += progressIncrement
        }
    }

    fun reset() {
        currentProgress = 0
    }
}