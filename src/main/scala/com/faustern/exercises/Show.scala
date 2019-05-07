package com.faustern.exercises

object ShowInstances {
  implicit val catShow: cats.Show[Cat] = cats.Show.show(value => s"${value.name} is a ${value.age} year-old ${value.color} cat")
}
