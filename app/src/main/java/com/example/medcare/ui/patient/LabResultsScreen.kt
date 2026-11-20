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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LabResultsScreen(
    onProfileClick: () -> Unit = {}
) {
    var selectedFilter by remember { mutableStateOf(0) } // 0: Tất cả, 1: Xét nghiệm, 2: X-quang, 3: Nội soi
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
            // Notification Banner Reassurance
            Surface(
                color = Color(0xFFE2E7FF),
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
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF86F2E4)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.NotificationsActive, contentDescription = null, tint = Color(0xFF006A61), modifier = Modifier.size(20.dp))
                    }
                    Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("THÔNG BÁO KẾT QUẢ", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006A61))
                            Text("Hôm nay", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3F4850))
                        }
                        Text(
                            text = buildAnnotatedString {
                                append("BS. CKI Nguyễn Văn Quang: ")
                                pushStyle(SpanStyle(fontWeight = FontWeight.Normal))
                                append("Kết quả đã có. Vui lòng đến ")
                                pop()
                                pushStyle(SpanStyle(fontWeight = FontWeight.Bold, textDecoration = androidx.compose.ui.text.style.TextDecoration.Underline))
                                append("Phòng khám 204 (Tầng 2)")
                                pop()
                                pushStyle(SpanStyle(fontWeight = FontWeight.Normal))
                                append(" để xem và nhận hướng dẫn tiếp theo.")
                                pop()
                            },
                            fontSize = 13.sp,
                            color = Color(0xFF006194)
                        )
                    }
                }
            }

            // Filter Chips
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FilterChipItem(title = "Tất cả", count = 4, selected = selectedFilter == 0, onClick = { selectedFilter = 0 })
                FilterChipItem(title = "Xét nghiệm", count = 2, selected = selectedFilter == 1, onClick = { selectedFilter = 1 })
                FilterChipItem(title = "X-quang", count = 1, selected = selectedFilter == 2, onClick = { selectedFilter = 2 })
                FilterChipItem(title = "Nội soi", count = 1, selected = selectedFilter == 3, onClick = { selectedFilter = 3 })
            }

            // Lab Result Card 1: Blood Test
            LabResultCard(
                title = "Phiếu xét nghiệm máu",
                subtitle = "Ngày thực hiện: 18/10/2024",
                status = "Đã có kết quả",
                statusColor = Color(0xFF005049),
                statusBg = Color(0xFF89F5E7),
                doctor = "BS. CKI Nguyễn Văn Quang"
            )

            // Lab Result Card 2: X-Ray
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
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(44.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color(0xFFEAEDFF)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(Icons.Default.Image, contentDescription = null, tint = Color(0xFF006194))
                            }
                            Column {
                                Text("Chụp X-quang ngực", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                                Text("Phòng chụp XR-02", fontSize = 13.sp, color = Color(0xFF3F4850))
                            }
                        }
                        Surface(
                            color = Color(0xFF89F5E7),
                            shape = RoundedCornerShape(99.dp)
                        ) {
                            Text("Đã đọc phim", color = Color(0xFF005049), fontSize = 11.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
                        }
                    }

                    // PACS Preview Viewer Frame Simulation
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(192.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFF283044)),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(Icons.Default.MedicalServices, contentDescription = null, tint = Color.White.copy(alpha = 0.8f), modifier = Modifier.size(48.dp))
                            Text("Ảnh X-quang • 18/10/2024", color = Color(0xFFEEF0FF), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        }
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF283044).copy(alpha = 0.85f)),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(12.dp)
                                .fillMaxWidth()
                        ) {
                            Icon(Icons.Default.Visibility, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Xem ảnh X-quang", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
                        }
                    }

                    // Medical Findings Summary
                    Surface(
                        color = Color(0xFFF2F3FF),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                Icon(Icons.Default.Info, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(15.dp))
                                Text("Thông tin kết quả", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                            }
                            Text("Đã có kết luận của bác sĩ. Chọn xem chi tiết hoặc tải phiếu kết quả.", fontSize = 14.sp, color = Color(0xFF3F4850))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column {
                                    Text("Bác sĩ đọc kết quả:", fontSize = 11.sp, color = Color(0xFF3F4850), fontWeight = FontWeight.Bold)
                                    Text("BS. CKII Lê Hoàng Nam", fontSize = 11.sp, color = Color(0xFF131B2E), fontWeight = FontWeight.Black)
                                }
                                Text("18/10/2024", fontSize = 11.sp, color = Color(0xFF3F4850), fontWeight = FontWeight.Bold)
                            }
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEAEDFF)),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(Icons.Default.Description, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Xem kết luận chi tiết", color = Color(0xFF006194), fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                        }
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEAEDFF)),
                            shape = RoundedCornerShape(8.dp),
                            contentPadding = PaddingValues(0.dp),
                            modifier = Modifier.size(44.dp)
                        ) {
                            Icon(Icons.Default.Download, contentDescription = "Tải", tint = Color(0xFF006194))
                        }
                    }
                }
            }

            // Lab Result Card 3: Endoscopy
            LabResultCard(
                title = "Nội soi dạ dày - tá tràng",
                subtitle = "Ngày thực hiện: 15/01/2024",
                status = "Lịch sử",
                statusColor = Color(0xFF3F4850),
                statusBg = Color(0xFFDAE2FD),
                actionText = "Xem phiếu kết quả"
            )

            // Lab Result Card 4: Biochemistry
            LabResultCard(
                title = "Phiếu xét nghiệm sinh hóa",
                subtitle = "Ngày thực hiện: 18/10/2024",
                status = "Đã có kết quả",
                statusColor = Color(0xFF005049),
                statusBg = Color(0xFF89F5E7),
                actionText = "Xem phiếu kết quả"
            )
        }
    }
}

@Composable
fun FilterChipItem(title: String, count: Int, selected: Boolean, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        color = if (selected) Color(0xFF006194) else Color(0xFFF2F3FF),
        shape = RoundedCornerShape(99.dp),
        shadowElevation = 1.dp
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(title, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = if (selected) Color.White else Color(0xFF3F4850))
            Surface(
                color = if (selected) Color.White.copy(alpha = 0.2f) else Color(0xFFDAE2FD),
                shape = RoundedCornerShape(99.dp)
            ) {
                Text("$count", fontSize = 10.sp, fontWeight = FontWeight.SemiBold, color = if (selected) Color.White else Color(0xFF3F4850), modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
            }
        }
    }
}

@Composable
fun LabResultCard(
    title: String,
    subtitle: String,
    status: String,
    statusColor: Color,
    statusBg: Color,
    doctor: String? = null,
    actionText: String = "Xem phiếu kết quả"
) {
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
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFFEAEDFF)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.Assignment, contentDescription = null, tint = Color(0xFF006194))
                    }
                    Column {
                        Text(title, fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                        Text(subtitle, fontSize = 13.sp, color = Color(0xFF3F4850))
                    }
                }
                Surface(
                    color = statusBg,
                    shape = RoundedCornerShape(99.dp)
                ) {
                    Text(status, color = statusColor, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
                }
            }

            if (doctor != null) {
                Surface(
                    color = Color(0xFFF2F3FF),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("Bác sĩ phụ trách", fontSize = 11.sp, color = Color(0xFF3F4850))
                            Text(doctor, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                        }
                        Column {
                            Text("Trạng thái", fontSize = 11.sp, color = Color(0xFF3F4850))
                            Text(status, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF006A61))
                        }
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEAEDFF)),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Description, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(actionText, color = Color(0xFF006194), fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                }
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEAEDFF)),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier.size(44.dp)
                ) {
                    Icon(Icons.Default.Download, contentDescription = "Tải", tint = Color(0xFF006194))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LabResultsScreenPreview() {
    LabResultsScreen()
}

