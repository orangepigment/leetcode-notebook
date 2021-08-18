package ru.orangepigment.arrays

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/two-sum]]
 */
object TwoSum {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val numberXIndexOfComplementary = mutable.Map.empty[Int,Int]

    for (i <- nums.indices) {
      numberXIndexOfComplementary.get(nums(i)) match {
        case Some(idxOfComplementary) =>
          return Array(i, idxOfComplementary)
        case None =>
          numberXIndexOfComplementary += (target - nums(i)) -> i
      }
    }
    Array.empty[Int]
  }
}
