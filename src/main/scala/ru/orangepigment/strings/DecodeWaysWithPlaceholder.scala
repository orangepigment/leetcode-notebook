package ru.orangepigment.strings

/**
 * [[https://leetcode.com/problems/decode-ways-ii/]]
 */
object DecodeWaysWithPlaceholder {

  // 10 ** 9 + 7
  private val modulo = 1000000007

  def numDecodings(s: String): Int = {
    val cache = Array.fill(s.length)(-1L)
    (dp(s, cache) % modulo).toInt
  }

  def dp(s: String, cache: Array[Long], index: Int = 0): Long = {
    index match {
      case i if i == s.length => 1
      case i if s(i) == '0' => 0
      case i if i == s.length - 1 => if (s(i) == '*') 9 else 1
      case i if cache(i) != -1 => cache(i)
      case i if s(i) == '*' && s(i + 1) == '*' =>
        cache(i) = 9 * (dp(s, cache, i + 1) % modulo) % modulo + 15 * (dp(s, cache, i + 2) % modulo) % modulo
        cache(i)
      case i if s(i) == '*' =>
        if (s(i + 1).asDigit <= 6) {
          cache(i) = 9 * (dp(s, cache, i + 1) % modulo) % modulo + 2 * (dp(s, cache, i + 2) % modulo) % modulo
        } else {
          cache(i) = 9 * (dp(s, cache, i + 1) % modulo) % modulo + (dp(s, cache, i + 2) % modulo) % modulo
        }
        cache(i)
      case i if s(i + 1) == '*' =>
        if (s(i).asDigit == 1) {
          cache(i) = (dp(s, cache, i + 1) % modulo) % modulo + 9 * (dp(s, cache, i + 2) % modulo) % modulo
        } else if (s(i).asDigit == 2) {
          cache(i) = (dp(s, cache, i + 1) % modulo) % modulo + 6 * (dp(s, cache, i + 2) % modulo) % modulo
        } else {
          cache(i) = (dp(s, cache, i + 1) % modulo) % modulo
        }
        cache(i)
      case i =>
        if (10 * s(i).asDigit + s(i + 1).asDigit <= 26) {
          cache(i) = (dp(s, cache, i + 1) % modulo) % modulo + (dp(s, cache, i + 2) % modulo) % modulo
        } else {
          cache(i) = (dp(s, cache, i + 1) % modulo) % modulo
        }
        cache(i)
    }
  }

}
