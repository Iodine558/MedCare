package com.example.medcare.ui.patient

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
fun PatientHomeScreen(
    onProfileClick: () -> Unit = {}
) {
    var med1Checked by remember { mutableStateOf(false) }
    var med2Checked by remember { mutableStateOf(false) }

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
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Patient Welcome Card
            Card(
                onClick = onProfileClick,
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier.size(56.dp)) {
                            Box(
                                modifier = Modifier
                                    .size(56.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFFE2E2EC)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(32.dp), tint = Color(0xFF006194))
                            }
                            Box(
                                modifier = Modifier
                                    .size(14.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF006A61))
                                    .align(Alignment.BottomEnd)
                            )
                        }
                        Column {
                            Text("Xin chào,", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3F4850))
                            Text("Trần Văn An", fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                            Text("Mã BN: BN-2024-0891", fontSize = 11.sp, fontWeight = FontWeight.Medium, color = Color(0xFF006194))
                        }
                    }
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEAEDFF)),
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
                    ) {
                        Icon(Icons.Default.QrCode, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Thẻ KCB", color = Color(0xFF006194), fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
                    }
                }
            }

            // Upcoming Appointment Banner
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF006194)),
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
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            modifier = Modifier
                                .clip(RoundedCornerShape(99.dp))
                                .background(Color.White.copy(alpha = 0.15f))
                                .padding(horizontal = 10.dp, vertical = 4.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF89F5E7))
                            )
                            Text("Hôm nay • 14:30", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 11.sp)
                        }
                        Text("Phòng khám 204", color = Color.White.copy(alpha = 0.9f), fontSize = 12.sp, fontWeight = FontWeight.Medium)
                    }

                    Column {
                        Text("Tái khám Hô hấp", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Text("BS. CKI Nguyễn Văn Quang • Tầng 2, Nhà B", color = Color.White.copy(alpha = 0.85f), fontSize = 13.sp)
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(Icons.Default.Directions, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Chỉ đường đến phòng", color = Color(0xFF006194), fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                        }
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.2f)),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("Chi tiết", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                        }
                    }
                }
            }

            // Quick Utilities
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Tiện ích nhanh", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    QuickUtilityItem(icon = Icons.Default.Event, label = "Đặt lịch khám", color = Color(0xFF006194), bg = Color(0xFFEAEDFF))
                    QuickUtilityItem(icon = Icons.Default.Assignment, label = "Kết quả xét nghiệm", color = Color(0xFF006A61), bg = Color(0xFFE0F8F4))
                    QuickUtilityItem(icon = Icons.Default.Medication, label = "Đơn thuốc điện tử", color = Color(0xFF006194), bg = Color(0xFFEAEDFF))
                    QuickUtilityItem(icon = Icons.Default.VideoCall, label = "Tư vấn từ xa", color = Color(0xFF825100), bg = Color(0xFFFFF2D6))
                }
            }

            // Today's Medication Schedule
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
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Icon(Icons.Default.Medication, contentDescription = null, tint = Color(0xFF006194))
                            Text("Uống thuốc hôm nay", fontWeight = FontWeight.SemiBold, fontSize = 16.sp, color = Color(0xFF131B2E))
                        }
                        Surface(
                            color = Color(0xFFE0F8F4),
                            shape = RoundedCornerShape(99.dp)
                        ) {
                            Text(
                                "2 cử còn lại",
                                color = Color(0xFF006A61),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                    Text("Kê bởi BS. CKI Nguyễn Văn Quang", fontSize = 12.sp, color = Color(0xFF3F4850))

                    // Med 1
                    Surface(
                        color = Color(0xFFF2F3FF),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically) {
                                Surface(
                                    color = Color.White,
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Column(
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text("13:00", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Color(0xFF006194))
                                        Text("Trưa", fontSize = 10.sp, color = Color(0xFF3F4850))
                                    }
                                }
                                Column {
                                    Text("Azithromycin 500mg", fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = Color(0xFF131B2E))
                                    Text("1 viên • Uống sau khi ăn 30 phút", fontSize = 12.sp, color = Color(0xFF3F4850))
                                }
                            }
                            Checkbox(checked = med1Checked, onCheckedChange = { med1Checked = it })
                        }
                    }

                    // Med 2
                    Surface(
                        color = Color(0xFFF2F3FF),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically) {
                                Surface(
                                    color = Color.White,
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Column(
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text("18:00", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Color(0xFF006194))
                                        Text("Tối", fontSize = 10.sp, color = Color(0xFF3F4850))
                                    }
                                }
                                Column {
                                    Text("Acetylcysteine 200mg", fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = Color(0xFF131B2E))
                                    Text("1 gói • Hoà tan trong 100ml nước ấm", fontSize = 12.sp, color = Color(0xFF3F4850))
                                }
                            }
                            Checkbox(checked = med2Checked, onCheckedChange = { med2Checked = it })
                        }
                    }
                }
            }

            // Vital Signs Grid
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Chỉ số sinh hiệu", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                    Text("Cập nhật sáng nay", fontSize = 12.sp, color = Color(0xFF3F4850))
                }

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    VitalCard(title = "Huyết áp", value = "135/85", unit = "mmHg", status = "Hơi cao nhẹ", statusColor = Color(0xFFBA1A1A), modifier = Modifier.weight(1f))
                    VitalCard(title = "Đường huyết đói", value = "5.4", unit = "mmol/L", status = "Bình thường", statusColor = Color(0xFF006A61), modifier = Modifier.weight(1f))
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    VitalCard(title = "Nhịp tim", value = "78", unit = "bpm", status = "Ổn định", statusColor = Color(0xFF3F4850), modifier = Modifier.weight(1f))
                    VitalCard(title = "Cân nặng", value = "68.0", unit = "kg", status = "BMI 22.1", statusColor = Color(0xFF3F4850), modifier = Modifier.weight(1f))
                }
            }

            // Doctor Advice
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Lời khuyên từ Bác sĩ", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                    Text("Xem tất cả", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF006194))
                }

                AdviceCard(
                    category = "HÔ HẤP & MIỄN DỊCH",
                    title = "Phòng ngừa các bệnh hô hấp cấp tính thời điểm giao mùa",
                    meta = "BS. CKI Nguyễn Văn Quang • 4 phút đọc",
                    categoryColor = Color(0xFF006194)
                )
                AdviceCard(
                    category = "TIM MẠCH & DINH DƯỠNG",
                    title = "Chế độ ăn giảm muối và duy trì huyết áp an toàn tại nhà",
                    meta = "Khoa Dinh Dưỡng Lâm Sàng • 6 phút đọc",
                    categoryColor = Color(0xFF825100)
                )
            }
        }
    }
}

@Composable
fun QuickUtilityItem(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String, color: Color, bg: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(80.dp)
    ) {
        Surface(
            color = bg,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.size(56.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(icon, contentDescription = label, tint = color, modifier = Modifier.size(24.dp))
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(label, fontSize = 11.sp, color = Color(0xFF131B2E), maxLines = 2, fontWeight = FontWeight.Medium, textAlign = androidx.compose.ui.text.style.TextAlign.Center)
    }
}

@Composable
fun VitalCard(title: String, value: String, unit: String, status: String, statusColor: Color, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF2F3FF)),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(title, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3F4850))
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(value, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
                Text(unit, fontSize = 11.sp, color = Color(0xFF3F4850), modifier = Modifier.padding(bottom = 3.dp))
            }
            Text(status, fontSize = 11.sp, color = statusColor, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
fun AdviceCard(category: String, title: String, meta: String, categoryColor: Color) {
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
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFE2E2EC)),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Article, contentDescription = null, tint = Color(0xFF006194))
            }
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(category, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = categoryColor)
                Text(title, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E), maxLines = 2)
                Text(meta, fontSize = 11.sp, color = Color(0xFF3F4850))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PatientHomeScreenPreview() {
    PatientHomeScreen()
}

