package com.hotels.hackday

import scala.io.Source
import scala.util.matching.Regex

/**
  * Created by Abimbola on 12/05/2017.
  */
object BerlinClock {

  val timeFormat: Regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]".r

  def main(args: Array[String]): Unit = {

    args.headOption match {
      case Some(time) =>

        time match {
          case timeFormat(hour, minutes, seconds) => ???
          case _ => showErrorMessage()
        }
      case None => showInstructions()
    }
  }

  private def showInstructions() = println(Source.fromResource("instructions.txt").mkString)
  private def showErrorMessage() = println("Your time is not in the correct format, please correct it (HH:mm:ss)")
}
