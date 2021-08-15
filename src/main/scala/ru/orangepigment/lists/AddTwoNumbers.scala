package ru.orangepigment.lists

import ru.orangepigment.data.ListNode

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/add-two-numbers/]]
 */
object AddTwoNumbers {

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    val sum = listToNumber(l1) + listToNumber(l2)
    numberToList(sum.toString)
  }

  @tailrec
  def listToNumber(l: ListNode, power: BigInt = 1, acc: BigInt = 0): BigInt = {
    if (l == null) {
      acc
    } else {
      listToNumber(l.next, power * 10, acc + l.x * power)
    }
  }

  @tailrec
  def numberToList(num: Seq[Char], list: ListNode = null): ListNode = {
    if (num.isEmpty) {
      list
    } else {
      numberToList(num.tail, new ListNode(num.head.asDigit, list))
    }
  }

  def main(args: Array[String]): Unit = {
    addTwoNumbers(
      new ListNode(2, new ListNode(4, new ListNode(3, null))),
      new ListNode(5, new ListNode(6, new ListNode(4, null)))
    )
  }

}
