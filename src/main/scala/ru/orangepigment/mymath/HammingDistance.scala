package ru.orangepigment.mymath

/**
 * [[https://leetcode.com/problems/hamming-distance/]]
 */
object HammingDistance {

  def hammingDistance(x: Int, y: Int): Int = {
    Integer.bitCount(x ^ y)
  }

}
