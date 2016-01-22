package sortable

import play.api.libs.json._

import scala.io.Source
import scala.util.{Failure, Success, Try}

/**
  * Created by kasonchan on 1/21/16.
  */
object Sortable {

  /**
    * Read a JSON file line by line as JSON format string
    *
    * @param pathName the directory of the JSON file
    */
  def read(pathName: String) = {
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

  /**
    * Convert raw JSON string to JSON
    *
    * @param rawJson JSON string
    */
  def toJson(rawJson: String): Either[String, JsValue] = {
    Try {
      Json.parse(rawJson)
    }
    match {
      case Success(j) => Right(j)
      case Failure(e) => Left(e.toString)
    }
  }

}
