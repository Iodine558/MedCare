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
fun AdminAccountsScreen() {
    var searchQuery by remember { mutableStateOf("") }
    var selectedFilter by remember { mutableStateOf(0) } // 0: Tất cả, 1: Bác sĩ, 2: Dược sĩ, ...

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
            // Header Context & Stat Callout
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        color = Color(0xFFE2E7FF),
                        shape = RoundedCornerShape(99.dp)
                    ) {
                        Text("HỆ THỐNG TUÂN THỦ BỘ Y TẾ", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006194), modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp))
                    }
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF006A61))
                        )
                        Text("142 nhân sự online", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3F4850))
                    }
                }

                Text("QUẢN TRỊ TÀI KHOẢN & PHÂN QUYỀN", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
                Text("Kiểm soát truy cập phân tầng RBAC • 142 tài khoản nội bộ đang hoạt động", fontSize = 13.sp, color = Color(0xFF3F4850))
            }

            // Primary Operations Buttons
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006194)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Icon(Icons.Default.PersonAdd, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Cấp mới tài khoản", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            }

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF86F2E4)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Icon(Icons.Default.GridOn, contentDescription = null, tint = Color(0xFF006F66), modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Ma trận quyền", color = Color(0xFF006F66), fontWeight = FontWeight.Bold, fontSize = 14.sp)
            }

            // Security Indices Cards
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
                        Text("CHỈ SỐ AN TOÀN PHIÊN & XÁC THỰC", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3F4850))
                        Surface(
                            color = Color(0xFFE0F8F4),
                            shape = RoundedCornerShape(99.dp)
                        ) {
                            Text("Zero Trust", color = Color(0xFF006A61), fontSize = 11.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
                        }
                    }

                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        SecurityMiniMetric(title = "139", label = "Đã bật 2FA", percentage = "98%", modifier = Modifier.weight(1f))
                        SecurityMiniMetric(title = "34", label = "Phiên đồng thời", status = "●", modifier = Modifier.weight(1f))
                        SecurityMiniMetric(title = "03", label = "Cảnh báo bảo mật", alert = "Chú ý", modifier = Modifier.weight(1f))
                    }

                    Surface(
                        color = Color(0xFFFFDAD6),
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
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                Icon(Icons.Default.Warning, contentDescription = null, tint = Color(0xFFBA1A1A), modifier = Modifier.size(16.dp))
                                Text("3 tài khoản chưa đổi mật khẩu", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFFBA1A1A))
                            }
                            Button(
                                onClick = { },
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBA1A1A)),
                                shape = RoundedCornerShape(4.dp),
                                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Text("Xác thực ngay", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }

            // User Search and Category Filters
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Tìm theo Tên, Email, Mã NV hoặc Khoa...", fontSize = 14.sp, color = Color(0xFF707881)) },
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
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                AdminRoleChip(title = "Tất cả (142)", selected = selectedFilter == 0, onClick = { selectedFilter = 0 })
                AdminRoleChip(title = "Bác sĩ (48)", selected = selectedFilter == 1, onClick = { selectedFilter = 1 })
                AdminRoleChip(title = "Dược sĩ (16)", selected = selectedFilter == 2, onClick = { selectedFilter = 2 })
            }

            // User Card 1: BS. CKI Nguyễn Văn Quang
            AdminUserCard(
                name = "BS. CKI Nguyễn Văn Quang",
                department = "Khoa Nội Hô hấp • NV-DOC-0102",
                roleBadge = "DOCTOR_FULL",
                authBadge = "2FA Bật",
                permissions = "Phạm vi tác vụ: Khám bệnh, Xem toàn bộ EMR, Kê đơn, Chỉ định CLS",
                lastAccess = "Truy cập: 2 phút trước (Phòng khám 202)",
                isOnline = true
            )

            // User Card 2: DS. Phạm Văn Dũng
            AdminUserCard(
                name = "DS. Phạm Văn Dũng",
                department = "Khoa Dược Bệnh viện • NV-PHA-0045",
                roleBadge = "PHARMACY_MANAGER",
                authBadge = "2FA Bật",
                permissions = "Phạm vi tác vụ: Duyệt xuất kho, xem đơn thuốc ngoại/nội trú",
                extraWarning = "* Không có quyền can thiệp hay sửa chẩn đoán bệnh án lâm sàng.",
                isOnline = true
            )

            // User Card 3: NV. Lê Thị Nga
            AdminUserCard(
                name = "NV. Lê Thị Nga",
                department = "Tiếp đón & BHYT • NV-REC-0089",
                roleBadge = "RECEPTIONIST",
                authBadge = "2FA Đang cấu hình",
                authAlert = true,
                permissions = "Tiếp nhận BN, Tạo PID, Quét CCCD/BHYT, Gộp hồ sơ trùng",
                extraWarning = "* Nghiêm cấm xem dữ liệu xét nghiệm và chi tiết bệnh án lâm sàng.",
                isOnline = false
            )

            // Least Privilege Principle Box
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF2F3FF)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Icon(Icons.Default.Security, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(18.dp))
                            Column {
                                Text("Nguyên tắc Phân quyền Tối thiểu (Least Privilege)", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
                                Text("Chiếu theo Thông tư 46/2018/TT-BYT & 54/2017/TT-BYT", fontSize = 11.sp, color = Color(0xFF3F4850))
                            }
                        }
                    }

                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Surface(
                            color = Color.White,
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                Text("Dữ liệu Lâm sàng", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006A61))
                                Text("Chỉ Bác sĩ điều trị & Điều dưỡng được gán ca trực mới có quyền đọc hồ sơ bệnh án.", fontSize = 11.sp, color = Color(0xFF3F4850))
                            }
                        }
                        Surface(
                            color = Color.White,
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                Text("Hồ sơ BHYT & Viện phí", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006194))
                                Text("Kế toán & Tiếp đón chỉ thao tác mã thanh toán, hoàn toàn bị ẩn lịch sử hội chẩn.", fontSize = 11.sp, color = Color(0xFF3F4850))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SecurityMiniMetric(title: String, label: String, percentage: String? = null, status: String? = null, alert: String? = null, modifier: Modifier = Modifier) {
    Surface(
        color = Color(0xFFF2F3FF),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text(title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = if (alert != null) Color(0xFFBA1A1A) else Color(0xFF131B2E))
                if (percentage != null) Text(percentage, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006A61))
                if (alert != null) Text(alert, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFFBA1A1A))
            }
            Text(label, fontSize = 10.sp, color = Color(0xFF3F4850))
        }
    }
}

@Composable
fun AdminRoleChip(title: String, selected: Boolean, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        color = if (selected) Color(0xFF006194) else Color(0xFFF2F3FF),
        shape = RoundedCornerShape(99.dp)
    ) {
        Text(title, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = if (selected) Color.White else Color(0xFF3F4850), modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp))
    }
}

@Composable
fun AdminUserCard(
    name: String,
    department: String,
    roleBadge: String,
    authBadge: String,
    authAlert: Boolean = false,
    permissions: String,
    extraWarning: String? = null,
    lastAccess: String? = null,
    isOnline: Boolean = true
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(40.dp)) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFEAEDFF)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(name.substringBefore(" ").take(2), color = Color(0xFF006194), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        }
                        if (isOnline) {
                            Box(
                                modifier = Modifier
                                    .size(10.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF006A61))
                                    .align(Alignment.BottomEnd)
                            )
                        }
                    }
                    Column {
                        Text(name, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF131B2E))
                        Text(department, fontSize = 12.sp, color = Color(0xFF3F4850))
                        Row(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
                            Surface(
                                color = Color(0xFFE2E7FF),
                                shape = RoundedCornerShape(4.dp)
                            ) {
                                Text(roleBadge, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006194), modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp))
                            }
                            Surface(
                                color = if (authAlert) Color(0xFFFFE0B2) else Color(0xFF86F2E4),
                                shape = RoundedCornerShape(4.dp)
                            ) {
                                Text(authBadge, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = if (authAlert) Color(0xFF825100) else Color(0xFF006F66), modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp))
                            }
                        }
                    }
                }
                IconButton(onClick = { }) {
                    Icon(Icons.Default.MoreVert, contentDescription = null, tint = Color(0xFF3F4850))
                }
            }

            Surface(
                color = Color(0xFFF2F3FF),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(permissions, fontSize = 12.sp, fontWeight = FontWeight.Medium, color = Color(0xFF131B2E))
                    if (extraWarning != null) {
                        Text(extraWarning, fontSize = 11.sp, color = Color(0xFFBA1A1A), fontWeight = FontWeight.Medium)
                    }
                    if (lastAccess != null) {
                        Text(lastAccess, fontSize = 11.sp, color = Color(0xFF707881))
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEAEDFF)),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text("Khóa tạm thời", color = Color(0xFF131B2E), fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006194)),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text("Phân quyền", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AdminAccountsScreenPreview() {
    AdminAccountsScreen()
}

