package com.leojoestrela.packagelist.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pacote(
    val id: String?,
    val codigo: String?,
    val pontoEntrega: String?,
    val municipio: String?,
    val escola: String?,
    val anoEscolarEtapa: String?,
    val componenteCurricular: String?,
    val statusPacote: ArrayList<StatusPacote>,
) : Parcelable