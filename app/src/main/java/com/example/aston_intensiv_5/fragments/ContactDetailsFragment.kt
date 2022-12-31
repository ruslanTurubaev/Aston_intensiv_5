package com.example.aston_intensiv_5.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.aston_intensiv_5.MainViewModel
import com.example.aston_intensiv_5.R
import com.example.aston_intensiv_5.data.ContactItem
import com.example.aston_intensiv_5.extentions.CONTACT_ITEM
import com.example.aston_intensiv_5.extentions.isPhone

class ContactDetailsFragment : Fragment() {

    private val mainViewModel by activityViewModels<MainViewModel>()

    private lateinit var buttonSave: Button
    private lateinit var textViewFistName: EditText
    private lateinit var textViewSecondName: EditText
    private lateinit var textViewTelNumber: EditText

    private lateinit var contactItem: ContactItem

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contactItem = requireArguments().getSerializable(CONTACT_ITEM) as ContactItem
        return inflater.inflate(R.layout.fragment_contact_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.selectedContactItem(null)

        findViews(view)
        setTextFields(contactItem)

        buttonSave.setOnClickListener { saveData(view.context, contactItem.id) }
    }

    private fun findViews(view: View) {
        buttonSave = view.findViewById(R.id.button_save)
        textViewFistName = view.findViewById(R.id.text_view_first_name)
        textViewSecondName = view.findViewById(R.id.text_view_second_name)
        textViewTelNumber = view.findViewById(R.id.text_view_tel_number)
    }

    private fun setTextFields(contactItem: ContactItem) {
        textViewFistName.setText(contactItem.firstName)
        textViewSecondName.setText(contactItem.secondName)
        textViewTelNumber.setText(contactItem.telNumber)
    }

    private fun saveData(device: Context, itemID: Int) {
        val firstName = textViewFistName.text.toString()
        val secondName = textViewSecondName.text.toString()
        val telNumber = textViewTelNumber.text.toString()

        contactItem = ContactItem(
            id = itemID,
            firstName = firstName,
            secondName = secondName,
            telNumber = telNumber
        )

        mainViewModel.amendContactList(itemID, contactItem)

        if (device.isPhone()) {
            requireActivity().onBackPressed()
        }
    }
}