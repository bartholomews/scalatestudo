package io.bartholomews.testudo.data

import org.http4s.client.oauth1.{Consumer, Token}

trait TestudoHttp4sData {
  val sampleConsumer: Consumer =
    Consumer(key = "SAMPLE_CONSUMER_KEY", secret = "SAMPLE_CONSUMER_SECRET")

  val sampleToken: Token =
    Token(value = "SAMPLE_TOKEN_VALUE", secret = "SAMPLE_TOKEN_SECRET")
}

object TestudoHttp4sData extends TestudoHttp4sData {}
