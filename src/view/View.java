package view;

import controller.ChessController;
import controller.ControllerLocal;
import javafx.scene.layout.GridPane;
import shared.GUICoord;

import java.util.List;

public class View extends GridPane implements ChessView {

    public View(ChessController controllerLocal) {

    }

    @Override
    public void setPieceToMoveVisible(GUICoord gUICoord, boolean visible) {

    }

    @Override
    public void resetLight(List<GUICoord> gUICoords, boolean isLight) {

    }

    @Override
    public void movePiece(GUICoord initCoord, GUICoord targetCoord) {

    }

    @Override
    public void undoMovePiece(GUICoord pieceToMoveInitCoord) {

    }

    @Override
    public String getPromotionType() {
        return null;
    }

    @Override
    public void promotePiece(GUICoord gUICoord, String promotionType) {

    }
}
