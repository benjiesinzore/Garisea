package com.garisea.datasets.local.models

 data class ItemOffers  (
     val id: Int,
     val name: String,
     val valid: String,
     val description: String
 )

data class OffersWrapper(
    val name: String,
    val items: List<ItemOffers>
)