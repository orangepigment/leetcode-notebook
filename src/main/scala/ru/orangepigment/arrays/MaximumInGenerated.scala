package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/get-maximum-in-generated-array/]]
 */
object MaximumInGenerated {

  def getMaximumGenerated(n: Int): Int = {
    if (n <= 1) {
      n
    } else {
      var max = 0
      val nums = new Array[Int](n + 1)
      nums(1) = 1

      for (i <- 2 to n) {
        if (i % 2 == 0) {
          nums(i) = nums(i / 2)
        } else {
          nums(i) = nums(i / 2) + nums(i / 2 + 1)
        }
        if (nums(i) > max) {
          max = nums(i)
        }
      }

      max
    }
  }

}
