package com.xebia.exercise4

import scala.concurrent.{ExecutionContext, Future}

object ReverserFactory {
  type AsyncReverseFunction = String => Future[String]

  def loadReverser(implicit executionContext:ExecutionContext): Future[AsyncReverseFunction] = {
    Future{
      Thread.sleep(500)
      (value => Future.successful(value.reverse)):AsyncReverseFunction
    }
  }
}