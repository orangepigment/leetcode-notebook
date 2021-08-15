package ru.orangepigment.strings

object ValidNumberTest {

  val validNumbers = Seq("2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789")
  val invalidNumbers = Seq("abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53")

  def main(args: Array[String]): Unit = {
    validNumbers.foreach { s =>
      require(ValidNumber.isNumber(s), s"$s is a valid number")
    }

    invalidNumbers.foreach { s =>
      require(!ValidNumber.isNumber(s), s"$s is not a valid number")
    }
  }

}
