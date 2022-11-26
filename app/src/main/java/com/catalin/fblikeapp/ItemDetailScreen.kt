package com.catalin.fblikeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.catalin.fblikeapp.data.Dessert
import com.catalin.fblikeapp.data.Fruit
import com.catalin.fblikeapp.data.getItem

@Composable
fun ItemDetailScreen(itemId: Int, modifier: Modifier) {
    val item = getItem(itemId)
    var dessert: Dessert? = null
    var fruit: Fruit? = null
    if (item is Dessert)
        dessert = item
    else if (item is Fruit)
        fruit = item

    val painter = (dessert?.resId ?: fruit?.resId)?.let { painterResource(id = it) }
    val title = (dessert?.title ?: fruit?.name)?.let { it }
    val desc = (dessert?.desc ?: fruit?.desc)?.let { it }
    val origin = (dessert?.origin ?: fruit?.origin)?.let { it }

    Column(modifier.background(Color.White)) {
        painter?.let { Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        ) }

        title?.let {
            Text(text = it, fontWeight = FontWeight.Bold, fontSize = 25.sp, modifier = Modifier.padding(8.dp))
        }
        origin?.let {
            Text(text = it, fontSize = 12.sp, modifier = Modifier.padding(8.dp))
        }
        desc?.let {
            Text(text = it, modifier = Modifier.padding(8.dp), textAlign = TextAlign.Justify)
        }
    }

}






