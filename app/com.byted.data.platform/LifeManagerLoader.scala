package com.byted.data.platform

import com.byted.data.platform.modules.LifeManagerComponent
import play.api.cache.caffeine.CaffeineCacheComponents
import play.api.mvc.EssentialFilter
import play.api.routing.Router
import play.api.{Application, ApplicationLoader, BuiltInComponentsFromContext, LoggerConfigurator}

class LifeManagerLoader extends ApplicationLoader{
  override def load(context: ApplicationLoader.Context): Application = {
    LoggerConfigurator(context.environment.classLoader).foreach{
      _.configure(context.environment,context.initialConfiguration,Map.empty)
    }

    new BuiltInComponentsFromContext(context) with LifeManagerComponent with CaffeineCacheComponents {
      override def router: Router = lifeManagerRouter

      override def httpFilters: Seq[EssentialFilter] = Seq.empty
    }.application
  }
}
