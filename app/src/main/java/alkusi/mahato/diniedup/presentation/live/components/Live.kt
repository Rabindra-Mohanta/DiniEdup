package alkusi.mahato.diniedup.presentation.live.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Live() {
    Box(modifier = Modifier.fillMaxWidth().fillMaxHeight().background(color = Color.Blue), contentAlignment = Alignment.Center) {
        Text(text = "Live")
    }
}