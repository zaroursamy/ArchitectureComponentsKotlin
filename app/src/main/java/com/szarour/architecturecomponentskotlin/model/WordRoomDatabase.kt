package com.szarour.architecturecomponentskotlin.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Word::class], version = 1)
abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {
        @Volatile // mark thread
        var database: WordRoomDatabase? = null

        fun getInstance(context: Context): WordRoomDatabase? {
            if (database == null) {
                synchronized(WordRoomDatabase::class.java) {
                    if (database == null) {
                        database =
                            Room.databaseBuilder(
                                context,
                                WordRoomDatabase::class.java,
                                "word_database"
                            )
                                .build()
                    }
                }

            }
            return database
        }
    }


}