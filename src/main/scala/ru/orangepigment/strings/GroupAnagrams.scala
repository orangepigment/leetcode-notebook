package ru.orangepigment.strings

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/group-anagrams/]]
 */
object GroupAnagrams {

  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    val strToMapOfChars = strs.map { s =>
      s -> s.map(_ -> 1).groupBy(_._1).map { case (key, value) =>
        key -> value.length
      }
    }

    val res = mutable.Set.empty[List[String]]
    for ((_, strMap) <- strToMapOfChars) {
      val anagrams = strToMapOfChars.filter { case (_, otherStrMap) =>
        compareMaps(strMap, otherStrMap)
      }.map(_._1).toList

      res += anagrams
    }

    res.toList
  }

  private def compareMaps(map: Map[Char, Int], other: Map[Char, Int]): Boolean = {
    map.size == other.size &&
      map.forall { case (char, count) =>
        count == other.getOrElse(char, 0)
      }
  }

}
