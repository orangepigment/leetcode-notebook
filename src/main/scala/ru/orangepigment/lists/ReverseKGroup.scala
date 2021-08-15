package ru.orangepigment.lists

import ru.orangepigment.data.ListNode

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/reverse-nodes-in-k-group/]]
 */
object ReverseKGroup {

  def reverseKGroup(head: ListNode, k: Int): ListNode = {
    if (k == 1) {
      head
    } else {
      reverseKGroupRecursive(head, head, k)
    }
  }

  def reverseKGroupRecursive(head: ListNode, current: ListNode, k: Int, counter: Int = 1): ListNode = {
    if (current == null) {
      null
    } else if (counter < k) {
      if (current.next != null) {
        reverseKGroupRecursive(head, current.next, k, counter + 1)
      } else {
        head
      }
    } else {
      val newHead = current.next
      current.next = null
      val reversedGroup = reverseRecursive(head)
      head.next = reverseKGroupRecursive(newHead, newHead, k)
      reversedGroup
    }
  }

  @tailrec
  private def appendList(current: ListNode, newNode: ListNode): Unit = {
    if (current.next == null) {
      current.next = newNode
    } else {
      appendList(current.next, newNode)
    }
  }

  @tailrec
  def reverseRecursive(current: ListNode, prev: ListNode = null): ListNode = {
    if (current == null) {
      prev
    } else if (prev == null) {
      val nxt = current.next
      current.next = null
      reverseRecursive(nxt, current)
    } else {
      val nxt = current.next
      current.next = prev
      reverseRecursive(nxt, current)
    }
  }

}
