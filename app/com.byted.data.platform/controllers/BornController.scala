package com.byted.data.platform.controllers

import play.api.mvc.{AbstractController, ControllerComponents}

import scala.concurrent.{ExecutionContext, Future}

class BornController(cc:ControllerComponents)(implicit ec:ExecutionContext) extends AbstractController(cc){
  def helloWorld=Action.async{
    r=>
      Future.successful(Ok("Hello world!"))
  }
}
