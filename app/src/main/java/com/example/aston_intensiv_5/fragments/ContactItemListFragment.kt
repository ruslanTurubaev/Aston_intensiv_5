package com.example.aston_intensiv_5.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.ListFragment
import androidx.fragment.app.activityViewModels
import com.example.aston_intensiv_5.MainViewModel
import com.example.aston_intensiv_5.R
import com.example.aston_intensiv_5.data.ContactItem

class ContactItemListFragment : ListFragment() {

    private val mainViewModel by activityViewModels<MainViewModel>()
    private val contactList = ArrayList<ContactItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainViewModel.contactList.observe(viewLifecycleOwner) { list ->
            contactList.clear()
            contactList.addAll(list)
            val contactItemListAdapter =
                ContactItemListAdapter(requireContext(), R.layout.list_item, contactList)
            listAdapter = contactItemListAdapter
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        mainViewModel.selectedContactItem(contactList[position])
    }
}