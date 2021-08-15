package ru.orangepigment.mymath

/**
 * [[https://leetcode.com/problems/sqrtx]]
 */
object MySqrt {

  // binary search approach
  def mySqrt(x: Int): Int = {
    if (x <= 1) {
      x
    } else {
      var right = x
      var left = 0
      var middle = evalMiddle(left, right)
      var square = evalSquare(middle)

      while (square != x && right - left > 1) {
        if (square > x || square < 0) {
          right = middle
          middle = evalMiddle(left, right)
        } else {
          left = middle
          middle = evalMiddle(left, right)
        }
        square = evalSquare(middle)
      }
      middle
    }
  }

  def evalMiddle(left: Int, right: Int): Int = {
    val sum = left + right
    if (sum < 0) Int.MaxValue / 2 else  sum / 2
  }

  def evalSquare(middle: Int): Int = {
    val square = middle * middle
    if (square / middle != middle) {
      // overflow handling
      -1
    } else {
      square
    }
  }

}
