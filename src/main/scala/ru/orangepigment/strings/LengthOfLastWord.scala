package ru.orangepigment.strings

/**
 * [[https://leetcode.com/problems/length-of-last-word]]
 */
object LengthOfLastWord {

  def lengthOfLastWord(s: String): Int = {
    s.foldLeft((0, 0)) { case (acc, ch) =>
      if (ch != ' ') (acc._1 + 1, acc._1 + 1) else (0, acc._2)
    }._2
  }

}
