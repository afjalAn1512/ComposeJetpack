package com.akash.mycomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.Size
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akash.mycomposeapplication.ui.theme.MyComposeApplicationTheme
import com.akash.mycomposeapplication.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                   color = MaterialTheme.colors.background
                ) {
                   Greeting()
                }
            }
        }
    }
}



@Composable
fun Greeting(){

    Box(
        modifier = Modifier
            .background(Color.Gray)
            .padding(8.dp),
        contentAlignment = Alignment.TopCenter
    ) {

        Box(modifier = Modifier
            .background(Color.Blue),
            contentAlignment = Alignment.Center

        )
        {
            Box(modifier = Modifier
                .height(80.dp)
                .width(80.dp)
                .background(Color.Green))
            Text(text = "I Love Android!", fontSize = 35.sp)
        }

    }
}


@Composable
fun customText(){
    Text(
        text = stringResource(id = R.string.app_name),
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .padding(16.dp)
            .width(200.dp),
        color = Color.White,
        fontSize = MaterialTheme.typography.h6.fontSize,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.End

    )
}


@Composable
fun customText2(){

    Text(
        buildAnnotatedString {

            withStyle(style = ParagraphStyle()) {
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.primary,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("SpanStyle")

                }
                append("B")
                append("C")
                append("D")
            }
        }, modifier = Modifier.width(200.dp)
    )

}

///Custom Text Selection Container
@Composable
fun customText3(){
    SelectionContainer {
        
        Column {
            Text(
                modifier = Modifier.background(MaterialTheme.colors.error),
                text = "Hello Akash",
            )
            DisableSelection {
                Text(text = "Hello Alif")
            }
            Text(text = "Hello World !")
        }
        
    }
}

///SuperScriptText
@Composable
fun superScriptText(
    normalText : String,
    normalFontSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
    superText : String,
    superTextFontSize: TextUnit = MaterialTheme.typography.overline.fontSize,
    superTextFontWeight: FontWeight = FontWeight.Normal

){
    Text(buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = normalFontSize

            )
        ){
           append(normalText)
        }
        withStyle(
            style = SpanStyle(
                fontSize = superTextFontSize,
                fontWeight = superTextFontWeight,
                baselineShift = BaselineShift.Superscript
            )
        ){
            append(superText)
        }
    })
}

///SubScriptText

@Composable
fun subScriptText(
    normalText : String,
    normalFontSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
    superText : String,
    subTextFontSize: TextUnit = MaterialTheme.typography.overline.fontSize,
    subTextFontWeight: FontWeight = FontWeight.Normal

){
    Text(buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = normalFontSize

            )
        ){
            append(normalText)
        }
        withStyle(
            style = SpanStyle(
                fontSize = subTextFontSize,
                fontWeight = subTextFontWeight,
                baselineShift = BaselineShift.Subscript
            )
        ){
            append(superText)
        }
    })
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeApplicationTheme {

        Column(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primaryVariant)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
            Greeting()
            customText()
            customText2()
            customText3()
            superScriptText(
                normalText = "Hello",
                superText = "world !",
                superTextFontWeight = FontWeight.ExtraBold
            )
            subScriptText(
                normalText = "Hello",
                superText = "Akash",
                subTextFontWeight = FontWeight.Medium
                )
            ExpandableCard()
        }
    }
}