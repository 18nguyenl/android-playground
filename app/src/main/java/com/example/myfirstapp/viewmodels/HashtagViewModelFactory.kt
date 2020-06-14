package com.example.myfirstapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myfirstapp.data.DataAccessObject
import com.example.myfirstapp.models.Hashtag

class HashtagViewModelFactory(private val dao: DataAccessObject<Hashtag>): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = HashtagViewModel(dao) as T

}