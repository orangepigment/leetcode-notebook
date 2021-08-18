package ru.orangepigment.mymath

/**
 * [[https://leetcode.com/problems/binary-number-with-alternating-bits/]]
 */
object AlternatingBits {

  def hasAlternatingBits(n: Int): Boolean = {
    if (n == Int.MaxValue) {
       false
    } else {
      var bit = (n & 1) != 0 // true 1, false 0
      var shifted = n >> 1
      while (shifted != 0) {
        if ((shifted & 1) != 0 == bit) {
          return false
        }
        bit = !bit
        shifted >>= 1
      }
      true
    }
  }

}
