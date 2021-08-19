package ru.orangepigment.apps

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/subdomain-visit-count/]]
 */
object SubdomainVisitCount {

  def subdomainVisits(cpdomains: Array[String]): List[String] = {
    val domainsXVisits = mutable.Map.empty[String, Int]

    for (e <- cpdomains) {
      val (count, domainParts) = e.split(' ') match {
        case Array(rawCount, lowLevelDomain) => (rawCount.toInt, lowLevelDomain.split('.').toList.reverse)
      }

      domainsXVisits += domainParts.head -> (domainsXVisits.getOrElse(domainParts.head, 0) + count)
      domainParts.tail.foldLeft(domainParts.head) { case (higherLevelDomain, domainPart) =>
        val domain = domainPart + "." + higherLevelDomain
        domainsXVisits += domain -> (domainsXVisits.getOrElse(domain, 0) + count)
        domain
      }
    }
    domainsXVisits.toList.map { case (d, c) => c + " " + d }
  }

}
