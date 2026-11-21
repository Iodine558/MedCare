package com.example.medcare.ui.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AdminApp(
    onLogout: () -> Unit = {}
) {
    var selectedTab by remember { mutableStateOf(0) } // 0: Tài khoản, 1: Audit Log, 2: Bảo mật, 3: Cá nhân

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFFFAFAFF),
                tonalElevation = 8.dp
            ) {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = { Icon(Icons.Default.ManageAccounts, contentDescription = "Tài khoản") },
                    label = {
                        Text(
                            text = "Tài khoản",
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
                    icon = { Icon(Icons.Default.HistoryEdu, contentDescription = "Audit Log") },
                    label = {
                        Text(
                            text = "Audit Log",
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
                    icon = { Icon(Icons.Default.Security, contentDescription = "Bảo mật") },
                    label = {
                        Text(
                            text = "Bảo mật",
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
                0 -> AdminAccountsScreen(onProfileClick = navigateToProfile)
                1 -> AdminAuditLogScreen(onProfileClick = navigateToProfile)
                2 -> AdminSecurityScreen(onProfileClick = navigateToProfile)
                3 -> AdminProfileScreen(onProfileClick = navigateToProfile, onLogout = onLogout)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AdminAppPreview() {
    AdminApp()
}

