val appName = "dlk-auditing-test-harness"

lazy val microservice = Project(appName, file("."))
  .enablePlugins(play.sbt.PlayScala, SbtDistributablesPlugin)
  .settings(
    majorVersion                     := 0,
    libraryDependencies              ++= AppDependencies.compile,
    scalaVersion := "2.13.10"
  )
