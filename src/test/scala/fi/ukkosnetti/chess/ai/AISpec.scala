package fi.ukkosnetti.chess.ai

import fi.ukkosnetti.chess.dto.Board
import fi.ukkosnetti.chess.test.util.BoardTestUtil
import org.scalatest._

class AISpec extends FlatSpec with Matchers {
  
  def gameAlmostOverBoard : Array[Array[Integer]] = {
    val board = Array.ofDim[Integer](8,8)
    board(0) = Array(-4,-2,-3,-5,-6,-3,-2,-4)
    board(1) = Array(-1,-1,-1,-1,0,-1,-1,-1)
    board(2) = Array(0,0,0,0,0,0,0,0)
    board(3) = Array(0,0,0,0,-1,0,0,0)
    board(4) = Array(0,0,0,0,0,1,1,0)
    board(5) = Array(0,0,2,0,0,0,0,0)
    board(6) = Array(1,1,1,1,1,0,0,1)
    board(7) = Array(4,0,3,5,6,3,2,4)
    board
  }
  
  it should "do a checkmate" in {
    val board = new Board(gameAlmostOverBoard, false)
    val ai = new AI()
    ai.getAIMove(board).board(4)(7) should be (-5)
  }
  
  it should "play" in {
    var board = new Board(BoardTestUtil.createStartingBoard(), true)
    val ai = new AI()
    board = ai.getAIMove(board)
    assert(board.turnOfWhite == false)
    board = ai.getAIMove(board)
    assert(board.turnOfWhite == true)
    board = ai.getAIMove(board)
    assert(board.turnOfWhite == false)
  }
  
}