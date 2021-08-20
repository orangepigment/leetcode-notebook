package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/remove-element]]
 */
object RemoveElement {

  def removeElement(nums: Array[Int], `val`: Int): Int = {
    var n = nums.length
    var i = 0
    while (i < n) {
      if (nums(i) == `val`) {
        nums(i) = nums(n - 1)
        n -= 1
      } else {
        i += 1
      }
    }
    n
  }

}
