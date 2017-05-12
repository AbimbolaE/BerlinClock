package com.hotels.hackday

import java.io.ByteArrayOutputStream

import org.scalatest.WordSpec

import scala.io.Source

/**
  * Created by Abimbola on 12/05/2017.
  */
class BerlinClockSpec extends WordSpec {

  val lineSeparator = sys.props("line.separator")

  "A Berlin Clock application" should {

    "print instructions if the time is missing" in {

      val stream = new ByteArrayOutputStream()
      Console.withOut(stream) {
        BerlinClock.main(Array.empty[String])
      }

      val instructions = Source.fromResource("instructions.txt").mkString + lineSeparator
      assert(stream.toString === instructions)
    }

    "print an error message if the time is in the wrong format" in {

      val stream = new ByteArrayOutputStream()
      Console.withOut(stream) {
        BerlinClock.main(Array("badly formatted time"))
      }

      val errorMessage = "Your time is not in the correct format, please correct it (HH:mm:ss)" + lineSeparator
      assert(stream.toString === errorMessage)
    }

    "print an error message if the time is in the right format but is invalid" in {

      val stream = new ByteArrayOutputStream()
      Console.withOut(stream) {
        BerlinClock.main(Array("99:99:99"))
      }

      val errorMessage = "Your time is not in the correct format, please correct it (HH:mm:ss)" + lineSeparator
      assert(stream.toString === errorMessage)
    }
  }
}
