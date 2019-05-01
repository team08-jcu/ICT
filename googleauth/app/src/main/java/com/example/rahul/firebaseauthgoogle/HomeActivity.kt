package com.example.rahul.firebaseauthgoogle


import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.homeactivity.*


class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
    private fun signOut() {
        startActivity(SignInActivity.getLaunchIntent(this))
        FirebaseAuth.getInstance().signOut();
    }
    private fun setupUI() {
        sign_out_button.setOnClickListener {
            signOut()
        }
    }
    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, HomeActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }
}