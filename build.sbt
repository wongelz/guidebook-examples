name := "guidebook-examples"

version := "0.1"

scalaVersion := "2.13.0"

resolvers += Resolver.bintrayRepo("wongelz", "guidebook")

libraryDependencies ++= Seq(
  "com.github.wongelz"           %% "guidebook"                % "0.4.0"  % Test
)

fork in run := true

parallelExecution in Test := false

testOptions in Test ++= Seq(
  Tests.Argument(TestFrameworks.ScalaTest, "-Dscreen.1.size=640x1024"),
  Tests.Argument(TestFrameworks.ScalaTest, "-o"),
  Tests.Argument(TestFrameworks.ScalaTest, "-C", "com.github.wongelz.guidebook.GuidebookReporter")
)
