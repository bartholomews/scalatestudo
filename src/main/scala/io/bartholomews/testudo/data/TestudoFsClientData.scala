package io.bartholomews.testudo.data

import io.bartholomews.fsclient.config.FsClientConfig.ConsumerConfig
import io.bartholomews.fsclient.config.UserAgent
import io.bartholomews.fsclient.entities.oauth.v2.OAuthV2AuthorizationFramework._
import io.bartholomews.fsclient.entities.oauth.{AuthorizationCode, NonRefreshableToken, Scope}
import org.http4s.Uri

trait TestudoFsClientData extends TestudoHttp4sData {

  val sampleUserAgent: UserAgent = UserAgent(
    appName = "SAMPLE_APP_NAME",
    appVersion = Some("SAMPLE_APP_VERSION"),
    appUrl = Some("https://bartholomews.io/sample-app-url")
  )

  val sampleConsumerConfig: ConsumerConfig = ConsumerConfig(
    appName = sampleUserAgent.appName,
    appVersion = sampleUserAgent.appVersion,
    appUrl = sampleUserAgent.appUrl,
    key = sampleConsumer.key,
    secret = sampleConsumer.secret
  )

  val sampleTokenEndpoint: Uri =
    Uri.unsafeFromString("http://127.0.0.1:8080/oauth/token")

  object OAuthV2 {

    val sampleClientId: ClientId = ClientId("SAMPLE_CLIENT_ID")
    val sampleClientSecret: ClientSecret = ClientSecret("SAMPLE_CLIENT_SECRET")
    val sampleClientPassword: ClientPassword = ClientPassword(sampleClientId, sampleClientSecret)

    val sampleAccessTokenKey: AccessToken = AccessToken(
      "00000000000-0000000000000000000-0000000-0000000000000000000000000000000000000000001"
    )

    val sampleRefreshToken: RefreshToken = RefreshToken("SAMPLE_REFRESH_TOKEN")

    val sampleAuthorizationCode: AuthorizationCode = AuthorizationCode(
      accessToken = sampleAccessTokenKey,
      tokenType = "bearer",
      expiresIn = 1000L,
      refreshToken = sampleRefreshToken,
      scope = Scope(List.empty)
    )

    val sampleNonRefreshableToken: NonRefreshableToken = NonRefreshableToken(
      accessToken = sampleAccessTokenKey,
      tokenType = "bearer",
      expiresIn = 1000L,
      scope = Scope(List.empty)
    )
  }
}

object TestudoFsClientData extends TestudoFsClientData {}
