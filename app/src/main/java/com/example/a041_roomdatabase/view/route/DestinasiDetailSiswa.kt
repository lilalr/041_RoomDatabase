package com.example.a041_roomdatabase.view.route

import com.example.a041_roomdatabase.R

object DestinasiDetailSiswa: DestinasiNavigasi {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}