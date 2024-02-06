package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.util.Stack

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var textForDisplay by remember {
                mutableStateOf("")
            }

            var isInSecretMode by remember {
                mutableStateOf(false)
            }

            Column {
                TextField(value = textForDisplay, onValueChange = {})

                Row {
                    Button(onClick = {
                        textForDisplay += "1"
                    }) {
                        Text(text = "1")
                    }

                    Button(onClick = {
                        textForDisplay += "2"
                    }) {
                        Text(text = "2")
                    }

                    Button(onClick = {
                        textForDisplay += "+"
                    }) {
                        Text(text = "+")
                    }

                    Button(onClick = {
                        textForDisplay += "-"
                    }) {
                        Text(text = "-")
                    }

                    Button(onClick = {
                        if(isInSecretMode) {
                            textForDisplay = "61688743"
                        } else {
                            textForDisplay = getResult(textForDisplay).toString()
                        }

                    }) {
                        Text(text = "=")
                    }
                }
            }
        }
    }
}

fun getResult(expression: String): Int {
    val tokens = tokenizeExpression(expression)
    return evaluateTokens(tokens)
}

fun tokenizeExpression(expression: String): List<String> {
    val regex = Regex("([*+/-])|([0-9]+)")
    return regex.findAll(expression).map { it.value }.toList()
}

fun evaluateTokens(tokens: List<String>): Int {
    val numberStack = Stack<Int>()
    val operatorStack = Stack<Char>()

    for (token in tokens) {
        when {
            token.isNumber() -> numberStack.push(token.toInt())
            token.isOperator() -> {
                while (!operatorStack.isEmpty() && hasHigherPrecedence(operatorStack.peek(), token[0])) {
                    val result = applyOperation(numberStack.pop(), numberStack.pop(), operatorStack.pop())
                    numberStack.push(result)
                }
                operatorStack.push(token[0])
            }
        }
    }

    while (!operatorStack.isEmpty()) {
        val result = applyOperation(numberStack.pop(), numberStack.pop(), operatorStack.pop())
        numberStack.push(result)
    }

    return numberStack.pop()
}

fun String.isNumber() = this.matches(Regex("\\d+"))
fun String.isOperator() = this.matches(Regex("[*+/-]"))
fun hasHigherPrecedence(op1: Char, op2: Char): Boolean {
    if (op1 == '*' || op1 == '/') return true
    if (op2 == '+' || op2 == '-') return true
    return false
}

fun applyOperation(a: Int, b: Int, op: Char): Int {
    return when (op) {
        '+' -> a + b
        '-' -> b - a
        '*' -> a * b
        '/' -> b / a
        else -> throw IllegalArgumentException("Unknown operator: $op")
    }
}