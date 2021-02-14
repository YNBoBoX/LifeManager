package com.byted.data.platform.modules

import com.byted.data.platform.controllers.BornController
import play.api.routing.Router
import play.api.routing.sird._

trait BornModule {
  def bornController:BornController

  val bornRoutes:Router=
    Router.from{
      case GET(p"/firstCrying")=>
        bornController.helloWorld()
    }
}
