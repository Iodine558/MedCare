package com.example.medcare.ui.patient

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PatientApp(
    onLogout: () -> Unit = {}
) {
    var selectedTab by remember { mutableStateOf(0) } // 0: Home, 1: Lab, 2: Booking, 3: Profile

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFFFAFAFF),
                tonalElevation = 8.dp
            ) {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Trang chủ") },
                    label = {
                        Text(
                            text = "Trang chủ",
                            textAlign = TextAlign.Center,
                            fontSize = 11.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                )
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = { Icon(Icons.Default.Science, contentDescription = "Kết quả CLS") },
                    label = {
                        Text(
                            text = "Kết quả CLS",
                            textAlign = TextAlign.Center,
                            fontSize = 11.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                )
                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    icon = { Icon(Icons.Default.CalendarToday, contentDescription = "Đặt khám") },
                    label = {
                        Text(
                            text = "Đặt khám",
                            textAlign = TextAlign.Center,
                            fontSize = 11.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                )
                NavigationBarItem(
                    selected = selectedTab == 3,
                    onClick = { selectedTab = 3 },
                    icon = { Icon(Icons.Default.Person, contentDescription = "Cá nhân") },
                    label = {
                        Text(
                            text = "Cá nhân",
                            textAlign = TextAlign.Center,
                            fontSize = 11.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .statusBarsPadding()
        ) {
            val navigateToProfile = { selectedTab = 3 }
            when (selectedTab) {
                0 -> PatientHomeScreen(onProfileClick = navigateToProfile)
                1 -> LabResultsScreen(onProfileClick = navigateToProfile)
                2 -> BookingScreen(onProfileClick = navigateToProfile)
                3 -> PatientProfileScreen(onProfileClick = navigateToProfile, onLogout = onLogout)
            }

            // Floating AI Chatbox — always visible above all tabs
            AiChatBox(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 16.dp, bottom = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PatientAppPreview() {
    PatientApp()
}

