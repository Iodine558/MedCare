package com.example.medcare.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(onLoginSuccess: (Int) -> Unit = {}) {
    var selectedRole by remember { mutableStateOf(0) } // 0: Patient, 1: Doctor, 2: Admin
    var idNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var rememberMe by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF8FF))
            .statusBarsPadding()
            .verticalScroll(scrollState)
            .padding(bottom = 24.dp)
    ) {
        // Header
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
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF006194)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.LocalHospital, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
                }
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("MedCare", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0xFF006194))
                        Icon(Icons.Default.Verified, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(14.dp))
                    }
                    Text("HIS / EMR PORT", fontWeight = FontWeight.Bold, fontSize = 11.sp, color = Color(0xFF3F4850))
                }
            }
            Text("•", color = Color(0xFF707881), fontSize = 16.sp)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Top Brand & Trust Intro
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color(0xFF006194)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.HealthAndSafety, contentDescription = null, tint = Color.White, modifier = Modifier.size(24.dp))
                    }
                    Column {
                        Text("Cổng Y tế MedCare", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color(0xFF131B2E))
                        Text("Hệ thống Quản lý Bệnh viện & EMR", fontSize = 13.sp, color = Color(0xFF3F4850))
                    }
                }

                Surface(
                    color = Color(0xFFEAEDFF),
                    shape = RoundedCornerShape(99.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(Icons.Default.Phone, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(12.dp))
                        Text("1900 8866", color = Color(0xFF006194), fontWeight = FontWeight.Bold, fontSize = 11.sp)
                    }
                }
            }

            // Visual Clinical Banner
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF131B2E)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(112.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("HỒ SƠ BỆNH ÁN ĐIỆN TỬ", color = Color(0xFF89F5E7), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        Text("Chăm sóc sức khỏe thông minh", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Text("Truy cập hồ sơ bệnh án, lịch khám và kết quả xét nghiệm", color = Color(0xFFE2E7FF), fontSize = 13.sp)
                    }
                }
            }

            // Role Segmented Tabs
            Surface(
                color = Color(0xFFE2E7FF),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    RoleTab(title = "Bệnh nhân", icon = Icons.Default.Person, selected = selectedRole == 0, onClick = { selectedRole = 0 }, modifier = Modifier.weight(1f))
                    RoleTab(title = "Bác sĩ", icon = Icons.Default.LocalHospital, selected = selectedRole == 1, onClick = { selectedRole = 1 }, modifier = Modifier.weight(1f))
                    RoleTab(title = "Quản trị", icon = Icons.Default.AdminPanelSettings, selected = selectedRole == 2, onClick = { selectedRole = 2 }, modifier = Modifier.weight(1f))
                }
            }

            // Main Authentication Form Card
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // ID Number Field
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text("Số định danh CCCD / BHYT", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                        OutlinedTextField(
                            value = idNumber,
                            onValueChange = { idNumber = it },
                            placeholder = { Text("12 số CCCD hoặc BHYT...", color = Color(0xFF707881), fontSize = 14.sp) },
                            leadingIcon = { Icon(Icons.Default.Badge, contentDescription = null, tint = Color(0xFF707881)) },
                            trailingIcon = {
                                TextButton(onClick = { }) {
                                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                        Icon(Icons.Default.QrCodeScanner, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(14.dp))
                                        Text("Quét QR", color = Color(0xFF006194), fontWeight = FontWeight.Bold, fontSize = 11.sp)
                                    }
                                }
                            },
                            shape = RoundedCornerShape(12.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedContainerColor = Color(0xFFF2F3FF),
                                focusedContainerColor = Color(0xFFF2F3FF),
                                unfocusedBorderColor = Color.Transparent,
                                focusedBorderColor = Color(0xFF006194)
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    // Password Field
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Mật khẩu", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF131B2E))
                            TextButton(onClick = { }) {
                                Text("Quên mật khẩu?", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF006194))
                            }
                        }
                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            placeholder = { Text("••••••••••••", color = Color(0xFF707881), fontSize = 14.sp) },
                            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null, tint = Color(0xFF707881)) },
                            trailingIcon = {
                                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                    Icon(
                                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                        contentDescription = "Hiện/ẩn mật khẩu",
                                        tint = Color(0xFF707881)
                                    )
                                }
                            },
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            shape = RoundedCornerShape(12.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedContainerColor = Color(0xFFF2F3FF),
                                focusedContainerColor = Color(0xFFF2F3FF),
                                unfocusedBorderColor = Color.Transparent,
                                focusedBorderColor = Color(0xFF006194)
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    // Remember Me
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Checkbox(checked = rememberMe, onCheckedChange = { rememberMe = it })
                        Text("Ghi nhớ đăng nhập", fontSize = 13.sp, color = Color(0xFF3F4850))
                    }

                    // Login Button
                    Button(
                        onClick = { onLoginSuccess(selectedRole) },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006194)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text("Đăng nhập", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                    }

                    // Biometric Login Button
                    Button(
                        onClick = { onLoginSuccess(selectedRole) },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEAEDFF)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                    ) {
                        Icon(Icons.Default.Fingerprint, contentDescription = null, tint = Color(0xFF006194), modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Đăng nhập bằng Sinh trắc học", color = Color(0xFF006194), fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
                    }

                    // Divider
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        HorizontalDivider(modifier = Modifier.weight(1f), color = Color(0x80BFC7D2))
                        Text("HOẶC TIẾP TỤC VỚI", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF707881))
                        HorizontalDivider(modifier = Modifier.weight(1f), color = Color(0x80BFC7D2))
                    }

                    // Social / VNeID & BHYT buttons
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Button(
                            onClick = { onLoginSuccess(selectedRole) },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF2F3FF)),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(44.dp)
                        ) {
                            Icon(Icons.Default.VerifiedUser, contentDescription = null, tint = Color(0xFFBA1A1A), modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("VNeID", color = Color(0xFF131B2E), fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
                        }
                        Button(
                            onClick = { onLoginSuccess(selectedRole) },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF2F3FF)),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(44.dp)
                        ) {
                            Icon(Icons.Default.MedicalServices, contentDescription = null, tint = Color(0xFF006A61), modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Thẻ BHYT", color = Color(0xFF131B2E), fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
                        }
                    }

                    // Help Links
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextButton(onClick = { }) {
                            Text("Hỗ trợ kỹ thuật", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF707881))
                        }
                        Text("•", color = Color(0xFFBFC7D2), fontSize = 16.sp)
                        TextButton(onClick = { }) {
                            Text("Hướng dẫn đăng ký", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF707881))
                        }
                    }
                }
            }

            // Footer Compliance
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Điều khoản sử dụng", fontSize = 13.sp, color = Color(0xFF707881))
                    Text("•", fontSize = 13.sp, color = Color(0xFF707881))
                    Text("Chính sách bảo mật", fontSize = 13.sp, color = Color(0xFF707881))
                }
                Text(
                    "© 2024 MedCare Smart Hospital Systems. Chuẩn BYT & ISO 27001.",
                    fontSize = 13.sp,
                    color = Color(0xFF707881),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun RoleTab(title: String, icon: androidx.compose.ui.graphics.vector.ImageVector, selected: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Surface(
        onClick = onClick,
        color = if (selected) Color.White else Color.Transparent,
        shape = RoundedCornerShape(8.dp),
        shadowElevation = if (selected) 1.dp else 0.dp,
        modifier = modifier.height(40.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                icon,
                contentDescription = null,
                tint = if (selected) Color(0xFF006194) else Color(0xFF3F4850),
                modifier = Modifier.size(15.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                title,
                fontSize = 11.sp,
                fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
                color = if (selected) Color(0xFF006194) else Color(0xFF3F4850)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}

