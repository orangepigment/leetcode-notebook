package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/xor-operation-in-an-array/]]
 */
object XorOperation {

  def xorOperation(n: Int, start: Int): Int = {
    (for {i <- 0 until n}
      yield start + 2 * i).reduce(_ ^ _)
  }

}
