package ru.orangepigment.arrays

import scala.collection.mutable.ListBuffer

/**
 * [[https://leetcode.com/problems/summary-ranges/]]
 */
object SummaryRanges {

  def summaryRanges(nums: Array[Int]): List[String] = {
    if (nums.isEmpty) {
      List.empty[String]
    } else {
      val ranges = ListBuffer.empty[String]
      var rangeStart: Int = nums(0)
      for (i <- 1 until nums.length) {
        if (nums(i) - nums(i - 1) != 1) {
          if (rangeStart == nums(i - 1)) {
            ranges += rangeStart.toString
          } else {
            ranges += s"$rangeStart->${nums(i - 1)}"
          }
          rangeStart = nums(i)
        }
      }

      if (rangeStart == nums(nums.length - 1)) {
        ranges += rangeStart.toString
      } else {
        ranges += s"$rangeStart->${nums(nums.length - 1)}"
      }

      ranges.toList
    }
  }

}
