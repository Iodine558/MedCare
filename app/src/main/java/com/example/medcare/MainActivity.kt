package com.example.medcare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import com.example.medcare.ui.admin.AdminApp
import com.example.medcare.ui.doctor.DoctorApp
import com.example.medcare.ui.login.LoginScreen
import com.example.medcare.ui.patient.PatientApp
import com.example.medcare.ui.theme.MedCareTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MedCareTheme {
                var isLoggedIn by remember { mutableStateOf(false) }
                var userRole by remember { mutableStateOf(0) } // 0: Patient, 1: Doctor, 2: Admin

                if (!isLoggedIn) {
                    LoginScreen(
                        onLoginSuccess = { role ->
                            userRole = role
                            isLoggedIn = true
                        }
                    )
                } else {
                    when (userRole) {
                        1 -> DoctorApp(onLogout = { isLoggedIn = false })
                        2 -> AdminApp(onLogout = { isLoggedIn = false })
                        else -> PatientApp(onLogout = { isLoggedIn = false })
                    }
                }
            }
        }
    }
}
