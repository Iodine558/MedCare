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
fun DoctorExamScreen() {
    var selectedTab by remember { mutableStateOf(0) } // 0: Lịch sử khám, 1: Dịch vụ, 2: Đơn thuốc, 3: Tóm tắt bệnh án
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
                    Text("Khám Bệnh", fontWeight = FontWeight.Bold, fontSize = 11.sp, color = Color(0xFF3F4850))
                }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { }) {
                    Icon(Icons.Default.NotificationsActive, contentDescription = "Thông báo khẩn cấp", tint = Color(0xFFBA1A1A))
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
            // Allergy Alert Banner
            Surface(
                color = Color(0xFFFFDAD6),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFBA1A1A)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.Warning, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text("LƯU Ý HỒ SƠ • Đã ghi nhận", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFBA1A1A))
                        Text("Có thông tin dị ứng", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF93000A))
                        Text("Xem thông tin dị ứng trong hồ sơ trước khi kê đơn.", fontSize = 13.sp, color = Color(0xFF93000A).copy(alpha = 0.9f))
                    }
                }
            }

            // Patient Master Profile Card
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
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(56.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFFEAEDFF)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(Icons.Default.Person, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(32.dp))
                            }
                            Column {
                                Row(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
                                    Text("Trần Văn An", fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                                    Text("54T · Nam", fontSize = 13.sp, color = Color(0xFF3F4850))
                                }
                                Text("PID: BN-2024-0891", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF006194))
                                Text("BHYT: GD-4-79-02-8821", fontSize = 12.sp, color = Color(0xFF3F4850))
                            }
                        }
                    }

                    // Vital signs grid ( Thông tin đo )
                    Surface(
                        color = Color(0xFFF2F3FF),
                        shape = RoundedCornerShape(8.dp),
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
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text("THÔNG TIN ĐO (09:15)", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3F4850))
                                Text("Đã cập nhật", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006A61))
                            }
                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                VitalMiniCard(title = "Huyết áp", value = "135/85", unit = "mmHg", modifier = Modifier.weight(1f))
                                VitalMiniCard(title = "Nhịp tim", value = "78", unit = "bpm", status = "Đã cập nhật", modifier = Modifier.weight(1f))
                            }
                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                VitalMiniCard(title = "SpO2", value = "98", unit = "%", status = "Đã cập nhật", modifier = Modifier.weight(1f))
                                VitalMiniCard(title = "Nhiệt độ", value = "36.8", unit = "°C", status = "Đã cập nhật", modifier = Modifier.weight(1f))
                            }
                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                VitalMiniCard(title = "BMI", value = "23.4", unit = "68kg / 170cm", modifier = Modifier.weight(1f))
                                VitalMiniCard(title = "Nhịp thở", value = "18", unit = "l/ph", status = "Đã cập nhật", modifier = Modifier.weight(1f))
                            }
                        }
                    }

                    // Current Visit Info (Đợt khám hiện tại)
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFE2E7FF)),
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
                                Text("Đợt khám hiện tại", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
                                Surface(
                                    color = Color(0xFF006194),
                                    shape = RoundedCornerShape(99.dp)
                                ) {
                                    Text("Phòng 204 • Khám Nội", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
                                }
                            }
                            Text("09:30, 18/10/2024 • BS. CKI Nguyễn Văn Quang", fontSize = 12.sp, color = Color(0xFF3F4850))

                            Text("LÝ DO ĐẾN KHÁM", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF707881))
                            Text("Ho khan kéo dài 1 tuần, kèm sốt nhẹ.", fontSize = 13.sp, color = Color(0xFF131B2E))

                            Text("GHI CHÚ ĐỢT KHÁM", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF707881))
                            Text("Bác sĩ đang cập nhật nội dung khám.", fontSize = 13.sp, fontWeight = FontWeight.Medium, color = Color(0xFF006194))
                        }
                    }
                }
            }

            // Sub-tabs: Lịch sử khám, Dịch vụ, Đơn thuốc, Tóm tắt bệnh án
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                DoctorSubTab(title = "Lịch sử khám", selected = selectedTab == 0, onClick = { selectedTab = 0 })
                DoctorSubTab(title = "Dịch vụ (2)", selected = selectedTab == 1, onClick = { selectedTab = 1 })
                DoctorSubTab(title = "Đơn thuốc", selected = selectedTab == 2, onClick = { selectedTab = 2 })
                DoctorSubTab(title = "Tóm tắt bệnh án", selected = selectedTab == 3, onClick = { selectedTab = 3 })
            }

            // Timeline history section
            Text("Lịch sử khám bệnh", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))

            TimelineItem(
                date = "Hôm nay • 18/10/2024 (09:30)",
                status = "Đang thực hiện dịch vụ",
                title = "Khám Nội Tổng Quát - Bệnh viện Đa khoa MedCare",
                doctor = "BS. CKI Nguyễn Văn Quang • Phòng 204",
                services = listOf("X-Quang Ngực (Chờ chụp)", "Xét nghiệm máu (Đã lấy máu)")
            )

            TimelineItem(
                date = "12/06/2024 (4 tháng trước)",
                status = "Hoàn thành",
                title = "Khám Chuyên khoa Tim Mạch & Huyết áp",
                doctor = "BS. Trần Minh Châu • Mã hồ sơ: DT-2024-4410",
                note = "Đã lưu nội dung khám và đơn thuốc. Xem hồ sơ để biết chi tiết."
            )

            // Quick Actions Hub
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
                    Text("Thao tác nhanh", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                    Text("Phiên làm việc BS. Quang", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006A61))

                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEAEDFF)),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.EditNote, contentDescription = null, tint = Color(0xFF131B2E), modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("+ Cập nhật ghi chú khám", color = Color(0xFF131B2E), fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                    }

                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006194)),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.ReceiptLong, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Kê đơn & Chỉ định xét nghiệm", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                    }

                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF86F2E4)),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Kết thúc đợt khám", color = Color(0xFF006F66), fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        }
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E7FF)),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Chuyển viện", color = Color(0xFF3F4850), fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun VitalMiniCard(title: String, value: String, unit: String, status: String? = null, modifier: Modifier = Modifier) {
    Surface(
        color = Color.White,
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(title, fontSize = 11.sp, color = Color(0xFF3F4850))
            Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(value, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006194))
                Text(unit, fontSize = 11.sp, color = Color(0xFF3F4850), modifier = Modifier.padding(bottom = 2.dp))
            }
            if (status != null) {
                Text(status, fontSize = 10.sp, color = Color(0xFF006A61), fontWeight = FontWeight.Medium)
            }
        }
    }
}

@Composable
fun DoctorSubTab(title: String, selected: Boolean, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        color = if (selected) Color(0xFF006194) else Color(0xFFEAEDFF),
        shape = RoundedCornerShape(99.dp)
    ) {
        Text(
            title,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = if (selected) Color.White else Color(0xFF006194),
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
        )
    }
}

@Composable
fun TimelineItem(date: String, status: String, title: String, doctor: String, services: List<String>? = null, note: String? = null) {
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
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(date, fontSize = 11.sp, color = Color(0xFF3F4850), fontWeight = FontWeight.Medium)
                Surface(
                    color = Color(0xFFEAEDFF),
                    shape = RoundedCornerShape(99.dp)
                ) {
                    Text(status, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E), modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
                }
            }

            Text(title, fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
            Text(doctor, fontSize = 13.sp, color = Color(0xFF3F4850))

            if (services != null) {
                Surface(
                    color = Color(0xFFF2F3FF),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(8.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text("DỊCH VỤ ĐƯỢC YÊU CẦU:", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3F4850))
                        services.forEach { service ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(service.substringBefore("(").trim(), fontSize = 12.sp, color = Color(0xFF131B2E))
                                Surface(
                                    color = Color(0xFFE2E7FF),
                                    shape = RoundedCornerShape(4.dp)
                                ) {
                                    Text(service.substringAfter("(").substringBefore(")"), fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006194), modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                                }
                            }
                        }
                    }
                }
            }

            if (note != null) {
                Surface(
                    color = Color(0xFFF2F3FF),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(note, fontSize = 13.sp, color = Color(0xFF3F4850), modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DoctorExamScreenPreview() {
    DoctorExamScreen()
}

