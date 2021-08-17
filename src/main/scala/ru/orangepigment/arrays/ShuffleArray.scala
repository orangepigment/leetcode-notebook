package ru.orangepigment.arrays

import scala.util.Random

/**
 * [[https://leetcode.com/problems/shuffle-an-array/]]
 *
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(nums)
 * var param_1 = obj.reset()
 * var param_2 = obj.shuffle()
 */

class ShuffleArray(_nums: Array[Int]) {

  private val original = _nums.clone()

  /** Resets the array to its original configuration and return it. */
  def reset(): Array[Int] = {
    original.clone()
  }

  /** Returns a random shuffling of the array. */
  def shuffle(): Array[Int] = {
    val rand = new Random()
    for (i <- 0 until _nums.length - 1) {
      val j = rand.between(i, _nums.length)
      val tmp = _nums(j)
      _nums(j) = _nums(i)
      _nums(i) = tmp
    }
    _nums
  }

}
