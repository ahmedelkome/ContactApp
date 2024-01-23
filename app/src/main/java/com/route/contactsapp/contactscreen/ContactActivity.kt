package com.route.contactsapp.contactscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.route.contactsapp.Constants
import com.route.contactsapp.R
import com.route.contactsapp.contactadapter.ContactAdapter
import com.route.contactsapp.contactdetailsscreen.ContactDetailsActivity
import com.route.contactsapp.databinding.ActivityContactBinding
import com.route.contactsapp.datacontact.Contacts

class ContactActivity : AppCompatActivity() {
    lateinit var name:String
    lateinit var phone: String
    lateinit var Description:String
    lateinit var adapter: ContactAdapter
    val contactList = mutableListOf<Contacts>()
    lateinit var binding : ActivityContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityContactBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        showRecyclerView()
        saveButtonClick()
    }

    private fun showRecyclerView(){
        adapter = ContactAdapter(contactList)
        binding.rvContacts.adapter = adapter
        navigatetoContactDetails()
    }

    private fun navigatetoContactDetails() {
        adapter.lisnner = object : ContactAdapter.onContactClick {
            override fun onclick(contact: Contacts) {
                val intent = Intent(this@ContactActivity, ContactDetailsActivity::class.java)
                intent.putExtra(Constants.CONTACT, contact)
                startActivity(intent)
            }

        }
    }

    private fun saveButtonClick() {
        binding.btnSave.setOnClickListener {
            if (!(validateInput())) {
                return@setOnClickListener
            }

            name = binding.nameEdt1.text?.trim().toString()
            phone = binding.phoneEdt.text?.trim().toString()
            Description = binding.desEdt.text?.trim().toString()

            val contact = Contacts(name, phone, Description)
            contactList.add(contact)
            adapter.notifyItemInserted(contactList.size-1)
        }
    }

    private fun validateInput():Boolean{
        name = binding.nameEdt1.text?.trim().toString()
        phone = binding.phoneEdt.text?.trim().toString()
        binding.nameTil1.error = validateName(name)
        binding.phoneTil2.error = validatePhone(phone)

        return validateName(name)==null&&validatePhone(phone)==null
    }
    private fun validateName(name:String):String?{
        if (name.isEmpty())
            return "Required"
        if (name.trim().length<3)
            return "name should be 3 chars or more"
        return null
    }

    private fun validatePhone(phone:String):String?{
        if (phone.isEmpty())
            return "Required"
        if (phone.trim().length<11)
            return "phone should be 11 numbers"
        return null
    }
}