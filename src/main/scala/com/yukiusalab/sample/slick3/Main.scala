package com.yukiusalab.sample.slick3
import com.yukiusalab.sample.slick3.models.Tables._


import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}

/**
  * Created by yukiusa on 17/05/03.
  */
object Main extends App {
    implicit val ec = ExecutionContext.global
    // execute select by Id(PK)
    Await.result( CategoryDAO.findAll , Duration.Inf) foreach println
    // execute select by Id(PK)
    Await.result( CategoryDAO.findById(2) , Duration.Inf) foreach println
    // execute insert
    Await.result( CategoryDAO.insert("TestNameXXX" , "テストカテゴリXXXX" ), Duration.Inf)

    // execute bulk insert
    val objectList : Seq[CategoriesRow]  = Seq(
        CategoriesRow(0 , name = "TestName2" , nameJp = Some("テストカテゴリ2") ) ,
        CategoriesRow(0 , name = "TestName3" )  ,
        CategoriesRow(0 , name = "TestName4" , nameJp = Some("テストカテゴリ4") )
    )
    Await.result( CategoryDAO.insertAll(objectList), Duration.Inf)
}

/* Database */
trait Db {
   import slick.jdbc.JdbcProfile
   val profile : JdbcProfile
   val db : JdbcProfile#Backend#Database
}

trait PostgresDb extends Db {
    import slick.jdbc.PostgresProfile
    import slick.jdbc.PostgresProfile.api._
    override val profile = PostgresProfile
    // see main/resource/application.conf
    override val db : Database = Database.forConfig("database")
}

/* Data Access Object */
trait CategoryDAO {
    this : Db =>
    import slick.jdbc.PostgresProfile.api._

    def findAll(): Future[Seq[CategoriesRow]] = {
        db.run(Categories.result)
    }
    def findById(id: Int): Future[Option[CategoriesRow]] = {
        db.run(Categories.filter( _.id === id ).result.headOption)
    }
    def insert( name : String , nameJp : String )  = {
        db.run( Categories += CategoriesRow( 0 /*skipping AutoInc */ , name , Some(nameJp)) )
    }
    def insertAll( rows : Seq[CategoriesRow] ) = {
        db.run( Categories ++= rows )
    }
    def deleteById( id : Int) : Unit = {
        //TODO DBだけTraitで切り出したらあとはいらないんじゃ…
    }
}
object CategoryDAO extends CategoryDAO with PostgresDb

trait TablesJsonFormatProvider {
    //TODO jsonへのフォーマット。あとで書く
}




