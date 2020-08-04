package dyield

object ForestObserver {

  type Tree = (Int,Int)


  def angleBetweenTrees(a:Tree,b:Tree) = {
    val (a_x,a_y) = a
    val (b_x,b_y) = b
    val result = math.atan2(a_x * b_y - a_y * b_x,a_x * b_x + a_y * b_y).toDegrees
    if(result > 0) result else 360 + result
  }

  /*
  My assumption is that the forest data structure is already sorted according to the natural order of the rotation direction
  Which means that the first tree in array is actually the first tree I will encounter if I choose to rotate in certain direction.
  I also assume that the forest contains at least a single tree, and the provided angle is not 0
  (it will make code uglier to support those edge cases, and as a home exercise I see no reason doing so).

  The algorithm is O(n) complexity
   */
  def findMaxTrees(forest:Array[Tree], maxObserveAngle:Double) = {
    var backword = 0
    var forward = 1
    var maxTrees = 1 // I am assuming that the input angle is wide enough to observe at least a single tree
    var observedTrees = 1
    while(forward < forest.size) {
      val currentAngle = angleBetweenTrees(forest(backword),forest(forward))
      if(currentAngle <= maxObserveAngle) {
        forward = forward + 1
        observedTrees = observedTrees + 1
        if(observedTrees > maxTrees)
          maxTrees = observedTrees
      }
      else {
        backword = backword + 1
        observedTrees = observedTrees - 1
      }
    }
    maxTrees
  }
}
