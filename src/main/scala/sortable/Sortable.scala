package sortable

import java.io.{File, PrintWriter}

import play.api.libs.json._

import scala.io.Source

/**
  * Created by kasonchan on 1/21/16.
  */
object Sortable {

  /**
    * Read a JSON file line by line as sequence of raw JSON string.
    *
    * @param pathName directory of the JSON file
    */
  def readAsSeq(pathName: String): Seq[String] = {
    val src = Source.fromFile(pathName)
    val lines = src.getLines().toSeq
    lines
  }

  /**
    * Convert raw JSON string to JSON.
    *
    * @param rawJson raw JSON string
    */
  def toJson(rawJson: String): JsValue = {
    Json.parse(rawJson)
  }

  /**
    * Associate the product objects with list of matching listing objects.
    *
    * @param productsJson list of product objects
    * @param listingsJson list of listing objects
    * @return
    */
  def associate(productsJson: Seq[JsValue], listingsJson: Seq[JsValue]): Seq[JsObject] = {
    for {
      pj <- productsJson
    } yield Json.obj("product_name" -> (pj \ "product_name").as[String],
      "listings" -> listingsJson.filter(l =>
        // TODO: Check manufacturer, family and model name in title
        (// manufacturer, family, model in the title
          ((l \ "title").as[String].toLowerCase contains (pj \ "manufacturer").as[String].toLowerCase) &&
            ((l \ "title").as[String].toLowerCase contains (pj \ "family").asOpt[String].getOrElse("").toLowerCase) &&
            ((l \ "title").as[String].toLowerCase contains (pj \ "model").as[String].toLowerCase) &&
            (pj \ "manufacturer").as[String].toLowerCase == (l \ "manufacturer").as[String].toLowerCase
          ) || (// manufacturer, model in the title
          ((l \ "title").as[String].toLowerCase contains (pj \ "manufacturer").as[String].toLowerCase) &&
            ((l \ "title").as[String].toLowerCase contains (pj \ "model").as[String].toLowerCase) &&
            (pj \ "manufacturer").as[String].toLowerCase == (l \ "manufacturer").as[String].toLowerCase
          )
      )
    )
  }

  /**
    * Print the output to the terminal and to the filename.
    *
    * @param output   output string
    * @param filename filename of the output
    */
  def print(output: String, filename: String): Unit = {
    println(output)
    val writer = new PrintWriter(new File(filename))
    writer.write(output)
    writer.close()
  }

  def main(args: Array[String]): Unit = {
    val products = readAsSeq("resources/data/products.txt")
    val listings = readAsSeq("resources/data/listings.txt")

    val productsJson = products.map(p => toJson(p))
    val listingsJson = listings.map(l => toJson(l))

    val result = associate(productsJson, listingsJson).mkString("", "\n", "")

    print(result, "results.txt")
  }

}
