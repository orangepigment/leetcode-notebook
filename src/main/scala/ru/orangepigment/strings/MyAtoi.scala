package ru.orangepigment.strings

/**
 * [[https://leetcode.com/problems/string-to-integer-atoi]]
 */
object MyAtoi {

  def myAtoi(s: String): Int = {
    val trimmed = s.dropWhile(_ == ' ')
    val (sign, trimmedWithoutSign) =
      trimmed.headOption match {
        case Some('+')  => (1, trimmed.tail)
        case Some('-') => (-1, trimmed.tail)
        case _ => (1, trimmed)
      }


    val digits = trimmedWithoutSign.takeWhile(_.isDigit)
    if (digits.isEmpty) {
      0
    } else {
      val number = BigInt(digits) * sign
      if (number > Int.MaxValue) {
        Int.MaxValue
      } else if (number < Int.MinValue) {
        Int.MinValue
      } else {
        number.toInt
      }
    }
  }

}
