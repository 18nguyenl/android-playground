package com.example.myfirstapp.services

interface DBService<T> {

    fun insert(vararg element: T)
    fun delete(element: T)
    fun getAll(): Array<T>

}