package sortable

import Sortable.read
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by kasonchan on 1/22/16.
  */
class SortableSpec extends FlatSpec with Matchers {

  "sortable" should "pass" in {
    read("resources/data/testListings.txt") shouldBe
      Right("[{\"title\":\"LED Flash Macro Ring Light (48 X LED) with 6 Adapter Rings for For Canon/Sony/Nikon/Sigma Lenses\",\"manufacturer\":\"Neewer Electronics Accessories\",\"currency\":\"CAD\",\"price\":\"35.99\"},{\"title\":\"Canon PowerShot SX130IS 12.1 MP Digital Camera with 12x Wide Angle Optical Image Stabilized Zoom with 3.0-Inch LCD\",\"manufacturer\":\"Canon Canada\",\"currency\":\"CAD\",\"price\":\"199.96\"}]")
    read("resources/data/testProducts.txt") shouldBe
      Right("[{\"product_name\":\"Samsung_TL240\",\"manufacturer\":\"Samsung\",\"model\":\"TL240\",\"announced-date\":\"2010-01-05T19:00:00.000-05:00\"},{\"product_name\":\"Nikon-s6100\",\"manufacturer\":\"Nikon\",\"model\":\"S6100\",\"family\":\"Coolpix\",\"announced-date\":\"2011-02-08T19:00:00.000-05:00\"},{\"product_name\":\"Samsung_TL220\",\"manufacturer\":\"Samsung\",\"model\":\"TL220\",\"announced-date\":\"2009-08-12T20:00:00.000-04:00\"},{\"product_name\":\"Fujifilm-T205\",\"manufacturer\":\"Fujifilm\",\"model\":\"T205\",\"family\":\"FinePix\",\"announced-date\":\"2011-02-15T19:00:00.000-05:00\"},{\"product_name\":\"Casio_QV-5000SX\",\"manufacturer\":\"Casio\",\"model\":\"QV-5000SX\",\"announced-date\":\"1998-04-19T20:00:00.000-04:00\"},{\"product_name\":\"Canon_Digital_IXUS_130_IS\",\"manufacturer\":\"Canon\",\"model\":\"130 IS\",\"family\":\"Digital IXUS\",\"announced-date\":\"2010-02-07T19:00:00.000-05:00\"}]")
  }

}
