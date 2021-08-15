package ru.orangepigment.mymath

/**
 * [[https://leetcode.com/problems/powx-n]]
 */
object MyPow {

  def myPow(x: Double, n: Int): Double = {
    impl(x, n)
  }

  def impl(num: Double, n: Int, acc: Double = 1.0): Double = {
    if (n == 0 || num == 1.0) {
      acc
    } else if (num == -1.0) {
      if (n % 2 == 0) 1.0 else -1.0
    } else if (n < 0) {
      1 / num * impl(1 / num, -(n + 1), acc)
    } else {
      impl(num, n - 1, acc * num)
    }
  }

}
