package com.yeseul.subwayinfo.data.db.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class StationWithSubwayEntity(
    @Embedded val station: StationEntity,
    @Relation(
        parentColumn = "stationName",
        entityColumn = "subwayId",
        associateBy = Junction(StationSubwayCrossRefEntity::class)
    )
    val subways: List<SubwayEntity>
)
