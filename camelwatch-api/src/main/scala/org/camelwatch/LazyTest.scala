package org.camelwatch

/** @author Stephen Samuel */
class LazyTest extends App {

    lazy val name = {
        println("expensive name computation")
        "sam"
    }

    def getName = name
}
