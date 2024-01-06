package com.garisea.datasets.local.models

data class ItemFinancing(
    val id: Int,
    val name: String,
    val description: String,
    val score: Int
)


data class FinancingWrapper(
    val name: String,
    val items: List<ItemFinancing>
)

