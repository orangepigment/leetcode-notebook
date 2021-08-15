package ru.orangepigment.arrays

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/plus-one]]
 */
object PlusOne {

  def plusOne(digits: Array[Int]): Array[Int] = {
    plusOneRecursive(digits.length - 1, digits)
  }

  @tailrec
  def plusOneRecursive(index: Int, digits: Array[Int]): Array[Int] = {
    if (index < 0) {
      1 +: digits
    } else {
      if (digits(index) == 9) {
        digits(index) = 0
        plusOneRecursive(index - 1, digits)
      } else {
        digits(index) += 1
        digits
      }
    }
  }

}
