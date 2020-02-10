package model;

import shared.ActionType;
import shared.ModelCoord;
import shared.PieceSquareColor;

import java.util.List;

public class Fou implements ChessPieceModel {
    public Fou (PieceSquareColor pieceSquareColor,ModelCoord modelCoord) {

    }

    @Override
    public ModelCoord getCoord() {
        return null;
    }

    @Override
    public PieceSquareColor getCouleur() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public ActionType doMove(ModelCoord coord) {
        return null;
    }

    @Override
    public boolean catchPiece() {
        return false;
    }

    @Override
    public boolean isAlgoMoveOk(ModelCoord coord) {
        return false;
    }

    @Override
    public boolean isAlgoMoveOk(ModelCoord coord, ActionType type) {
        return false;
    }

    @Override
    public List<ModelCoord> getMoveItinerary(ModelCoord coord) {
        return null;
    }

    @Override
    public boolean undoLastMove() {
        return false;
    }

    @Override
    public boolean undoLastCatch() {
        return false;
    }
}
