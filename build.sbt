import uk.gov.hmrc.DefaultBuildSettings.integrationTestSettings

val appName = "dlk-auditing-test-harness"

lazy val microservice = Project(appName, file("."))
  .enablePlugins(play.sbt.PlayScala, BuildInfoPlugin)
  .settings(
    majorVersion                     := 0,
    libraryDependencies              ++= AppDependencies.compile,
    scalaVersion := "2.12.8"
  )
  .configs(IntegrationTest)
  .settings(resolvers += Resolver.jcenterRepo)
