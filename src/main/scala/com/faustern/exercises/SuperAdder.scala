package com.faustern.exercises

import cats._

case class Order(totalCost: Double, quantity: Double)

object SuperAdder {
  def add[A](l: List[A])(implicit m: Monoid[A]): A = l.foldRight(m.empty)(m.combine)
}

object MonoidInstances_ {
  implicit val orderMonoid: Monoid[Order] = new Monoid[Order] {
    def combine(o1: Order, o2: Order) = new Order(o1.totalCost + o2.totalCost, o1.quantity + o2.quantity)
    def empty = new Order(0, 0)
  }
}