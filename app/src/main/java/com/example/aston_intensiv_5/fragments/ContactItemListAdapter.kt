package com.example.aston_intensiv_5.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.aston_intensiv_5.R
import com.example.aston_intensiv_5.extentions.find
import com.example.aston_intensiv_5.data.ContactItem

class ContactItemListAdapter(
    context: Context,
    resource: Int,
    private val list: ArrayList<ContactItem>
) : ArrayAdapter<ContactItem>(context, resource, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItem = convertView

        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.list_item, null)
            listItem!!
        }

        val contactItem = list[position]
        val textViewItemFirstName by listItem.find<TextView>(R.id.text_view_item_first_name)
        val textViewItemSecondName by listItem.find<TextView>(R.id.text_view_item_second_name)

        textViewItemFirstName.text = contactItem.firstName
        textViewItemSecondName.text = contactItem.secondName

        return listItem
    }

}