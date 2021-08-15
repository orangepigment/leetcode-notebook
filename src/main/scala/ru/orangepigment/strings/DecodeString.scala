package ru.orangepigment.strings

import scala.collection.mutable.ListBuffer

object DecodeString {

  def decodeString(s: String): String = {
    decodeImpl(s)
  }

  def decodeImpl(s: String, buffer: ListBuffer[String] = ListBuffer.empty[String]): String = {
    var pos = 0
    while (pos < s.length) {
      s(pos) match {
        case ch if ch.isLetter =>
          buffer.addOne(ch.toString)
          pos += 1
        case ch if ch.isDigit =>
          var repetitions = 0
          while (s(pos) != '[') {
            repetitions = repetitions * 10 + s(pos).asDigit
            pos += 1
          }
          // pos is now at the position of [

          // Find the position of corresponding closing bracket
          var bracketCounter = 1
          var substrIndex = pos + 1

          while (bracketCounter != 0) {
            s(substrIndex) match {
              case '[' => bracketCounter += 1
              case ']' => bracketCounter -= 1
              case _ =>
            }
            substrIndex += 1
          }
          // substrIndex is now at the position after ]

          //  Process the nested string
          for (_ <- 0 until repetitions) {
            buffer.addOne(
              decodeImpl(s.substring(pos + 1, substrIndex - 1))
            )
          }

          // Continue after the processed substring
          pos = substrIndex
      }
    }
    buffer.mkString
  }

}
