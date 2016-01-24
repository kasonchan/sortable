# Sortable

[![Build Status](https://travis-ci.org/kasonchan/sortable.svg?branch=master)](https://travis-ci.org/kasonchan/sortable)
[![codecov.io](https://codecov.io/github/kasonchan/sortable/coverage.svg?branch=master)](https://codecov.io/github/kasonchan/sortable?branch=master)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/216d15ebeabd4e8285890153b89d3e0d)](https://www.codacy.com/app/kasonchan/sortable)

### Task

Generate a file with a list of Result objects. A result object associates a 
Product with a list of matching Listing objects.

### Details

#### Data Objects

##### Product

```
{
  "product_name": String   // A unique id for the product
  "manufacturer": String
  "family": String         // optional grouping of products
  "model": String
  "announced-date": String // ISO-8601 formatted date string, e.g. 2011-04-28T19:00:00.000-05:00
}
```

##### Listing

```
{
  "title": String        // description of product for sale
  "manufacturer": String // who manufactures the product for sale
  "currency": String     // currency code, e.g. USD, CAD, GBP, etc.
  "price": String        // price, e.g. 19.99, 100.00
}
```

##### Result

A file full of Result objects is what the solution will be generating. A 
Result simply associates a Product with a list of matching Listing objects.

```
{
  "product_name": String
  "listings": Array[Listing]
}
```

#### Challenge Data

Contains two files which are located in the `resources/data` directory:
-  products.txt – Contains around 700 products
-  listings.txt – Contains about 20,000 product listings

#### Input Files

##### Products file (products.txt)

Text file with one Product object per line.

##### Listings file (listings.txt)
    
Text file with one Listing object per line.

##### Output File

The output your solution creates should be a text file with one Result object per line.

### Development

This application is built with the following:

-  [Scala](http://www.scala-lang.org/) version 2.11.7
-  [SBT](http://www.scala-sbt.org/) version 0.13.8
-  [Play](https://www.playframework.com) version 2.3.10

### Assumptions

-  output text file is named `results.txt`.
-  The attributes excluding `product_name` from product objects do not carry over
to the result objects.

### Running the code 

Follow these steps to run the code:

1. Download this repository.
2. `Unzip` the downloaded repository.
3. `cd` into the directory.
4. Enter `sbt test` to test. `blank.txt`, `tests.txt` and `results.txt` files will be created. 
5. Enter `sbt run` to execute.
6. Enter `sbt clean` to clean up the compiled files.

-  The `results.txt` created in running `sbt test` is the same as running `sbt run`.
