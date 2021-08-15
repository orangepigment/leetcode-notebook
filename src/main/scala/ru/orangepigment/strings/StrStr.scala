package ru.orangepigment.strings

object StrStr {

  def strStr(haystack: String, needle: String): Int = {
    (haystack, needle) match {
      case (_, "") => 0
      case ("", _) => -1
      case (_, _) =>
        var offset = 0
        var i = needle.length - 1
        var found = false
        while (i + offset < haystack.length && !found) {
          while (i >= 0) {
            val curChar = haystack(i + offset)
            if (curChar == needle(i)) {
              i -= 1
            } else {
              offset += 1

              var j = needle.length - 2
              while (j >= 0 && curChar != needle(j)) {
                offset += 1
                j -= 1
              }

              i = -100
            }
          }
          found = i == -1
          i = needle.length - 1
        }
        if (offset + needle.length <= haystack.length) offset else -1
    }
  }

  /*
  "ababbbbaaabbbaaa"
"bbbb"
   */
  def main(args: Array[String]): Unit = {
    println(strStr("ababbbbaaabbbaaa", "bbbb"))
  }

}
