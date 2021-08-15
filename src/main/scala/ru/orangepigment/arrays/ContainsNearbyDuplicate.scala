package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/contains-duplicate-ii/]]
 */
object ContainsNearbyDuplicate {

  def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
    if (k != 0 && nums.length > 1) {
      for (i <- 0 until nums.length - 1) {
        for (j <- i + 1 to Math.min(i + k, nums.length - 1)) {
          if (nums(i) == nums(j)) {
            return true
          }
        }
      }
    }
    false
  }

}
