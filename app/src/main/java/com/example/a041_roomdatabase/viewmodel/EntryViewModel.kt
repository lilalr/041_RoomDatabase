package com.example.a041_roomdatabase.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.a041_roomdatabase.repositori.RepositoriSiswa
import com.example.a041_roomdatabase.room.Siswa

class EntryViewModel(private val repositoriSiswa: RepositoriSiswa): ViewModel()
    { /* berisi status siswa saat ini */
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set
    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa
    ): Boolean {
        return with(uiState)
        {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }
        fun updateUiState(detailSiswa: DetailSiswa) {
            uiStateSiswa =
                UIStateSiswa(
                    detailSiswa = detailSiswa, isEntryValid =
                        validasiInput(detailSiswa)
                )
        }
        suspend fun saveSiswa() {
            if (validasiInput()) {
                repositoriSiswa.insertSiswa(uiStateSiswa.detailSiswa.toSiswa())
            }
        }
    }

data class UIStateSiswa(
    val detailSiswa: DetailSiswa = DetailSiswa(),
    val isEntryValid: Boolean = false
)

data class DetailSiswa(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = "",
)





