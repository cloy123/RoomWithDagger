package com.monsieur.cloy.roomexample.utils

import androidx.fragment.app.Fragment
import com.monsieur.cloy.roomexample.R

fun replaceFragment(fragment: Fragment, addStack: Boolean = true) {
    if (addStack) {
        APP_ACTIVITY.supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(
                R.id.container,
                fragment
            ).commit()
    } else {
        APP_ACTIVITY.supportFragmentManager.beginTransaction()
            .replace(
                R.id.container,
                fragment
            ).commit()
    }
}