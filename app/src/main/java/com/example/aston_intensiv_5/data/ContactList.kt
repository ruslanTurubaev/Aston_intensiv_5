package com.example.aston_intensiv_5.data

class ContactList {

    private val contactList = ArrayList<ContactItem>()

    init {
        contactList.add(
            ContactItem(
                id = 0,
                firstName = "John",
                secondName = "Smith",
                telNumber = "74727732824"
            )
        )
        contactList.add(
            ContactItem(
                id = 1,
                firstName = "Kim",
                secondName = "Po",
                telNumber = "1234567"
            )
        )
        contactList.add(
            ContactItem(
                id = 2,
                firstName = "Bill",
                secondName = "Blake",
                telNumber = "98271893"
            )
        )
        contactList.add(
            ContactItem(
                id = 3,
                firstName = "Rick",
                secondName = "Sanchez",
                telNumber = "59251931"
            )
        )
    }

    fun getContactList(): ArrayList<ContactItem> {
        return contactList
    }
}