package com.example.aston_intensiv_5

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aston_intensiv_5.data.*

class MainViewModel : ViewModel() {

    private val mutableContactList = MutableLiveData<ArrayList<ContactItem>>()
    private val mutableSelectedContactItem = MutableLiveData<ContactItem?>()

    init {
        mutableContactList.value = ContactList().getContactList()
    }

    val contactList: LiveData<ArrayList<ContactItem>> get() = mutableContactList

    val selectedContactItem: LiveData<ContactItem?> get() = mutableSelectedContactItem

    fun selectedContactItem(contactItem: ContactItem?) {
        mutableSelectedContactItem.value = contactItem
    }

    fun amendContactList(id: Int, item: ContactItem) {
        val list = mutableContactList.value
        list?.removeAt(id)
        list?.add(id, item)
        mutableContactList.value = list!!
    }
}