package com.faustern.exercises

import cats._
import cats.implicits._

object CatInstances {
  implicit val catShow: Show[Cat] = cats.Show.show(value => s"${value.name} is a ${value.age} year-old ${value.color} cat")

  implicit val catEq: Eq[Cat] =
    Eq.instance[Cat] { (cat1, cat2) =>
      cat1.name === cat2.name &&
        cat1.age === cat2.age &&
        cat1.color === cat2.color
    }
}
