package com.example.medcare.ui.doctor

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DoctorApp() {
    var selectedTab by remember { mutableStateOf(0) } // 0: Hồ sơ BN, 1: Khám bệnh, 2: Kê đơn & CLS, 3: Báo cáo & Lịch

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFFFAFAFF),
                tonalElevation = 8.dp
            ) {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = { Icon(Icons.Default.FolderShared, contentDescription = "Hồ sơ BN") },
                    label = { Text("Hồ sơ BN") }
                )
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = { Icon(Icons.Default.LocalHospital, contentDescription = "Khám bệnh") },
                    label = { Text("Khám bệnh") }
                )
                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    icon = { Icon(Icons.Default.ReceiptLong, contentDescription = "Kê đơn") },
                    label = { Text("Kê đơn") }
                )
                NavigationBarItem(
                    selected = selectedTab == 3,
                    onClick = { selectedTab = 3 },
                    icon = { Icon(Icons.Default.BarChart, contentDescription = "Báo cáo & Lịch") },
                    label = { Text("Báo cáo & Lịch") }
                )
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedTab) {
                0 -> DoctorPatientRecordsScreen()
                1 -> DoctorExamScreen()
                2 -> DoctorPrescriptionScreen()
                3 -> DoctorReportsScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DoctorAppPreview() {
    DoctorApp()
}

