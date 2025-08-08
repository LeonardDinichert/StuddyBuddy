package com.studdybuddy.model

import java.util.UUID

data class IntroPage(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String,
    val systemImage: String
)

object IntroPagesModel {
    val pages = listOf(
        IntroPage(title = "Welcome", description = "Welcome to StuddyBuddy ! Here, you can learn more effectively and more easily. This app has been build with the lates psychlogy techniques and learniing methods to automate your learning.", systemImage = "star"),
        IntroPage(title = "Use AI", description = "With the AI we created, you will be able to chat with it in order to understant some subject better. The provided context makes it more awares of your goals, what you want to learn or even how you do it.", systemImage = "list.bullet.rectangle"),
        IntroPage(title = "Stay Focused", description = "With lots of features all aiming to help you stay focuses and remember thing in short ot long term, this app gives you all teh chances for success in your studies.", systemImage = "timer")
    )
}
