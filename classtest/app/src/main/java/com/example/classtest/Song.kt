package com.example.classtest

class Song (
    val songName: String,
    val artists: MutableList<String>,
    val duration: Int,
    val imageSrc: String,

) {
    var currentDuration: Int = 0;
    var songNameFormatted: String = "benjamin"
        set(value) {
            field = value + "🎉"
        }
        get() {
            return this.songName + "test"
        }

    fun play() {

    }

    fun stop() {
        this.currentDuration = 0;
    }

    fun pause() {

    }
}