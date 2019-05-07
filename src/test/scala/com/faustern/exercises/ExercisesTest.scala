package com.faustern.exercises

import cats.implicits._
import com.faustern.exercises.PrintableInstances._
import com.faustern.exercises.PrintableSyntax._
import com.faustern.exercises.ShowInstances._
import org.scalatest._

class ExercisesTest extends FlatSpec with Matchers {
  "Printable" should "work correctly" in {
    Printable.format("string") should be ("string")
    Printable.format(2) should be ("2")

    val cat = Cat("Lui", 18, "white")

    Printable.format(cat) should be ("Lui is a 18 year-old white cat")

    cat.format should be ("Lui is a 18 year-old white cat")

    cat.print
  }

  "Show" should "work correctly" in {
    val cat = Cat("Lui", 18, "white")
    cat.show should be ("Lui is a 18 year-old white cat")
  }
}
