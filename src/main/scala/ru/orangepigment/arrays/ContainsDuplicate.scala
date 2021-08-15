package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/contains-duplicate/]]
 */
object ContainsDuplicate {

  // ToDo: try using a custom sort
  def containsDuplicate(nums: Array[Int]): Boolean = {
    nums.sortInPlace()(Ordering.Int)
    for (i <- 0 until nums.length - 1) {
      if (nums(i) == nums(i + 1)) {
        return true
      }
    }
    false
  }

}
