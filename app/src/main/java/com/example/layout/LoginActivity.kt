package com.example.layout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Khởi tạo FirebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()

        // Kết nối View từ giao diện
        val edtUser = findViewById<EditText>(R.id.edtUser)
        val edtPassWord = findViewById<EditText>(R.id.edtPassWord)
        val btSignin = findViewById<Button>(R.id.btSignin)
        val tvSwitchToRegister = findViewById<TextView>(R.id.tvSwitchToRegister)

        // Xử lý nút Đăng nhập
        btSignin.setOnClickListener {
            val email = edtUser.text.toString().trim()
            val password = edtPassWord.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show()
            } else {
                loginUser(email, password)
            }
        }

        // Chuyển sang màn hình Đăng ký
        tvSwitchToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginUser(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Đăng nhập thành công
                    Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show()
                    // Chuyển về màn hình chính (MainActivity)
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Kết thúc LoginActivity
                } else {
                    // Đăng nhập thất bại
                    val errorMessage = task.exception?.message ?: "Đăng nhập thất bại!"
                    Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
    }
}
