package ru.orangepigment.strings

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
      var currentStates = Set(NDFA.INITIAL_STATE)

      for (letter <- text) {
        //  We can make the following steps: lambda, lambda + char
        val reachableViaLetter = currentStates.flatMap { state =>
          transitions.get(state -> Some(letter)) ++
            transitions.get(state -> NDFA.ANY_CHAR)
        }

        val reachableViaLambda = transitViaLambda(currentStates)

        val reachableViaLambdaAndLetter = reachableViaLambda.flatMap { state =>
          transitions.get(state -> Some(letter)) ++
            transitions.get(state -> NDFA.ANY_CHAR)
        }

        currentStates = reachableViaLetter ++ reachableViaLambdaAndLetter

        if (currentStates.isEmpty) {
          return false
        }
      }

      // If the text is finished we still can make lambda transitions
      currentStates = currentStates ++ transitViaLambda(currentStates)

      currentStates.contains(acceptingState)
    }

    private def transitViaLambda(currentStates: Set[NDFA.State]): Set[NDFA.State] = {
      var reachableViaLambda = currentStates.flatMap(s => transitions.get(s -> None))
      var nextReachableViaLambda = Set.empty[NDFA.State]
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

}

