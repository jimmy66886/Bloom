package com.zzmr.bloom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.zzmr.bloom.ui.theme.body1
import com.zzmr.bloom.ui.theme.body2
import com.zzmr.bloom.ui.theme.button
import com.zzmr.bloom.ui.theme.gray
import com.zzmr.bloom.ui.theme.h1
import com.zzmr.bloom.ui.theme.medium
import com.zzmr.bloom.ui.theme.pink900
import com.zzmr.bloom.ui.theme.small
import com.zzmr.bloom.ui.theme.white

@Composable
fun LoginInPage(navController: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(white)
            .padding(horizontal = 16.dp) // 设计稿中所规定的内边距
    ) {
        LoginTitle()
        LoginInputBox()
        HintWithUnderline()
        LoginButton()
    }
}

@Composable
fun LoginTitle() {
    Text(
        text = "Log in with email",
        modifier = Modifier
            .fillMaxWidth()
            .paddingFromBaseline(top = 184.dp, bottom = 16.dp),
        style = h1,
        color = gray,
        textAlign = TextAlign.Center
    )
}

@Composable
fun LoginInputBox() {
    Column {
        LoginTextField("Email address")
        Spacer(Modifier.height(8.dp))
        LoginTextField("Password(8+Characters)")
    }
}

@Composable
fun LoginTextField(placeHolder: String) {
    var inputValue by remember { mutableStateOf("") }
    OutlinedTextField(
        value = inputValue,
        onValueChange = {
            inputValue = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(small),
        placeholder = {
            Text(
                text = placeHolder,
                style = body1,
                color = gray
            )
        }
    )
}

@Composable
fun HintWithUnderline() {
    Column(
        Modifier.paddingFromBaseline(top = 24.dp, bottom = 16.dp)
    ) {
        TopText()
        BottomText()
    }
}

@Composable
fun TopText() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        var keywordPre = "By Clicking below you agree to our".split(" ")
        var keywordPost = "and consent".split(" ")

        for (word in keywordPre) {
            Text(
                text = word,
                style = body2,
                color = gray
            )
        }

        Text(
            text = "Terms of Use",
            style = body2,
            color = gray,
            textDecoration = TextDecoration.Underline
        )

        for (word in keywordPost) {
            Text(
                text = word,
                style = body2,
                color = gray
            )
        }

    }
}

@Composable
fun BottomText() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "to Our ",
            style = body2,
            color = gray
        )
        Text(
            text = "Privacy Policy.",
            style = body2,
            color = gray,
            textDecoration = TextDecoration.Underline
        )
    }
}

@Composable
fun LoginButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth()
            .clip(medium),
        colors = ButtonDefaults.buttonColors(pink900)
    ) {
        Text(
            text = "Log in",
            style = button,
            color = white
        )
    }
}