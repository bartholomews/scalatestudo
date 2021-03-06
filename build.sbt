name := "scalatestudo"
scalaVersion := "2.13.3"

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

libraryDependencies ++= Seq(
  // https://github.com/softwaremill/sttp/releases
  "com.softwaremill.sttp.client3" %% "core" % "3.0.0-RC13",
  // https://github.com/scalatest/scalatest/releases
  "org.scalatest" %% "scalatest" % "3.2.2",
  // https://github.com/softwaremill/diffx/releases
  "com.softwaremill.diffx" %% "diffx-scalatest" % "0.3.29",
  // https://github.com/tomakehurst/wiremock/releases
  "com.github.tomakehurst" % "wiremock" % "2.27.2"
)
