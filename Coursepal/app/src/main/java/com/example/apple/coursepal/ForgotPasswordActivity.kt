package com.example.apple.coursepal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import android.view.View
import android.widget.Toast
import android.text.TextUtils
import android.util.Log
import android.content.Intent

class ForgotPasswordActivity : AppCompatActivity() {
    private val TAG = "ForgotPasswordActivity"

    //UI elements
    private var etEmail: EditText? = null
    private var btnSubmit: Button? = null

    //Firebase references
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        initialise()
    }

    private fun initialise() {
        Log.d(TAG,"1")
        etEmail = findViewById(R.id.et_email) as EditText
        btnSubmit = findViewById(R.id.btn_submit) as Button

        mAuth = FirebaseAuth.getInstance()

        btnSubmit!!.setOnClickListener { sendPasswordResetEmail() }
    }

    private fun sendPasswordResetEmail() {
        Log.d(TAG,"2")
        val email = etEmail?.text.toString()

        if (!TextUtils.isEmpty(email)) {
            mAuth!!
                    .sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {

                            val message = "Email sent."
                            Log.d(TAG, message)
                            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                            updateUI()
                        } else {
                            Log.w(TAG, task.exception!!.message)
                            Toast.makeText(this, "No user found with this email.", Toast.LENGTH_SHORT).show()
                        }
                    }
        } else {
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI() {
        Log.d(TAG,"-3")
        val intent = Intent(this@ForgotPasswordActivity, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
