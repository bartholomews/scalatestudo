package io.bartholomews.scalatestudo

import io.bartholomews.scalatestudo.diffs.DiffDerivations
import io.bartholomews.scalatestudo.matchers.StubbedIO
import io.bartholomews.scalatestudo.wiremock.WiremockServer
import org.scalatest.Suite
import org.scalatest.matchers.should.Matchers

trait TestudoSuite extends Suite with WiremockServer with StubbedIO with Matchers with DiffDerivations
