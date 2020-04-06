package model;

import shared.ActionType;
import shared.ModelCoord;
import shared.PieceSquareColor;

public abstract class Piece implements ChessPieceModel {
    private PieceSquareColor color;
    private ModelCoord coord;

    public Piece(PieceSquareColor color, ModelCoord coord) {
        this.color = color;
        this.coord = coord;
    }

    @Override
    public ModelCoord getCoord() {
        return this.coord;
    }

    @Override
    public PieceSquareColor getCouleur() {
        return color;
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
    public boolean undoLastMove() {
        return false;
    }

    @Override
    public boolean undoLastCatch() {
        return false;
    }
}
