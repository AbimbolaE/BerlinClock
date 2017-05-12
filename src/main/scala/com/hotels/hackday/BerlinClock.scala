package com.hotels.hackday

import scala.io.Source
import scala.util.matching.Regex

/**
  * Created by Abimbola on 12/05/2017.
  */
case class BerlinClock private (seconds: Int, majorHour: Int, minorHour: Int, majorMinutes: Int, minorMinutes: Int) {

  def this(hours: Int, minutes: Int, seconds: Int) {
    this(seconds % 2, hours / 5, hours % 5, minutes / 5, minutes % 5)
  }
}

object BerlinClock {

  val `24-hour-format`: Regex = "([01][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])".r

  def main(args: Array[String]): Unit = {

    args.headOption match {
      case Some(time) =>

        time match {
          case `24-hour-format`(hours, minutes, seconds) =>

            val clock = new BerlinClock(hours.toInt, minutes.toInt, seconds.toInt)
            val panel = DigiPanel.render(clock)
            println(panel)
          case _ => showErrorMessage()
        }
      case None => showInstructions()
    }
  }

  private def showInstructions() = println(Source.fromResource("instructions.txt").mkString)
  private def showErrorMessage() = println("Your time is not in the correct format, please correct it (HH:mm:ss)")
}
