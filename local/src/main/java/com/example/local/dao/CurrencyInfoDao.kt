package com.example.local.dao

import androidx.room.*
import com.example.local.entity.CurrencyInfoEntity
import io.reactivex.Single

@Dao
interface CurrencyInfoDao {

    @Query("select * from CurrencyInfo")
    fun getAll(): Single<List<CurrencyInfoEntity>>

    @Query("select * from CurrencyInfo where id = :id")
    fun get(id: Int): CurrencyInfoEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(currencyInfoEntityList: List<CurrencyInfoEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(currencyInfoEntity: CurrencyInfoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg currencyInfoEntity: CurrencyInfoEntity)

    @Update
    fun update(currencyInfoEntity: CurrencyInfoEntity)

    @Delete
    fun delete(currencyInfoEntityList: List<CurrencyInfoEntity>)

    @Delete
    fun delete(currencyInfoEntity: CurrencyInfoEntity)

    @Query("delete from CurrencyInfo")
    fun deleteAll()

}