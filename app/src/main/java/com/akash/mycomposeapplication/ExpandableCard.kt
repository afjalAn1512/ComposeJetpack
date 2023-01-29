package com.akash.mycomposeapplication

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akash.mycomposeapplication.ui.theme.Shapes
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCard(){
    var expandedState by remember { mutableStateOf(false)}

    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f   else 0f
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = Shapes.medium,
        onClick = {
            expandedState = !expandedState
        }
    ) {

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                ){

            Row (verticalAlignment = Alignment.CenterVertically){

                Text(
                    modifier = Modifier.weight(6f),
                    text = "My Tittle",
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }) {
                      Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription ="Drop-Down Arrow" )
                }
            }

            if (expandedState){

                Text(
                    text = "FD JSDFGKHDSG SDABS DSGGGGGGGGGGGGBCVDGFDSH" +
                            "GGGGGGGGGGGGGGDSGHKJDSHGFHDSGDJKSGD SDFHDSJKHF" +
                            "JKV JHZFGJDZGV fdjjlsg hkehaw aibf as" +
                            "gh sagbffae  vrhehti trwehwetne ertojr" +
                            "eotkae rhksnofg ",
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Normal,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )

            }


        }

    }
}


@Composable
@Preview
fun ExpandableCardPreview(){
    ExpandableCard()
}