package com.example.testing

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun `Addition works`() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `Sum function works`() {
        val list = listOf(1, 2, 3);
        val sum = getSum(list);
        assertEquals(6, sum)
    }
}