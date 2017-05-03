package com.yukiusalab.sample.slick3.tools

import slick.codegen.SourceCodeGenerator

/**
  * Created by yukiusa on 17/05/03.
  */
object Codegen {
    def main(args: Array[String]): Unit = {
        val slickDriver = "slick.jdbc.PostgresProfile"
        val jdbcDriver = "org.postgresql.Driver"
        val url = "jdbc:postgresql://localhost:5432/user1"
        val user = "user1"
        val password = "user1"

        val outputFolder = "src/main/scala/"
        val pkg = "com.yukiusalab.sample.slick3.models"

        SourceCodeGenerator.main(
            Array(
                slickDriver,
                jdbcDriver,
                url,
                outputFolder,
                pkg,
                user,
                password
            )
        )
    }
}
