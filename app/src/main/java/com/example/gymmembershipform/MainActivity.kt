package com.example.gymmembershipform

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var dobEditText: EditText
    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var membershipSpinner: Spinner
    private lateinit var termsCheckBox: CheckBox
    private lateinit var submitButton: Button
    private lateinit var visitWebsiteButton: Button
    private lateinit var socialMediaButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        initViews()

        // Set click listeners
        setClickListeners()
    }

    private fun initViews() {
        nameEditText = findViewById(R.id.nameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        phoneEditText = findViewById(R.id.phoneEditText)
        dobEditText = findViewById(R.id.dobEditText)
        genderRadioGroup = findViewById(R.id.genderRadioGroup)
        membershipSpinner = findViewById(R.id.membershipSpinner)
        termsCheckBox = findViewById(R.id.termsCheckBox)
        submitButton = findViewById(R.id.submitButton)
        visitWebsiteButton = findViewById(R.id.visitWebsiteButton)
        socialMediaButton = findViewById(R.id.socialMediaButton)
    }

    private fun setClickListeners() {
        submitButton.setOnClickListener {
            validateAndSubmitForm()
        }

        visitWebsiteButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com"))
            startActivity(intent)
        }

        socialMediaButton.setOnClickListener {
            val intent = Intent(this, SocialMediaActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validateAndSubmitForm() {
        val name = nameEditText.text.toString().trim()
        val email = emailEditText.text.toString().trim()
        val phone = phoneEditText.text.toString().trim()
        val dob = dobEditText.text.toString().trim()
        val gender = when (genderRadioGroup.checkedRadioButtonId) {
            R.id.maleRadioButton -> "Male"
            R.id.femaleRadioButton -> "Female"
            else -> ""
        }
        val membershipType = membershipSpinner.selectedItem.toString()
        val termsChecked = termsCheckBox.isChecked

        if (TextUtils.isEmpty(name)) {
            nameEditText.error = "Please enter your name"
            return
        }

        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.error = "Please enter a valid email address"
            return
        }

        if (TextUtils.isEmpty(phone) || !isValidPhoneNumber(phone)) {
            phoneEditText.error = "Please enter a valid phone number"
            return
        }

        if (TextUtils.isEmpty(dob)) {
            dobEditText.error = "Please enter your date of birth"
            return
        }

        if (TextUtils.isEmpty(gender)) {
            Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show()
            return
        }

        if (!termsChecked) {
            Toast.makeText(this, "Please agree to the terms and conditions", Toast.LENGTH_SHORT)
                .show()
            return
        }


        // Navigate to DisplayUserDataActivity
        val intent = Intent(this, DisplayUserDataActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("email", email)
        intent.putExtra("phone", phone)
        intent.putExtra("dob", dob)
        intent.putExtra("gender", gender)
        intent.putExtra("membershipType", membershipType)
        startActivity(intent)
    }

    private fun isValidPhoneNumber(phone: String): Boolean {
        // Implement phone number validation logic here
        if(phone.length==10)
        {
            return true
        }
        return false
    }


}