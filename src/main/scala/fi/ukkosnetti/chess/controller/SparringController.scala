package fi.ukkosnetti.chess.controller

import org.springframework.web.bind.annotation.{ResponseBody, RequestBody, RequestMapping, PathVariable, RequestMethod, RestController}
import fi.ukkosnetti.chess.dto.Board
import fi.ukkosnetti.chess.ai.AI

@RestController
@RequestMapping(Array("aimove"))
class SparringController {
  
  @RequestMapping(method = Array(RequestMethod.POST))
  def aiTurn(@RequestBody board: Board): Board = {
    new AI().getAIMove(board)
  }
}