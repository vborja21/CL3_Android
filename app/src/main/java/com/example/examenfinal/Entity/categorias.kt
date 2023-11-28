package com.example.examenfinal.Entity

import com.google.gson.annotations.SerializedName

data class categorias(
    @SerializedName("categories") val categories: List<categoria>
)
