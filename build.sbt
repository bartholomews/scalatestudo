organization := "io.bartholomews"
name := "scalatestudo"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.13.1"

resolvers += "Sonatype OSS Snapshots".at("https://oss.sonatype.org/content/repositories/snapshots")
libraryDependencies += "io.bartholomews" %% "fsclient" % "0.0.1-SNAPSHOT"

libraryDependencies ++= Seq(
  // https://github.com/scalatest/scalatest/releases
  "org.scalatest" %% "scalatest" % "3.1.1",
  // https://github.com/softwaremill/diffx/releases
  "com.softwaremill.diffx" %% "diffx-scalatest" % "0.3.27",
  // https://github.com/tomakehurst/wiremock/releases
  "com.github.tomakehurst" % "wiremock" % "2.26.3"
)