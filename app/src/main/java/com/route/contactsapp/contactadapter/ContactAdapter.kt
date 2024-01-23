package com.route.contactsapp.contactadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.contactsapp.R
import com.route.contactsapp.datacontact.Contacts

class ContactAdapter(val contactsList : List<Contacts>) : RecyclerView.Adapter<ContactAdapter.contactViewHolder>() {
    class contactViewHolder(itemview: View) : ViewHolder(itemview)
    {
        val name :TextView = itemview.findViewById(R.id.name)
        val phone :TextView = itemview.findViewById(R.id.phone)
        val description : TextView = itemview.findViewById(R.id.description)

        fun bind(contact : Contacts){
            name.text = contact.name
            phone.text = contact.phone
            description.text = contact.description
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): contactViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contact
            ,parent
            ,false)

        return contactViewHolder(view)
    }

    override fun getItemCount(): Int = contactsList.size

    override fun onBindViewHolder(holder: contactViewHolder, position: Int) {
        val contact = contactsList[position]
        holder.bind(contact)
        holder.itemView.setOnClickListener {
            lisnner?.onclick(contact)
        }

    }

    interface onContactClick{
        fun onclick(contact:Contacts)
    }
    var lisnner : onContactClick? = null

}