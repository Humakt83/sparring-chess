import AssemblyKeys._

assemblySettings

name := "SparringChess"

version := "0.1"

scalaVersion := "2.11.7"

sbtVersion := "0.13.1"

resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"

seq(webSettings : _*)

libraryDependencies += "fi.ukkosnetti" % "lchessrulz" % "1.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" withSources() withJavadoc()

libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-web" % "1.2.7.RELEASE",
  "org.webjars" % "bootstrap" % "3.1.1",
  "org.springframework.boot" % "spring-boot-starter-tomcat" % "1.2.7.RELEASE" % "provided",
  "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided"
)


libraryDependencies ++= Seq(
  "org.apache.tomcat.embed" % "tomcat-embed-core"         % "8.0.28" % "container",
  "org.apache.tomcat.embed" % "tomcat-embed-logging-juli" % "8.0.28" % "container",
  "org.apache.tomcat.embed" % "tomcat-embed-jasper"       % "8.0.28" % "container"
)