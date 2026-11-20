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

@Composable
fun AdminSecurityScreen(
    onProfileClick: () -> Unit = {}
) {
    var enforce2FA by remember { mutableStateOf(true) }
    var autoLock by remember { mutableStateOf(true) }
    var ipWhitelisting by remember { mutableStateOf(true) }

    val scrollState = rememberScrollState()

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
                        .size(40.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF006194)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.AdminPanelSettings, contentDescription = null, tint = Color.White)
                }
                Column {
                    Text("MedCare", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0xFF006194))
                    Text("Quản Trị / Super Admin", fontWeight = FontWeight.Medium, fontSize = 11.sp, color = Color(0xFF3F4850))
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
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Icon(Icons.Default.Security, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(18.dp))
                    Text("TRUNG TÂM AN NINH & SAO LƯU DỮ LIỆU", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006194))
                }
                Surface(
                    color = Color(0xFF86F2E4),
                    shape = RoundedCornerShape(99.dp)
                ) {
                    Text("Trực tuyến", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006F66), modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
                }
            }

            // Security Status Card
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFEAEDFF)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("TRẠNG THÁI AN NINH TOÀN VIỆN", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006A61))
                        Text("HỆ THỐNG BẢO MẬT TỐI ƯU", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                        Text("Không phát hiện lỗ hổng EMR nghiêm trọng", fontSize = 13.sp, color = Color(0xFF3F4850))
                    }
                    Surface(
                        color = Color.White,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(verticalAlignment = Alignment.Bottom) {
                                Text("99", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006194))
                                Text("/100", fontSize = 14.sp, color = Color(0xFF707881))
                            }
                            Text("An toàn tuyệt đối", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006A61))
                        }
                    }
                }
            }

            // Encryption Standards & Infrastructure
            Text("Tiêu chuẩn Mã hóa & Hạ tầng", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))

            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color(0xFFCCE5FF)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(Icons.Default.Lock, contentDescription = null, tint = Color(0xFF006194))
                            }
                            Column {
                                Text("Mã hóa Dữ liệu Y tế Quốc gia", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
                                Text("AES-256 (At-Rest) & TLS 1.3 (In-Transit). Khóa quản lý HSM cấp độ 3.", fontSize = 12.sp, color = Color(0xFF3F4850))
                            }
                        }
                    }
                    Text("🔐 Chứng chỉ bảo mật còn hạn: 340 ngày", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006A61))
                }
            }

            // Auto Backup & Disaster Recovery
            Text("Sao lưu Tự động & Dự phòng Thảm họa", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))

            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text("BẢN SAO LƯU GẦN NHẤT", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF707881))
                            Text("03:00 Sáng nay", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
                            Text("Ngày 18/10/2024 • Thành công 100%", fontSize = 12.sp, color = Color(0xFF3F4850))
                        }
                        Surface(
                            color = Color(0xFF86F2E4),
                            shape = RoundedCornerShape(99.dp)
                        ) {
                            Text("48.6 GB", color = Color(0xFF006F66), fontSize = 11.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
                        }
                    }

                    Surface(
                        color = Color(0xFFF2F3FF),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                Text("Primary Storage:", fontSize = 12.sp, color = Color(0xFF3F4850))
                                Text("Local On-Premise SAN", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
                            }
                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                Text("Secondary Mirror:", fontSize = 12.sp, color = Color(0xFF3F4850))
                                Text("AWS GovCloud (Encrypted)", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
                            }
                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                Text("Chu kỳ định kỳ:", fontSize = 12.sp, color = Color(0xFF3F4850))
                                Text("Daily 03:00 (Incr) • CN (Full)", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
                            }
                        }
                    }

                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006194)),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(Icons.Default.CloudUpload, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Sao lưu ngay", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        }
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E7FF)),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Khôi phục thử nghiệm", color = Color(0xFF006194), fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        }
                    }
                }
            }

            // Security Policy & Switches
            Text("Cấu hình An ninh & Chính sách Tài khoản", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))

            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    SecurityToggleRow(
                        title = "Bắt buộc xác thực 2 bước (2FA)",
                        subtitle = "Áp dụng 100% tài khoản bác sĩ, y tá & quản trị",
                        checked = enforce2FA,
                        onCheckedChange = { enforce2FA = it }
                    )
                    HorizontalDivider(color = Color(0xFFE2E7FF))
                    SecurityToggleRow(
                        title = "Tự động khóa phiên làm việc",
                        subtitle = "Tự động đăng xuất sau 15 phút không thao tác",
                        checked = autoLock,
                        onCheckedChange = { autoLock = it }
                    )
                    HorizontalDivider(color = Color(0xFFE2E7FF))
                    SecurityToggleRow(
                        title = "Giới hạn IP nội bộ (Whitelisting)",
                        subtitle = "Chỉ cho phép truy cập module EMR từ mạng bệnh viện",
                        checked = ipWhitelisting,
                        onCheckedChange = { ipWhitelisting = it }
                    )
                }
            }
        }
    }
}

@Composable
fun SecurityToggleRow(title: String, subtitle: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(title, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
            Text(subtitle, fontSize = 12.sp, color = Color(0xFF3F4850))
        }
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
}

@Preview(showBackground = true)
@Composable
fun AdminSecurityScreenPreview() {
    AdminSecurityScreen()
}

