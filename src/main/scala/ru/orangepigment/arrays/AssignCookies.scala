package ru.orangepigment.arrays

// ToDo: there is also a solution via array sorting
/**
 * [[https://leetcode.com/problems/assign-cookies]]
 */
object AssignCookies {

  def findContentChildren(g: Array[Int], s: Array[Int]): Int = {
    var acc = 0
    for (cookie <- s) {
      var cookieEaten = false
      var lastSuitableChildIndex = -1
      var leastSuitableDiff = Int.MaxValue
      var currentChildIndex = 0

      while (!cookieEaten && currentChildIndex < g.length) {
        if (cookie == g(currentChildIndex)) {
          acc += 1
          g(currentChildIndex) = 0 // We won't give more cookies to this child
          cookieEaten = true
        } else if (cookie > g(currentChildIndex) && g(currentChildIndex) > 0) {
          val diff = cookie - g(currentChildIndex)
          if (diff < leastSuitableDiff) {
            lastSuitableChildIndex = currentChildIndex
            leastSuitableDiff = diff
          }
          currentChildIndex += 1
        } else {
          currentChildIndex += 1
        }
      }

      if (!cookieEaten && lastSuitableChildIndex != -1) {
        acc += 1
        g(lastSuitableChildIndex) = 0
      }
    }
    acc
  }

}
