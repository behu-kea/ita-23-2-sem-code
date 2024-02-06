package com.example.classtest


fun main () {
    val artists = mutableListOf<String>("frygtløs");
    val tænkerForMeget: Song = Song("Tænker for meget", artists, 180, "https://asd.com");
    tænkerForMeget.songNameFormatted = "asd";
    println(tænkerForMeget.songNameFormatted);
}