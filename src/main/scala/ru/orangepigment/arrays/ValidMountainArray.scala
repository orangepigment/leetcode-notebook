package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/valid-mountain-array/]]
 */
object ValidMountainArray {

  def validMountainArray(arr: Array[Int]): Boolean = {
    if (arr.length < 3) {
      false
    } else {
      var peakReached = false
      for (i <- 1 until arr.length) {
        if (peakReached) {
          if (arr(i) >= arr(i - 1)) return false
        } else {
          if (arr(i) < arr(i - 1)) {
            if (i - 1 != 0) peakReached = true else return false
          } else if (arr(i) == arr(i - 1)) {
            return false
          }
        }
      }
      peakReached
    }
  }

}
