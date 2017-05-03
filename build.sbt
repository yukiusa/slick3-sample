name := "slick3-sample"
version := "1.0"
scalaVersion := "2.12.2"
lazy val root = (project in file(".")).settings( baseSettings )

lazy val baseSettings = Seq(
    scalacOptions := Seq(
        "-target:jvm-1.8",
        "-encoding", "UTF-8",
        "-unchecked",
        "-deprecation",
        "-Xfuture",
        "-Yno-adapted-args",
        "-Ywarn-dead-code",
        "-Ywarn-numeric-widen",
        "-Ywarn-value-discard",
        "-Ywarn-unused"
    ),
    libraryDependencies := {
        lazy val slickVersion = "3.2.0"
        Seq(
            "org.postgresql" % "postgresql" % "42.0.0",
            // Slick
            "com.typesafe.slick" %% "slick" % slickVersion,
            "com.typesafe.slick" %% "slick-hikaricp" % slickVersion,
            "com.typesafe.slick" %% "slick-codegen" % slickVersion,
            // https://mvnrepository.com/artifact/org.slf4j/slf4j-simple
            "org.slf4j" % "slf4j-simple" % "1.7.25"

        )
    }
)


