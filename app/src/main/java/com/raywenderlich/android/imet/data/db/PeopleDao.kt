package com.raywenderlich.android.imet.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.raywenderlich.android.imet.data.model.People

@Dao
interface PeopleDao {

    @Query("SELECT * FROM People ORDER BY id DESC")
    fun getAll(): List<People>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(people: People)

    @Query("DELETE FROM PEOPLE")
    fun deleteAll()

    @Query("SELECT * FROM People WHERE id = :id")
    fun find(id: Int): People
}