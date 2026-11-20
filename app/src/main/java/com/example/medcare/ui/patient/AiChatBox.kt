package com.example.medcare.ui.patient

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// --- Data model ---------------------------------------------------------

data class ChatMessage(
    val id: Int,
    val text: String,
    val isUser: Boolean,
    val timestamp: String = ""
)

private val sampleMessages = listOf(
    ChatMessage(0, "Xin chào! Tôi là MedCare AI, trợ lý y tế thông minh của bạn. Tôi có thể giúp gì cho bạn hôm nay?", false, "09:00"),
    ChatMessage(1, "Tôi muốn đặt lịch khám tim mạch, bạn có thể hướng dẫn tôi không?", true, "09:01"),
    ChatMessage(2, "Tất nhiên! Để đặt lịch khám Tim Mạch, bạn vào tab **Đặt khám** ở thanh dưới → chọn **Chuyên khoa** → chọn **Tim Mạch** → chọn bác sĩ và khung giờ phù hợp. Bạn có muốn tôi gợi ý bác sĩ chuyên khoa không?", false, "09:01"),
)

private val quickReplies = listOf(
    "📅 Đặt lịch khám",
    "🔬 Xem kết quả xét nghiệm",
    "💊 Nhắc uống thuốc",
    "🏥 Tìm bác sĩ",
)

// --- Main composable ----------------------------------------------------

@Composable
fun AiChatBox(
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(false) }
    var inputText by remember { mutableStateOf("") }
    val messages = remember { mutableStateListOf(*sampleMessages.toTypedArray()) }
    var nextId by remember { mutableStateOf(sampleMessages.size) }
    val listState = rememberLazyListState()

    // Scroll to bottom whenever messages change
    LaunchedEffect(messages.size) {
        if (messages.isNotEmpty()) {
            listState.animateScrollToItem(messages.size - 1)
        }
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomEnd
    ) {
        // ── Chat panel ──────────────────────────────────────────────────
        AnimatedVisibility(
            visible = isExpanded,
            enter = expandVertically(
                expandFrom = Alignment.Bottom,
                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
            ) + fadeIn(),
            exit = shrinkVertically(shrinkTowards = Alignment.Bottom) + fadeOut()
        ) {
            Card(
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 16.dp, bottomEnd = 16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F9FF)),
                modifier = Modifier
                    .width(340.dp)
                    .height(480.dp)
                    .padding(bottom = 72.dp) // above FAB
            ) {
                Column(modifier = Modifier.fillMaxSize()) {

                    // Header
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                Brush.horizontalGradient(
                                    listOf(Color(0xFF006194), Color(0xFF00897B))
                                )
                            )
                            .padding(horizontal = 16.dp, vertical = 12.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            // AI avatar
                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(CircleShape)
                                    .background(Color.White.copy(alpha = 0.2f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.AutoAwesome,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(20.dp)
                                )
                            }

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "MedCare AI",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(6.dp)
                                            .clip(CircleShape)
                                            .background(Color(0xFF69F0AE))
                                    )
                                    Text(
                                        text = "Trực tuyến • Phản hồi ngay",
                                        color = Color.White.copy(alpha = 0.85f),
                                        fontSize = 11.sp
                                    )
                                }
                            }

                            IconButton(
                                onClick = { isExpanded = false },
                                modifier = Modifier.size(32.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowDown,
                                    contentDescription = "Đóng chat",
                                    tint = Color.White
                                )
                            }
                        }
                    }

                    // Message list
                    LazyColumn(
                        state = listState,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(messages) { msg ->
                            ChatBubble(message = msg)
                        }
                    }

                    // Quick replies
                    if (messages.size <= sampleMessages.size) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp, vertical = 4.dp),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = "Gợi ý nhanh:",
                                fontSize = 11.sp,
                                color = Color(0xFF707881),
                                fontWeight = FontWeight.Medium
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                quickReplies.take(2).forEach { reply ->
                                    SuggestionChip(
                                        onClick = {
                                            messages.add(
                                                ChatMessage(nextId++, reply, true)
                                            )
                                        },
                                        label = {
                                            Text(
                                                reply,
                                                fontSize = 11.sp,
                                                maxLines = 1
                                            )
                                        },
                                        modifier = Modifier.weight(1f),
                                        colors = SuggestionChipDefaults.suggestionChipColors(
                                            containerColor = Color(0xFFEAEDFF)
                                        ),
                                        border = SuggestionChipDefaults.suggestionChipBorder(
                                            enabled = true,
                                            borderColor = Color(0xFFD0D5FF)
                                        )
                                    )
                                }
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                quickReplies.drop(2).forEach { reply ->
                                    SuggestionChip(
                                        onClick = {
                                            messages.add(
                                                ChatMessage(nextId++, reply, true)
                                            )
                                        },
                                        label = {
                                            Text(
                                                reply,
                                                fontSize = 11.sp,
                                                maxLines = 1
                                            )
                                        },
                                        modifier = Modifier.weight(1f),
                                        colors = SuggestionChipDefaults.suggestionChipColors(
                                            containerColor = Color(0xFFEAEDFF)
                                        ),
                                        border = SuggestionChipDefaults.suggestionChipBorder(
                                            enabled = true,
                                            borderColor = Color(0xFFD0D5FF)
                                        )
                                    )
                                }
                            }
                        }
                    }

                    HorizontalDivider(color = Color(0xFFE8ECFF))

                    // Input row
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(horizontal = 10.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = inputText,
                            onValueChange = { inputText = it },
                            placeholder = {
                                Text(
                                    "Hỏi về sức khỏe, lịch khám...",
                                    fontSize = 12.sp,
                                    color = Color(0xFFA0A8B0)
                                )
                            },
                            shape = RoundedCornerShape(24.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = Color(0xFFF4F5FF),
                                unfocusedContainerColor = Color(0xFFF4F5FF),
                                focusedBorderColor = Color(0xFF006194),
                                unfocusedBorderColor = Color.Transparent
                            ),
                            modifier = Modifier.weight(1f),
                            maxLines = 3,
                            textStyle = LocalTextStyle.current.copy(fontSize = 13.sp)
                        )

                        // Send button
                        val canSend = inputText.isNotBlank()
                        FilledIconButton(
                            onClick = {
                                if (canSend) {
                                    messages.add(ChatMessage(nextId++, inputText.trim(), true))
                                    inputText = ""
                                }
                            },
                            enabled = canSend,
                            colors = IconButtonDefaults.filledIconButtonColors(
                                containerColor = Color(0xFF006194),
                                disabledContainerColor = Color(0xFFD8E2F0)
                            ),
                            modifier = Modifier.size(42.dp)
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.Send,
                                contentDescription = "Gửi",
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                }
            }
        }

        // ── FAB ─────────────────────────────────────────────────────────
        val fabSize by animateDpAsState(
            targetValue = if (isExpanded) 48.dp else 56.dp,
            animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
            label = "fabSize"
        )

        Box(
            modifier = Modifier
                .size(fabSize)
                .shadow(
                    elevation = 8.dp,
                    shape = CircleShape,
                    ambientColor = Color(0xFF006194).copy(alpha = 0.3f),
                    spotColor = Color(0xFF006194).copy(alpha = 0.4f)
                )
                .clip(CircleShape)
                .background(
                    Brush.radialGradient(
                        listOf(Color(0xFF00A0C8), Color(0xFF006194))
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            FloatingActionButton(
                onClick = { isExpanded = !isExpanded },
                containerColor = Color.Transparent,
                elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                if (isExpanded) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Đóng AI Chat",
                        tint = Color.White,
                        modifier = Modifier.size(22.dp)
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.AutoAwesome,
                        contentDescription = "Mở AI Chat",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

// --- Chat bubble --------------------------------------------------------

@Composable
private fun ChatBubble(message: ChatMessage) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (message.isUser) Arrangement.End else Arrangement.Start,
        verticalAlignment = Alignment.Bottom
    ) {
        // AI avatar
        if (!message.isUser) {
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(
                        Brush.radialGradient(
                            listOf(Color(0xFF00A0C8), Color(0xFF006194))
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.AutoAwesome,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(14.dp)
                )
            }
            Spacer(modifier = Modifier.width(6.dp))
        }

        Column(
            horizontalAlignment = if (message.isUser) Alignment.End else Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp,
                            bottomStart = if (message.isUser) 16.dp else 4.dp,
                            bottomEnd = if (message.isUser) 4.dp else 16.dp
                        )
                    )
                    .background(
                        if (message.isUser) Color(0xFF006194)
                        else Color.White
                    )
                    .padding(horizontal = 12.dp, vertical = 8.dp)
                    .widthIn(max = 230.dp)
            ) {
                Text(
                    text = message.text,
                    fontSize = 13.sp,
                    color = if (message.isUser) Color.White else Color(0xFF131B2E),
                    lineHeight = 18.sp
                )
            }

            if (message.timestamp.isNotEmpty()) {
                Text(
                    text = message.timestamp,
                    fontSize = 10.sp,
                    color = Color(0xFFA0A8B0),
                    textAlign = if (message.isUser) TextAlign.End else TextAlign.Start
                )
            }
        }

        // User avatar
        if (message.isUser) {
            Spacer(modifier = Modifier.width(6.dp))
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE2E7FF)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = Color(0xFF006194),
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

// --- Preview ------------------------------------------------------------

@Preview(showBackground = true, backgroundColor = 0xFFF5F5F5)
@Composable
fun AiChatBoxPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        AiChatBox()
    }
}
