package fi.ukkosnetti.chess.rest

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._

class ChessServiceActor extends Actor with ChessService {
  
  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(route)
  
}

trait ChessService extends HttpService {

  val route =
    path("") {
      get {
        respondWithMediaType(`application/json`) {
          complete {
            <html>
              <body>
                <h1>Say hello to <i>spray-routing</i> on <i>spray-can</i>!</h1>
              </body>
            </html>
          }
        }
      }
    }
}