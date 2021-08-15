package ru.orangepigment.strings

/**
 * [[https://leetcode.com/problems/integer-to-roman/]]
 */
object IntToRoman {

  def intToRoman(num: Int): String = {
    val sb = new StringBuilder()

    val rawNum = num.toString
    val numDigits = rawNum.length

    for (i <- 0 until numDigits) {
      val digit = numDigits - i
      rawNum(i) match {
        case '0' =>
        case '1' =>
          digit match {
            case 4 => sb.append("M")
            case 3 => sb.append("C")
            case 2 => sb.append("X")
            case 1 => sb.append("I")
          }

        case '2' =>
          digit match {
            case 4 => sb.append("MM")
            case 3 => sb.append("CC")
            case 2 => sb.append("XX")
            case 1 => sb.append("II")
          }

        case '3' =>
          digit match {
            case 4 => sb.append("MMM")
            case 3 => sb.append("CCC")
            case 2 => sb.append("XXX")
            case 1 => sb.append("III")
          }

        case '4' =>
          digit match {
            case 3 => sb.append("CD")
            case 2 => sb.append("XL")
            case 1 => sb.append("IV")
          }

        case '5' =>
          digit match {
            case 3 => sb.append("D")
            case 2 => sb.append("L")
            case 1 => sb.append("V")
          }

        case '6' =>
          digit match {
            case 3 => sb.append("DC")
            case 2 => sb.append("LX")
            case 1 => sb.append("VI")
          }

        case '7' =>
          digit match {
            case 3 => sb.append("DCC")
            case 2 => sb.append("LXX")
            case 1 => sb.append("VII")
          }

        case '8' =>
          digit match {
            case 3 => sb.append("DCCC")
            case 2 => sb.append("LXXX")
            case 1 => sb.append("VIII")
          }

        case '9' =>
          digit match {
            case 3 => sb.append("CM")
            case 2 => sb.append("XC")
            case 1 => sb.append("IX")
          }
      }
    }

    sb.toString
  }

}
