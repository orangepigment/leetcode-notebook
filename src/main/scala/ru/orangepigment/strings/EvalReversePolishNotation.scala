package ru.orangepigment.strings

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/evaluate-reverse-polish-notation/]]
 */
object EvalReversePolishNotation {

  def evalRPN(tokens: Array[String]): Int = {
    val stack = mutable.Stack.empty[Int]
    for (t <- tokens) {
      t match {
        case "+" =>
          val res = stack.pop() + stack.pop()
          stack.push(res)
        case "-" =>
          val op2 =stack.pop()
          val op1 =stack.pop()
          val res = op1 - op2
          stack.push(res)
        case "*" =>
          val res = stack.pop() * stack.pop()
          stack.push(res)
        case "/" =>
          val op2 =stack.pop()
          val op1 =stack.pop()
          val res = op1 / op2
          stack.push(res)
        case _ => stack.push(t.toInt)
      }
    }
    stack.pop()
  }

}
