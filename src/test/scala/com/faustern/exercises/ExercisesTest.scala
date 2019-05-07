package com.faustern.exercises

import cats.implicits._
import com.faustern.exercises.PrintableInstances._
import com.faustern.exercises.PrintableSyntax._
import com.faustern.exercises.CatInstances._
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

  "Eq" should "work correctly" in {
    val cat1 = Cat("Garfield",   38, "orange and black")
    val cat2 = Cat("Heathcliff", 33, "orange and black")
    val cat3 = Cat("Garfield",   38, "orange and black")

    val optionCat1 = Option(cat1)
    val optionCat2 = Option.empty[Cat]
    val optionCat3 = Option(cat3)

    cat1.eqv(cat2) should be (false)
    optionCat1.eqv(optionCat2) should be (false)
    optionCat1.eqv(optionCat3) should be (true)
  }
}
