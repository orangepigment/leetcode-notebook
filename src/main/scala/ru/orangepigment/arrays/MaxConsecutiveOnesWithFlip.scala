package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/max-consecutive-ones-ii/]]
 */
object MaxConsecutiveOnesWithFlip {

  def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
    var max = 0
    var counter = 0
    var counterWithZero = 0
    for (n <- nums) {
      n match {
        case 1 =>
          counter += 1
          counterWithZero += 1

        case 0 =>
          counterWithZero = counter + 1
          counter = 0
      }
      if (counterWithZero > max) {
        max = counterWithZero
      }
    }

    max
  }

}
