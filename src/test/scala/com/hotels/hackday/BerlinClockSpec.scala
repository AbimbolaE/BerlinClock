package com.hotels.hackday

import java.io.ByteArrayOutputStream

import org.scalatest.WordSpec
import org.scalatest.Matchers._

import scala.io.Source

/**
  * Created by Abimbola on 12/05/2017.
  */
class BerlinClockSpec extends WordSpec {

  "A Berlin Clock application" should {

    val lineSeparator = sys.props("line.separator")

    "print instructions if the time is missing" in {

      val stream = new ByteArrayOutputStream()
      Console.withOut(stream) {
        BerlinClock.main(Array.empty[String])
      }

      val instructions = Source.fromResource("instructions.txt").mkString + lineSeparator
      stream.toString should be (instructions)
    }

    "print a clock panel if the time is valid and in the correct format" in {

      val stream = new ByteArrayOutputStream()
      Console.withOut(stream) {
        BerlinClock.main(Array("17:01:21"))
      }

      val panel = Source.fromResource("17-01-21.txt").mkString + lineSeparator
      stream.toString should be (panel)
    }

    "print an error message if the input is not a time" in {

      val stream = new ByteArrayOutputStream()
      Console.withOut(stream) {
        BerlinClock.main(Array("not-a-time"))
      }

      val errorMessage = "Your time is not in the correct format, please correct it (HH:mm:ss)" + lineSeparator
      stream.toString should be (errorMessage)
    }

    "print an error message if the time is in the wrong format" in {

      val stream = new ByteArrayOutputStream()
      Console.withOut(stream) {
        BerlinClock.main(Array("1:00"))
      }

      val errorMessage = "Your time is not in the correct format, please correct it (HH:mm:ss)" + lineSeparator
      stream.toString should be (errorMessage)
    }

    "print an error message if the time is in the right format but is invalid" in {

      val stream = new ByteArrayOutputStream()
      Console.withOut(stream) {
        BerlinClock.main(Array("99:99:99"))
      }

      val errorMessage = "Your time is not in the correct format, please correct it (HH:mm:ss)" + lineSeparator
      stream.toString should be (errorMessage)
    }
  }

  "A Berlin Clock" should {

    "contain the correct values for 00:00:00" in {

      val clock = new BerlinClock(0, 0, 0)

      clock.seconds should be (0)
      clock.majorHour should be (0)
      clock.minorHour should be (0)
      clock.majorMinutes should be (0)
      clock.minorMinutes should be (0)
    }

    "contain the correct values for 17:01:21" in {

      val clock = new BerlinClock(17, 1, 21)

      clock.seconds should be (1)
      clock.majorHour should be (3)
      clock.minorHour should be (2)
      clock.majorMinutes should be (0)
      clock.minorMinutes should be (1)
    }

    "contain the correct values for 23:59:59" in {

      val clock = new BerlinClock(23, 59, 59)

      clock.seconds should be (1)
      clock.majorHour should be (4)
      clock.minorHour should be (3)
      clock.majorMinutes should be (11)
      clock.minorMinutes should be (4)
    }
  }
}
