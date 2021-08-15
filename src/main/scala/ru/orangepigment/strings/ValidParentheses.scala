package ru.orangepigment.strings

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/valid-parentheses]]
 */
object ValidParentheses {

  def isValid(s: String): Boolean = {
    if (s.length % 2 != 0) return false

    val stack = mutable.Stack.empty[Char]
    for (ch <- s) {
      ch match {
        case '(' | '{' | '[' => stack.push(ch)
        case ')' | '}' | ']' if stack.nonEmpty =>
          (stack.pop(), ch) match {
            case ('(', ')') | ('{', '}') | ('[', ']') =>
            case _ => return false
          }
        case _ => return false
      }
    }
    if (stack.isEmpty) {
      true
    } else {
      false
    }
  }

}
