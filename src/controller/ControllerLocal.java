package controller;

import model.ChessModel;
import shared.GUICoord;
import shared.PieceSquareColor;
import view.ChessView;

public class ControllerLocal implements ChessControllerView, ChessControllerModel {
    @Override
    public void setModel(ChessModel chessModel) {

    }

    @Override
    public void setView(ChessView chessGUI) {

    }

    @Override
    public boolean actionsWhenPieceIsSelectedOnGui(PieceSquareColor pieceSquareColor, GUICoord pieceToMoveCoord) {
        return true;
    }

    @Override
    public boolean actionsWhenPieceIsDraggedOnGui(PieceSquareColor pieceSquareColor, GUICoord pieceToMoveCoord) {
        return true;
    }

    @Override
    public void actionsWhenPieceIsMovedOnGui(GUICoord targetCoord) {

    }

    @Override
    public void actionsWhenPieceIsReleasedOnGui(GUICoord targetCoord) {

    }

}
