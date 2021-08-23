package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/]]
 */
object TwoSumWithSortedInput {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var left = 0
    var right = nums.length -1

    while (left < right) {
      if (nums(left) + nums(right) == target) {
        return Array(left + 1, right + 1)
      } else if (nums(left) + nums(right) > target) {
        right -= 1
      } else {
        left += 1
      }
    }
    Array.empty[Int]
  }

}
