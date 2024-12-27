package com.example.layout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Kết nối View từ giao diện
        val edtUser = findViewById<EditText>(R.id.edtUser)
        val edtPassWord = findViewById<EditText>(R.id.edtPassWord)
        val btSignin = findViewById<Button>(R.id.btSignin)
        val tvSwitchToRegister = findViewById<TextView>(R.id.tvSwitchToRegister)

        // Xử lý nút Đăng nhập
        btSignin.setOnClickListener {
            val username = edtUser.text.toString()
            val password = edtPassWord.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show()
            } else {
                // Xử lý logic đăng nhập (có thể tích hợp với backend)
                Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show()
            }
        }

        // Chuyển sang màn hình Đăng ký
        tvSwitchToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}