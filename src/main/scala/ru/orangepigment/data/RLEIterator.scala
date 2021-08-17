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

  def next(n: Int): Int = {
    var counter = n
    while (pointer < _encoding.length) {
      if (counter <= _encoding(pointer)) {
        _encoding(pointer) -= counter
        return _encoding(pointer + 1)
      }

      counter -= _encoding(pointer)
      pointer += 2
    }

    -1
  }

}
