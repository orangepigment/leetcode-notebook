package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/find-the-duplicate-number/]]
 */
object FindDuplicate {

  // ToDo: try using a custom sort
  def findDuplicate(nums: Array[Int]): Int = {
    nums.sortInPlace()(Ordering.Int)
    for (i <- 0 until nums.length - 1) {
      if (nums(i) == nums(i + 1)) {
        return nums(i)
      }
    }
    0
  }

}
