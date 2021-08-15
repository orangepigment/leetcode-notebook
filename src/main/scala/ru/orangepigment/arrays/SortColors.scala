package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/sort-colors/]]
 */
object SortColors {

  def sortColors(nums: Array[Int]): Unit = {
    if (nums.length > 1) {
      var whiteStart = 0
      var unknownStart = 0
      var unknownEnd = nums.length - 1

      while (unknownStart <= unknownEnd) {
        nums(unknownStart) match {
          case 0 =>
            swap(whiteStart, unknownStart, nums)
            whiteStart += 1
            unknownStart += 1
          case 1 =>
            unknownStart += 1
          case 2 =>
            swap(unknownStart, unknownEnd, nums)
            unknownEnd -= 1
          case _ =>
        }
      }
    }
  }

  def swap(i1: Int, i2: Int, nums: Array[Int]): Unit = {
    val tmp = nums(i1)
    nums(i1) = nums(i2)
    nums(i2) = tmp
  }

}
