package com.example.transformarray

fun main() {
    println("asd")

    val listOfNumbers: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5);
    println(transforArray(listOfNumbers));
}

fun transforArray(listOfNumber: MutableList<Int>): MutableList<Int> {
    var transformedList: MutableList<Int> = mutableListOf();

    for (number in listOfNumber) {
        println("number from array: " + number)
        val transformedNumber: Int;
        if (number % 2 == 0) {
           transformedNumber = number / 2;
        } else {
            transformedNumber = (number * 3) + 1;
        }
        transformedList.add(transformedNumber)
    }
    return transformedList;
}
