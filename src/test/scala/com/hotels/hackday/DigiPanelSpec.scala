package com.hotels.hackday

import org.scalatest.WordSpec
import org.scalatest.Matchers._

import scala.io.Source

/**
  * Created by Abimbola on 12/05/2017.
  */
class DigiPanelSpec extends WordSpec {

  "A DigiPanel" should {

    "contain the correct values for 00:00:00" in {

      val clock = new BerlinClock(0, 0, 0)

      val expectedPanel = Source.fromResource("00-00-00.txt").mkString
      DigiPanel.render(clock) should be (expectedPanel)
    }

    "contain the correct values for 17:01:21" in {

      val clock = new BerlinClock(17, 1, 21)

      val expectedPanel = Source.fromResource("17-01-21.txt").mkString
      DigiPanel.render(clock) should be (expectedPanel)
    }

    "contain the correct values for 23:59:59" in {

      val clock = new BerlinClock(23, 59, 59)

      val expectedPanel = Source.fromResource("23-59-59.txt").mkString
      DigiPanel.render(clock) should be (expectedPanel)
    }
  }
}
