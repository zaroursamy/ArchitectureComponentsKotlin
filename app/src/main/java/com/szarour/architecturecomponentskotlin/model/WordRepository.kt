package com.szarour.architecturecomponentskotlin.model

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData

class WordRepository(application: Application) {

    private val wordDao: WordDao?

    private val allWords: LiveData<List<Word>>?

    init {

        val db = WordRoomDatabase.getInstance(application)

        wordDao = db?.wordDao()

        allWords = wordDao?.getAllWords()
    }

    fun insertWord(word: Word) {
        InsertAsyncTask(wordDao!!).execute(word)
    }


    fun deleteWord(word: Word) {
        DeleteAsyncTask(wordDao!!).execute(word)
    }


    fun deleteAllWords() {
        DeleteAllAsyncTask(wordDao!!).execute()
    }


    fun getAllWords(): LiveData<List<Word>> {
        return allWords!!
    }

    fun getWordByName(name: String): Word? {
        return allWords?.value?.firstOrNull { word -> word.name == name }
    }


    /** Async task classes **/

    private class InsertAsyncTask(private val dao: WordDao) : AsyncTask<Word, Void, Void>() {
        override fun doInBackground(vararg params: Word): Void? {
            dao.insertWord(params[0])
            return null
        }
    }

    private class DeleteAsyncTask(private val dao: WordDao) : AsyncTask<Word, Void, Void>() {
        override fun doInBackground(vararg params: Word): Void? {
            dao.deleteWord(params[0])
            return null
        }

    }

    private class DeleteAllAsyncTask(private val dao: WordDao) : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            dao.deleteAllWords()
            return null
        }

    }
}