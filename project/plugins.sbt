resolvers ++= Seq(
  Resolver.url("HMRC-open-artefacts-ivy", url("https://open.artefacts.tax.service.gov.uk/ivy2"))(Resolver.ivyStylePatterns),
  Resolver.url("HMRC-sbt-plugin-ivy-releases-cache", url("https://artefacts.tax.service.gov.uk/artifactory/sbt-plugin-ivy-releases-cache"))(
    Resolver.ivyStylePatterns),
  "hmrc-releases" at "https://artefacts.tax.service.gov.uk/artifactory/hmrc-releases/",
  "third-party-maven-releases" at "https://artefacts.tax.service.gov.uk/artifactory/third-party-maven-releases/",
  "HMRC-open-artefacts-maven" at "https://open.artefacts.tax.service.gov.uk/maven2"
)

resolvers += "HMRC Releases" at "https://dl.bintray.com/hmrc/releases"

resolvers += Resolver.typesafeRepo("releases")

addSbtPlugin("com.github.sbt" % "sbt-release" % "1.1.0")

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.19")

addSbtPlugin("uk.gov.hmrc" % "sbt-settings" % "4.15.0")

addSbtPlugin("uk.gov.hmrc" % "sbt-distributables" % "2.2.0")

addSbtPlugin("uk.gov.hmrc" % "sbt-auto-build" % "3.14.0")

addSbtPlugin("uk.gov.hmrc" % "sbt-git-versioning" % "2.4.0")

addSbtPlugin("uk.gov.hmrc" % "sbt-artifactory" % "1.17.0")