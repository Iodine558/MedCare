package com.example.medcare.ui.doctor

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
fun DoctorReportsScreen(
    onProfileClick: () -> Unit = {}
) {
    var dateFilter by remember { mutableStateOf(0) } // 0: Ngày, 1: Tháng, 2: Quý
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
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text("MedCare", fontWeight = FontWeight.SemiBold, fontSize = 18.sp, color = Color(0xFF006194))
                        Surface(
                            color = Color(0xFF86F2E4),
                            shape = RoundedCornerShape(99.dp)
                        ) {
                            Text("Bác sĩ CKI", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006F66), modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                        }
                    }
                    Text("Báo Cáo & Lịch", fontWeight = FontWeight.Bold, fontSize = 11.sp, color = Color(0xFF3F4850))
                }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { }) {
                    Icon(Icons.Default.NotificationsActive, contentDescription = "Thông báo khẩn cấp", tint = Color(0xFFBA1A1A))
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
            // Top Operational Banner & Date Filter
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF006A61))
                    )
                    Text("HỆ THỐNG TRỰC BAN KHOA LÂM SÀNG", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006A61))
                }
                Surface(
                    color = Color(0xFFE2E7FF),
                    shape = RoundedCornerShape(99.dp)
                ) {
                    Text("Thứ Sáu, 18/10/2024", fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF3F4850), modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp))
                }
            }

            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        color = Color(0xFFEAEDFF),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Row(modifier = Modifier.padding(2.dp)) {
                            ReportDateChip(title = "Ngày", selected = dateFilter == 0, onClick = { dateFilter = 0 })
                            ReportDateChip(title = "Tháng", selected = dateFilter == 1, onClick = { dateFilter = 1 })
                            ReportDateChip(title = "Quý", selected = dateFilter == 2, onClick = { dateFilter = 2 })
                        }
                    }

                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E7FF)),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
                    ) {
                        Icon(Icons.Default.Download, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(14.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Xuất File", color = Color(0xFF006194), fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
                    }
                }
            }

            // Executive Metrics 2x2 Bento Grid
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    MetricCard(title = "Tổng khám", value = "248 BN", subtitle = "↑ +12% so hôm qua", icon = Icons.Default.Groups, modifier = Modifier.weight(1f))
                    MetricCard(title = "Chờ / Giường bệnh", value = "34 chờ / 68 g", subtitle = "Công suất 85%", icon = Icons.Default.LocalHospital, modifier = Modifier.weight(1f))
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    MetricCard(title = "Viện phí (24h)", value = "84.5 tr", subtitle = "BHYT chỉ 68% (57.4tr)", icon = Icons.Default.Payments, modifier = Modifier.weight(1f))
                    MetricCard(title = "Dịch tễ hàng đầu", value = "Cúm & Hô hấp", subtitle = "Tỷ trọng: 38% tổng ca", icon = Icons.Default.Coronavirus, modifier = Modifier.weight(1f))
                }
            }

            // Lịch hẹn & Ca trực (Schedule & Duty Roster)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Icon(Icons.Default.CalendarMonth, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(18.dp))
                    Text("Lịch hẹn & Ca trực", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                }
                TextButton(onClick = { }) {
                    Text("Xếp ca ›", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF006194))
                }
            }

            // Calendar days row
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    DutyDayItem(day = "T2", date = "14", selected = false)
                    DutyDayItem(day = "T3", date = "15", selected = false)
                    DutyDayItem(day = "T4", date = "16", selected = false)
                    DutyDayItem(day = "T5", date = "17", selected = false)
                    DutyDayItem(day = "T6", date = "18", selected = true)
                    DutyDayItem(day = "T7", date = "19", selected = false)
                    DutyDayItem(day = "CN", date = "20", selected = false, isSunday = true)
                }
            }

            // Duty shift cards
            DutyShiftCard(
                doctorName = "BS. CKI Nguyễn Văn Quang",
                department = "Phòng 204 • Nội hô hấp & Dị ứng",
                status = "Đang khám",
                time = "08:00 - 11:30",
                slotInfo = "18 / 20 slot (90%)",
                progress = 0.9f,
                avatarInitial = "Q"
            )
            DutyShiftCard(
                doctorName = "BS. Trần Minh Châu",
                department = "Phòng 208 • Khám Tim mạch & Huyết áp",
                status = "Ca chiều",
                time = "13:30 - 17:00",
                slotInfo = "12 / 20 slot (60%)",
                progress = 0.6f,
                avatarInitial = "C"
            )

            // Auto SMS / Zalo reminder toggle
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE2E7FF)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(Icons.Default.Notifications, contentDescription = null, tint = Color(0xFF006194))
                        Column {
                            Text("Hệ thống gửi SMS / Zalo nhắc hẹn trước 24h", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
                            Text("Đã gửi tự động thành công 46/46 bệnh nhân", fontSize = 11.sp, color = Color(0xFF3F4850))
                        }
                    }
                    Switch(checked = true, onCheckedChange = { })
                }
            }
        }
    }
}

@Composable
fun ReportDateChip(title: String, selected: Boolean, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        color = if (selected) Color(0xFF006194) else Color.Transparent,
        shape = RoundedCornerShape(6.dp)
    ) {
        Text(
            title,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = if (selected) Color.White else Color(0xFF3F4850),
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}

@Composable
fun MetricCard(title: String, value: String, subtitle: String, icon: androidx.compose.ui.graphics.vector.ImageVector, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = modifier
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
                Text(title, fontSize = 12.sp, color = Color(0xFF3F4850))
                Icon(icon, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(16.dp))
            }
            Text(value, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
            Text(subtitle, fontSize = 11.sp, fontWeight = FontWeight.Medium, color = if (subtitle.contains("↑") || subtitle.contains("85%")) Color(0xFF006A61) else Color(0xFFBA1A1A))
        }
    }
}

@Composable
fun DutyDayItem(day: String, date: String, selected: Boolean, isSunday: Boolean = false) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(day, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = if (isSunday) Color(0xFFBA1A1A) else Color(0xFF3F4850))
        Surface(
            color = if (selected) Color(0xFF006194) else Color.Transparent,
            shape = CircleShape,
            modifier = Modifier.size(32.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(date, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = if (selected) Color.White else if (isSunday) Color(0xFFBA1A1A) else Color(0xFF131B2E))
            }
        }
    }
}

@Composable
fun DutyShiftCard(
    doctorName: String,
    department: String,
    status: String,
    time: String,
    slotInfo: String,
    progress: Float,
    avatarInitial: String
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
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
                verticalAlignment = Alignment.Top
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFEAEDFF)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(avatarInitial, color = Color(0xFF006194), fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                    Column {
                        Text(doctorName, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
                        Text(department, fontSize = 12.sp, color = Color(0xFF3F4850))
                    }
                }
                Column(horizontalAlignment = Alignment.End) {
                    Surface(
                        color = if (status == "Đang khám") Color(0xFF86F2E4) else Color(0xFFE2E7FF),
                        shape = RoundedCornerShape(99.dp)
                    ) {
                        Text(status, color = if (status == "Đang khám") Color(0xFF006F66) else Color(0xFF3F4850), fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(time, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006194))
                }
            }

            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Tải khám trực tuyến", fontSize = 11.sp, color = Color(0xFF3F4850))
                    Text(slotInfo, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
                }
                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(RoundedCornerShape(3.dp)),
                    color = Color(0xFF006194),
                    trackColor = Color(0xFFF2F3FF)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DoctorReportsScreenPreview() {
    DoctorReportsScreen()
}

