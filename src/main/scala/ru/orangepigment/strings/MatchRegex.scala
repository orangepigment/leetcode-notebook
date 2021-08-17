package ru.orangepigment.strings

import ru.orangepigment.strings.MatchRegex.NDFA.State

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/regular-expression-matching/]]
 */
object MatchRegex {

  object NDFA {

    type State = Int

    private val INITIAL_STATE = 0
    private val ANY_CHAR = Some('.')

    def apply(pattern: String): NDFA = {
      var acceptingState: State = -1
      val transitions = mutable.LinkedHashMap.empty[(State, Option[Char]), State]

      var pi = 0
      var currentState = INITIAL_STATE
      var transitionFromPreviousState: Option[(State, Option[Char])] = None
      while (pi < pattern.length) {
        transitionFromPreviousState.foreach(transitions += _ -> currentState)

        if (pi < pattern.length - 1 && pattern(pi + 1) == '*') {
          // As
          transitions += (currentState, Some(pattern(pi))) -> currentState
          pi += 1

          transitionFromPreviousState = Some((currentState, None))
        } else {
          transitionFromPreviousState = Some((currentState, Some(pattern(pi))))
        }

        pi += 1
        currentState += 1
        if (pi == pattern.length) {
          transitionFromPreviousState.foreach(transitions += _ -> currentState)
          acceptingState = currentState
        }
      }
      new NDFA(acceptingState, transitions.toMap)
    }

  }

  class NDFA private(
                      acceptingState: NDFA.State,
                      transitions: Map[(NDFA.State, Option[Char]), NDFA.State]
                    ) {

    def matches(text: String): Boolean = {
      println(s"Accepting state is $acceptingState")
      var currentStates = Set(NDFA.INITIAL_STATE)
      println(s"Current states: ${currentStates.mkString(" ")}")

      for (letter <- text) {
        println(s"Current ch is $letter")
        //  We can make the following steps: lambda, char + lambda, lambda + char
        val reachableViaLetter = currentStates.flatMap { state =>
          transitions.get(state -> Some(letter)) ++
            transitions.get(state -> NDFA.ANY_CHAR)
        }
        println(s"States reachable via letter: ${reachableViaLetter.mkString(" ")}")

        val reachableViaLambda = transitViaLambda(currentStates)
        println(s"States reachable via lambda: ${reachableViaLambda.mkString(" ")}")

        val reachableViaLambdaAndLetter = reachableViaLambda.flatMap { state =>
          transitions.get(state -> Some(letter)) ++
            transitions.get(state -> NDFA.ANY_CHAR)
        }

        println(s"States reachable via lambda and letter: ${reachableViaLambdaAndLetter.mkString(" ")}")

        val reachableViaLambdaAndLetterAndLambda =
          reachableViaLambdaAndLetter ++ transitViaLambda(reachableViaLambdaAndLetter)

        println(s"States reachable via lambda and letter and lambda: ${reachableViaLambdaAndLetterAndLambda.mkString(" ")}")

        currentStates =
          reachableViaLetter ++ reachableViaLambdaAndLetterAndLambda

        if (currentStates.isEmpty) {
          return false
        }

        println(s"Current states: ${currentStates.mkString(" ")}\n")
      }

      // If the text is finished we still can make lambda transitions
      currentStates = transitViaLambda(currentStates)
      println(s"Current states: ${currentStates.mkString(" ")}\n")

      currentStates.contains(acceptingState)
    }

    private def transitViaLambda(currentStates: Set[NDFA.State]): Set[NDFA.State] = {
      var reachableViaLambda = currentStates.flatMap(s => transitions.get(s -> None))
      var nextReachableViaLambda = Set.empty[State]
      while (reachableViaLambda.diff(nextReachableViaLambda).nonEmpty) {
        nextReachableViaLambda = reachableViaLambda
        reachableViaLambda ++= reachableViaLambda.flatMap(s => transitions.get(s -> None))
      }
      reachableViaLambda
    }

  }

  def isMatch(s: String, p: String): Boolean = {
    val ndfa = NDFA(p)
    ndfa.matches(s)
  }

  def main(args: Array[String]): Unit = {
    println(isMatch("aa", "a*").toString)
  }

}
