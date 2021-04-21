import play.core.PlayVersion.current
import play.sbt.PlayImport._
import sbt.Keys.libraryDependencies
import sbt._

object AppDependencies {

  val compile = Seq(

    "uk.gov.hmrc"             %% "govuk-template"           % "5.65.0-play-27" exclude ("uk.gov.hmrc", "play-auditing-play-27_2.12"),
    "uk.gov.hmrc"             %% "play-ui"                  % "9.1.0-play-27" exclude ("uk.gov.hmrc", "play-auditing-play-27_2.12"),
    "uk.gov.hmrc"             %% "bootstrap-frontend-play-27" % "4.2.0" exclude ("uk.gov.hmrc", "play-auditing-play-27_2.12")
  )

  val test = Seq(
    "uk.gov.hmrc"             %% "bootstrap-frontend-play-27"        % "4.2.0"              % Test classifier "tests",
    "org.scalatest"           %% "scalatest"                % "3.0.8"               % Test,
    "org.scalacheck"          %% "scalacheck"               % "1.14.3"              % Test,
    "org.jsoup"               %  "jsoup"                    % "1.10.2"              % Test,
    "com.typesafe.play"       %% "play-test"                % current               % Test,
    "org.pegdown"             %  "pegdown"                  % "1.6.0"               % "test, it",
    "org.mockito"             %% "mockito-scala-scalatest"  % "1.10.2"              % Test,
    "org.scalatestplus.play"  %% "scalatestplus-play"       % "3.1.2"               % "test, it"
  )

}
