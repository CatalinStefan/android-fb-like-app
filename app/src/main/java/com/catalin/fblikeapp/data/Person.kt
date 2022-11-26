package com.catalin.fblikeapp.data

import com.catalin.fblikeapp.R
import kotlin.random.Random

data class Person(
    val id: Int,
    val resId: Int,
    val name: String,
    val text: String
):ListItem() {
    companion object {
        private val people = listOf(
            Person(getUUID(), R.drawable.p1, "James", getMessage()),
            Person(getUUID(), R.drawable.p2, "Mary", getMessage()),
            Person(getUUID(), R.drawable.p3, "Robert", getMessage()),
            Person(getUUID(), R.drawable.p4, "John", getMessage()),
            Person(getUUID(), R.drawable.p5, "Michael", getMessage()),
            Person(getUUID(), R.drawable.p6, "Patricia", getMessage()),
            Person(getUUID(), R.drawable.p7, "Jennifer", getMessage()),
            Person(getUUID(), R.drawable.p8, "Linda", getMessage()),
            Person(getUUID(), R.drawable.p9, "Elisabeth", getMessage()),
            Person(getUUID(), R.drawable.p10, "David", getMessage()),
            Person(getUUID(), R.drawable.p11, "Barbara", getMessage()),
            Person(getUUID(), R.drawable.p12, "William", getMessage()),
            Person(getUUID(), R.drawable.p13, "Susan", getMessage()),
            Person(getUUID(), R.drawable.p14, "Richard", getMessage()),
            Person(getUUID(), R.drawable.p15, "Jessica", getMessage()),
            Person(getUUID(), R.drawable.p16, "Joseph", getMessage()),
            Person(getUUID(), R.drawable.p17, "Sarah", getMessage()),
            Person(getUUID(), R.drawable.p18, "Karen", getMessage()),
            Person(getUUID(), R.drawable.p19, "Thomas", getMessage()),
            Person(getUUID(), R.drawable.p20, "Lisa", getMessage()),
        )

        private fun getMessage() =
            when (Random.nextInt() % 5) {
                0 -> "added ${Random.nextInt(10)} photos."
                1 -> "commented on your photo."
                2 -> "likes a photo you shared."
                3 -> "has their birthday today."
                else -> "sent you a friend request."
            }

        fun getPeople() = people
    }
}