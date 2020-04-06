package model;

import shared.ActionType;
import shared.ModelCoord;
import shared.PieceSquareColor;

public class Implementor implements ChessImplementor {
    private ChessPieceModel chessPieceModel = null;

    public Implementor(ChessPieceModel cpm)
    {
        this.chessPieceModel = cpm;
    }

    @Override
    public boolean isPieceHere(ModelCoord coord, PieceSquareColor currentColor) {

        return false;
    }

    @Override
    public boolean isAlgoMoveOk(ModelCoord initCoord, ModelCoord finalCoord, ActionType type) {
        return false;
    }

    @Override
    public ActionType doMove(ModelCoord initCoord, ModelCoord finalCoord) {
        return null;
    }

    @Override
    public ActionType doCatch(ModelCoord coord) {
        return null;
    }

    @Override
    public boolean undoLastCapture() {
        return false;
    }

    @Override
    public boolean undoLastMove() {
        return false;
    }

    @Override
    public boolean pawnPromotion(ModelCoord promotionCoord, String promotionType) {
        return false;
    }

    @Override
    public ModelCoord getKingCoord(PieceSquareColor currentColor) {
        return null;
    }

    @Override
    public boolean isItineraryEmpty(ModelCoord initCoord, ModelCoord finalCoord) {
        return false;
    }
}
