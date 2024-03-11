package com.example.indkbsseddel.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class GroceryItem (var title: String) {
    var isChecked: Boolean by mutableStateOf(false);
    var amount: Int by mutableIntStateOf(1);
}