package ru.orangepigment.strings

/**
 * [[https://leetcode.com/problems/letter-combinations-of-a-phone-number]]
 */
object LetterCombinations {

  val digitsToLetters = Map(
    '2' -> List("a", "b", "c"),
    '3' -> List("d", "e", "f"),
    '4' -> List("g", "h", "i"),
    '5' -> List("j", "k", "l"),
    '6' -> List("m", "n", "o"),
    '7' -> List("p", "q", "r", "s"),
    '8' -> List("t", "u", "v"),
    '9' -> List("w", "x", "y", "z")
  )

  def letterCombinations(digits: String): List[String] = {
    if (digits.isEmpty) {
      List.empty[String]
    } else {
      digits.map(digitsToLetters(_)).foldLeft(List("")) { case (acc, list) =>
        for {
          s1 <- acc
          s2 <- list
        } yield s1 + s2
      }
    }
  }

}
