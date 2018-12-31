package com.example.afsal.roomtutorialcoroutine.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Task {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var name: String? = null
}