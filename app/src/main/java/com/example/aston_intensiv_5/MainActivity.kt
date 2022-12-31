package com.example.aston_intensiv_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import com.example.aston_intensiv_5.extentions.CONTACT_ITEM
import com.example.aston_intensiv_5.extentions.find
import com.example.aston_intensiv_5.extentions.isExist
import com.example.aston_intensiv_5.fragments.ContactDetailsFragment
import com.example.aston_intensiv_5.fragments.ContactItemListFragment

class MainActivity : AppCompatActivity() {

    private val secondFragmentContainer by find<FragmentContainerView>(R.id.second_fragment_container)
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                add(R.id.fragment_container, ContactItemListFragment())
            }
        }

        mainViewModel.selectedContactItem.observe(this) { selectedItem ->
            if (selectedItem != null) {
                val args = bundleOf(CONTACT_ITEM to selectedItem)

                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)

                    val contactDetailsFragment =
                        ContactDetailsFragment().also { it.arguments = args }

                    if (secondFragmentContainer.isExist()) {
                        replace(R.id.second_fragment_container, contactDetailsFragment)
                    } else {
                        replace(R.id.fragment_container, contactDetailsFragment)
                    }

                    addToBackStack(null)
                }
            }
        }
    }
}