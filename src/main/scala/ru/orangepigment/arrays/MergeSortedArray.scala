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
      var i = 0
      var j = 0
      while (i < m + n && j < n) {
        if (nums1(i) <= nums2(j)) {
          i += 1
        } else {
          var toShift = nums1(i)

          // Shift all elements to the right by 1 position
          for (k <- i + 1 until m + n) {
            val buf = nums1(k)
            nums1(k) = toShift
            toShift = buf
          }

          nums1(i) = nums2(j)
          j += 1
        }
      }

      // Fill remaining zeroes if necessary
      if (i == m + n) {
        for (kk <- j until n) {
          nums1(m + kk) = nums2(kk)
        }
      }
    }
  }

}
