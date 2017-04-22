import cats.Functor
import org.scalatest.{FreeSpec, Matchers}

class FunctorsSpec extends FreeSpec with Matchers {
  "functor for Tree" in {
    import Functors.treeFunctor

    Functor[Tree].map(Leaf(1))(_ * 2) shouldBe Leaf(2)

    Functor[Tree].map(
      Branch(
        Leaf(1),
        Branch(Leaf(2), Leaf(3))
      )
    )(_ * 3) shouldBe Branch(Leaf(1 * 3), Branch(Leaf(2 * 3), Leaf(3 * 3)))
  }

}
