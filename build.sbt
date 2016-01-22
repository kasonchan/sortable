name := "sortable"

version := "1.0"

scalaVersion := "2.11.7"

val testDependencies = Seq(
  "org.scalacheck" %% "scalacheck" % "1.12.5",
  "org.scalatest" %% "scalatest" % "2.2.5"
)

libraryDependencies ++= testDependencies.map(_ % "test")
