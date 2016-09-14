name := "finagle-weather"
version := "1.0"
organization := "net.gutefrage"

scalaVersion  := "2.11.7"

val finagleVersion = "6.38.0"
val finchVersion = "0.10.0"
val finatraVersion = "2.4.0"

libraryDependencies ++= Seq(
  "com.twitter" %% "scrooge-core" % "4.7.0",
  "com.twitter" %% "finagle-serversets" % finagleVersion,
  "com.twitter" %% "finagle-redis" % finagleVersion,
  "com.twitter" %% "finagle-mysql" % finagleVersion,
  "com.twitter" %% "finagle-thrift"  % finagleVersion,
  "com.twitter" %% "finagle-http" % finagleVersion,
  "com.twitter" %% "finagle-thriftmux"  % finagleVersion,
  "com.twitter" %% "finagle-stats"  % finagleVersion,
  "com.twitter" %% "twitter-server"  % "1.23.0",
  "com.twitter" %% "finatra-http" % finatraVersion,
  "com.twitter" %% "finatra-http" % finatraVersion % "test" classifier "tests",
  "com.github.finagle" %% "finch-core" % finchVersion,
  "com.github.finagle" %% "finch-circe" % finchVersion,
  // json
  "io.circe" %% "circe-generic" % "0.4.1",
  // logging
  "org.slf4j" % "jul-to-slf4j" % "1.7.7",
  "ch.qos.logback" % "logback-core" % "1.1.7",
  "ch.qos.logback" % "logback-classic" % "1.1.7",
  // TODO remove and use finagle-redis
  "net.debasishg" %% "redisclient" % "3.0"
)

libraryDependencies := libraryDependencies.value.map(_
    .exclude("org.slf4j", "slf4j-jdk14")
    .exclude("org.slf4j", "slf4j-log4j12")
)

resolvers += "twitter-repo" at "https://maven.twttr.com"

fork in run := true
