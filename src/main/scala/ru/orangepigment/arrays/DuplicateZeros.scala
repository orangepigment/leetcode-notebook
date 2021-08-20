package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/duplicate-zeros/]]
 */
object DuplicateZeros {

  def duplicateZeros(arr: Array[Int]): Unit = {
    var i = 0
    while (i < arr.length -1) {
      if (arr(i) == 0) {
        // Shift everything and add zero
        for (j <- arr.length - 1 to i + 2 by -1) {
          arr(j) = arr(j - 1)
        }
        arr(i + 1) = 0
        i += 2
      } else {
        i += 1
      }
    }
  }

}
