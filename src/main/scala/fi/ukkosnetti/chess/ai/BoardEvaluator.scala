package fi.ukkosnetti.chess.ai

import scala.collection.JavaConverters._
import fi.ukkosnetti.chess.dto.Board
import fi.ukkosnetti.chess.rules.MoveUtil
import fi.ukkosnetti.chess.rules.piece.Piece

class BoardEvaluator {
  
  def evaluateBoard(board: Board): Long = {
    (MoveUtil.getPieces(board, true).asScala ++ (MoveUtil.getPieces(board, false)).asScala)
      .map(_.getEvaluationValue(board))
      .sum
  }
  
}