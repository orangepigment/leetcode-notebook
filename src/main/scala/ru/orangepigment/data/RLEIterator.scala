package ru.orangepigment.data

/**
 * [[https://leetcode.com/problems/rle-iterator/]]
 *
 * Your RLEIterator object will be instantiated and called as such:
 * var obj = new RLEIterator(encoding)
 * var param_1 = obj.next(n)
 */
class RLEIterator(_encoding: Array[Int]) {

  private var pointer = 0
  private val dataLength = _encoding.length
  private var lastExhaustedElem = -1
  private var exhaustedElems = 0

  def next(n: Int): Int = {
    if (pointer == dataLength) {
      -1
    } else {
      exhaustedElems = 0

      while (exhaustedElems != n) {
        if (pointer == dataLength) {
          return -1
        }

        while (_encoding(pointer) - exhaustedElems != 0) {
          if (exhaustedElems == n) {
            return lastExhaustedElem
          }

          lastExhaustedElem = _encoding(pointer + 1)
          exhaustedElems += 1
        }

        pointer += 2
      }

      lastExhaustedElem
    }
  }

}
