package db

import com.mongodb.casbah._
import com.mongodb.casbah.commons.MongoDBObject

object DBHandler {
  val mongoConn = MongoConnection()
  val mongoColl = mongoConn("test")("post")

  def saveData(name:String,article:String) = {
    val mongoObject = MongoDBObject("name"->name,"article"->article)
    println(mongoColl.find().count)
    mongoColl.insert(mongoObject)
    println(mongoColl.find().count)
  }
}
