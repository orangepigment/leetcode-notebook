package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/sort-array-by-parity/]]
 */
object SortByParity {

  def sortArrayByParity(nums: Array[Int]): Array[Int] = {
    var left = 0 // Even
    var right = nums.length - 1 // Odd
    while (left < right) {
      if (nums(left) % 2 == 0) {
        left += 1
      } else if (nums(right) % 2 == 1) {
        right -= 1
      } else {
        // Swap
        nums(left) = nums(left) - nums(right)
        nums(right) = nums(left) + nums(right)
        nums(left) = nums(right) - nums(left)
      }
    }
    nums
  }

}
