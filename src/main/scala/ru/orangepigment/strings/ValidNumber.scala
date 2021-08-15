package ru.orangepigment.strings

import scala.util.matching.Regex

// ToDo: rewrite to a custom DFA
object ValidNumber {

  val validNumber: Regex = """([+-])?((\d+)|((\d+\.)|(\d+\.\d+)|(\.\d+)))([eE]([+-])?\d+)?""".r // sign integer or decimal E and signed integer

  def isNumber(s: String): Boolean = {
    validNumber.matches(s)
  }

}
