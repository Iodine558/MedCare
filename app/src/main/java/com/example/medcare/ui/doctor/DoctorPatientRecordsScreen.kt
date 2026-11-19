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
fun DoctorPatientRecordsScreen() {
    var searchQuery by remember { mutableStateOf("") }
    var selectedFilter by remember { mutableStateOf(0) } // 0: Tất cả, 1: Nội trú, 2: Ngoại trú, 3: Cấp cứu

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
                    Text("Hồ Sơ Bệnh Nhân", fontWeight = FontWeight.Bold, fontSize = 11.sp, color = Color(0xFF3F4850))
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
            // Search & QR Scanner
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("Mã BN, CCCD, SĐT hoặc họ tên...", fontSize = 14.sp, color = Color(0xFF707881)) },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color(0xFF707881)) },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color(0xFF006194)
                    ),
                    modifier = Modifier.weight(1f)
                )
                Surface(
                    onClick = { },
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.size(48.dp),
                    shadowElevation = 1.dp
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(Icons.Default.QrCodeScanner, contentDescription = "Quét mã QR", tint = Color(0xFF006194))
                    }
                }
            }

            // Quick Status Filter Pills
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                DoctorFilterChip(title = "Tất cả (1,248)", selected = selectedFilter == 0, onClick = { selectedFilter = 0 })
                DoctorFilterChip(title = "Nội trú (42)", selected = selectedFilter == 1, onClick = { selectedFilter = 1 })
                DoctorFilterChip(title = "Ngoại trú (118)", selected = selectedFilter == 2, onClick = { selectedFilter = 2 })
                DoctorFilterChip(title = "Cấp cứu (5)", selected = selectedFilter == 3, onClick = { selectedFilter = 3 }, isAlert = true)
            }

            // Triage Alert Banner: Duplicate Data
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFE0B2)),
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
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFE65100)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("2", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        }
                        Column {
                            Text("Phát hiện trùng khớp dữ liệu", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = Color(0xFF2A1700))
                            Text("CCCD 079084001234 khớp với 2 hồ sơ số hiệu BN-2024-0891 và BN-2022-1102.", fontSize = 11.sp, color = Color(0xFF3F4850))
                        }
                    }
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF825100)),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
                    ) {
                        Text("Gộp ngay", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            // Patient Card 1: Trần Văn An
            DoctorPatientCard(
                name = "Trần Văn An",
                ageGender = "54t · Nam",
                id = "BN-2024-0891",
                status = "Chờ khám · P.204",
                statusColor = Color(0xFF006194),
                statusBg = Color(0xFFEAEDFF),
                cccd = "CCCD: 079084001234",
                allergy = "DỊ ỨNG: Penicillin, Thuốc kháng viêm NSAIDs",
                bhyt = "BHYT: GD4791029381xxx (Đúng tuyến 100%)",
                extraNote = "Đã nạp viện phí",
                actionLabel = "Xem EMR"
            )

            // Patient Card 2: Lê Thị Mai
            DoctorPatientCard(
                name = "Lê Thị Mai",
                ageGender = "32t · Nữ",
                id = "BN-2024-0902",
                status = "Có kết quả CLS",
                statusColor = Color(0xFF006A61),
                statusBg = Color(0xFF86F2E4),
                cccd = "CCCD: 079192005678",
                history = "TIỀN SỬ: Hen phế quản, Đái tháo đường Type 2",
                clsInfo = "CLS: X-quang phổi thẳng & Xét nghiệm HbA1c",
                doctorName = "Bs. Trịnh Thu Hà",
                actionLabel = "Xem kết quả CLS"
            )

            // Patient Card 3: Nguyễn Hoàng Quân
            DoctorPatientCard(
                name = "Nguyễn Hoàng Quân",
                ageGender = "8t · Nam",
                id = "BN-2024-0915",
                status = "Tái khám 14:30",
                statusColor = Color(0xFF131B2E),
                statusBg = Color(0xFFEAEDFF),
                bhytInfo = "BHYT TE <6t chuyển diện",
                deptInfo = "Khoa Nhi · Khám định kỳ Hô hấp",
                checkinStatus = "Đã check-in",
                actionLabel = "Chuẩn bị khám",
                isActionPrimary = true
            )
        }
    }
}

@Composable
fun DoctorFilterChip(title: String, selected: Boolean, onClick: () -> Unit, isAlert: Boolean = false) {
    Surface(
        onClick = onClick,
        color = if (selected) Color(0xFF006194) else if (isAlert) Color(0xFFFFDAD6) else Color(0xFFF2F3FF),
        shape = RoundedCornerShape(99.dp),
        shadowElevation = 1.dp
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            if (isAlert) {
                Box(
                    modifier = Modifier
                        .size(6.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFBA1A1A))
                )
            }
            Text(
                title,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = if (selected) Color.White else if (isAlert) Color(0xFF93000A) else Color(0xFF3F4850)
            )
        }
    }
}

@Composable
fun DoctorPatientCard(
    name: String,
    ageGender: String,
    id: String,
    status: String,
    statusColor: Color,
    statusBg: Color,
    cccd: String? = null,
    allergy: String? = null,
    bhyt: String? = null,
    extraNote: String? = null,
    history: String? = null,
    clsInfo: String? = null,
    doctorName: String? = null,
    bhytInfo: String? = null,
    deptInfo: String? = null,
    checkinStatus: String? = null,
    actionLabel: String,
    isActionPrimary: Boolean = false
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
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFE2E7FF)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.Person, contentDescription = null, tint = Color(0xFF006194))
                    }
                    Column {
                        Row(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
                            Text(name, fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                            Text("($ageGender)", fontSize = 13.sp, color = Color(0xFF3F4850))
                        }
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                            Text(id, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF006194))
                            if (bhytInfo != null) {
                                Text("•", color = Color(0xFF707881))
                                Text(bhytInfo, fontSize = 13.sp, color = Color(0xFF3F4850))
                            }
                        }
                    }
                }
                Surface(
                    color = statusBg,
                    shape = RoundedCornerShape(99.dp)
                ) {
                    Text(status, color = statusColor, fontSize = 11.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
                }
            }

            if (cccd != null) {
                Text(cccd, fontSize = 13.sp, color = Color(0xFF3F4850))
            }

            if (allergy != null) {
                Surface(
                    color = Color(0xFFFFDAD6),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.Warning, contentDescription = null, tint = Color(0xFFBA1A1A), modifier = Modifier.size(16.dp))
                        Text(allergy, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF93000A))
                    }
                }
            }

            if (history != null) {
                Surface(
                    color = Color(0xFFFFE0B2),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.MedicalInformation, contentDescription = null, tint = Color(0xFF825100), modifier = Modifier.size(16.dp))
                        Text(history, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2A1700))
                    }
                }
            }

            if (bhyt != null) {
                Text(bhyt, fontSize = 13.sp, color = Color(0xFF3F4850))
            }

            if (extraNote != null) {
                Text(extraNote, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF006A61))
            }

            if (clsInfo != null && doctorName != null) {
                Column {
                    Text(clsInfo, fontSize = 13.sp, color = Color(0xFF3F4850))
                    Text(doctorName, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006194))
                }
            }

            if (deptInfo != null && checkinStatus != null) {
                Surface(
                    color = Color(0xFFEAEDFF),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(deptInfo, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3F4850))
                        Text(checkinStatus, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006194))
                    }
                }
            }

            HorizontalDivider(color = Color(0xFFE2E7FF))

            // Footer Actions
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = if (isActionPrimary) Color(0xFF006194) else Color(0xFF006A61)),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp)
                ) {
                    Icon(
                        imageVector = if (isActionPrimary) Icons.Default.EventAvailable else Icons.Default.Visibility,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(actionLabel, color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
                }

                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    IconButton(
                        onClick = { },
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFFF2F3FF))
                    ) {
                        Icon(Icons.Default.Edit, contentDescription = "Chỉnh sửa", tint = Color(0xFF3F4850), modifier = Modifier.size(16.dp))
                    }
                    IconButton(
                        onClick = { },
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFFF2F3FF))
                    ) {
                        Icon(Icons.Default.Archive, contentDescription = "Lưu trữ", tint = Color(0xFF3F4850), modifier = Modifier.size(16.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DoctorPatientRecordsScreenPreview() {
    DoctorPatientRecordsScreen()
}

