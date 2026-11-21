package com.example.medcare.ui.patient

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medcare.ui.theme.MedCareTheme

@Composable
fun PatientProfileScreen(
    onProfileClick: () -> Unit = {},
    onLogout: () -> Unit = {},
    onHelpClick: (() -> Unit)? = null
) {
    var showInternalHelp by remember { mutableStateOf(false) }
    val handleHelpClick = onHelpClick ?: { showInternalHelp = true }

    if (showInternalHelp) {
        PatientHelpScreen(onBack = { showInternalHelp = false })
        return
    }

    val scrollState = rememberScrollState()
    var showLogoutDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF8FF))
            .verticalScroll(scrollState)
            .padding(bottom = 24.dp)
    ) {
        // Top App Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFF006194)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.LocalHospital, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
                }
                Column {
                    Text("MedCare", fontWeight = FontWeight.SemiBold, fontSize = 18.sp, color = Color(0xFF006194))
                    Text("BỆNH NHÂN", fontWeight = FontWeight.Bold, fontSize = 11.sp, color = Color(0xFF3F4850))
                }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { }) {
                    Box {
                        Icon(Icons.Default.Notifications, contentDescription = "Thông báo", tint = Color(0xFF3F4850))
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFBA1A1A))
                                .align(Alignment.TopEnd)
                        )
                    }
                }
                Surface(
                    onClick = onProfileClick,
                    shape = CircleShape,
                    color = Color(0xFF006194),
                    contentColor = Color.White,
                    modifier = Modifier.size(32.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Hồ sơ cá nhân",
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Page Title
            Column {
                Text("Cá nhân", fontSize = 24.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                Text("Quản lý tài khoản và thông tin sức khỏe", fontSize = 13.sp, color = Color(0xFF3F4850))
            }

            // Patient Profile Card
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFE2E2EC)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(32.dp), tint = Color(0xFF006194))
                        }
                        Column {
                            Text("Trần Văn An", fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                            Text("Mã BN: BN-2024-0891", fontSize = 11.sp, fontWeight = FontWeight.Medium, color = Color(0xFF006194))
                        }
                    }

                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEAEDFF)),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.Edit, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Chỉnh sửa thông tin cá nhân", color = Color(0xFF006194), fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                    }
                }
            }

            // Health Documents & Cards
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Hồ sơ & thẻ y tế", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))

                // Digital Patient Card
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF006194)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("THẺ KHÁM CHỮA BỆNH", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                            Icon(Icons.Default.CreditCard, contentDescription = null, tint = Color.White)
                        }

                        Column {
                            Text("Trần Văn An", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                            Text("BN-2024-0891", color = Color(0xFFCCE5FF), fontSize = 12.sp, fontWeight = FontWeight.Medium)
                        }

                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(Icons.Default.QrCode, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Xem mã QR thẻ KCB", color = Color(0xFF006194), fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                        }
                    }
                }

                // Linked Records List
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        ProfileMenuItem(icon = Icons.Default.HealthAndSafety, title = "Bảo hiểm y tế", subtitle = "Quản lý thông tin bảo hiểm")
                        HorizontalDivider(color = Color(0xFFF2F3FF))
                        ProfileMenuItem(icon = Icons.Default.FamilyRestroom, title = "Hồ sơ người thân", subtitle = "Thêm và quản lý người thân")
                    }
                }
            }

            // Account Settings
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Cài đặt tài khoản", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        ProfileMenuItem(icon = Icons.Default.NotificationsActive, title = "Thông báo & nhắc nhở")
                        HorizontalDivider(color = Color(0xFFF2F3FF))
                        ProfileMenuItem(icon = Icons.Default.Lock, title = "Mật khẩu & bảo mật", iconBg = Color(0xFFEAEDFF), iconTint = Color(0xFF006194))
                        HorizontalDivider(color = Color(0xFFF2F3FF))
                        ProfileMenuItem(icon = Icons.Default.Language, title = "Ngôn ngữ", subtitle = "Tiếng Việt", iconBg = Color(0xFFEAEDFF), iconTint = Color(0xFF006194))
                    }
                }
            }

            // Help & Info
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Hỗ trợ & thông tin", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        ProfileMenuItem(
                            icon = Icons.Default.Help,
                            title = "Hướng dẫn sử dụng & Trợ giúp",
                            subtitle = "Quy trình khám, tra cứu CLS & hỏi đáp",
                            iconBg = Color(0xFFEAEDFF),
                            iconTint = Color(0xFF006194),
                            onClick = handleHelpClick
                        )
                        HorizontalDivider(color = Color(0xFFF2F3FF))
                        ProfileMenuItem(icon = Icons.Default.SupportAgent, title = "Liên hệ hỗ trợ", iconBg = Color(0xFFEAEDFF), iconTint = Color(0xFF006194))
                        HorizontalDivider(color = Color(0xFFF2F3FF))
                        ProfileMenuItem(icon = Icons.Default.PrivacyTip, title = "Điều khoản & quyền riêng tư", iconBg = Color(0xFFEAEDFF), iconTint = Color(0xFF006194))
                    }
                }
            }

            // Sign out
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Button(
                    onClick = { showLogoutDialog = true },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Đăng xuất", color = Color(0xFFBA1A1A), fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                }
                Text(
                    "MedCare • Chăm sóc sức khỏe của bạn",
                    fontSize = 11.sp,
                    color = Color(0xFF3F4850),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }
        }
    }

    if (showLogoutDialog) {
        AlertDialog(
            onDismissRequest = { showLogoutDialog = false },
            title = {
                Text("Đăng xuất", fontWeight = FontWeight.Bold)
            },
            text = {
                Text("Bạn có chắc chắn muốn đăng xuất khỏi ứng dụng MedCare?")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showLogoutDialog = false
                        onLogout()
                    }
                ) {
                    Text("Đăng xuất", color = Color(0xFFBA1A1A), fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showLogoutDialog = false }
                ) {
                    Text("Hủy", color = Color(0xFF3F4850))
                }
            }
        )
    }
}

@Composable
fun ProfileMenuItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    subtitle: String? = null,
    iconBg: Color? = null,
    iconTint: Color = Color(0xFF3F4850),
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            if (iconBg != null) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(iconBg),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(icon, contentDescription = null, tint = iconTint, modifier = Modifier.size(18.dp))
                }
            } else {
                Icon(icon, contentDescription = null, tint = iconTint, modifier = Modifier.size(40.dp))
            }
            Column {
                Text(title, fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color(0xFF131B2E))
                if (subtitle != null) {
                    Text(subtitle, fontSize = 12.sp, color = Color(0xFF3F4850))
                }
            }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp), verticalAlignment = Alignment.CenterVertically) {
            if (subtitle != null && title == "Ngôn ngữ") {
                Text(subtitle, fontSize = 12.sp, color = Color(0xFF3F4850))
            }
            Text("›", fontSize = 24.sp, color = Color(0xFF3F4850))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PatientProfileScreenPreview() {
    MedCareTheme {
        PatientProfileScreen()
    }
}

