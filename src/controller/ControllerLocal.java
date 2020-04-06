package controller;

import model.ChessModel;
import shared.GUICoord;
import shared.PieceSquareColor;
import view.ChessView;

public class ControllerLocal implements ChessControllerView, ChessControllerModel {
    private ChessModel model = null;
    private ChessView view = null;
    private boolean tour = true;
    @Override
    public void setModel(ChessModel chessModel) {
        this.model = chessModel;
    }

    @Override
    public void setView(ChessView chessGUI) {
        this.view = chessGUI;
    }

    @Override
    public boolean actionsWhenPieceIsSelectedOnGui(PieceSquareColor pieceSquareColor, GUICoord pieceToMoveCoord) {
        if(pieceSquareColor.equals(PieceSquareColor.WHITE) && isTour())
        {
            setTour(false);
            return true;
        }
        else if( pieceSquareColor.equals(PieceSquareColor.BLACK) && !isTour())
        {
            setTour(true);
            return true;
        }
        System.out.println("When piece is selected on GUI");
        return false;
    }

    @Override
    public boolean actionsWhenPieceIsDraggedOnGui(PieceSquareColor pieceSquareColor, GUICoord pieceToMoveCoord) {

        System.out.println("When piece is dragged on GUI");
        return true;
    }

    @Override
    public void actionsWhenPieceIsMovedOnGui(GUICoord targetCoord) {
        System.out.println("When piece is moved on GUI");
        //this.model.move(,targetCoord);
    }

    @Override
    public void actionsWhenPieceIsReleasedOnGui(GUICoord targetCoord) {
        System.out.println("When piece is released on GUI");
    }

    public boolean isTour() {
        return tour;
    }

    public void setTour(boolean tour) {
        this.tour = tour;
    }
}
