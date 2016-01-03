package fi.ukkosnetti.chess.ai

import scala.collection.JavaConversions._
import scala.util.Random
import fi.ukkosnetti.chess.dto.Board
import fi.ukkosnetti.chess.rules.MoveUtil
import fi.ukkosnetti.chess.rules.piece.Piece

class AI {
  
  private val calculationDepth = 2
  private val evaluator = new BoardEvaluator
  
  def getAIMove(board: Board): Board = {
    val moves = getMoves(board).map(calculateScoreForMove(_))
    var score = 0l
    if (board.turnOfWhite) {
      score = moves.maxBy(_.getEvaluatedValue).getEvaluatedValue()
    } else {
      score = moves.minBy(_.getEvaluatedValue).getEvaluatedValue()
    }
    pickRandomMoveFromBest(moves, score)
  }
  
  private def pickRandomMoveFromBest(moves : List[Board], valueToLook : Long): Board = {
    val random = new Random(System.currentTimeMillis())
    val filteredMoves = moves.filter(_.getEvaluatedValue == valueToLook)
    filteredMoves.apply(random.nextInt(filteredMoves.size))
  }
  
  private def calculateScoreForMove(board: Board): Board = {
    board.setEvaluatedValue(getScoreForMove(board, calculationDepth));
    board
  }
  
  private def getScoreForMove(board: Board, depthLeft : Int): Long = {
    val turnOfWhite = board.turnOfWhite
    if (depthLeft < 1) {
      evaluator.evaluateBoard(board)
    } else if (turnOfWhite) {
      getMoves(board)
        .map(getScoreForMove(_, depthLeft - 1))
        .max
    } else {
      getMoves(board)
        .map(getScoreForMove(_, depthLeft - 1))
        .min
    }
  }
  
  private def getMoves(board: Board): List[Board] = {
    MoveUtil.getPieces(board, board.turnOfWhite).toList
      .map(_.getMoves(board))
      .flatten.toList
  }
  
}