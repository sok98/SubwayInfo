package com.yeseul.subwayinfo.data.api

import com.yeseul.subwayinfo.data.db.entity.StationEntity
import com.yeseul.subwayinfo.data.db.entity.SubwayEntity

interface StationApi {

    suspend fun getStationDataUpdatedTimeMillis(): Long

    suspend fun getStationSubways(): List<Pair<StationEntity, SubwayEntity>>
}