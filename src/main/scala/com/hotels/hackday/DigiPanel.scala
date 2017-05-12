package com.hotels.hackday

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Abimbola on 12/05/2017.
  */
object DigiPanel {

  def render(clock: BerlinClock): String = {

    val newline = sys.props("line.separator")
    val divider = Array.fill(23)("-").mkString

    rowOfOne(clock.seconds).mkString + newline +
      divider + newline +
    rowOfFour("R", clock.majorHour).mkString("| ", "  |  ", " |") + newline +
      divider + newline +
    rowOfFour("R", clock.minorHour).mkString("| ", "  |  ", " |") + newline +
      divider + newline +
    rowOfEleven(1, clock.majorMinutes).mkString("|", "|", "|") + newline +
      divider + newline +
    rowOfFour("Y", clock.minorMinutes).mkString("| ", "  |  ", " |") + newline +
      divider
  }

  private def rowOfOne(seconds: Int): Array[String] = {

    val prefix = Array.fill(9)(" ")
    val light = if (seconds == 0) Array("| Y |") else Array("| _ |")
    prefix ++ light
  }

  private def rowOfFour(color: String, noOfLights: Int): Array[String] = {

    val start = Array.fill(noOfLights)(color)
    val end = Array.fill(4 - noOfLights)("_")
    start ++ end
  }

  private def rowOfEleven(position: Int, until: Int, lights:ArrayBuffer[String] = ArrayBuffer.empty[String]): Array[String] = {

    if (position > until) {

      val blanks = Array.fill(11 - until)("_")
      (lights ++= blanks).toArray
    } else {

      val color = if (position % 3 == 0) "R" else "Y"
      rowOfEleven(position + 1, until, lights += color)
    }
  }
}
