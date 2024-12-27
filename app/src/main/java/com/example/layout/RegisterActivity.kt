package com.example.layout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Khởi tạo FirebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()

        // Kết nối View từ giao diện
        val edtUser = findViewById<EditText>(R.id.edtUser)
        val edtPassWord = findViewById<EditText>(R.id.edtPassWord)
        val btSignin = findViewById<Button>(R.id.btSignin)

        // Xử lý nút Đăng ký
        btSignin.setOnClickListener {
            val email = edtUser.text.toString().trim()
            val password = edtPassWord.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show()
            } else {
                registerUser(email, password)
            }
        }
    }

    private fun registerUser(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Đăng ký thành công
                    Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show()
                    // Chuyển về màn hình chính (MainActivity)
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Kết thúc RegisterActivity
                } else {
                    // Đăng ký thất bại
                    val errorMessage = task.exception?.message ?: "Đăng ký thất bại!"
                    Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
    }
}
