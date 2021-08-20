package ru.orangepigment.arrays

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/]]
 */
object ReplaceElements {

  def replaceElements(arr: Array[Int]): Array[Int] = {
    replaceRecursive(arr, arr.length - 2, arr(arr.length - 1))
    arr(arr.length - 1) = -1
    arr
  }

  @tailrec
  def replaceRecursive(arr: Array[Int], i: Int, maxToTheRight: Int): Unit = {
    if (i >= 0) {
      val newMax = Math.max(arr(i), maxToTheRight)
      arr(i) = maxToTheRight
      replaceRecursive(arr, i - 1, newMax)
    }
  }

}
