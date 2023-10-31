val appName = "dlk-auditing-test-harness"

lazy val microservice = Project(appName, file("."))
  .enablePlugins(play.sbt.PlayScala)
  .settings(
    majorVersion                     := 0,
    libraryDependencies              ++= AppDependencies.compile,
    scalaVersion := "2.12.8"
  )
