package ru.orangepigment.data

/**
 * [[https://leetcode.com/problems/design-front-middle-back-queue/]]
 *
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * var obj = new FrontMiddleBackQueue()
 * obj.pushFront(`val`)
 * obj.pushMiddle(`val`)
 * obj.pushBack(`val`)
 * var param_4 = obj.popFront()
 * var param_5 = obj.popMiddle()
 * var param_6 = obj.popBack()
 */
class FrontMiddleBackQueue() {

  class ListNode(
                  var value: Int = 0,
                  var next: ListNode = null,
                  var prev: ListNode = null
                )

  private var front: ListNode = _
  private var middle: ListNode = _
  private var back: ListNode = _
  private var size = 0

  def pushFront(`val`: Int): Unit = {
    val node = new ListNode(`val`, front)
    if (front == null) {
      front = node
      middle = front
      back = front
    } else {
      front.prev = node
      front = node
      if (size % 2 != 0) {
        middle = middle.prev
      }
    }
    size += 1
  }

  def pushMiddle(`val`: Int): Unit = {
    if (middle == null) {
      pushFront(`val`)
    } else if (middle.next == null) {
      pushBack(`val`)
    } else {
      val node = new ListNode(`val`)
      if (size % 2 != 0) {
        node.next = middle
        node.prev = middle.prev
        middle.prev.next = node
        middle.prev = node
        middle = node
      } else {
        node.prev = middle
        node.next = middle.next
        middle.next.prev = node
        middle.next = node
        middle = node
      }
    }
    size += 1
  }

  def pushBack(`val`: Int): Unit = {
    if (back == null) {
      pushFront(`val`)
    } else {
      val node = new ListNode(`val`, prev = back)
      back.next = node
      back = node
      if (size % 2 == 0) {
        middle = middle.next
      }
    }
    size += 1
  }

  def popFront(): Int = {
    if (front != null) {
      val res = front.value
      if (front.next == null) {
        front = null
        middle = null
        back = null
      } else {
        front = front.next
        front.prev = null
        if (size % 2 == 0) {
          middle = middle.next
        }
      }
      size -= 1
      res
    } else {
      -1
    }
  }

  def popMiddle(): Int = {
    if (front.next == null) {
      popFront()
    } else {
      val res = middle.value
      if (size % 2 != 0) {
        // Here size is >= 3 so we always have not-null prev and next
        middle.prev.next = middle.next
        middle.next.prev = middle.prev
        middle = middle.prev
      } else {
        // Here size is >= 2 so we can have prev = null and must check this case
        if (middle.prev != null) {
          middle.prev.next = middle.next
          middle.next.prev = middle.prev
          middle = middle.next
        } else {
          // size == 2 and middle == front, so update front an back as well
          // Current back becomes front
          front = middle.next
          front.prev = null
          back = front
          middle = front
        }
      }
      size -= 1
      res
    }
  }

  def popBack(): Int = {
    if (front.next == null) {
      popFront()
    } else {
      val res = back.value
      back = back.prev
      back.next = null
      if (size % 2 != 0) {
        middle = middle.prev
      }
      size -= 1
      res
    }
  }

}

object FrontMiddleBackQueue {
  def main(args: Array[String]): Unit = {
    val q = new FrontMiddleBackQueue
    q.pushMiddle(1)
    q.pushMiddle(2)
    q.pushMiddle(3)
    q.popMiddle()
    q.popMiddle()
    q.popMiddle()
  }
}
