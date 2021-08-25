package com.yeseul.subwayinfo.data.repository

import com.yeseul.subwayinfo.domain.Station
import kotlinx.coroutines.flow.Flow

interface StationRepository {

    val stations: Flow<List<Station>>

    suspend fun refreshStations()
}