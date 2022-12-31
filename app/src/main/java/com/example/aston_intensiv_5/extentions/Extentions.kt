package com.example.aston_intensiv_5.extentions

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.view.View

const val CONTACT_ITEM = "CONTACT_ITEM"

fun <T> unsafeLazy(initializer: () -> T) = lazy(LazyThreadSafetyMode.NONE, initializer)

fun <T : View> View.find(idRes: Int) = unsafeLazy<T> { findViewById(idRes) }

fun <T : View?> Activity.find(idRes: Int) = unsafeLazy<T?> { findViewById(idRes) }

fun View?.isExist(): Boolean = this != null

fun Context.isPhone(): Boolean =
    this.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK < Configuration.SCREENLAYOUT_SIZE_LARGE

