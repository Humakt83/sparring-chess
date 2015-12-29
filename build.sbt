import AssemblyKeys._

assemblySettings

scalaVersion := "2.11.7"

resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"

libraryDependencies += "org.json4s" %% "json4s-native" % "3.2.11" withSources() withJavadoc()
libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.2.11" withSources() withJavadoc()
libraryDependencies += "fi.ukkosnetti" % "lchessrulz" % "1.0.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" withSources() withJavadoc()

libraryDependencies ++= {
  val akkaV = "2.3.9"
  val sprayV = "1.3.3"
  Seq(
    "io.spray"            %%  "spray-can"     % sprayV,
    "io.spray"            %%  "spray-routing" % sprayV,
    "io.spray"            %%  "spray-testkit" % sprayV  % "test",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test"
  )
}

name := "SparringChess"

version := "0.1"

Revolver.settings