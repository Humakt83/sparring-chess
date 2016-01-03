package fi.ukkosnetti.chess.ai

import fi.ukkosnetti.chess.dto.Board
import fi.ukkosnetti.chess.test.util.BoardTestUtil
import org.scalatest._

class BoardEvaluatorSpec extends FlatSpec with Matchers {
  
    
  "Evaluated board " should " equal 0 for starting positions" in {
    val board = new Board(BoardTestUtil.createStartingBoard(), true)
    new BoardEvaluator().evaluateBoard(board) should be (0)
  }
  
}