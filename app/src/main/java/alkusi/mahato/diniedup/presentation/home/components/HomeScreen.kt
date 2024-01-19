package alkusi.mahato.diniedup.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign


@Composable()
fun HomeScreen() {
    Box(
        modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight()
          .background(color = Color.Yellow),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "home", textAlign = TextAlign.Center)
    }
}