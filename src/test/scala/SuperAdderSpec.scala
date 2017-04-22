import cats.Monoid
import org.scalatest.{FreeSpec, Matchers}
import cats.instances.int._
import cats.instances.option._

class SuperAdderSpec extends FreeSpec with Matchers {

  import SuperAdder._

  "addInt" in {
    addInts(List(1,2,3)) shouldBe List(1,2,3).sum
  }

  "addOption" in {
    addOptions(
      List(
        Some(1),
        Some(2),
        None,
        Some(3)
      )
    ) shouldBe Some(1 + 2 + 3)
  }

  "generalized add for lists of anything" in {
    add(List(1,2,3)) shouldBe 1 + 2 + 3
    add(List(Some(1), Some(2), None)) shouldBe Some(1 + 2)
  }

  "adding Orders" in {
    add(List(Order(totalCost = 5, quantity = 2))) shouldBe Order(5, 2)
    add(
      List(
        Order(totalCost = 5, quantity = 2),
        Order(totalCost = 1, quantity = 3)
      )
    ) shouldBe Order(5 + 1, 2 + 3)

  }

}

case class Order(totalCost: Double, quantity: Double)

object Order {
  implicit val monoidInstance: Monoid[Order] = new Monoid[Order] {
    def empty: Order = Order(0,0)

    def combine(x: Order, y: Order): Order =
      Order(
        totalCost = x.totalCost + y.totalCost,
        quantity = x.quantity + y.quantity)
  }
}
