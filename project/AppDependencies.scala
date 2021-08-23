import sbt.{ExclusionRule, _}

object AppDependencies {

  val compile = Seq(
    "uk.gov.hmrc"             %% "bootstrap-frontend-play-28" % "5.11.0" excludeAll (ExclusionRule("uk.gov.hmrc", "auth-client_2.12"))
  )
}
