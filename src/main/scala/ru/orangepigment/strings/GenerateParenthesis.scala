package ru.orangepigment.strings

/**
 * [[https://leetcode.com/problems/generate-parentheses/]]
 */
object GenerateParenthesis {

  def generateParenthesis(n: Int): List[String] = {
    generateRecursive(2 * n)
  }

  def generateRecursive(leftSymbols: Int, openedBrackets: Int = 0, acc: List[String] = List("")): List[String] = {
    if (leftSymbols == 0) {
      acc
    } else if (openedBrackets == 0) {
      generateRecursive(
        leftSymbols - 1,
        1,
        acc.map(s => s + "(")
      )
    } else if (openedBrackets < leftSymbols) {
      generateRecursive(
        leftSymbols - 1,
        openedBrackets - 1,
        acc.map(s => s + ")")
      ) ++
        generateRecursive(
          leftSymbols - 1,
          openedBrackets + 1,
          acc.map(s => s + "(")
        )
    } else {
      generateRecursive(
        leftSymbols - 1,
        openedBrackets - 1,
        acc.map(s => s + ")")
      )
    }
  }

}
