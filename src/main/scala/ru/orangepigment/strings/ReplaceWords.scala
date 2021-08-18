package ru.orangepigment.strings

/**
 * [[https://leetcode.com/problems/replace-words/]]
 */
object ReplaceWords {

  def replaceWords(dictionary: List[String], sentence: String): String = {
    val sortedDict = dictionary.sortBy(_.length)
    sentence.split(" ").map { word =>
      sortedDict.find(word.startsWith) match {
        case Some(prefix) => prefix
        case None => word
      }
    }.mkString(" ")
  }

}
