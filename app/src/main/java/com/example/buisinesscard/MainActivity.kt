package com.example.buisinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buisinesscard.ui.theme.BuisinesscardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BuisinesscardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BuisinessCard()
                }
            }
        }
    }
}


@Composable
fun ImageFunc(){
    val image = painterResource(R.drawable.android_studio__2_)
    Column(modifier=Modifier
        .fillMaxWidth()
        .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Image(
            painter = image,
            contentDescription = "Profile picture of Aman Kaushik",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            alpha = 0.7F
        )

        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.name_string),
            modifier = Modifier
                .padding(top = 16.dp),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.headline_description),
            modifier = Modifier,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Composable
fun ContactInfoRow(
    image: Painter,
    iconDescription: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(vertical = 8.dp)
    ) {
        Image(
            painter = image,
            contentDescription = iconDescription,
            modifier = Modifier.size(24.dp),
        )
        Spacer(Modifier.width(16.dp))
        Text(text = text)
    }
}

@Composable
fun ContactInfoSection(modifier: Modifier = Modifier) {
    Column(modifier=modifier.padding(horizontal=24.dp)) {
        ContactInfoRow(
            image = painterResource(id = R.drawable.callicon),
            iconDescription = "Call Icon",
            text = "+91 8882050710"
        )
        ContactInfoRow(
            image = painterResource(id=R.drawable.insta),
            iconDescription = "Share Icon",
            text = "@amankaushik"
        )
        ContactInfoRow(
            image = painterResource(id = R.drawable.mail),
            iconDescription = "Email Icon",
            text = "amankaushiksome@gmail.com"
        )
    }
}


@Composable
fun BuisinessCard() {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceAround) {
        ImageFunc()
        ContactInfoSection()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BuisinesscardPreview() {
    BuisinesscardTheme {
        BuisinessCard()
    }
}