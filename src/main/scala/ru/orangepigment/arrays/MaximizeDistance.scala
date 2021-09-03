package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/maximize-distance-to-closest-person/]]
 */
object MaximizeDistance {

  def maxDistToClosest(seats: Array[Int]): Int = {
    var leftNeighbor = -1
    var rightNeighbor = 0
    var maxDistance = 0

    for (i <- seats.indices) {
      if (seats(i) == 1) {
        leftNeighbor = i
      } else {
        while (rightNeighbor < seats.length && seats(rightNeighbor) == 0 || rightNeighbor < i) {
          rightNeighbor += 1
        }

        val leftDistance = if (leftNeighbor == -1) seats.length else i - leftNeighbor
        val rightDistance = if (rightNeighbor == seats.length) seats.length else rightNeighbor - i
        maxDistance = Math.max(maxDistance, Math.min(leftDistance, rightDistance))
      }
    }

    maxDistance
  }

}
