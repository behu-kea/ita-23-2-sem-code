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

    @Test
    fun `CPR number valid`() {
        val isCPRValid = isValidCPR("121101-3456");
        assertEquals(true, isCPRValid)

        val isCPRValid1 = isValidCPR("271101-3456");
        assertEquals(true, isCPRValid1)

        val isCPRValid2 = isValidCPR("");
        assertEquals(false, isCPRValid2)

        val isCPRValid3 = isValidCPR("12110");
        assertEquals(false, isCPRValid3)

        val isCPRValid4 = isValidCPR("ajshgdjkasgdisajdi");
        assertEquals(false, isCPRValid4)

        val isCPRValid5 = isValidCPR("211101-hasv");
        assertEquals(false, isCPRValid5)

        val isCPRValid6 = isValidCPR("211101-0000");
        assertEquals(false, isCPRValid6)
    }



}