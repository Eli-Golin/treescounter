package dyield

import org.scalatest.flatspec.AnyFlatSpec
import ForestObserver._
import org.scalatest.matchers.should.Matchers
class ForestObserverTest extends AnyFlatSpec with Matchers {

  val forest = Array(5 -> 1, 4 -> 2, 3 -> 3, 2 -> 4, 1 -> 5, -1 -> 5, -2 -> 4, -3 -> 3, -4 -> 2, -5 -> 1,
    -5 -> -1, -4 -> -2, -3 -> -3, -2 -> -4, -1 -> -5, 1 -> -5, 2 -> -4, 3 -> -3, 4 -> -2, 5 -> -1)
  "When getting a forest of 20 trees we" should "return a correct answer for 45 degree angle" in {
    val angle = 45d
    findMaxTrees(forest,angle) should be (3)
  }
  it should "be 6 for 90 degree angle" in {
    val angle = 90d
    findMaxTrees(forest,angle) should be (6)
  }
  it should "be 12 for 270 degree angle" in {
    val angle = 270d
    findMaxTrees(forest,angle) should be (16)
  }

  it should "be 20 for 360 degree angle" in {
    val angle = 360d
    findMaxTrees(forest,angle) should be (20)
  }
}
