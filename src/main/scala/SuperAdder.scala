import cats.Monoid

import cats.syntax.semigroup._
import cats.instances.int._
import cats.instances.option._

object SuperAdder {

  def addInts(items: List[Int]): Int =
    items.fold(Monoid[Int].empty) { _ |+| _ }

  def addOptions(items: List[Option[Int]]): Option[Int] =
    items.fold(Monoid[Option[Int]].empty) { _ |+| _ }

  def add[T : Monoid](items: List[T]): T =
    items.fold(Monoid[T].empty) { _ |+| _ }


}
