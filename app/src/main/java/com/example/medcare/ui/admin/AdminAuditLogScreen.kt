package com.example.medcare.ui.admin

import androidx.compose.foundation.BorderStroke
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
fun AdminAuditLogScreen() {
    var searchQuery by remember { mutableStateOf("") }
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
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF006194)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.Person, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Ambient Banner Header
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("GIÁM SÁT NHẬT KÝ HỆ THỐNG & EMR AUDIT LOG", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006194))
                    Surface(
                        color = Color(0xFF86F2E4),
                        shape = RoundedCornerShape(99.dp)
                    ) {
                        Row(modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            Box(modifier = Modifier.size(6.dp).clip(CircleShape).background(Color(0xFF006A61)))
                            Text("Live Stream 100%", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006F66))
                        }
                    }
                }
                Text("Truy vết Pháp lý & An toàn Bệnh án", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
            }

            // Compliance Banner: Immutable WORM Audit
            Surface(
                color = Color(0xFFF2F3FF),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFFCCE5FF)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.Verified, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(16.dp))
                    }
                    Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Text("Quy chuẩn HIPAA & Bộ Y Tế", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006194))
                            Surface(
                                color = Color(0xFFE2E7FF),
                                shape = RoundedCornerShape(4.dp)
                            ) {
                                Text("Immutable Log", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3F4850), modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                            }
                        }
                        Text("Hệ thống tự động ghi vết bất biến (Immutable Audit Trail) toàn bộ thao tác xem, sửa, in, xuất dữ liệu hồ sơ bệnh án theo tiêu chuẩn HIPAA & Bộ Y Tế. Dữ liệu được ký số chống chối bỏ.", fontSize = 13.sp, color = Color(0xFF3F4850))
                    }
                }
            }

            // Quick Stats Metrics
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                AuditMetricCard(title = "1,842", label = "Đọc EMR", trend = "↑ +12% hôm nay", modifier = Modifier.weight(1f))
                AuditMetricCard(title = "428", label = "Cập nhật tiến trình", trend = "Đã ký số", modifier = Modifier.weight(1f))
                AuditMetricCard(title = "0", label = "Xâm nhập lạ", trend = "Tuyệt đối an toàn", isSecure = true, modifier = Modifier.weight(1f))
            }

            // Export Audit Log File Button
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E7FF)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Default.FileDownload, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Xuất file kiểm toán ký số (PDF / CSV)", color = Color(0xFF006194), fontWeight = FontWeight.Bold, fontSize = 13.sp)
            }

            // Search Bar & Realtime Timeline
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Tìm theo Mã BN, IP, Tên cán bộ y tế...", fontSize = 14.sp, color = Color(0xFF707881)) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color(0xFF707881)) },
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color(0xFF006194)
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Nhật Ký Thời Gian Thực", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
                Text("5 bản ghi mới nhất", fontSize = 11.sp, color = Color(0xFF3F4850))
            }

            // Audit Log Items
            AuditLogCard(
                action = "XEM BỆNH ÁN EMR",
                time = "09:34:12",
                user = "BS. Nguyễn Văn Quang (NV-DOC-0102)",
                details = "Truy cập hồ sơ bệnh án BN Trần Văn An (Mã: BN-2024-089). Thao tác: Mở xem lịch sử khám và kết quả phim X-quang lồng ngực kỹ thuật số.",
                ipInfo = "IP: 192.168.1.104 (Máy trạm Phòng 204)",
                hash = "#SHA256-8a7f9c"
            )

            AuditLogCard(
                action = "KÊ ĐƠN THUỐC",
                time = "09:28:45",
                user = "BS. Nguyễn Văn Quang (NV-DOC-0102)",
                details = "Đã hoàn tất ký số đơn thuốc điện tử #DT-2024-88942 cho BN Trần Văn An.",
                warning = "Cảnh báo tương tác Amoxicillin: Đã được bác sĩ ghi nhận và xác nhận xử lý thay thế sang nhóm Macrolide an toàn.",
                signature = "Ký số SmartCA v4: Hợp lệ • Chữ ký #E889-12"
            )

            AuditLogCard(
                action = "CẢNH BÁO BẢO MẬT",
                time = "08:42:19",
                user = "Tài khoản Kế toán (NV-ACC-0034)",
                details = "Phát hiện 2 lần nhập sai mã OTP 2FA liên tiếp từ tài khoản Viện phí. Địa chỉ IP: 14.161.42.18 (Phát hiện ngoài dải VPN bệnh viện).",
                alertNote = "Biện pháp ngăn chặn tự động: Khóa đăng nhập tạm 15 phút, Push notification khẩn và SMS cảnh báo đã được gửi tới Super Admin.",
                isCritical = true
            )
        }
    }
}

@Composable
fun AuditMetricCard(title: String, label: String, trend: String, isSecure: Boolean = false, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(label, fontSize = 11.sp, color = Color(0xFF3F4850))
            Text(title, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = if (isSecure) Color(0xFF006A61) else Color(0xFF006194))
            Text(trend, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = if (isSecure) Color(0xFF006A61) else Color(0xFF006194))
        }
    }
}

@Composable
fun AuditLogCard(
    action: String,
    time: String,
    user: String,
    details: String,
    ipInfo: String? = null,
    hash: String? = null,
    warning: String? = null,
    signature: String? = null,
    alertNote: String? = null,
    isCritical: Boolean = false
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        border = if (isCritical) BorderStroke(1.dp, Color(0xFFBA1A1A)) else null,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = if (isCritical) Color(0xFFFFDAD6) else Color(0xFFE2E7FF),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(action, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = if (isCritical) Color(0xFFBA1A1A) else Color(0xFF006194), modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                }
                Text(time, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3F4850))
            }

            Text(user, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
            Text(details, fontSize = 13.sp, color = Color(0xFF3F4850))

            if (warning != null) {
                Surface(
                    color = Color(0xFFFFE0B2),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(warning, fontSize = 12.sp, color = Color(0xFF825100), fontWeight = FontWeight.Medium, modifier = Modifier.padding(8.dp))
                }
            }

            if (alertNote != null) {
                Surface(
                    color = Color(0xFFFFDAD6),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(alertNote, fontSize = 12.sp, color = Color(0xFF93000A), fontWeight = FontWeight.Medium, modifier = Modifier.padding(8.dp))
                }
            }

            if (ipInfo != null && hash != null) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(ipInfo, fontSize = 11.sp, color = Color(0xFF707881))
                    Text(hash, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006194))
                }
            }

            if (signature != null) {
                Text(signature, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006A61))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AdminAuditLogScreenPreview() {
    AdminAuditLogScreen()
}

