package ru.orangepigment.arrays

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/merge-intervals/]]
 */
object MergeIntervals {

  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
    mergeRecursive(intervals.sortBy(_(0)))
  }

  @tailrec
  def mergeRecursive(
                      intervals: Array[Array[Int]],
                      i: Int = 0,
                      acc: List[Array[Int]] = List.empty[Array[Int]]
                    ): Array[Array[Int]] = {

    if (i >= intervals.length) {
      acc.reverse.toArray
    } else if (acc.isEmpty) {
      mergeRecursive(
        intervals,
        i + 1,
        intervals(i) +: acc
      )
    } else if (acc.head(1) >= intervals(i)(0)) {
      mergeRecursive(
        intervals,
        i + 1,
        Array(
          Math.min(acc.head(0), intervals(i)(0)),
          Math.max(acc.head(1), intervals(i)(1)),
        ) +: acc.tail
      )
    } else {
      mergeRecursive(
        intervals,
        i + 1,
        intervals(i) +: acc
      )
    }
  }

}
