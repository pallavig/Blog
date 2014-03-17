package controllers

import play.api.mvc.{Action, Controller}
import db.DBHandler

object Application extends Controller {
  def index = Action {
    Ok(views.html.index(""))
  }

  def saveArticle() = Action { implicit request=>
    val map = request.body.asFormUrlEncoded.get
    val name = map.get("name").get.head
    println(name)
    val article = map.get("article").get.head
    println(article)
    DBHandler.saveData(name,article)
    Ok(views.html.index("Your article saved"))
  }
}