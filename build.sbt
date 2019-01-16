import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "imcamilo.com.github",
      scalaVersion := "2.12.7",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "easytrdctr",
    libraryDependencies += scalaTest % Test
)

libraryDependencies += gct
