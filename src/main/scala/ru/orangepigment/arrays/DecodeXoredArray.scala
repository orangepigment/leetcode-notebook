package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/decode-xored-array/]]
 */
object DecodeXoredArray {

  def decode(encoded: Array[Int], first: Int): Array[Int] = {
    val arr = Array.fill(encoded.length + 1)(first)
    for (i <- encoded.indices) {
      arr(i + 1) = arr(i) ^ encoded(i)
    }

    arr
  }

}
