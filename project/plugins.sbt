logLevel := Level.Warn

resolvers ++= Seq("Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/"
)

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.3.3")

addSbtPlugin("com.codacy" % "sbt-codacy-coverage" % "1.2.1")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.8.0")
