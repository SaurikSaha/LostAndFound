package com.example.lostandfound

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignUp: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth= FirebaseAuth.getInstance()
        edtEmail=findViewById(R.id.email)
        edtPassword=findViewById(R.id.password)
        btnLogin=findViewById(R.id.login)
        btnSignUp=findViewById(R.id.signup)

        btnSignUp.setOnClickListener{
            val intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener{
            val email=edtEmail.text.toString()
            val password =edtPassword.text.toString()

            login(email,password)
        }
    }
    private fun login(email: String,password: String){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent=Intent(this@LoginActivity,HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this@LoginActivity,"Invalid credentials", Toast.LENGTH_SHORT).show()
                }
            }
    }
}