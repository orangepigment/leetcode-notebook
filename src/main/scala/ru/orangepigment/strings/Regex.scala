package ru.orangepigment.strings

object Regex {
  def isMatch(s: String, p: String): Boolean = {
    if (p == ".*") return true

    var si = 0
    val sLength = s.length
    val pLength = p.length
    for ((pch, pi) <- p.zipWithIndex) {
      // ToDo: cover .* case
      pch match {
        case '*' => // We cover it in letter and * branch
        case letter if pi + 1 < pLength && p(pi + 1) == '*' =>
          if (pi + 2 < pLength && charMatch(p(pi + 2), letter) || hasOtherOptionalChars(p, pi + 2, letter)) {
            // Be not greedy
            println(s"Non-greedy $letter, si is $si")
            while (si < sLength - 1 && charMatch(s(si), letter) && (letter == '.' || s.substring(si + 1).contains(letter))) {
              si += 1
            }
          } else {
            println(s"Greedy $letter, si is $si")
            while (si < sLength && charMatch(s(si), letter)) {
              si += 1
            }
          }

        case letter =>
          println(s"Just $letter, si is $si")
          if (si < sLength && charMatch(s(si), letter)) {
            si += 1
          } else {
            println("Bad string")
            return false
          }
      }
    }
    si == sLength
  }

  def charMatch(char: Char, p: Char): Boolean = {
    char == p || p == '.'
  }

  def hasOtherOptionalChars(p: String, pi: Int, letter: Char): Boolean = {
    val letterInd = p.substring(pi).indexOf(letter)
    if (letterInd == -1) {
      false
    } else {
      val substr = p.substring(pi, pi + letterInd)
      substr.length % 2 == 0 && substr.count(_ == '*') == substr.length / 2
    }
  }

}