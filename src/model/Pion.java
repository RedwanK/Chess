package model;

import shared.ActionType;
import shared.ModelCoord;
import shared.PieceSquareColor;

import java.util.List;

public class Pion extends Piece {
    public Pion(PieceSquareColor color, ModelCoord coord) {
        super(color, coord);
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

}
