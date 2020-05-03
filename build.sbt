name := "scalatestudo"
scalaVersion := "2.13.2"

inThisBuild(
  List(
    organization := "io.bartholomews",
    homepage := Some(url("https://github.com/bartholomews/scalatestudo")),
    licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
    developers := List(
      Developer(
        "bartholomews",
        "Federico Bartolomei",
        "scalatestudo@bartholomews.io",
        url("https://bartholomews.io")
      )
    )
  )
)

libraryDependencies += "io.bartholomews" %% "fsclient" % "0.0.1"
libraryDependencies ++= Seq(
  // https://github.com/scalatest/scalatest/releases
  "org.scalatest" %% "scalatest" % "3.1.1",
  // https://github.com/softwaremill/diffx/releases
  "com.softwaremill.diffx" %% "diffx-scalatest" % "0.3.27",
  // https://github.com/tomakehurst/wiremock/releases
  "com.github.tomakehurst" % "wiremock" % "2.26.3"
)
