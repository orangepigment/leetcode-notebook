package ru.orangepigment.strings

/**
 * https://leetcode.com/problems/roman-to-integer
 */
object RomanToInteger {

  def romanToInt(s: String): Int = {
    var acc = 0
    var i = 0

    while (i != s.length) {
      val possibleLookahead = i + 1 != s.length
      s(i) match {
        case 'I' if possibleLookahead =>
          // Lookahead
          s(i + 1) match {
            case 'V' =>
              acc += 4
              i += 1
            case 'X' =>
              acc += 9
              i += 1
            case _ => acc += 1
          }

        case 'I' => acc += 1

        case 'V' => acc += 5

        case 'X' if possibleLookahead =>
          // Lookahead
          s(i + 1) match {
            case 'L' =>
              acc += 40
              i += 1
            case 'C' =>
              acc += 90
              i += 1
            case _ => acc += 10
          }
        case 'X' => acc += 10

        case 'L' => acc += 50

        case 'C' if possibleLookahead =>
          // Lookahead
          s(i + 1) match {
            case 'D' =>
              acc += 400
              i += 1
            case 'M' =>
              acc += 900
              i += 1
            case _ => acc += 100
          }
        case 'C' => acc += 100

        case 'D' => acc += 500
        case 'M' => acc += 1000
      }
      i += 1
    }

    acc
  }

}
