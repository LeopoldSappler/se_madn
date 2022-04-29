package MADN.util

import MADN.util.Observable
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ObservableSpec extends AnyWordSpec with Matchers{
  val observable = new Observable
  var updated = false
  val observer: Observer = new Observer {
    override def update(): Unit =
      updated = true
  }

  "observable should have subscriber" in {
    observable.add(observer)
    observable.subscribers.contains(observer) should be (true)
  }

  "observable should not have subscriber" in {
    observable.remove(observer)
    observable.subscribers.contains(observer) should be (false)
  }

  "observable should have updated" in {
    observable.add(observer)
    observable.notifyObservers()
    updated should be (true)
  }
}
