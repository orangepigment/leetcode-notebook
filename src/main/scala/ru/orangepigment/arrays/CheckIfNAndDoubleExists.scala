package ru.orangepigment.arrays

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/check-if-n-and-its-double-exist/]]
 */
object CheckIfNAndDoubleExists {

  def checkIfExist(arr: Array[Int]): Boolean = {
    val sorted = arr.sorted
    for (i <- sorted.indices) {
      if (sorted(i) < 0 && sorted(i) % 2 == 0) {
        if (binarySearch(sorted, sorted(i) / 2)(i + 1) != -1) return true
      } else {
        if (binarySearch(sorted, sorted(i) * 2)(i + 1) != -1) return true
      }
    }
    false
  }

  @tailrec
  def binarySearch(arr: Array[Int], target: Int)
                  (left: Int = 0, right: Int = arr.length - 1): Int = {
    if (left <= right) {
      val i = (right - left) / 2 + left
      if (arr(i) == target) {
        i
      } else if (arr(i) < target) {
        binarySearch(arr, target)(i + 1, right)
      } else {
        binarySearch(arr, target)(left, i - 1)
      }
    } else {
      -1
    }
  }

}
