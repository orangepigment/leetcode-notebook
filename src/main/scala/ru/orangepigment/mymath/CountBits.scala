package ru.orangepigment.mymath

/**
 * [[https://leetcode.com/problems/counting-bits/]]
 */
object CountBits {

  def countBits(n: Int): Array[Int] = {
    Range(0, n+1).toArray.map(Integer.bitCount)
  }

}
