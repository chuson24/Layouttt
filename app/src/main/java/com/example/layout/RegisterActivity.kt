package com.example.layout


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Kết nối View từ giao diện
        val edtUser = findViewById<EditText>(R.id.edtUser)
        val edtPassWord = findViewById<EditText>(R.id.edtPassWord)
        val btSignin = findViewById<Button>(R.id.btSignin)

        // Xử lý nút Đăng ký
        btSignin.setOnClickListener {
            val username = edtUser.text.toString()
            val password = edtPassWord.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show()
            } else {
                // Xử lý logic đăng ký (có thể lưu thông tin vào cơ sở dữ liệu)
                Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show()

                // Quay lại màn hình Đăng nhập
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}