package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/third-maximum-number/]]
 */
object ThirdMaximum {

  def thirdMax(nums: Array[Int]): Int = {
    var firstMax: Option[Int] = None
    var secondMax: Option[Int] = None
    var thirdMax: Option[Int] = None
    for (i <- nums.indices) {
      if (firstMax.isEmpty || nums(i) > firstMax.get) {
        thirdMax = secondMax
        secondMax = firstMax
        firstMax = Some(nums(i))
      } else if (nums(i) < firstMax.get && (secondMax.isEmpty || nums(i) > secondMax.get)) {
        thirdMax = secondMax
        secondMax = Some(nums(i))
      } else if (nums(i) < secondMax.getOrElse(Int.MinValue) && (thirdMax.isEmpty || nums(i) > thirdMax.get)) {
        thirdMax = Some(nums(i))
      }
    }

    thirdMax.getOrElse(firstMax.getOrElse(Int.MinValue))
  }

}
