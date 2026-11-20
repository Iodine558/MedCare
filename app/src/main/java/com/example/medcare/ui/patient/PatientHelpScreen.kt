package com.example.medcare.ui.patient

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.automirrored.filled.ReceiptLong
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PatientHelpScreen(
    onBack: () -> Unit = {}
) {
    val scrollState = rememberScrollState()
    var selectedCategory by remember { mutableStateOf(0) } // 0: Tất cả, 1: Đặt khám, 2: Kết quả CLS, 3: Thẻ y tế, 4: Hỏi đáp
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF8FF))
    ) {
        // Top App Bar
        Surface(
            color = Color.White,
            tonalElevation = 2.dp,
            shadowElevation = 1.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(horizontal = 8.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Quay lại",
                            tint = Color(0xFF131B2E)
                        )
                    }
                    Column {
                        Text(
                            text = "Hướng dẫn sử dụng",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF131B2E)
                        )
                        Text(
                            text = "Trung tâm trợ giúp bệnh nhân MedCare",
                            fontSize = 11.sp,
                            color = Color(0xFF006194),
                            fontWeight = FontWeight.Medium
                        )
                    }
                }

                Surface(
                    shape = CircleShape,
                    color = Color(0xFFEAEDFF),
                    modifier = Modifier
                        .size(36.dp)
                        .padding(end = 4.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Help,
                            contentDescription = null,
                            tint = Color(0xFF006194),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
        }

        // Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Hero Welcome Card
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF006194)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            color = Color.White.copy(alpha = 0.2f),
                            shape = RoundedCornerShape(20.dp)
                        ) {
                            Text(
                                text = "TRỢ GIÚP 24/7",
                                color = Color.White,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                        Icon(
                            imageVector = Icons.Default.HealthAndSafety,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }

                    Text(
                        text = "Khám chữa bệnh thông minh & tiện lợi",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Text(
                        text = "MedCare giúp bạn đặt lịch khám trước, theo dõi hồ sơ sức khỏe và nhận kết quả cận lâm sàng nhanh chóng ngay trên điện thoại.",
                        fontSize = 13.sp,
                        color = Color(0xFFE2E7FF),
                        lineHeight = 18.sp
                    )
                }
            }

            // Search Bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Tìm kiếm câu hỏi hoặc tính năng...", fontSize = 13.sp, color = Color(0xFF707881)) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color(0xFF006194)) },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(Icons.Default.Clear, contentDescription = "Xóa tìm kiếm", tint = Color(0xFF707881))
                        }
                    }
                },
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color(0xFF006194),
                    unfocusedBorderColor = Color(0xFFD8E2F0)
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            // Category Filter Chips
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val categories = listOf("Tất cả", "Đặt khám", "Kết quả CLS", "Thẻ y tế", "Hỏi đáp")
                categories.forEachIndexed { index, title ->
                    val isSelected = selectedCategory == index
                    Surface(
                        onClick = { selectedCategory = index },
                        shape = RoundedCornerShape(20.dp),
                        color = if (isSelected) Color(0xFF006194) else Color.White,
                        shadowElevation = if (isSelected) 2.dp else 0.dp,
                        border = if (!isSelected) androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFD8E2F0)) else null,
                        modifier = Modifier.height(36.dp)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.padding(horizontal = 14.dp)
                        ) {
                            Text(
                                text = title,
                                fontSize = 12.sp,
                                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                                color = if (isSelected) Color.White else Color(0xFF3F4850)
                            )
                        }
                    }
                }
            }

            // Quick 4-Step Hospital Workflow Overview
            if (selectedCategory == 0 || selectedCategory == 1) {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text(
                        text = "Quy trình khám bệnh tại MedCare",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF131B2E)
                    )

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
                            verticalArrangement = Arrangement.spacedBy(14.dp)
                        ) {
                            WorkflowStepItem(
                                stepNumber = 1,
                                title = "Đặt lịch khám trực tuyến",
                                desc = "Chọn bác sĩ, chuyên khoa và khung giờ hẹn phù hợp trên app để nhận phiếu khám điện tử.",
                                icon = Icons.Default.CalendarMonth
                            )
                            HorizontalDivider(color = Color(0xFFF2F3FF))
                            WorkflowStepItem(
                                stepNumber = 2,
                                title = "Check-in nhanh tại bệnh viện",
                                desc = "Đến trước 15 phút, quét mã QR Thẻ KCB tại Kiosk lễ tân để lấy số thứ tự ưu tiên.",
                                icon = Icons.Default.QrCodeScanner
                            )
                            HorizontalDivider(color = Color(0xFFF2F3FF))
                            WorkflowStepItem(
                                stepNumber = 3,
                                title = "Khám & Thực hiện cận lâm sàng",
                                desc = "Vào phòng khám theo thông báo trên màn hình; thực hiện xét nghiệm, chụp chiếu nếu có chỉ định.",
                                icon = Icons.Default.MedicalServices
                            )
                            HorizontalDivider(color = Color(0xFFF2F3FF))
                            WorkflowStepItem(
                                stepNumber = 4,
                                title = "Nhận kết quả & đơn thuốc trên app",
                                desc = "Kết quả xét nghiệm, chẩn đoán hình ảnh và đơn thuốc được cập nhật tự động về máy.",
                                icon = Icons.AutoMirrored.Filled.ReceiptLong
                            )
                        }
                    }
                }
            }

            // Detailed Feature Guides
            Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                Text(
                    text = "Hướng dẫn chi tiết từng tính năng",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF131B2E)
                )

                if (selectedCategory == 0 || selectedCategory == 1) {
                    FeatureHelpCard(
                        icon = Icons.Default.CalendarToday,
                        title = "1. Cách đặt lịch khám bệnh",
                        badge = "Đặt khám",
                        steps = listOf(
                            "Nhấn vào tab 'Đặt khám' ở thanh điều hướng phía dưới màn hình.",
                            "Chọn hình thức khám: 'Theo Bác sĩ', 'Chuyên khoa' hoặc 'Khám BHYT'.",
                            "Chọn ngày khám và khung giờ còn trống (ô màu sáng hiển thị giờ tiếp nhận).",
                            "Nhập triệu chứng sơ bộ hoặc ghi chú lý do khám để bác sĩ chuẩn bị.",
                            "Nhấn 'Xác nhận đặt lịch'. Bạn sẽ nhận được mã phiếu khám điện tử và thông báo nhắc hẹn trước ca khám."
                        )
                    )
                }

                if (selectedCategory == 0 || selectedCategory == 2) {
                    FeatureHelpCard(
                        icon = Icons.Default.Science,
                        title = "2. Cách tra cứu kết quả cận lâm sàng",
                        badge = "Kết quả CLS",
                        steps = listOf(
                            "Chọn tab 'Kết quả CLS' tại thanh dưới màn hình.",
                            "Lọc theo loại: 'Xét nghiệm', 'X-quang', 'Nội soi' hoặc 'Tất cả'.",
                            "Bấm vào từng phiếu để xem chi tiết chỉ số xét nghiệm cùng giới hạn bình thường/bất thường.",
                            "Nhấn nút 'Tải PDF' hoặc xem hình ảnh phim chụp X-quang/MRI chất lượng cao được lưu vĩnh viễn trên tài khoản của bạn."
                        )
                    )
                }

                if (selectedCategory == 0 || selectedCategory == 3) {
                    FeatureHelpCard(
                        icon = Icons.Default.CreditCard,
                        title = "3. Sử dụng Thẻ KCB & Mã QR cá nhân",
                        badge = "Thẻ y tế",
                        steps = listOf(
                            "Truy cập tab 'Cá nhân' và chọn 'Xem mã QR thẻ KCB' ở thẻ xanh đầu trang.",
                            "Mã QR chứa Mã bệnh nhân (Mã BN) và thông tin liên thông BHYT đã mã hóa an toàn.",
                            "Tại sảnh tiếp đón bệnh viện, đưa mã QR vào đầu đọc tại Kiosk tự phục vụ để lấy số phòng khám ngay lập tức.",
                            "Không cần mang sổ khám bệnh giấy truyền thống khi đã có thẻ KCB điện tử MedCare."
                        )
                    )
                }

                if (selectedCategory == 0 || selectedCategory == 3) {
                    FeatureHelpCard(
                        icon = Icons.Default.FamilyRestroom,
                        title = "4. Quản lý hồ sơ người thân",
                        badge = "Gia đình",
                        steps = listOf(
                            "Vào tab 'Cá nhân', chọn mục 'Hồ sơ người thân'.",
                            "Nhấn 'Thêm người thân', nhập Họ tên, Ngày sinh, Quan hệ (Con cái, Bố mẹ,...) và số thẻ BHYT.",
                            "Khi đặt lịch hoặc xem kết quả, bạn có thể dễ dàng chuyển đổi qua lại giữa hồ sơ cá nhân và hồ sơ người thân."
                        )
                    )
                }
            }

            // Frequently Asked Questions (FAQ)
            if (selectedCategory == 0 || selectedCategory == 4) {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text(
                        text = "Câu hỏi thường gặp (FAQ)",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF131B2E)
                    )

                    FaqItem(
                        question = "Tôi có thể hủy hoặc dời lịch khám đã đặt không?",
                        answer = "Có. Bạn có thể vào chi tiết lịch hẹn đã đặt và chọn 'Hủy lịch' hoặc 'Đổi giờ khám' trước giờ hẹn ít nhất 02 tiếng mà không phát sinh bất kỳ khoản phí nào."
                    )

                    FaqItem(
                        question = "Ứng dụng có hỗ trợ thanh toán bảo hiểm y tế (BHYT) không?",
                        answer = "Có. MedCare tích hợp hệ thống giám định BHYT điện tử. Khi đặt khám chọn diện 'BHYT', hệ thống sẽ tự động xác thực và áp dụng mức giảm trừ đúng tuyến theo quy định Bộ Y Tế."
                    )

                    FaqItem(
                        question = "Bao lâu sau khi xét nghiệm thì có kết quả trên app?",
                        answer = "Các kết quả xét nghiệm sinh hóa, huyết học thường có sau 45–90 phút. Chẩn đoán hình ảnh (X-quang, MRI) có sau 1–2 giờ sau khi bác sĩ chuyên khoa đọc kết quả."
                    )

                    FaqItem(
                        question = "Làm sao để liên kết hồ sơ của con dưới 6 tuổi?",
                        answer = "Bạn vào 'Cá nhân' -> 'Hồ sơ người thân', chọn 'Thêm thành viên' và nhập thông tin Giấy khai sinh hoặc mã thẻ BHYT trẻ em để đồng bộ hồ sơ tiêm chủng và khám nhi."
                    )
                }
            }

            // Contact & Support Hotline Card
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
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFFEAEDFF),
                            modifier = Modifier.size(40.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.SupportAgent,
                                    contentDescription = null,
                                    tint = Color(0xFF006194)
                                )
                            }
                        }
                        Column {
                            Text(
                                text = "Bạn vẫn cần hỗ trợ thêm?",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF131B2E)
                            )
                            Text(
                                text = "Đội ngũ CSKH MedCare luôn sẵn sàng hỗ trợ bạn 24/7",
                                fontSize = 12.sp,
                                color = Color(0xFF707881)
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006194)),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(Icons.Default.Phone, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("1900 1234", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                        }

                        OutlinedButton(
                            onClick = { },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(Icons.Default.Email, contentDescription = null, modifier = Modifier.size(16.dp), tint = Color(0xFF006194))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Gửi phản hồi", fontSize = 13.sp, color = Color(0xFF006194))
                        }
                    }
                }
            }

            // Footer
            Text(
                text = "MedCare v2.4 • Hướng dẫn sử dụng & Trợ giúp y tế",
                fontSize = 11.sp,
                color = Color(0xFF707881),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
}

@Composable
private fun WorkflowStepItem(
    stepNumber: Int,
    title: String,
    desc: String,
    icon: ImageVector
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.Top
    ) {
        Surface(
            shape = CircleShape,
            color = Color(0xFF006194),
            modifier = Modifier.size(28.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = "$stepNumber",
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Column(modifier = Modifier.weight(1f)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF131B2E)
                )
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color(0xFF006194),
                    modifier = Modifier.size(14.dp)
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = desc,
                fontSize = 12.sp,
                color = Color(0xFF3F4850),
                lineHeight = 16.sp
            )
        }
    }
}

@Composable
private fun FeatureHelpCard(
    icon: ImageVector,
    title: String,
    badge: String,
    steps: List<String>
) {
    var expanded by remember { mutableStateOf(true) }

    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFFEAEDFF),
                        modifier = Modifier.size(34.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(icon, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(18.dp))
                        }
                    }
                    Column {
                        Text(
                            text = title,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF131B2E)
                        )
                        Surface(
                            color = Color(0xFFEAEDFF),
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = badge,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF006194),
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }

                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = if (expanded) "Thu gọn" else "Mở rộng",
                        tint = Color(0xFF707881)
                    )
                }
            }

            AnimatedVisibility(visible = expanded) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(top = 6.dp)
                ) {
                    steps.forEachIndexed { idx, step ->
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.Top
                        ) {
                            Surface(
                                shape = CircleShape,
                                color = Color(0xFFE2E7FF),
                                modifier = Modifier.size(18.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text(
                                        text = "${idx + 1}",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF006194)
                                    )
                                }
                            }
                            Text(
                                text = step,
                                fontSize = 12.sp,
                                color = Color(0xFF3F4850),
                                lineHeight = 17.sp,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun FaqItem(
    question: String,
    answer: String
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = question,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF131B2E),
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = if (expanded) "Thu gọn" else "Xem trả lời",
                    tint = Color(0xFF006194),
                    modifier = Modifier.size(20.dp)
                )
            }

            AnimatedVisibility(visible = expanded) {
                Column(modifier = Modifier.padding(top = 8.dp)) {
                    HorizontalDivider(color = Color(0xFFF2F3FF))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = answer,
                        fontSize = 12.sp,
                        color = Color(0xFF3F4850),
                        lineHeight = 17.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PatientHelpScreenPreview() {
    PatientHelpScreen()
}
