package com.example.medcare.ui.patient

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
fun BookingScreen() {
    var selectedExamType by remember { mutableStateOf(0) } // 0: Theo Bác sĩ, 1: Chuyên khoa, 2: BHYT
    var selectedSpecialty by remember { mutableStateOf(0) } // 0: Nội Hô hấp, 1: Tim mạch, ...
    var selectedDate by remember { mutableStateOf(4) } // Index 4 is T6 18 (Selected)
    var selectedTimeSlot by remember { mutableStateOf(0) } // 0: 08:00 - 08:30
    var symptoms by remember { mutableStateOf("") }

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
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Progress Header
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF006A61))
                        )
                        Text("HỆ THỐNG THÔNG MINH", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006A61))
                    }
                    Surface(
                        color = Color(0xFFE2E7FF),
                        shape = RoundedCornerShape(99.dp)
                    ) {
                        Text("5 bước nhanh", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF3F4850), modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
                    }
                }
                Text("Đặt lịch khám bệnh", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
                Text("Chủ động hẹn giờ, tiết kiệm thời gian chờ và ưu tiên khám đúng hẹn.", fontSize = 13.sp, color = Color(0xFF3F4850))
            }

            // Step 1: Exam Type
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF006194)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("1", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }
                    Text("Hình thức khám", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    ExamTypeButton(title = "Theo Bác sĩ", icon = Icons.Default.MedicalServices, selected = selectedExamType == 0, onClick = { selectedExamType = 0 }, modifier = Modifier.weight(1f))
                    ExamTypeButton(title = "Chuyên khoa", icon = Icons.Default.Domain, selected = selectedExamType == 1, onClick = { selectedExamType = 1 }, modifier = Modifier.weight(1f))
                    ExamTypeButton(title = "BHYT / Tái khám", icon = Icons.Default.HealthAndSafety, selected = selectedExamType == 2, onClick = { selectedExamType = 2 }, modifier = Modifier.weight(1f))
                }
            }

            // Step 2: Specialty
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF006194)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("2", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                        Text("Chọn chuyên khoa", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                    }
                    TextButton(onClick = { }) {
                        Text("Tất cả ›", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF006194))
                    }
                }
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        SpecialtyChip(title = "Nội Hô hấp", selected = selectedSpecialty == 0, onClick = { selectedSpecialty = 0 })
                        SpecialtyChip(title = "Tim mạch & Huyết áp", selected = selectedSpecialty == 1, onClick = { selectedSpecialty = 1 })
                    }
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        SpecialtyChip(title = "Tai Mũi Họng", selected = selectedSpecialty == 2, onClick = { selectedSpecialty = 2 })
                        SpecialtyChip(title = "Tiêu hóa", selected = selectedSpecialty == 3, onClick = { selectedSpecialty = 3 })
                        SpecialtyChip(title = "Nhi khoa", selected = selectedSpecialty == 4, onClick = { selectedSpecialty = 4 })
                    }
                }
            }

            // Step 3: Doctor in charge
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF006194)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("3", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                        Text("Bác sĩ phụ trách", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                    }
                    Text("2 bác sĩ sẵn sàng", fontSize = 12.sp, color = Color(0xFF3F4850))
                }

                DoctorCard(
                    name = "BS. CKI Nguyễn Văn Quang",
                    specialty = "Khoa Nội Hô hấp • 15 năm kinh nghiệm",
                    rating = "4.9 (348)",
                    badge = "Ưu tiên chọn",
                    insurance = "Áp dụng BHYT",
                    price = "150.000đ",
                    selected = true
                )
                DoctorCard(
                    name = "BS. Trần Minh Châu",
                    specialty = "Khoa Tim mạch • 12 năm kinh nghiệm",
                    rating = "4.8 (210)",
                    badge = "Khám đa khoa",
                    price = "150.000đ",
                    selected = false
                )
            }

            // Step 4: Date & Time
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF006194)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("4", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                        Text("Ngày & giờ khám", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                    }
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Icon(Icons.Default.CalendarMonth, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(16.dp))
                        Text("Tháng 10, 2024", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF006194))
                    }
                }

                // Date row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    DateItem(day = "T2", date = "14", selected = selectedDate == 0, onClick = { selectedDate = 0 })
                    DateItem(day = "T3", date = "15", selected = selectedDate == 1, onClick = { selectedDate = 1 })
                    DateItem(day = "T4", date = "16", selected = selectedDate == 2, onClick = { selectedDate = 2 })
                    DateItem(day = "T5", date = "17", selected = selectedDate == 3, onClick = { selectedDate = 3 })
                    DateItem(day = "T6", date = "18", selected = selectedDate == 4, onClick = { selectedDate = 4 })
                }

                // Time slots
                Text("Buổi sáng", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3F4850))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    TimeSlotItem(time = "08:00 - 08:30", status = "Còn 2 chỗ", selected = selectedTimeSlot == 0, available = true, onClick = { selectedTimeSlot = 0 }, modifier = Modifier.weight(1f))
                    TimeSlotItem(time = "09:00 - 09:30", status = "Đã đầy", selected = false, available = false, onClick = { }, modifier = Modifier.weight(1f))
                    TimeSlotItem(time = "10:00 - 10:30", status = "Còn 4 chỗ", selected = selectedTimeSlot == 2, available = true, onClick = { selectedTimeSlot = 2 }, modifier = Modifier.weight(1f))
                }

                Text("Buổi chiều", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3F4850))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    TimeSlotItem(time = "14:00 - 14:30", status = "Còn 5 chỗ trống", selected = false, available = true, onClick = { }, modifier = Modifier.weight(1f))
                    TimeSlotItem(time = "15:30 - 16:00", status = "Còn chỗ trống", selected = false, available = true, onClick = { }, modifier = Modifier.weight(1f))
                }
            }

            // Step 5: Information & Symptoms
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF006194)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("5", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }
                    Text("Thông tin & Triệu chứng", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                }

                // Patient Profile Card inside booking
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
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
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFFEAEDFF)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("TA", color = Color(0xFF006194), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            }
                            Column {
                                Text("Trần Văn An", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                                Text("Bản thân • Đã liên kết BHYT (DN401...)", fontSize = 11.sp, color = Color(0xFF006A61))
                            }
                        }
                        Icon(Icons.Default.KeyboardArrowDown, contentDescription = null, tint = Color(0xFF3F4850))
                    }
                }

                // Symptoms input
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Mô tả triệu chứng hoặc lý do khám", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF3F4850))
                        Text("Tùy chọn", fontSize = 11.sp, color = Color(0xFF3F4850))
                    }
                    OutlinedTextField(
                        value = symptoms,
                        onValueChange = { symptoms = it },
                        placeholder = { Text("Ví dụ: Ho kéo dài 4 ngày, sốt nhẹ về chiều, cảm giác khó thở khi leo cầu thang...", fontSize = 13.sp, color = Color(0xFF3F4850).copy(alpha = 0.6f)) },
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White,
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = Color(0xFF006194)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(110.dp)
                    )

                    // Quick Symptom Tags
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        SymptomTag(title = "+ Sốt nhẹ")
                        SymptomTag(title = "+ Ho đờm")
                        SymptomTag(title = "+ Đau ngực")
                        SymptomTag(title = "+ Tái khám theo hẹn")
                    }
                }
            }

            // Summary & BHYT Calculation Card
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF2F3FF)),
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
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Icon(Icons.Default.Receipt, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(18.dp))
                            Text("Tóm tắt thanh toán tạm tính", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                        }
                        Surface(
                            color = Color(0xFF86F2E4).copy(alpha = 0.5f),
                            shape = RoundedCornerShape(99.dp)
                        ) {
                            Text("Hưởng BHYT 80%", color = Color(0xFF006A61), fontSize = 11.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
                        }
                    }

                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text("Tiền khám theo chuyên khoa:", fontSize = 13.sp, color = Color(0xFF3F4850))
                            Text("150.000đ", fontSize = 13.sp, fontWeight = FontWeight.Medium, color = Color(0xFF131B2E))
                        }
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Row(horizontalArrangement = Arrangement.spacedBy(4.dp), verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Color(0xFF006A61), modifier = Modifier.size(14.dp))
                                Text("Giảm trừ Bảo hiểm Y tế (80%):", fontSize = 13.sp, color = Color(0xFF006A61))
                            }
                            Text("- 120.000đ", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006A61))
                        }
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text("Phí nền tảng & đặt hẹn trực tuyến:", fontSize = 13.sp, color = Color(0xFF3F4850))
                            Text("Miễn phí", fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF006A61))
                        }
                    }

                    HorizontalDivider(color = Color(0xFFE2E7FF))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Tổng chi phí tạm tính:", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                        Column(horizontalAlignment = Alignment.End) {
                            Text("30.000đ", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006194))
                            Text("Thanh toán tại quầy hoặc ứng dụng", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3F4850))
                        }
                    }
                }
            }

            // Primary CTA
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006194)),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp)
                ) {
                    Icon(Icons.Default.EventAvailable, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Xác nhận đặt lịch & Nhận mã số khám", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.Notifications, contentDescription = null, tint = Color(0xFF3F4850), modifier = Modifier.size(14.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Hệ thống sẽ tự động gửi thông báo qua SMS & Zalo nhắc hẹn trước 24 giờ", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3F4850))
                }
            }
        }
    }
}

@Composable
fun ExamTypeButton(title: String, icon: androidx.compose.ui.graphics.vector.ImageVector, selected: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Surface(
        onClick = onClick,
        color = if (selected) Color(0xFF006194) else Color.White,
        shape = RoundedCornerShape(12.dp),
        shadowElevation = 1.dp,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(icon, contentDescription = null, tint = if (selected) Color.White else Color(0xFF006194), modifier = Modifier.size(24.dp))
            Text(title, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = if (selected) Color.White else Color(0xFF131B2E), textAlign = androidx.compose.ui.text.style.TextAlign.Center)
        }
    }
}

@Composable
fun SpecialtyChip(title: String, selected: Boolean, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        color = if (selected) Color(0xFF006194) else Color.White,
        shape = RoundedCornerShape(99.dp),
        shadowElevation = 1.dp
    ) {
        Text(
            title,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = if (selected) Color.White else Color(0xFF131B2E),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
        )
    }
}

@Composable
fun DoctorCard(
    name: String,
    specialty: String,
    rating: String,
    badge: String,
    insurance: String? = null,
    price: String,
    selected: Boolean
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = if (selected) Color(0xFFF2F3FF) else Color.White),
        border = if (selected) BorderStroke(1.dp, Color(0xFF006194)) else null,
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
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFFE2E2EC)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.Person, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(32.dp))
                    }
                    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                        Text(name, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
                        Text(specialty, fontSize = 12.sp, color = Color(0xFF3F4850))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                                Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFFFB300), modifier = Modifier.size(14.dp))
                                Text(rating, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
                            }
                            Surface(
                                color = Color(0xFF86F2E4).copy(alpha = 0.5f),
                                shape = RoundedCornerShape(4.dp)
                            ) {
                                Text(badge, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006A61), modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp))
                            }
                            if (insurance != null) {
                                Surface(
                                    color = Color(0xFFEAEDFF),
                                    shape = RoundedCornerShape(4.dp)
                                ) {
                                    Text(insurance, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006194), modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp))
                                }
                            }
                        }
                    }
                }
            }

            HorizontalDivider(color = Color(0xFFE2E7FF))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Giá khám niêm yết", fontSize = 11.sp, color = Color(0xFF3F4850))
                    Text(price, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006194))
                }
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(if (selected) Color(0xFF006194) else Color(0xFFEAEDFF)),
                    contentAlignment = Alignment.Center
                ) {
                    if (selected) {
                        Icon(Icons.Default.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
                    } else {
                        Icon(Icons.Default.Add, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(14.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun DateItem(day: String, date: String, selected: Boolean, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        color = if (selected) Color(0xFF006194) else Color.White,
        shape = RoundedCornerShape(12.dp),
        shadowElevation = 1.dp
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(day, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = if (selected) Color.White.copy(alpha = 0.8f) else Color(0xFF3F4850))
            Text(date, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = if (selected) Color.White else Color(0xFF131B2E))
        }
    }
}

@Composable
fun TimeSlotItem(time: String, status: String, selected: Boolean, available: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Surface(
        onClick = onClick,
        enabled = available,
        color = if (selected) Color(0xFF006194) else if (available) Color.White else Color(0xFFF2F3FF),
        shape = RoundedCornerShape(8.dp),
        shadowElevation = if (available) 1.dp else 0.dp,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(time, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = if (selected) Color.White else if (available) Color(0xFF131B2E) else Color(0xFF707881))
            Text(status, fontSize = 10.sp, color = if (selected) Color.White.copy(alpha = 0.9f) else if (available) Color(0xFF006194) else Color(0xFF707881))
        }
    }
}

@Composable
fun SymptomTag(title: String) {
    Surface(
        color = Color(0xFFEAEDFF),
        shape = RoundedCornerShape(4.dp)
    ) {
        Text(title, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3F4850), modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun BookingScreenPreview() {
    BookingScreen()
}

@Preview(showBackground = true)
@Composable
fun DoctorCardPreview() {
    DoctorCard(
        name = "BS. CKI Nguyễn Văn Quang",
        specialty = "Khoa Nội Hô hấp • 15 năm kinh nghiệm",
        rating = "4.9 (348)",
        badge = "Ưu tiên chọn",
        insurance = "Áp dụng BHYT",
        price = "150.000đ",
        selected = true
    )
}

@Preview(showBackground = true)
@Composable
fun ExamTypeButtonPreview() {
    ExamTypeButton(
        title = "Theo Bác sĩ",
        icon = Icons.Default.MedicalServices,
        selected = true,
        onClick = {}
    )
}

