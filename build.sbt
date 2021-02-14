import play.sbt.PlayImport._
import sbt._

lazy val macwireDeps = {
  val macwireVersion = "2.3.3"
  Seq(
    "com.softwaremill.macwire" %% "macros" % macwireVersion,
    "com.softwaremill.macwire" %% "macrosakka" % macwireVersion,
    "com.softwaremill.macwire" %% "util" % macwireVersion,
    "com.softwaremill.macwire" %% "proxy" % macwireVersion
  )
}

lazy val playSlickVersion = "5.0.0"
lazy val playSlickDeps = Seq(
  "com.typesafe.play" %% "play-slick" % playSlickVersion,
  "com.typesafe.play" %% "play-slick-evolutions" % playSlickVersion
)

lazy val playJsonDeps = Seq(
  "com.typesafe.play" %% "play-json-joda" % "2.8.1",
  "org.julienrf" %% "play-json-derived-codecs" % "6.0.0",
  "ai.x" %% "play-json-extensions" % "0.42.0"
)

lazy val databaseDeps = Seq(
  "mysql" % "mysql-connector-java" % "8.0.21"
).map(_.excludeAll(ExclusionRule("org.slf4j", "*"), ExclusionRule("log4j", "log4j")))

lazy val playDeps = Seq(
  ws, caffeine, filters
)
lazy val LifeManager = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    libraryDependencies ++= macwireDeps ++ playSlickDeps ++ playJsonDeps ++ databaseDeps ++ playDeps
  )