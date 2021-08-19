package ru.orangepigment.arrays

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/3sum/]]
 */
object ThreeSum {

  val TARGET = 0

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val res = mutable.Set.empty[Set[Int]]
    for (i <- 0 until nums.length - 1) {
      val newTarget = TARGET - nums(i)
      val numberXIndexOfComplementary = mutable.Map.empty[Int, Int]
      val newTargetPairs =
        for (j <- nums.indices) yield {
          if (j != i) {
            numberXIndexOfComplementary.get(nums(j)) match {
              case Some(idxOfComplementary) =>
                Set(j, idxOfComplementary)
              case None =>
                numberXIndexOfComplementary += (newTarget - nums(j)) -> j
                Set.empty[Int]
            }
          } else {
            Set.empty[Int]
          }
        }

      res ++= newTargetPairs.filter(_.nonEmpty).map(pair => pair + i)
    }

    res.toList.map(s => s.toList.map(nums.apply).sorted).distinct
  }

}
