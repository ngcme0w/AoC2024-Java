package meow.ngc.Day

import meow.ngc.InputHandler

import scala.util.Properties

class Two extends InputHandler {
  private val inputLocation: String = "src/inputs/Two/input"

  private val inputsAsList: List[Array[Int]] =
    getInputs(inputLocation).split(Properties.lineSeparator)
      .map(line => line
        .split(" ")
        .map(_.toInt)).toList

  private def isInConstraints(report: Array[Int]): Boolean = {
    val isIncreasing = report.sliding(2).forall {
      case Array(a, b) => (b - a >= 1) && (b - a <= 3)
    }

    val isDecreasing = report.sliding(2).forall {
      case Array(a, b) => (a - b >= 1) && (a - b <= 3)
    }

    isIncreasing || isDecreasing
  }

  def getNumberOfSafeReports: Int = {
    inputsAsList.count(report => isInConstraints(report))
  }
}