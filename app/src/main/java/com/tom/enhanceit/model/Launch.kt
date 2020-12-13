package com.tom.enhanceit.model

import java.util.*

class Launch(
    val name: String?,
    val date_local: Date?,
    val links: Links?,
    val success: Boolean?
){
    val imageUrl:String? get() = links?.patch?.small
}

data class Links(val patch: Patchs)

data class Patchs(
    val small: String,
    val large: String
)


