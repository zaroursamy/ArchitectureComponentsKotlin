package com.szarour.architecturecomponentskotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.szarour.architecturecomponentskotlin.model.Word
import com.szarour.architecturecomponentskotlin.model.WordRepository

class WordViewModel(application: Application): AndroidViewModel(application) {

    private val wordRepository: WordRepository
    private val allWords: LiveData<List<Word>>

    init {
        wordRepository = WordRepository(application)

        allWords = wordRepository.getAllWords()
    }

    fun insertWord(word: Word){
        wordRepository.insertWord(word)
    }

    fun deleteWord(word: Word){
        wordRepository.deleteWord(word)
    }

    fun deleteAllWords(){
        wordRepository.deleteAllWords()
    }

    fun getAllWords(): LiveData<List<Word>> = allWords

    fun getWordByName(name: String): Word? {
        return wordRepository.getWordByName(name)
    }
}