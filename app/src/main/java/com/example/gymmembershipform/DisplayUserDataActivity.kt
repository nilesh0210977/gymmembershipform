package com.example.gymmembershipform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayUserDataActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var phoneTextView: TextView
    private lateinit var dobTextView: TextView
    private lateinit var genderTextView: TextView
    private lateinit var membershipTypeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_user_data)

        initViews()
        displayUserData()
    }

    private fun initViews() {
        nameTextView = findViewById(R.id.nameTextView)
        emailTextView = findViewById(R.id.emailTextView)
        phoneTextView = findViewById(R.id.phoneTextView)
        dobTextView = findViewById(R.id.dobTextView)
        genderTextView = findViewById(R.id.genderTextView)
        membershipTypeTextView = findViewById(R.id.membershipTypeTextView)
    }

    private fun displayUserData() {
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")
        val dob = intent.getStringExtra("dob")
        val gender = intent.getStringExtra("gender")
        val membershipType = intent.getStringExtra("membershipType")

        nameTextView.text = "Name: $name"
        emailTextView.text = "Email: $email"
        phoneTextView.text = "Phone: $phone"
        dobTextView.text = "Date of Birth: $dob"
        genderTextView.text = "Gender: $gender"
        membershipTypeTextView.text = "Membership Type: $membershipType"
    }
}