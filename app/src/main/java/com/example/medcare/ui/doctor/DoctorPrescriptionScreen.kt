package com.example.medcare.ui.doctor

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DoctorPrescriptionScreen(
    onProfileClick: () -> Unit = {}
) {
    var drugSearch by remember { mutableStateOf("Azithromycin 500mg") }
    var selectedDrugFilter by remember { mutableStateOf(0) } // 0: Tất cả, 1: Dạng viên, 2: Dạng gói, 3: Khác
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
                    Text("Kê đơn thuốc", fontWeight = FontWeight.Bold, fontSize = 11.sp, color = Color(0xFF3F4850))
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
            // Patient Sticky Header & Allergy Warning
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
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFFCCE5FF)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("TA", color = Color(0xFF001D31), fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                            }
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        "Trần Văn An",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color(0xFF131B2E),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        modifier = Modifier.weight(1f, fill = false)
                                    )
                                    Text(
                                        "54 tuổi (Nam)",
                                        fontSize = 12.sp,
                                        color = Color(0xFF3F4850),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                                Text(
                                    "Mã BN: #MED-88942 • Khoa Nội Hô hấp • Phòng 402",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF3F4850),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                        Surface(
                            color = Color(0xFF86F2E4),
                            shape = RoundedCornerShape(99.dp),
                            modifier = Modifier.padding(start = 8.dp)
                        ) {
                            Text(
                                "BHYT 80%",
                                color = Color(0xFF006F66),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                maxLines = 1,
                                softWrap = false,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                            )
                        }
                    }

                    // Allergy strip
                    Surface(
                        color = Color(0xFFFFDAD6).copy(alpha = 0.6f),
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
                            Row(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Warning, contentDescription = null, tint = Color(0xFFBA1A1A), modifier = Modifier.size(16.dp))
                                Text("LƯU Ý HỒ SƠ:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFFBA1A1A))
                                Text("Có thông tin dị ứng • Xem hồ sơ", fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF93000A))
                            }
                            Icon(Icons.Default.ChevronRight, contentDescription = null, tint = Color(0xFF93000A))
                        }
                    }
                }
            }

            // Segmented toggle: Kê đơn thuốc (3) | Kết quả (2)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Surface(
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(1f),
                    shadowElevation = 1.dp
                ) {
                    Row(
                        modifier = Modifier.padding(10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.ReceiptLong, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Kê đơn thuốc (3)", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006194))
                    }
                }
                Surface(
                    color = Color(0xFFE2E7FF),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Row(
                        modifier = Modifier.padding(10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.Assignment, contentDescription = null, tint = Color(0xFF3F4850), modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Kết quả (2)", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3F4850))
                    }
                }
            }

            // Drug Search & Add Section
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Icon(Icons.Default.LocalPharmacy, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(18.dp))
                    Text("Tìm và thêm thuốc", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                    Spacer(modifier = Modifier.weight(1f))
                    Text("Kho Dược BV: Còn 1.420 mã thuốc", fontSize = 11.sp, color = Color(0xFF3F4850))
                }

                OutlinedTextField(
                    value = drugSearch,
                    onValueChange = { drugSearch = it },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color(0xFF707881)) },
                    trailingIcon = { Icon(Icons.Default.Mic, contentDescription = null, tint = Color(0xFF707881)) },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = Color(0xFFF2F3FF),
                        focusedContainerColor = Color(0xFFF2F3FF),
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color(0xFF006194)
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                val drugFilterScrollState = rememberScrollState()
                Row(
                    modifier = Modifier
                        .horizontalScroll(drugFilterScrollState),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    DrugFilterChip(title = "Tất cả", selected = selectedDrugFilter == 0, onClick = { selectedDrugFilter = 0 })
                    DrugFilterChip(title = "Dạng viên", selected = selectedDrugFilter == 1, onClick = { selectedDrugFilter = 1 })
                    DrugFilterChip(title = "Dạng gói", selected = selectedDrugFilter == 2, onClick = { selectedDrugFilter = 2 })
                    DrugFilterChip(title = "Khác", selected = selectedDrugFilter == 3, onClick = { selectedDrugFilter = 3 })
                }
            }

            // Prescription list section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Đơn thuốc", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
                    Surface(
                        color = Color(0xFF006194),
                        shape = CircleShape
                    ) {
                        Text("3", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                    }
                }
                Surface(
                    color = Color(0xFFFFE0B2),
                    shape = RoundedCornerShape(99.dp)
                ) {
                    Text("Chờ duyệt và cấp phát", color = Color(0xFF825100), fontSize = 11.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp))
                }
            }

            // Prescribed Drug Items
            PrescribedDrugCard(number = "1", name = "Azithromycin 500mg", type = "Thuốc kê đơn • Dạng viên • Đường uống", quantity = "03 viên", note = "Hướng dẫn sử dụng: Xem ghi chú bác sĩ", accentColor = Color(0xFF006A61))
            PrescribedDrugCard(number = "2", name = "Acetylcysteine 200mg", type = "Thuốc kê đơn • Dạng gói • Đường uống", quantity = "20 gói", note = "Hướng dẫn sử dụng: Xem ghi chú bác sĩ", accentColor = Color(0xFF006194))
            PrescribedDrugCard(number = "3", name = "Esomeprazole 40mg", type = "Thuốc kê đơn • Dạng viên • Đường uống", quantity = "14 viên", note = "Hướng dẫn sử dụng: Xem ghi chú bác sĩ", accentColor = Color(0xFFFFB300))

            // Total price & Save/Send actions
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
                        Text("Tổng chi phí ước tính:", fontSize = 13.sp, color = Color(0xFF3F4850))
                        Text("246.000 ₫", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006194))
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006194)),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp)
                        ) {
                            Icon(Icons.Default.Send, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Lưu & Gửi đơn", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                        }
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE2E7FF)),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.size(48.dp),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Icon(Icons.Default.Print, contentDescription = "In đơn thuốc", tint = Color(0xFF006194))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DrugFilterChip(title: String, selected: Boolean, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        color = if (selected) Color(0xFF006194) else Color(0xFFEAEDFF),
        shape = RoundedCornerShape(99.dp)
    ) {
        Text(
            title,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = if (selected) Color.White else Color(0xFF3F4850),
            maxLines = 1,
            softWrap = false,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
        )
    }
}

@Composable
fun PrescribedDrugCard(number: String, name: String, type: String, quantity: String, note: String, accentColor: Color) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(4.dp)
                    .background(accentColor)
                    .align(Alignment.CenterStart)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .padding(start = 4.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Row(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
                            Text("$number. $name", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
                            Surface(
                                color = Color(0xFFE2E7FF),
                                shape = RoundedCornerShape(4.dp)
                            ) {
                                Text("Thuốc kê đơn", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E), modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp))
                            }
                        }
                        Text(type, fontSize = 12.sp, color = Color(0xFF3F4850))
                    }
                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(quantity.substringBefore(" "), fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006194))
                        Text(quantity.substringAfter(" "), fontSize = 12.sp, color = Color(0xFF3F4850), modifier = Modifier.padding(bottom = 2.dp))
                    }
                }

                Surface(
                    color = Color(0xFFF2F3FF),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.Schedule, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(14.dp))
                        Text(note, fontSize = 12.sp, color = Color(0xFF131B2E))
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Đã thêm vào đơn", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006A61))
                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                            Icon(Icons.Default.Edit, contentDescription = null, tint = Color(0xFF3F4850), modifier = Modifier.size(12.dp))
                            Text("Sửa", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3F4850))
                        }
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                            Icon(Icons.Default.Delete, contentDescription = null, tint = Color(0xFF3F4850), modifier = Modifier.size(12.dp))
                            Text("Xóa", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3F4850))
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DoctorPrescriptionScreenPreview() {
    DoctorPrescriptionScreen()
}

