name := """underscore-advanced-scala"""

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++=
  "org.typelevel" %% "cats-core" % "0.9.0" ::
  "org.scalatest" %% "scalatest" % "3.0.1" % "test" ::
  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test" ::
  Nil


