package com.fortatic.apps.kotlinflix.domain

import android.content.res.Resources
import android.util.DisplayMetrics
import com.fortatic.apps.kotlinflix.BuildConfig
import kotlin.math.pow
import kotlin.math.sqrt

const val SMALL_SIZE = "w200"
const val MEDIUM_SIZE = "w300"
const val LARGE_SIZE = "w400"
const val XLARGE_SIZE = "w500"
const val TABLET_SIZE = 7

fun String.toUrl(): String {
    val url = BuildConfig.IMAGE_BASE_URL
    val dm = Resources.getSystem().displayMetrics
    val density = dm.densityDpi
    val size = if (isTablet(dm)) XLARGE_SIZE else when (density) {
        in DisplayMetrics.DENSITY_XXHIGH until DisplayMetrics.DENSITY_XXXHIGH -> XLARGE_SIZE
        in DisplayMetrics.DENSITY_XHIGH until DisplayMetrics.DENSITY_XXHIGH -> LARGE_SIZE
        in DisplayMetrics.DENSITY_MEDIUM until DisplayMetrics.DENSITY_XHIGH -> MEDIUM_SIZE
        in DisplayMetrics.DENSITY_LOW until DisplayMetrics.DENSITY_MEDIUM -> SMALL_SIZE
        else -> MEDIUM_SIZE
    }
    return url.plus(size).plus(this)
}

fun isTablet(dm: DisplayMetrics): Boolean {
    val x = (dm.widthPixels / dm.xdpi.toDouble()).pow(2)
    val y = (dm.heightPixels / dm.ydpi.toDouble()).pow(2)
    val inches = sqrt(x.plus(y))
    return inches > TABLET_SIZE
}