package com.leojoestrela.packagelist.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class StatusPacote(
    val idStatus: String,
    val descricaoStatus: String,
    val dataDiaStatus: String
) : Parcelable
