package com.yeseul.subwayinfo.data.db.entity.mapper

import com.yeseul.subwayinfo.data.db.entity.StationWithSubwayEntity
import com.yeseul.subwayinfo.data.db.entity.SubwayEntity
import com.yeseul.subwayinfo.domain.Station
import com.yeseul.subwayinfo.domain.Subway


fun StationWithSubwayEntity.toStation() = Station(
    name = station.stationName,
    isFavorited = station.isFavorited,
    connectedSubways = subways.toSubways()
)

fun List<StationWithSubwayEntity>.toStations() = map { it.toStation() }

fun List<SubwayEntity>.toSubways(): List<Subway> = map { Subway.findById(it.subwayId) }