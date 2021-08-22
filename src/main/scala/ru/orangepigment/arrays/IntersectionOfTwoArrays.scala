package ru.orangepigment.arrays

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
object IntersectionOfTwoArrays {

  def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val res = ArrayBuffer.empty[Int]
    val nums1Map = mutable.Map.empty[Int, Int]
    for (n <- nums1) {
      nums1Map += n -> (nums1Map.getOrElse(n, 0) + 1)
    }

    for (n <- nums2) {
      if (nums1Map.getOrElse(n, 0) > 0) {
        res += n
        nums1Map += n -> (nums1Map.getOrElse(n, 0) - 1)
      }
    }

    res.toArray
  }

}
