package com.byted.data.platform.modules

import com.byted.data.platform.controllers.BornController
import com.byted.data.platform.daos.BornDao
import com.byted.data.platform.services.BornService
import com.softwaremill.macwire.wire
import play.api.BuiltInComponentsFromContext
import play.api.mvc.ControllerComponents

trait LifeManagerComponent extends BornModule {
  self: BuiltInComponentsFromContext =>
  def controllerComponents: ControllerComponents

  lazy val bornController: BornController = wire[BornController]

  lazy val bornService: BornService = wire[BornService]

  lazy val bornDao: BornDao = wire[BornDao]

  lazy val lifeManagerRouter = bornRoutes

}
