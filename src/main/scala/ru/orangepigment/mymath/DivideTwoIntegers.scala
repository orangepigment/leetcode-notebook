package ru.orangepigment.mymath

/**
 * [[https://leetcode.com/problems/divide-two-integers/]]
 */
object DivideTwoIntegers {

  def divide(dividend: Int, divisor: Int): Int = {
    if (dividend == 0) {
      0
    } else if (divisor == Int.MinValue) {
      if (dividend == Int.MinValue) {
        1
      } else {
        0
      }
    } else {
      var acc = 0
      val absDivisor = Math.abs(divisor)
      var residue =
        if (dividend == Int.MinValue) {
          acc += 1
          Math.abs(dividend + absDivisor)
        } else {
          Math.abs(dividend)
        }

      while (residue >= absDivisor) {
        acc += 1
        residue -= absDivisor
      }

      if (dividend >= 0 && divisor > 0 || dividend < 0 && divisor < 0) {
        if (acc < 0) Int.MaxValue else acc
      } else {
        -acc
      }
    }
  }

}
