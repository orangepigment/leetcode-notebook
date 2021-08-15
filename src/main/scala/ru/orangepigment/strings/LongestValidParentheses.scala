package ru.orangepigment.strings

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/valid-parentheses]]
 */
object LongestValidParentheses {
  def longestValidParentheses(s: String): Int = {
    var res = 0
    if (s.isEmpty) return res

    for (i <- 0 until s.length - 1) {
      val length = findLongestValidParentheses(s, i)
      if (length > res) {
        res = length
      }
    }

    res
  }

  @tailrec
  def findLongestValidParentheses(
                                   s: String,
                                   currentIndex: Int,
                                   counter: Int = 0,
                                   currentLength: Int = 0,
                                   maxLength: Int = 0
                                 ): Int = {
    if (currentIndex == s.length) {
      maxLength
    } else {
      s(currentIndex) match {
        case '(' =>
          findLongestValidParentheses(s, currentIndex + 1, counter + 1, currentLength + 1, maxLength)

        case ')' =>
          val shiftedCounter = counter - 1

          if (shiftedCounter < 0) {
            maxLength
          } else if (shiftedCounter == 0) {
            findLongestValidParentheses(s, currentIndex + 1, counter - 1, currentLength + 1, currentLength + 1)
          } else {
            findLongestValidParentheses(s, currentIndex + 1, counter - 1, currentLength + 1, maxLength)
          }
      }
    }
  }

}