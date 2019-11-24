package com.szarour.architecturecomponentskotlin.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWord(word: Word)

    @Query(value = "DELETE FROM word_table")
    fun deleteAllWords()

    @Delete
    fun deleteWord(word: Word)

    @Query(value = "SELECT * FROM word_table ORDER BY name ASC")
    fun getAllWords(): LiveData<List<Word>>

    @Query(value = "SELECT * FROM word_table WHERE name=:name")
    fun getWordByName(name: String): Word


}