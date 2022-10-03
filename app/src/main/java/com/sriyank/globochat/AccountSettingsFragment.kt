package com.sriyank.globochat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.preference.MultiSelectListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceCategory
import androidx.preference.PreferenceFragmentCompat


class AccountSettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {

        val publicInfoPref = context?.let { MultiSelectListPreference(it) }
        publicInfoPref?.entries = resources.getStringArray(R.array.entries_public_info)
        publicInfoPref?.entryValues = resources.getStringArray(R.array.values_auto_reply_time)
        publicInfoPref?.key = getString(R.string.key_public_info)
        publicInfoPref?.title = getString(R.string.title_public_info)
        publicInfoPref?.isIconSpaceReserved = false

        val logOutPref = context?.let { Preference(it) }
        logOutPref?.key = getString(R.string.key_log_out)
        logOutPref?.title = getString(R.string.title_log_out)
        logOutPref?.isIconSpaceReserved = false

        val deleteAccPref = context?.let { Preference(it) }
        deleteAccPref?.key = getString(R.string.key_delete_account)
        deleteAccPref?.summary = getString(R.string.summary_delete_account)
        deleteAccPref?.title = getString(R.string.title_delete_account)
        deleteAccPref?.icon = ResourcesCompat.getDrawable(resources, android.R.drawable.ic_menu_delete, null)

        val privacyCategory = context?.let { PreferenceCategory(it) }
        privacyCategory?.title = getString(R.string.title_privacy)
        privacyCategory?.isIconSpaceReserved = false

        val securityCategory = context?.let { PreferenceCategory(it) }
        securityCategory?.title = getString(R.string.title_security)
        securityCategory?.isIconSpaceReserved = false

        val prefScreen = context?.let { preferenceManager.createPreferenceScreen(it) }

        // Step 2: Add all the Preference objects in hierarchy
        if (privacyCategory != null) {
            prefScreen?.addPreference(privacyCategory)
        }
        if (securityCategory != null) {
            prefScreen?.addPreference(securityCategory)
        }

        if (publicInfoPref != null) {
            privacyCategory?.addPreference(publicInfoPref)
        }

        if (logOutPref != null) {
            securityCategory?.addPreference(logOutPref)
        }
        if (deleteAccPref != null) {
            securityCategory?.addPreference(deleteAccPref)
        }

        // Step 3: Set the preference screen
        preferenceScreen = prefScreen
    }
}