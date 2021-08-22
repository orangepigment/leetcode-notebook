package ru.orangepigment.strings

/**
 * [[https://leetcode.com/problems/string-compression/]]
 */
object StringCompression {

  def compress(chars: Array[Char]): Int = {
    var writePointer = 0
    var currentChar = chars(0)
    var counter = 1
    for (i <- 1 until chars.length) {
      if (chars(i) != currentChar) {
        chars(writePointer) = currentChar
        writePointer += 1
        if (counter > 1) {
          counter.toString.foreach { ch =>
            chars(writePointer) = ch
            writePointer += 1
          }
        }

        currentChar = chars(i)
        counter = 1
      } else {
        counter += 1
      }
    }

    chars(writePointer) = currentChar
    writePointer += 1
    if (counter > 1) {
      counter.toString.foreach { ch =>
        chars(writePointer) = ch
        writePointer += 1
      }
    }

    writePointer
  }

}
