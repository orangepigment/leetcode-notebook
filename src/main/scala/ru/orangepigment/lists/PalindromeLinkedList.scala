package ru.orangepigment.lists

import ru.orangepigment.data.ListNode

/**
 * [[https://leetcode.com/problems/palindrome-linked-list/]]
 */
object PalindromeLinkedList {

  def isPalindrome(head: ListNode): Boolean = {
    var frontPointer = head

    def isPalindromeRecursive(current: ListNode): Boolean = {
      if (current != null) {
        if (!isPalindromeRecursive(current.next)) {
          return false
        } else if (current.x != frontPointer.x) {
          return false
        } else {
          frontPointer = frontPointer.next
        }
      }
      true
    }

    isPalindromeRecursive(head)
  }

}
