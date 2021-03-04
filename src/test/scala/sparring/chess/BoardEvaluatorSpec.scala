package fi.ukkosnetti.chess.ai

import fi.ukkosnetti.chess.dto.Board
import fi.ukkosnetti.chess.test.util.BoardTestUtil

import org.scalatestplus.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuite

@RunWith(classOf[JUnitRunner])
class BoardEvaluatorSpec extends AnyFunSuite {
  
    
  test("Evaluated board should equal 0 for starting positions") {
    val board = new Board(BoardTestUtil.createStartingBoard(), true)
    assert(new BoardEvaluator().evaluateBoard(board) == 0)
  }
  
}