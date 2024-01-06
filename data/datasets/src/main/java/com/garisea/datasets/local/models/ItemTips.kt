package com.garisea.datasets.local.models

data class ItemTips (
    val id: Int,
    val name: String,
    val description: String
)

data class TipsWrapper(
    val name: String,
    val items: List<ItemTips>
)