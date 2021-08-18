package ru.orangepigment.data

import scala.annotation.tailrec
import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/implement-trie-prefix-tree/]]
 *
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
class Trie() {

  case class TrieNode(
                       letter: Char,
                       isWordEnd: Boolean = false,
                       children: Map[Char, TrieNode] = Map.empty[Char, TrieNode]
                     )

  /** Initialize your data structure here. */
  private val data = mutable.Map.empty[Char, TrieNode]


  /** Inserts a word into the trie. */
  def insert(word: String): Unit = {
    data.get(word(0)) match {
      case Some(trie) =>
        data += word(0) -> insertImpl(trie, word)

      case None =>
        data += word(0) -> insertImpl(TrieNode(word(0)), word)
    }
  }

  @tailrec
  private def insertImpl(
                          trie: TrieNode,
                          word: String,
                          index: Int = 1,
                          parents: List[TrieNode] = List.empty[TrieNode]
                        ): TrieNode = {
    if (index == word.length) {
      // If th node is word end - modify nothing
      parents match {
        case head :: tail =>
          updateParents(
            head.copy(children = head.children + (trie.letter -> trie.copy(isWordEnd = true))),
            tail
          )

        case Nil =>
          trie.copy(isWordEnd = true)
      }
    } else {
      trie.children.get(word(index)) match {
        case Some(child) =>
          insertImpl(child, word, index + 1, trie +: parents)
        case None =>
          insertImpl(TrieNode(word(index)), word, index + 1, trie +: parents)
      }
    }
  }

  @tailrec
  private def updateParents(trie: TrieNode, parents: List[TrieNode]): TrieNode = {
    parents match {
      case head :: tail =>
        updateParents(
          head.copy(children = head.children + (trie.letter -> trie)),
          tail
        )

      case Nil =>
        trie
    }
  }

  /** Returns if the word is in the trie. */
  def search(word: String): Boolean = {
    data.get(word(0)) match {
      case Some(trie) =>
        searchRec(trie, word)

      case None => false
    }
  }

  @tailrec
  private def searchRec(trie: TrieNode, word: String, index: Int = 1): Boolean = {
    if (index == word.length) {
      trie.isWordEnd
    } else {
      trie.children.get(word(index)) match {
        case Some(child) => searchRec(child, word, index + 1)
        case None => false
      }
    }
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  def startsWith(prefix: String): Boolean = {
    data.get(prefix(0)) match {
      case Some(trie) =>
        startsWithRec(trie, prefix)

      case None => false
    }
  }

  @tailrec
  private def startsWithRec(trie: TrieNode, word: String, index: Int = 1): Boolean = {
    if (index == word.length) {
      true
    } else {
      trie.children.get(word(index)) match {
        case Some(child) => startsWithRec(child, word, index + 1)
        case None => false
      }
    }
  }

}
