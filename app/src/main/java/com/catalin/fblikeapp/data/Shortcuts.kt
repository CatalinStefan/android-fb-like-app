package com.catalin.fblikeapp.data

import androidx.compose.ui.graphics.Color
import com.catalin.fblikeapp.R

data class Shortcut(
    val id: Int,
    val title: String,
    val resId: Int,
    val tint: Color
) {
    companion object {
        private val shortcuts = listOf(
            Shortcut(0, "Marketplace", R.drawable.ic_marketplace, Color.Blue),
            Shortcut(1, "Memories", R.drawable.ic_time, Color.Blue),
            Shortcut(2, "Videos on Watch", R.drawable.ic_video, Color.Blue),
            Shortcut(3, "Feeds", R.drawable.ic_feed, Color.Blue),
            Shortcut(4, "Friends", R.drawable.ic_people, Color.Blue),
            Shortcut(5, "Groups", R.drawable.ic_group, Color.Blue),
            Shortcut(6, "Saved", R.drawable.ic_saved, Color(0xFF940EDB)),
            Shortcut(7, "Pages", R.drawable.ic_pages, Color.Red),
            Shortcut(8, "Reels", R.drawable.ic_reels, Color(0xFFFA3200)),
            Shortcut(9, "News", R.drawable.ic_news, Color.Blue),
            Shortcut(10, "Dating", R.drawable.ic_dating, Color.Red),
            Shortcut(11, "Event", R.drawable.ic_event, Color.Red),
            Shortcut(12, "Gaming", R.drawable.ic_game, Color.Blue),
            Shortcut(13, "Shop", R.drawable.ic_shop, Color.Blue)
        )
        fun getShortcuts() = shortcuts
    }
}
