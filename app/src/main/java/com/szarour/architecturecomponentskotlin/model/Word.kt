package com.szarour.architecturecomponentskotlin.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class Word(@PrimaryKey @NonNull val name: String, @NonNull val meaning: String) {
}