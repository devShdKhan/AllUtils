package com.sdhkhan.everyutils

import android.content.Context
import android.location.LocationManager
import android.net.ConnectivityManager

object SHDCheckNetwork {

    fun isConnected(context: Context): Boolean {
        try {
            val connMngr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val wifiNetwork = connMngr.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
            if (wifiNetwork != null && wifiNetwork.isConnectedOrConnecting) {
                return true
            }

            val mobileNetwork = connMngr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
            if (mobileNetwork != null && mobileNetwork.isConnectedOrConnecting) {
                return true
            }

            val activeNetwork = connMngr.activeNetworkInfo
            if (activeNetwork != null && activeNetwork.isConnectedOrConnecting) {
                return true
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return false
    }

    fun isGPSTurnOn(context: Context): Boolean {
        val manager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return manager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

}
