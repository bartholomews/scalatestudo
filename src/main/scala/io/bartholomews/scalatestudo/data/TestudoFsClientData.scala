package io.bartholomews.scalatestudo.data

import cats.effect.{ConcurrentEffect, ContextShift}
import io.bartholomews.fsclient.client.FsClientV2
import io.bartholomews.fsclient.config.{FsClientConfig, UserAgent}
import io.bartholomews.fsclient.entities.oauth._
import io.bartholomews.fsclient.entities.oauth.v2.OAuthV2AuthorizationFramework._
import org.http4s.Uri

import scala.concurrent.ExecutionContext

trait TestudoFsClientData extends TestudoHttp4sData {

  val sampleUserAgent: UserAgent = UserAgent(
    appName = "SAMPLE_APP_NAME",
    appVersion = Some("SAMPLE_APP_VERSION"),
    appUrl = Some("https://bartholomews.io/sample-app-url")
  )

  val sampleTokenEndpoint: Uri =
    Uri.unsafeFromString("http://127.0.0.1:8080/oauth/token")

  object OAuthV2 {

    val sampleClientId: ClientId = ClientId("SAMPLE_CLIENT_ID")
    val sampleClientSecret: ClientSecret = ClientSecret("SAMPLE_CLIENT_SECRET")
    val sampleClientPassword: ClientPassword = ClientPassword(sampleClientId, sampleClientSecret)

    def sampleClient[F[_]: ConcurrentEffect](implicit ec: ExecutionContext,
                                             cs: ContextShift[F]): FsClientV2[F, SignerV2] = FsClientV2[F, SignerV2](
      appConfig = FsClientConfig(sampleUserAgent, ClientPasswordBasicAuthenticationV2(OAuthV2.sampleClientPassword)),
      OAuthV2.sampleClientPassword
    )

    val sampleAccessTokenKey: AccessToken = AccessToken(
      "00000000000-0000000000000000000-0000000-0000000000000000000000000000000000000000001"
    )

    val sampleRefreshToken: RefreshToken = RefreshToken("SAMPLE_REFRESH_TOKEN")

    val sampleAuthorizationCode: AuthorizationCode = AuthorizationCode(
      generatedAt = 21312L,
      accessToken = sampleAccessTokenKey,
      tokenType = "bearer",
      expiresIn = 1000L,
      refreshToken = Some(sampleRefreshToken),
      scope = Scope(List.empty)
    )

    val sampleNonRefreshableToken: NonRefreshableToken = NonRefreshableToken(
      generatedAt = 21312L,
      accessToken = sampleAccessTokenKey,
      tokenType = "bearer",
      expiresIn = 1000L,
      scope = Scope(List.empty)
    )
  }
}

object TestudoFsClientData extends TestudoFsClientData {}
