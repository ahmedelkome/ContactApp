package com.route.contactsapp.datacontact

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contacts(val name:String,val phone:String,val description:String):Parcelable