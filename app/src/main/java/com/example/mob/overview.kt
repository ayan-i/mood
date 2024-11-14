package com.example.mob

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.*
import java.text.SimpleDateFormat
import java.util.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class overviewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            overview()
        }
    }
}

@Composable
fun overview() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(color = Color.Black)
    systemUiController.setNavigationBarColor(colorResource(R.color.lightpurple))

    var showDialog by remember { mutableStateOf(false) }
    var currentScreen by remember { mutableStateOf("overview") }

    Box(
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxSize()
    ) {
        when (currentScreen) {
            "overview" -> {
                Text(
                    text = "Overview",
                    fontSize = 30.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 30.dp, start = 135.dp)
                )
            }
            "stressLevel" -> StressLevelScreen()
            "anxietyLevel" -> AnxietyLevelScreen()
        }

        // BottomNavigation
        BottomNavigation(
            backgroundColor = colorResource(R.color.lightpurple),
            contentColor = Color.Black,
            modifier = Modifier
                .padding(top = 790.dp)
                .fillMaxWidth()
                .height(100.dp)
        ) {
            BottomNavigationItem(
                selected = currentScreen == "overview",
                onClick = { currentScreen = "overview" },
                icon = {
                    Icon(
                        Icons.Default.ShowChart,
                        contentDescription = null,
                        modifier = Modifier.size(50.dp).padding(top = 10.dp)
                    )
                },
                label = { Text("Overview", fontWeight = FontWeight.SemiBold, fontSize = 13.sp) }
            )
            BottomNavigationItem(
                selected = currentScreen == "history",
                onClick = { /* Handle navigation */ },
                icon = {
                    Icon(
                        Icons.Filled.History,
                        contentDescription = null,
                        modifier = Modifier.size(50.dp).padding(top = 10.dp),
                    )
                },
                label = { Text("History", fontSize = 16.sp, fontWeight = FontWeight.Medium) }
            )
            BottomNavigationItem(
                selected = false,
                onClick = { showDialog = true },
                icon = {
                    Icon(
                        Icons.Filled.AddCircleOutline,
                        contentDescription = null,
                        modifier = Modifier.size(60.dp).padding(top = 10.dp)
                    )
                }
            )
            BottomNavigationItem(
                selected = currentScreen == "med",
                onClick = { /* Handle navigation */ },
                icon = {
                    Icon(
                        Icons.Filled.Medication,
                        contentDescription = null,
                        modifier = Modifier.size(50.dp).padding(top = 10.dp)
                    )
                },
                label = { Text("Med", fontSize = 16.sp) }
            )
            BottomNavigationItem(
                selected = currentScreen == "support",
                onClick = { /* Handle navigation */ },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = "Help",
                        modifier = Modifier.size(20.dp)
                    )
                },
                label = { Text("Support", fontSize = 11.sp) }
            )
        }

        // Show Dialog when the plus button is clicked
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Select Page") },
                text = {
                    Column {
                        Text(
                            "Stress Level",
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    currentScreen = "stressLevel"
                                    showDialog = false
                                }
                                .padding(8.dp)
                        )
                        Divider()
                        Text(
                            "Anxiety Level",
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    currentScreen = "anxietyLevel"
                                    showDialog = false
                                }
                                .padding(8.dp)
                        )
                    }
                },
                confirmButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}

@Composable
fun StressLevelScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Stress Level Page", color = Color.White, fontSize = 24.sp)
    }
}

@Composable
fun AnxietyLevelScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Anxiety Level Page", color = Color.White, fontSize = 24.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOverview() {
    overview()
}
