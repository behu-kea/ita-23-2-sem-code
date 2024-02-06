package com.example.firebase_learning

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore


const val TAG = "firestore";
val db = Firebase.firestore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //createNewCar()
        getCars()

        setContent {
            Text(text = "hallo")
        }
    }
}


fun createNewCar() {
    // Create a new user with a first and last name
    val greenCar = Car("green", 5);
    
    // Add a new document with a generated ID
    db.collection("cars")
        .add(greenCar)
        .addOnSuccessListener { documentReference ->
            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference}")
        }
        .addOnFailureListener { e ->
            Log.w(TAG, "Error adding document", e)
        }
}

fun getCars() {
    db.collection("cars")
        .get()
        .addOnSuccessListener { result ->
            for (document in result) {
                val car = document.toObject(Car::class.java)
                Log.d(TAG, "${document.id} => ${car}")
                Log.d(TAG, "${document.id} => ${car.color}")
            }
        }
        .addOnFailureListener { exception ->
            Log.w(TAG, "Error getting documents.", exception)
        }
}
