package com.hotels.hackday

import scala.io.Source

/**
  * Created by Abimbola on 12/05/2017.
  */
object BerlinClock {

  def main(args: Array[String]): Unit = {

    args match {
      case _ => println(Source.fromResource("instructions.txt").mkString)
    }
  }
}
