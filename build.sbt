name := "sortable"

version := "1.0"

scalaVersion := "2.11.7"

val testDependencies = Seq(
  "org.scalacheck" %% "scalacheck" % "1.12.5",
  "org.scalatest" %% "scalatest" % "2.2.5"
)

libraryDependencies ++= Seq(
  "com.typesafe.play" % "play_2.11" % "2.4.6") ++ testDependencies.map(_ % "test")
