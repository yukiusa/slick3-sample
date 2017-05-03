package com.yukiusalab.sample.slick3.models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.PostgresProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Categories.schema ++ Effects.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Categories
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(varchar), Length(256,true)
   *  @param nameJp Database column name_jp SqlType(varchar), Length(256,true), Default(None) */
  final case class CategoriesRow(id: Int, name: String, nameJp: Option[String] = None)
  /** GetResult implicit for fetching CategoriesRow objects using plain SQL queries */
  implicit def GetResultCategoriesRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]]): GR[CategoriesRow] = GR{
    prs => import prs._
    CategoriesRow.tupled((<<[Int], <<[String], <<?[String]))
  }
  /** Table description of table categories. Objects of this class serve as prototypes for rows in queries. */
  class Categories(_tableTag: Tag) extends profile.api.Table[CategoriesRow](_tableTag, "categories") {
    def * = (id, name, nameJp) <> (CategoriesRow.tupled, CategoriesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), nameJp).shaped.<>({r=>import r._; _1.map(_=> CategoriesRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(varchar), Length(256,true) */
    val name: Rep[String] = column[String]("name", O.Length(256,varying=true))
    /** Database column name_jp SqlType(varchar), Length(256,true), Default(None) */
    val nameJp: Rep[Option[String]] = column[Option[String]]("name_jp", O.Length(256,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Categories */
  lazy val Categories = new TableQuery(tag => new Categories(tag))

  /** Entity class storing rows of table Effects
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(varchar), Length(256,true)
   *  @param categoryId Database column category_id SqlType(int4) */
  final case class EffectsRow(id: Int, name: String, categoryId: Int)
  /** GetResult implicit for fetching EffectsRow objects using plain SQL queries */
  implicit def GetResultEffectsRow(implicit e0: GR[Int], e1: GR[String]): GR[EffectsRow] = GR{
    prs => import prs._
    EffectsRow.tupled((<<[Int], <<[String], <<[Int]))
  }
  /** Table description of table effects. Objects of this class serve as prototypes for rows in queries. */
  class Effects(_tableTag: Tag) extends profile.api.Table[EffectsRow](_tableTag, "effects") {
    def * = (id, name, categoryId) <> (EffectsRow.tupled, EffectsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(categoryId)).shaped.<>({r=>import r._; _1.map(_=> EffectsRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(varchar), Length(256,true) */
    val name: Rep[String] = column[String]("name", O.Length(256,varying=true))
    /** Database column category_id SqlType(int4) */
    val categoryId: Rep[Int] = column[Int]("category_id")

    /** Foreign key referencing Categories (database name effects_fk) */
    lazy val categoriesFk = foreignKey("effects_fk", categoryId, Categories)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Effects */
  lazy val Effects = new TableQuery(tag => new Effects(tag))
}
