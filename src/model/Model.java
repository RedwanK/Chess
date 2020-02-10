package model;

import shared.ActionType;
import shared.ModelCoord;

import java.util.List;

public class Model implements ChessModel {
    @Override
    public List<ModelCoord> getPieceListMoveOK(ModelCoord initCoord) {
        return null;
    }

    @Override
    public ActionType move(ModelCoord initCoord, ModelCoord finalCoord) {
        return ActionType.MOVE;
    }

    @Override
    public boolean pawnPromotion(ModelCoord promotionCoord, String promotionType) {
        return false;
    }

    @Override
    public boolean isEnd() {
        return false;
    }
}
