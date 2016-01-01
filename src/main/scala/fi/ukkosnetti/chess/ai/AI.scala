package fi.ukkosnetti.chess.ai

import scala.collection.JavaConversions._
import fi.ukkosnetti.chess.dto.Board
import fi.ukkosnetti.chess.rules.MoveUtil
import fi.ukkosnetti.chess.rules.piece.Piece

class AI {
  
  private val calculationDepth = 2
  
  def getAIMove(board: Board): Board = {
    if (board.turnOfWhite) {
      getMoves(board).map(calculateScoreForMove(_)).maxBy(_.score).board
    } else {
      getMoves(board).map(calculateScoreForMove(_)).minBy(_.score).board
    }
  }
  
  def evaluateBoard(board: Board): Int = {
    (MoveUtil.getPieces(board, true).toList ++ (MoveUtil.getPieces(board, false)).toList)
      .map(_.getEvaluationValue(board)).sum
  }
  
  private def calculateScoreForMove(board: Board): BoardWithScore = {
    new BoardWithScore(board, getScoreForMove(board, calculationDepth))
  }
  
  private def getScoreForMove(board: Board, depthLeft : Int): Int = {
    val turnOfWhite = board.turnOfWhite
    if (depthLeft < 1) {
      evaluateBoard(board)
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

class BoardWithScore(val board: Board, val score : Int)