package com.example.gallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gallery.ui.theme.GalleryTheme
import com.google.mlkit.vision.text.Text
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GalleryTheme {
                GalleryLayout()
            }
        }
    }
}

@Preview
@Composable
fun GalleryLayout(modifier: Modifier = Modifier) {
    Page(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}


@Composable
fun Page(modifier: Modifier) {

    var page by remember { mutableStateOf(1)}
    var image: Int
    var text1: String
    var text2: String

    when(page) {
        1 -> {
            image = R.drawable.first
            text1 = "1"
            text2 = "1"
        } 2 -> {
            image = R.drawable.second
            text1 = "2"
            text2 = "2"
        } 3 -> {
            image = R.drawable.third
            text1 = "3"
            text2 = "3"
        } 4 -> {
            image = R.drawable.forth
            text1 = "4"
            text2 = "4"
        } else -> {
            image = R.drawable.fifth
            text1 = "5"
            text2 = "5"
        }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 180.dp, bottom = 130.dp)

            ) {
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    Modifier.size(300.dp)
                )
                Text(
                    text = text1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = text2,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
        ) {
            Row {
                Button(
                    onClick = { page = if(page==1) 5 else page-1},
                    modifier = Modifier.padding(start = 20.dp, end = 150.dp)
                ) { Text(text = "Previous") }
                Button(
                    onClick = { page = if(page==5) 1 else page+1},
                    modifier = Modifier.size(width = 80.dp, height = 190.dp)
                ) { Text(text = "Next") }
            }
        }
    }

}


