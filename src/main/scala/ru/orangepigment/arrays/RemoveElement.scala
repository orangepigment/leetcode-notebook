package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/remove-element]]
 */
object RemoveElement {

  def removeElement(nums: Array[Int], `val`: Int): Int = {
    var acc = 0
    for (i <- nums.indices) {
      if (nums(i) == `val`) {
        var j = i + 1
        while (j < nums.length) {
          if (nums(i) != nums(j)) {
            nums(i) = nums(j)
            nums(j) = `val`
            j = nums.length
            acc += 1
          } else {
            j += 1
          }
        }
      } else {
        acc += 1
      }
    }
    acc
  }

}
