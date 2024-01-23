package com.route.contactsapp.contactdetailsscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.IntentCompat
import com.route.contactsapp.Constants
import com.route.contactsapp.R
import com.route.contactsapp.databinding.ActivityContactDetailsBinding
import com.route.contactsapp.datacontact.Contacts

class ContactDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityContactDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showDataContact()
        BackButton()

    }

    private fun BackButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun showDataContact(){
        val contact = IntentCompat.getParcelableExtra(intent,Constants.CONTACT,Contacts::class.java)

        contact?.let {

            binding.nameValue.text = contact.name
            binding.phoneValue.text = contact.phone
            binding.desValue.text = contact.description

        }
    }
}