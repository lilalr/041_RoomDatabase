package com.example.a041_roomdatabase.repositori

import com.example.a041_roomdatabase.room.Siswa
import com.example.a041_roomdatabase.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
}

