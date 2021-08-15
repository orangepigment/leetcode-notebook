package ru.orangepigment.strings

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/add-binary]]
 */
object AddBinary {

  def addBinary(a: String, b: String): String = {
    (a, b) match {
      case ("0", "0") => "0"
      case ("0", _) => b
      case (_, "0") => a
      case _ =>
        val s = mutable.ListBuffer.empty[String]
        var carry = false

        for ((ai, bj) <- a.reverse.zipAll(b.reverse, '0', '0')) {

          (ai, bj, carry) match {
            case ('0', '0', false) =>
              s.prepend("0")

            case ('0', '0', true) =>
              s.prepend("1")
              carry = false

            case ('0', '1', false) =>
              s.prepend("1")

            case ('0', '1', true) =>
              s.prepend("0")

            case ('1', '0', false) =>
              s.prepend("1")

            case ('1', '0', true) =>
              s.prepend("0")

            case ('1', '1', false) =>
              s.prepend("0")
              carry = true

            case ('1', '1', true) =>
              s.prepend("1")

            case other => println(other)
          }
        }

        if (carry) s.prepend("1")

        s.mkString
    }
  }

}
