import sbt.project

lazy val Versions = new {
  val App = "1.0-SNAPSHOT"
  val Scala = "2.12.4"
  val ScalaTest = "3.0.4"
}

lazy val testDeps = Seq(
  "org.scalatest" %% "scalatest" % Versions.ScalaTest % "test"
)

lazy val commonSettings = Seq(
  version := Versions.App,
  scalaVersion := Versions.Scala,
  scalacOptions ++= Seq("-feature", "-deprecation", "-unchecked"),
  libraryDependencies ++= testDeps
)

lazy val root = (project in file("."))
  .configs(IntegrationTest)
  .settings(commonSettings: _*)
  .settings(Defaults.itSettings : _*)
  .settings(name := "LoamStream Hiring Exercise")
