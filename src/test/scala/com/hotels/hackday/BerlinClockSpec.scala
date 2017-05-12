package com.hotels.hackday

import java.io.ByteArrayOutputStream

import org.scalatest.WordSpec

import scala.io.Source

/**
  * Created by Abimbola on 12/05/2017.
  */
class BerlinClockSpec extends WordSpec {

  "A Berlin Clock application" should {

    "print instructions if the time is missing" in {

      val stream = new ByteArrayOutputStream()
      Console.withOut(stream) {
        BerlinClock.main(Array.empty[String])
      }

      val instructions = Source.fromResource("instructions.txt").mkString + sys.props("line.separator")
      assert(stream.toString === instructions)
    }
  }
}
