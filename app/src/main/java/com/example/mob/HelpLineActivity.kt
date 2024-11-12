package com.example.mob

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.mob.R

class HelpLineActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelpLine() // Display the HelpLine Composable
        }
    }
}

@Composable
fun HelpLine() {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState) // Make content scrollable
    ) {
        // Full-width Image Section
        Image(
            painter = painterResource(id = R.drawable.uwe),
            contentDescription = "UWE Image",
            modifier = Modifier
                .fillMaxWidth() // Ensures the image spans the entire width
                .height(130.dp)

        )

        // Apply padding to the rest of the content
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp) // Padding applied to all other content except the image
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Section Card Composable
            @Composable
            fun SectionCard(title: String, content: @Composable () -> Unit) {
                Card(
                    shape = RoundedCornerShape(8.dp),
                    elevation = 4.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = title, fontSize = 18.sp, color = Color.Black)
                        Spacer(modifier = Modifier.height(8.dp))
                        content()
                    }
                }
            }

            // Contact Details Section
            SectionCard("Contact Details") {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.phone), // Using phone.png as the icon
                        contentDescription = "Phone Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Phone: +44 (0)800 028 3766", fontSize = 14.sp, color = Color.Gray)
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.email), // Using email.jpg as the icon
                        contentDescription = "Email Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Email: contact@uwe.ac.uk", fontSize = 14.sp, color = Color.Gray)
                }
            }

            // 24/7 Suicide Helpline Card
            SectionCard("24/7 Suicide Helpline") {
                Text(
                    text = "Call: 0800 123 4567",
                    fontSize = 14.sp,
                    color = Color.Red,
                    modifier = Modifier.clickable {
                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:08001234567"))
                        context.startActivity(intent)
                    }
                )
            }

            // 24/7 Mental Health Helpline Card
            SectionCard("24/7 Mental Health Helpline") {
                Text(
                    text = "Call: 0800 765 4321",
                    fontSize = 14.sp,
                    color = Color.Blue,
                    modifier = Modifier.clickable {
                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:08007654321"))
                        context.startActivity(intent)
                    }
                )
            }

            Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(vertical = 8.dp))

            // Other sections (Opening Hours, Location, Web Resources, etc.)
            SectionCard("Opening Hours") {
                Text(text = "Monday to Friday: 8 AM - 8 PM", fontSize = 14.sp, color = Color.Gray)
                Text(text = "Saturday: 10 AM - 4 PM", fontSize = 14.sp, color = Color.Gray)
            }

            SectionCard("Location") {
                Text(text = "UWE Campus, Room 101", fontSize = 14.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Get Directions",
                    fontSize = 14.sp,
                    color = Color.Blue,
                    modifier = Modifier.clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=UWE+Campus+Room+101"))
                        context.startActivity(intent)
                    }
                )
            }

            SectionCard("Web Resources") {
                Text(
                    text = "Visit our website",
                    fontSize = 14.sp,
                    color = Color.Blue,
                    modifier = Modifier.clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uwe.ac.uk"))
                        context.startActivity(intent)
                    }
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Student Support Services",
                    fontSize = 14.sp,
                    color = Color.Blue,
                    modifier = Modifier.clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uwe.ac.uk/student-support"))
                        context.startActivity(intent)
                    }
                )
            }

            SectionCard("Popular Topics") {
                Text(
                    text = "Managing Stress",
                    fontSize = 14.sp,
                    color = Color.Blue,
                    modifier = Modifier.clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uwe.ac.uk/stress-management"))
                        context.startActivity(intent)
                    }
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Exam Preparation Tips",
                    fontSize = 14.sp,
                    color = Color.Blue,
                    modifier = Modifier.clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uwe.ac.uk/exam-preparation"))
                        context.startActivity(intent)
                    }
                )
            }

            SectionCard("Emergency Resources") {
                Text(
                    text = "Emergency Hotline: 999",
                    fontSize = 14.sp,
                    color = Color.Red
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Nearest Hospital",
                    fontSize = 14.sp,
                    color = Color.Blue,
                    modifier = Modifier.clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=nearest+hospital"))
                        context.startActivity(intent)
                    }
                )
            }

            SectionCard("Feedback") {
                Text(
                    text = "Give Feedback",
                    fontSize = 14.sp,
                    color = Color.Blue,
                    modifier = Modifier.clickable {
                        val intent = Intent(Intent.ACTION_SENDTO).apply {
                            data = Uri.parse("mailto:feedback@uwe.ac.uk")
                            putExtra(Intent.EXTRA_SUBJECT, "Feedback on Support Services")
                        }
                        context.startActivity(intent)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHelpLine() {
    HelpLine()
}
