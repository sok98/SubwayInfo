package com.yeseul.subwayinfo.domain

data class Station(
    val name: String,
    val isFavorited: Boolean,
    val connectedSubways: List<Subway>
)