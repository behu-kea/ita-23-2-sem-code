package com.example.navigation_medito.viewmodels

import androidx.lifecycle.ViewModel
import com.example.navigation_medito.models.Topic

class MeditoViewModel: ViewModel() {
    val topics: MutableList<Topic> = mutableListOf();

    init {
        val bodyScanTopic = Topic("Body Scan", "Meditation for body");
        val breathingExercises = Topic("Breathing Exercises", "Breathing exercises to feel calmer");
        topics.add(bodyScanTopic);
        topics.add(breathingExercises);
    }
}