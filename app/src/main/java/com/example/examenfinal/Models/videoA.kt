package com.example.examenfinal.Models

import com.example.examenfinal.Entity.categorias
import retrofit2.Response
import retrofit2.http.GET

interface videoA {
        @GET("ListarPeliculas")
        suspend fun getVideo(): Response<categorias>
}