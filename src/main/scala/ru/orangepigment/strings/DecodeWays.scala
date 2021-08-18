package ru.orangepigment.strings

/**
 * [[https://leetcode.com/problems/decode-ways/]]
 */
object DecodeWays {

  def numDecodings(s: String): Int = {
    val cache = Array.fill(s.length)(-1)
    dp(s, cache)
  }

  def dp(s: String, cache: Array[Int], index: Int = 0): Int = {
    index match {
      case i if i == s.length => 1
      case i if s(i) == '0' => 0
      case i if i == s.length - 1 => 1
      case i if cache(i) != -1 => cache(i)
      case i =>
        val ans =
          if (10 * s(i).asDigit + s(i + 1).asDigit <= 26) {
            dp(s, cache, i + 1) + dp(s, cache, i + 2)
          } else {
            dp(s, cache, i + 1)
          }
        cache(i) = ans
        ans
    }
  }

  // "111111111111111111111111111111111111111111111" gives OOM
  def numDecodingsRecursive(s: String): Int = {
    if (s.nonEmpty && s(0) == '0') {
      0
    } else if (s.length <= 1) {
      1
    } else {
      val twoCharsDigit = 10 * s(0).asDigit + s(1).asDigit
      if (twoCharsDigit > 26) {
        numDecodingsRecursive(s.substring(1))
      } else {
        numDecodingsRecursive(s.substring(1)) + numDecodingsRecursive(s.substring(2))
      }
    }
  }

}
