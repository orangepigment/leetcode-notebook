package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/majority-element/]]
 */
object MajorityElement {

  def majorityElement(nums: Array[Int]): Int = {
    var majorityElem = nums(0)
    var counter = 1
    for (i <- 1 until nums.length) {
      if (counter == 0) {
        majorityElem = nums(i)
      }

      if (nums(i) == majorityElem) {
        counter += 1
      } else {
        counter -= 1
      }
    }
    majorityElem
  }

}
