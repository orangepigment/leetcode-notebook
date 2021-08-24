package ru.orangepigment.strings

/**
 * [[https://leetcode.com/problems/reverse-words-in-a-string-iii/]]
 */
object ReverseWords {

  def reverseWords(s: String): String = {
    var left = 0
    var right = 1
    val chars = s.toArray

    while (left < s.length ) {
      while (right < s.length && s(right) != ' ') {
        right += 1
      }

      var i = 0
      while (left + i <= (left + right) / 2 - 1) {
        val tmp = chars(left + i)
        chars(left + i) = chars(right - 1 - i)
        chars(right - 1 - i) = tmp
        i += 1
      }

      left = right + 1 // first letter of the next word
      right = left + 1
    }

    chars.mkString
  }

}
