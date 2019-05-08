package com.faustern.exercises

import cats._

object MonoidInstances {
  implicit val booleanAndMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def combine(b1: Boolean, b2: Boolean) = b1 && b2
    def empty = true
  }

  implicit val booleanOrMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def combine(b1: Boolean, b2: Boolean) = b1 || b2
    def empty = false
  }

  implicit val booleanXorMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def combine(b1: Boolean, b2: Boolean) = (b1 && !b2) || (!b1 && b2)
    def empty = false
  }

  implicit val booleanNxorMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def combine(b1: Boolean, b2: Boolean) = (b1 || !b2) && (!b1 || b2)
    def empty = true
  }

  implicit def setUnionMonoid[A]: Monoid[Set[A]] = new Monoid[Set[A]] {
    def combine(s1: Set[A], s2: Set[A]) = s1 union s2
    def empty = Set.empty
  }

  implicit def setSymDiffMonoid[A]: Monoid[Set[A]] = new Monoid[Set[A]] {
      def combine(a: Set[A], b: Set[A]): Set[A] = (a diff b) union (b diff a)
      def empty: Set[A] = Set.empty
    }
}

object MonoidRules {
  def associativeLaw[A](x: A, y: A, z: A)(implicit m: Monoid[A]): Boolean =
    m.combine(x, m.combine(y, z)) == m.combine(m.combine(x, y), z)

  def identityLaw[A](x: A)(implicit m: Monoid[A]): Boolean =
    (m.combine(x, m.empty) == x) && (m.combine(m.empty, x) == x)
}

object SemigroupInstances {
  implicit def setIntersectSemigroup[A]: Semigroup[Set[A]] = new Semigroup[Set[A]] {
    def combine(s1: Set[A], s2: Set[A]): Set[A] = s1 intersect s2
  }
}
