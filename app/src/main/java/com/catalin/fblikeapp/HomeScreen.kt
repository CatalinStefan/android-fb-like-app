package com.catalin.fblikeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.catalin.fblikeapp.data.Dessert
import com.catalin.fblikeapp.data.Fruit

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier) {
    val desserts = remember { mutableStateOf(Dessert.getAllDesserts()) }
    val fruits = remember { mutableStateOf(Fruit.getAllFruits()) }
    val pageSize = 5
    var currentPage = 0

    LazyColumn(modifier) {
        val dessertsSize = desserts.value.size
        while (dessertsSize > currentPage * pageSize) {

            val from = currentPage * pageSize
            var to = (currentPage + 1) * pageSize
            if (dessertsSize < to)
                to = dessertsSize
            val nextDesserts = desserts.value.subList(from, to)

            items(nextDesserts) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .background(Color.White)
                        .clickable { navController.navigate(Destination.Detail.createRoute(it.id)) }
                ) {
                    Text(
                        text = it.title,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(4.dp)
                    )
                    Text(text = it.desc, fontSize = 12.sp, modifier = Modifier.padding(4.dp))
                    Image(
                        painter = painterResource(id = it.resId),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                }
            }


            val fruitFrom = currentPage * pageSize
            var fruitTo = (currentPage + 1) * pageSize
            if (fruits.value.size < fruitTo)
                fruitTo = fruits.value.size
            val nextFruits = fruits.value.subList(fruitFrom, fruitTo)

            item {
                LazyRow(
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .height(250.dp)
                ) {
                    items(nextFruits) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(150.dp)
                                .padding(4.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .clickable { navController.navigate(Destination.Detail.createRoute(it.id)) }
                        ) {
                            Image(
                                painter = painterResource(id = it.resId),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.FillHeight
                            )
                            Text(
                                text = it.name,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(8.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(Color(0xaaffffff))
                                    .padding(4.dp)
                            )
                        }
                    }
                }
            }

            currentPage++
        }
    }
}









