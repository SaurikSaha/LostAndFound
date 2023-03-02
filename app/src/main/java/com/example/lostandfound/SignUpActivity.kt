package com.example.lostandfound

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnSignUp: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mAuth= FirebaseAuth.getInstance()
        edtName=findViewById(R.id.name)
        edtEmail=findViewById(R.id.email)
        edtPassword=findViewById(R.id.password)
        btnSignUp=findViewById(R.id.signup)

                btnSignUp.setOnClickListener{
                    val name=edtName.text.toString()
            val email=edtEmail.text.toString()
            val password =edtPassword.text.toString()

            signup(email,password)
        }
    }
    private fun signup(email: String,password: String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent=Intent(this@SignUpActivity,HomeActivity::class.java)
                    startActivity(intent)
                }
                else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this@SignUpActivity,"Some error occured",Toast.LENGTH_SHORT).show()
                }
            }
    }
}