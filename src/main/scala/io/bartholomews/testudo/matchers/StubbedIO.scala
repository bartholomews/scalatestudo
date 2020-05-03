package io.bartholomews.testudo.matchers

import com.github.tomakehurst.wiremock.stubbing.StubMapping
import io.bartholomews.fsclient.utils.HttpTypes.{HttpResponse, IOResponse}
import org.scalatest.{Assertion, Inside}

trait StubbedIO extends Inside {

  /**
   *  Assert with a partial function on `HttpResponse` given a `IOResponse` request and a `StubMapping` stub
   *
   *  "the server responds with the expected string message" should {
   *
   *    def request: IOResponse[String] = sampleClient.someEndpoint.getSomeString
   *    def stub: StubMapping =
   *      stubFor(
   *        get(urlMatching("/some_endpoint"))
   *          .willReturn(
   *            aResponse()
   *              .withStatus(200)
   *              .withBody("Response text")
   *          )
   *       )
   *
   *  "return a Right with expected response" in matchResponse(stub, request) {
   *      case FsResponseSuccess(_, _, response) =>
   *          response shouldBe("Response text")
   *   }
   *
   * @param stubMapping the stub to be setup before making the request
   * @param request the request to make
   * @param pf a partial function with assertion based on the `HttpResponse`
   * @tparam T the expected success response type
   * @return
   */
  def matchResponse[T](stubMapping: => StubMapping, request: IOResponse[T])(
    pf: PartialFunction[HttpResponse[T], Assertion]
  ): Assertion = {
    stubMapping
    inside(request.unsafeRunSync())(pf)
  }
}
