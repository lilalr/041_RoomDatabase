package com.example.a041_roomdatabase.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.a041_roomdatabase.repositori.AplikasiSiswa
import com.example.a041_roomdatabase.viewmodel.DetailViewModel
import com.example.a041_roomdatabase.viewmodel.EntryViewModel
import com.example.a041_roomdatabase.viewmodel.HomeViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiSiswa().container.repositoriSiswa)
        }

        initializer {
            EntryViewModel(aplikasiSiswa().container.repositoriSiswa)
        }
        //edit: tambah initializer utk DetailViewModel dan EditViewModel
        initializer {
            DetailViewModel (this.createSavedStateHandle(),
                aplikasiSiswa().container.repositoriSiswa)
        }
//        initializer {
//            EditViewModel(this.createSavedStateHandle(),
//                aplikasiSiswa().container.repositoriSiswa)
//        }
    }
}

fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as
            AplikasiSiswa)