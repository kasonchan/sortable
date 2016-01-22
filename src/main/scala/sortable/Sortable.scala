package sortable

import scala.io.Source
import scala.util.{Failure, Success, Try}

/**
  * Created by kasonchan on 1/21/16.
  */
object Sortable {

  /**
    * Read a JSON file line by line as JSON format string
    * @param pathName the directory of the JSON file
    */
  def read(pathName: String): Either[String, String] = {
    Try {
      val src = Source.fromFile(pathName)
      val lines = src.getLines().mkString("[", ",", "]")
      src.close()
      lines
    } match {
      case Success(f) => Right(f)
      case Failure(e) => Left(e.toString)
    }
  }

}
