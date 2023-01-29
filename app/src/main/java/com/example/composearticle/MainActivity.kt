package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Article("Android", "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.\nJetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.")
                }
            }
        }
    }
}

@Composable
fun Article(title: String, content: String) {
    val composeImage = painterResource(id = R.drawable.bg_compose_background)
    val paragraphs = content.split("\n")

    Column() {
        Image(painter = composeImage, contentDescription = null, modifier = Modifier.fillMaxWidth())
        ArticleTitle(title = title)
        paragraphs.mapIndexed {
            index, paragraph ->
                if(index > 0) {
                    ArticleParagraph(paragraph = paragraph, paddingTop = 16)
                } else {
                    ArticleParagraph(paragraph = paragraph)
                }
        }
    }
}

@Composable
fun ArticleTitle(title: String) {
    Text(text = title, modifier = Modifier.padding(16.dp), fontSize = 24.sp)
}

@Composable
fun ArticleParagraph(paragraph: String, paddingTop: Int = 0) {
    Text(text = paragraph, textAlign = TextAlign.Justify, modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = paddingTop.dp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
        Article("Jetpack Compose tutorial", "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.\nJetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.")
    }
}