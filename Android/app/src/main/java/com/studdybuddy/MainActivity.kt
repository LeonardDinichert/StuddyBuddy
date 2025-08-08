package com.studdybuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.studdybuddy.ui.theme.StuddyBuddyTheme
import androidx.navigation.compose.rememberNavController
import com.studdybuddy.ui.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StuddyBuddyTheme {
                val navController = rememberNavController()
                Navigation(navController)
            }
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    StuddyBuddyTheme {
        Text("Hello StuddyBuddy")
    }
}
