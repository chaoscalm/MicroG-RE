/*
 * SPDX-FileCopyrightText: 2020, microG Project Team
 * SPDX-License-Identifier: Apache-2.0
 */
package org.microg.gms.checkin

import android.content.Context
import android.content.Intent
import org.microg.gms.settings.SettingsContract
import org.microg.gms.settings.SettingsContract.CheckIn
import org.microg.gms.settings.SettingsContract.setSettings

object CheckinPreferences {

    @JvmStatic
    fun isEnabled(context: Context): Boolean {
        val projection = arrayOf(CheckIn.ENABLED)
        return SettingsContract.getSettings(
            context,
            CheckIn.getContentUri(context),
            projection
        ) { c ->
            c.getInt(0) != 0
        }
    }

    @JvmStatic
    fun setEnabled(context: Context, enabled: Boolean) {
        SettingsContract.setSettings(context, CheckIn.getContentUri(context)) {
            put(CheckIn.ENABLED, enabled)
        }
        if (enabled) {
            context.sendOrderedBroadcast(Intent(context, TriggerReceiver::class.java), null)
        }
    }

    @JvmStatic
    fun isSpoofingEnabled(context: Context): Boolean? {
        val projection = arrayOf(CheckIn.BRAND_SPOOF)
        return CheckIn.getContentUri(context)?.let {
            SettingsContract.getSettings(context, it, projection) { c ->
                c.getInt(0) != 0
            }
        }
    }

    @JvmStatic
    fun setSpoofingEnabled(context: Context, enabled: Boolean) {
        CheckIn.getContentUri(context)?.let {
            setSettings(context, it) {
                put(CheckIn.BRAND_SPOOF, enabled)
            }
        }
    }

//    @JvmStatic
//    fun hideLauncherIcon(context: Context, enabled: Boolean) {
//        CheckIn.getContentUri(context)?.let {
//            setSettings(context, it) {
//                put(CheckIn.HIDE_LAUNCHER_ICON, enabled)
//            }
//        }
//    }
}
