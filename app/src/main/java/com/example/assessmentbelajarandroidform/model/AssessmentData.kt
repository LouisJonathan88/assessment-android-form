package com.example.assessmentbelajarandroidform.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class AssessmentData(
    val nim: String,
    val nama: String,
    val semester: String,
    val jenisPerangkat: String,
    val sistemOperasi: String,
    val versiOs: String,
    val ram: String,
    val cpu: String,
    val deploy: String,
    val merkHp: String,
    val versiOsHp: String,
    val ukuranHp: String,
    val jenisInternet: String,
    val statusInstallAndroid: String,
    val versiInstallAndroid: String
): Parcelable
