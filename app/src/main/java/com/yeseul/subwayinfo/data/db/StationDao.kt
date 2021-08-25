package com.yeseul.subwayinfo.data.db

import androidx.room.*
import com.yeseul.subwayinfo.data.db.entity.StationEntity
import com.yeseul.subwayinfo.data.db.entity.StationSubwayCrossRefEntity
import com.yeseul.subwayinfo.data.db.entity.StationWithSubwayEntity
import com.yeseul.subwayinfo.data.db.entity.SubwayEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StationDao {

    @Transaction
    @Query("SELECT * FROM StationEntity")
    fun getStationWithSubways(): Flow<List<StationWithSubwayEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStations(station: List<StationEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubways(subways: List<SubwayEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCrossReferences(reference: List<StationSubwayCrossRefEntity>)

}