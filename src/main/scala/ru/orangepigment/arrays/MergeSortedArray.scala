package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/merge-sorted-array]]
 */
object MergeSortedArray {

  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    if (m == 0) {
      for (i <- 0 until n) {
        nums1(i) = nums2(i)
      }
    } else if (n == 0) {
      ()
    } else {
      var i = m - 1
      var j = n - 1

      for (k <- nums1.length - 1 to 0 by -1 if j >= 0) {
        if (i >= 0 && nums1(i) > nums2(j)) {
          nums1(k) = nums1(i)
          i -= 1
        } else {
          nums1(k) = nums2(j)
          j -= 1
        }
      }
    }
  }

}
