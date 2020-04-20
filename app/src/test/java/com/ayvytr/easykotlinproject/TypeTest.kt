package com.ayvytr.easykotlinproject

import org.junit.Test

/**
 * @author EDZ
 */
class TypeTest {
    @Test
    fun test() {
        val classA = A()
        val a = A::class
        val b = classA::class
        val c = A::javaClass
        val d = classA.javaClass
        val e=A::class.java
        val f = classA::class.java
        val g = A::class.java.kotlin
        val h = classA::class.java.kotlin
    }
}

class A {

}