package com.faustern.exercises.printable

trait Printable[A] {
  def format(value: A): String
}

object PrintableInstances {
  implicit val IntPrintable: Printable[Int] = (value: Int) => value.toString
  implicit val StringPrintable: Printable[String] = (value: String) => value.toString
  implicit val CatPrintable: Printable[Cat] = (value: Cat) => s"${value.name} is a ${value.age} year-old ${value.color} cat"
}

object Printable {
  def format[A](value: A)(implicit p: Printable[A]): String = p.format(value)
  def print[A](value: A)(implicit p: Printable[A]): Unit = println(p.format(value))
}

object PrintableSyntax {
  implicit class PrintableOps[A](value: A) {
    def format(implicit p: Printable[A]): String = p.format(value)
    def print(implicit p: Printable[A]): Unit = println(p.format(value))
  }
}