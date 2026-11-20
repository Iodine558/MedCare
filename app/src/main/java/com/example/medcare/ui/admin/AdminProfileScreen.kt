package com.example.medcare.ui.admin

import androidx.compose.foundation.background
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
import com.example.medcare.ui.patient.ProfileMenuItem

@Composable
fun AdminProfileScreen(
    onProfileClick: () -> Unit = {},
    onLogout: () -> Unit = {}
) {
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
                    Icon(Icons.Default.AdminPanelSettings, contentDescription = null, tint = Color.White)
                }
                Column {
                    Text("MedCare", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0xFF006194))
                    Text("QUẢN TRỊ / Super Admin", fontWeight = FontWeight.Medium, fontSize = 11.sp, color = Color(0xFF3F4850))
                }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { }) {
                    Icon(Icons.Default.Notifications, contentDescription = "Thông báo", tint = Color(0xFFBA1A1A))
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
                Text("Hồ sơ quản trị", fontSize = 24.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                Text("Quản lý tài khoản Super Admin và cấu hình hệ thống", fontSize = 13.sp, color = Color(0xFF3F4850))
            }

            // Admin Profile Card
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
                            Text("Le Hoang Nam", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                            Text("Super Admin System Controller • Mã ADM: ADM-2024-0001", fontSize = 11.sp, fontWeight = FontWeight.Medium, color = Color(0xFF006194))
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
                        Text("Chỉnh sửa thông tin quản trị", color = Color(0xFF006194), fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                    }
                }
            }

            // Admin Authority Card
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Thẩm quyền hệ thống", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))

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
                            Text("THẺ THẨM QUYỀN HỆ THỐNG MEDCARE", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                            Icon(Icons.Default.Security, contentDescription = null, tint = Color.White)
                        }

                        Column {
                            Text("Le Hoang Nam", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                            Text("Quyền hạn: Root Level 1 • Full System Control", color = Color(0xFFCCE5FF), fontSize = 12.sp, fontWeight = FontWeight.Medium)
                        }

                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(Icons.Default.QrCode, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Xem mã QR xác thực Admin", color = Color(0xFF006194), fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                        }
                    }
                }

                // System Control Items
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        ProfileMenuItem(icon = Icons.Default.ManageAccounts, title = "Phân quyền & Vai trò (RBAC)", subtitle = "Cấu hình quyền truy cập hệ thống")
                        HorizontalDivider(color = Color(0xFFF2F3FF))
                        ProfileMenuItem(icon = Icons.Default.HistoryEdu, title = "Nhật ký hệ thống & Audit Trail", subtitle = "Kiểm tra log truy cập & thao tác")
                    }
                }
            }

            // Security & Infrastructure Settings
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Bảo mật & Hạ tầng", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        ProfileMenuItem(icon = Icons.Default.VpnKey, title = "Xác thực 2 lớp (2FA Admin)", subtitle = "Quản lý mã OTP & Token", iconBg = Color(0xFFEAEDFF), iconTint = Color(0xFF006194))
                        HorizontalDivider(color = Color(0xFFF2F3FF))
                        ProfileMenuItem(icon = Icons.Default.Dns, title = "Cấu hình Server & Database", iconBg = Color(0xFFEAEDFF), iconTint = Color(0xFF006194))
                        HorizontalDivider(color = Color(0xFFF2F3FF))
                        ProfileMenuItem(icon = Icons.Default.Key, title = "Mật khẩu & Khóa API", iconBg = Color(0xFFEAEDFF), iconTint = Color(0xFF006194))
                    }
                }
            }

            // Technical Support & Documentation
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Hỗ trợ kỹ thuật", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        ProfileMenuItem(icon = Icons.Default.Description, title = "Tài liệu kỹ thuật Hệ thống", iconBg = Color(0xFFEAEDFF), iconTint = Color(0xFF006194))
                        HorizontalDivider(color = Color(0xFFF2F3FF))
                        ProfileMenuItem(icon = Icons.Default.HeadsetMic, title = "Hỗ trợ sự cố khẩn cấp (Hotline 24/7)", iconBg = Color(0xFFEAEDFF), iconTint = Color(0xFF006194))
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
                    "MedCare • Control Center Super Admin",
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
                Text("Bạn có chắc chắn muốn đăng xuất khỏi tài khoản Quản trị viên?")
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

@Preview(showBackground = true)
@Composable
fun AdminProfileScreenPreview() {
    AdminProfileScreen()
}
