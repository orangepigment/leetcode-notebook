package ru.orangepigment.data

class Node(var _value: Int) {
  var value: Int = _value
  var children: List[Node] = List()
}
