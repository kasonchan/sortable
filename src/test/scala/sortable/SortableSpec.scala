package sortable

import org.scalatest.{FlatSpec, Matchers}
import play.api.libs.json.Json
import sortable.Sortable.{associate, main, print, readAsSeq, toJson}

/**
  * Created by kasonchan on 1/22/16.
  */
class SortableSpec extends FlatSpec with Matchers {

  "readAsSeq" should "pass" in {
    readAsSeq("resources/data/testListings.txt") shouldBe
      Stream("{\"title\":\"LED Flash Macro Ring Light (48 X LED) with 6 Adapter Rings for For Canon/Sony/Nikon/Sigma Lenses\",\"manufacturer\":\"Neewer Electronics Accessories\",\"currency\":\"CAD\",\"price\":\"35.99\"}",
        "{\"title\":\"Canon PowerShot SX130IS 12.1 MP Digital Camera with 12x Wide Angle Optical Image Stabilized Zoom with 3.0-Inch LCD\",\"manufacturer\":\"Canon Canada\",\"currency\":\"CAD\",\"price\":\"199.96\"}",
        "{\"title\":\"Samsung TL240 - Digital camera - compact - 14.2 Mpix - optical zoom: 7 x - supported memory: microSD, microSDHC - black\",\"manufacturer\":\"Samsung\",\"currency\":\"USD\",\"price\":\"210.00\"}",
        "{\"title\":\"Samsung TL240 - Digital camera - compact - 14.2 Mpix - optical zoom: 7 x - supported memory: microSD, microSDHC - black\",\"manufacturer\":\"Samsung\",\"currency\":\"USD\",\"price\":\"265.99\"}",
        "{\"title\":\"Samsung TL240 - Digital camera - compact - 14.2 Mpix - optical zoom: 7 x - supported memory: microSD, microSDHC - black\",\"manufacturer\":\"Samsung\",\"currency\":\"USD\",\"price\":\"275.35\"}")
    readAsSeq("resources/data/testProducts.txt") shouldBe
      Stream("{\"product_name\":\"Samsung_TL240\",\"manufacturer\":\"Samsung\",\"model\":\"TL240\",\"announced-date\":\"2010-01-05T19:00:00.000-05:00\"}",
        "{\"product_name\":\"Nikon-s6100\",\"manufacturer\":\"Nikon\",\"model\":\"S6100\",\"family\":\"Coolpix\",\"announced-date\":\"2011-02-08T19:00:00.000-05:00\"}",
        "{\"product_name\":\"Samsung_TL220\",\"manufacturer\":\"Samsung\",\"model\":\"TL220\",\"announced-date\":\"2009-08-12T20:00:00.000-04:00\"}",
        "{\"product_name\":\"Fujifilm-T205\",\"manufacturer\":\"Fujifilm\",\"model\":\"T205\",\"family\":\"FinePix\",\"announced-date\":\"2011-02-15T19:00:00.000-05:00\"}",
        "{\"product_name\":\"Casio_QV-5000SX\",\"manufacturer\":\"Casio\",\"model\":\"QV-5000SX\",\"announced-date\":\"1998-04-19T20:00:00.000-04:00\"}",
        "{\"product_name\":\"Canon_Digital_IXUS_130_IS\",\"manufacturer\":\"Canon\",\"model\":\"130 IS\",\"family\":\"Digital IXUS\",\"announced-date\":\"2010-02-07T19:00:00.000-05:00\"}")
    intercept[java.io.FileNotFoundException] {
      readAsSeq("")
    }
    intercept[java.io.FileNotFoundException] {
      readAsSeq("x")
    }
  }

  "toJson" should "pass" in {
    toJson("[{\"product_name\":\"Samsung_TL240\",\"manufacturer\":\"Samsung\",\"model\":\"TL240\",\"announced-date\":\"2010-01-05T19:00:00.000-05:00\"}," +
      "{\"product_name\":\"Nikon-s6100\",\"manufacturer\":\"Nikon\",\"model\":\"S6100\",\"family\":\"Coolpix\",\"announced-date\":\"2011-02-08T19:00:00.000-05:00\"}," +
      "{\"product_name\":\"Samsung_TL220\",\"manufacturer\":\"Samsung\",\"model\":\"TL220\",\"announced-date\":\"2009-08-12T20:00:00.000-04:00\"}," +
      "{\"product_name\":\"Fujifilm-T205\",\"manufacturer\":\"Fujifilm\",\"model\":\"T205\",\"family\":\"FinePix\",\"announced-date\":\"2011-02-15T19:00:00.000-05:00\"}," +
      "{\"product_name\":\"Casio_QV-5000SX\",\"manufacturer\":\"Casio\",\"model\":\"QV-5000SX\",\"announced-date\":\"1998-04-19T20:00:00.000-04:00\"}," +
      "{\"product_name\":\"Canon_Digital_IXUS_130_IS\",\"manufacturer\":\"Canon\",\"model\":\"130 IS\",\"family\":\"Digital IXUS\",\"announced-date\":\"2010-02-07T19:00:00.000-05:00\"}]") shouldBe
      Json.parse("[{\"product_name\":\"Samsung_TL240\",\"manufacturer\":\"Samsung\",\"model\":\"TL240\",\"announced-date\":\"2010-01-05T19:00:00.000-05:00\"}," +
        "{\"product_name\":\"Nikon-s6100\",\"manufacturer\":\"Nikon\",\"model\":\"S6100\",\"family\":\"Coolpix\",\"announced-date\":\"2011-02-08T19:00:00.000-05:00\"}," +
        "{\"product_name\":\"Samsung_TL220\",\"manufacturer\":\"Samsung\",\"model\":\"TL220\",\"announced-date\":\"2009-08-12T20:00:00.000-04:00\"}," +
        "{\"product_name\":\"Fujifilm-T205\",\"manufacturer\":\"Fujifilm\",\"model\":\"T205\",\"family\":\"FinePix\",\"announced-date\":\"2011-02-15T19:00:00.000-05:00\"}," +
        "{\"product_name\":\"Casio_QV-5000SX\",\"manufacturer\":\"Casio\",\"model\":\"QV-5000SX\",\"announced-date\":\"1998-04-19T20:00:00.000-04:00\"}," +
        "{\"product_name\":\"Canon_Digital_IXUS_130_IS\",\"manufacturer\":\"Canon\",\"model\":\"130 IS\",\"family\":\"Digital IXUS\",\"announced-date\":\"2010-02-07T19:00:00.000-05:00\"}]")
    toJson("[{\"title\":\"LED Flash Macro Ring Light (48 X LED) with 6 Adapter Rings for For Canon/Sony/Nikon/Sigma Lenses\",\"manufacturer\":\"Neewer Electronics Accessories\",\"currency\":\"CAD\",\"price\":\"35.99\"}," +
      "{\"title\":\"Canon PowerShot SX130IS 12.1 MP Digital Camera with 12x Wide Angle Optical Image Stabilized Zoom with 3.0-Inch LCD\",\"manufacturer\":\"Canon Canada\",\"currency\":\"CAD\",\"price\":\"199.96\"}]") shouldBe
      Json.parse("[{\"title\":\"LED Flash Macro Ring Light (48 X LED) with 6 Adapter Rings for For Canon/Sony/Nikon/Sigma Lenses\",\"manufacturer\":\"Neewer Electronics Accessories\",\"currency\":\"CAD\",\"price\":\"35.99\"}," +
        "{\"title\":\"Canon PowerShot SX130IS 12.1 MP Digital Camera with 12x Wide Angle Optical Image Stabilized Zoom with 3.0-Inch LCD\",\"manufacturer\":\"Canon Canada\",\"currency\":\"CAD\",\"price\":\"199.96\"}]")
    toJson("{}") shouldBe
      Json.parse("{}")
    intercept[com.fasterxml.jackson.databind.JsonMappingException] {
      toJson("")
    }
  }

  "associate" should "pass" in {
    val products = readAsSeq("resources/data/testProducts.txt")
    val listings = readAsSeq("resources/data/testListings.txt")
    val productsJson = products.map(p => toJson(p))
    val listingsJson = listings.map(l => toJson(l))
    associate(productsJson, listingsJson).mkString("", "\n", "") shouldBe
      "{\"product_name\":\"Samsung_TL240\",\"listings\":[{\"title\":\"Samsung TL240 - Digital camera - compact - 14.2 Mpix - optical zoom: 7 x - supported memory: microSD, microSDHC - black\",\"manufacturer\":\"Samsung\",\"currency\":\"USD\",\"price\":\"210.00\"},{\"title\":\"Samsung TL240 - Digital camera - compact - 14.2 Mpix - optical zoom: 7 x - supported memory: microSD, microSDHC - black\",\"manufacturer\":\"Samsung\",\"currency\":\"USD\",\"price\":\"265.99\"},{\"title\":\"Samsung TL240 - Digital camera - compact - 14.2 Mpix - optical zoom: 7 x - supported memory: microSD, microSDHC - black\",\"manufacturer\":\"Samsung\",\"currency\":\"USD\",\"price\":\"275.35\"}]}" + "\n" +
      "{\"product_name\":\"Nikon-s6100\",\"listings\":[]}" + "\n" +
      "{\"product_name\":\"Samsung_TL220\",\"listings\":[]}" + "\n" +
      "{\"product_name\":\"Fujifilm-T205\",\"listings\":[]}" + "\n" +
      "{\"product_name\":\"Casio_QV-5000SX\",\"listings\":[]}" + "\n" +
      "{\"product_name\":\"Canon_Digital_IXUS_130_IS\",\"listings\":[]}"
    associate(Seq(), Seq()) shouldBe
      List()
  }

  "print" should "pass" in {
    print("test", "test.txt")
    readAsSeq("test.txt").mkString shouldBe "test"

    print("", "blank.txt")
    readAsSeq("blank.txt").mkString shouldBe ""

    intercept[java.io.FileNotFoundException] {
      print("", "")
    }
  }

  "main" should "pass" in {
    main(Array())
  }

}
