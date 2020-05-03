package io.bartholomews.testudo

import io.bartholomews.testudo.diffs.DiffDerivations
import io.bartholomews.testudo.matchers.StubbedIO
import io.bartholomews.testudo.wiremock.WiremockServer
import org.scalatest.Suite
import org.scalatest.matchers.should.Matchers

trait TestudoSuite extends Suite with WiremockServer with StubbedIO with Matchers with DiffDerivations
