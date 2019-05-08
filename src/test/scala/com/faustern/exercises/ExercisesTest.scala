package com.faustern.exercises

import cats.implicits._
import com.faustern.exercises.PrintableInstances._
import com.faustern.exercises.PrintableSyntax._
import com.faustern.exercises.CatInstances._
import com.faustern.exercises.MonoidInstances._
import com.faustern.exercises.SemigroupInstances._
import com.faustern.exercises.MonoidRules._
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

  "Boolean Monoids" should "work correctly" in {
    booleanOrMonoid.combine(true, false) should be (true)
    associativeLaw(false, true, true)(booleanOrMonoid) should be(true)
    identityLaw(false)(booleanOrMonoid) should be(true)

    booleanAndMonoid.combine(true, false) should be (false)
    associativeLaw(false, true, true)(booleanAndMonoid) should be(true)
    identityLaw(false)(booleanAndMonoid) should be(true)

    booleanXorMonoid.combine(true, false) should be (true)
    associativeLaw(false, true, true)(booleanXorMonoid) should be(true)
    identityLaw(true)(booleanXorMonoid) should be(true)

    booleanNxorMonoid.combine(true, false) should be (false)
    associativeLaw(false, true, true)(booleanNxorMonoid) should be(true)
    identityLaw(true)(booleanNxorMonoid) should be(true)

    setUnionMonoid.combine(Set(1), Set(2, 3)) should be (Set(1, 2, 3))
    associativeLaw(Set(1), Set(1, 2), Set(2, 3))(setUnionMonoid) should be(true)
    identityLaw(Set(1))(setUnionMonoid) should be(true)

    setSymDiffMonoid.combine(Set(1, 2), Set(2, 3)) should be (Set(1, 3))
    associativeLaw(Set(1), Set(1, 2), Set(2, 3))(setSymDiffMonoid) should be(true)
    identityLaw(Set(1))(setSymDiffMonoid) should be(true)

    setIntersectSemigroup.combine(Set("1", "2"), Set("2", "3")) should be (Set("2"))
  }
}
