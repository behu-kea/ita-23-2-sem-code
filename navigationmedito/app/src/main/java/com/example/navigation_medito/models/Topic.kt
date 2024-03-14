package com.example.navigation_medito.models

class Topic (val title: String, val description: String) {
    var episodes: MutableList<Episode> = mutableListOf();

    init {
        val yourFirstBodyScan = Episode("Your first...", "focusing")
        episodes.add(yourFirstBodyScan)
    }
}