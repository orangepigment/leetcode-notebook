package ru.orangepigment.mymath

/**
 * [[https://leetcode.com/problems/number-of-1-bits/]]
 */
object HammingWeight {

  private val masks = for {i <- 0 to 31} yield 1 << i

  // you need treat n as an unsigned value
  def hammingWeight(n: Int): Int = {
    masks.foldLeft(0) { case (counter, mask) =>
      if ((n & mask) != 0) counter + 1 else counter
    }
  }

}
