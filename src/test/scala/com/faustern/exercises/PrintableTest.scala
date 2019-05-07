package com.faustern.exercises

import com.faustern.exercises.printable.{Cat, Printable}
import com.faustern.exercises.printable.PrintableInstances._
import com.faustern.exercises.printable.PrintableSyntax._
import org.scalatest._

class PrintableTest extends FlatSpec with Matchers {
  it should "print correctly" in {
    Printable.format("string") should be ("string")
    Printable.format(2) should be ("2")

    val cat = Cat("Lui", 18, "white")

    Printable.format(cat) should be ("Lui is a 18 year-old white cat")

    cat.format should be ("Lui is a 18 year-old white cat")

    cat.print
  }
}
