package ru.orangepigment.strings

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/longest-common-prefix]]
 */
object LongestCommonPrefix {

  def longestCommonPrefix(strs: Array[String]): String = {
    longestCommonPrefixRecursive(strs)
  }

  @tailrec
  def longestCommonPrefixRecursive(strs: Array[String], i: Int = 0, prefix: List[Char] = List.empty[Char]): String = {
    val outOfRange = strs.foldLeft(false) { case (acc, s) =>
     acc || i >= s.length
    }

    if (outOfRange) {
      prefix.reverse.mkString
    } else {
      val char = strs.head(i)
      if (strs.forall(_ (i) == char)) {
        longestCommonPrefixRecursive(strs, i + 1, char +: prefix)
      } else {
        prefix.reverse.mkString
      }
    }

  }

}
