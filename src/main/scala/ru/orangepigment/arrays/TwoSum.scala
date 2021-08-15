package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/two-sum]]
 */
object TwoSum {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var result = Array[Int]()
    for (i <- nums.indices; j <- i + 1 until nums.length) {
      if (nums(i) + nums(j) == target) result = Array(i, j)
    }
    result
  }
}
