package controller;

import model.ChessModel;
import shared.GUICoord;
import shared.PieceSquareColor;
import view.ChessView;

public class ControllerLocal implements ChessControllerView, ChessControllerModel {
    private ChessModel model = null;
    private ChessView view = null;
    private boolean tour;
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
        System.out.println(isTour());
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
        return false;
    }

    @Override
    public boolean actionsWhenPieceIsDraggedOnGui(PieceSquareColor pieceSquareColor, GUICoord pieceToMoveCoord) {

        return true;
    }

    @Override
    public void actionsWhenPieceIsMovedOnGui(GUICoord targetCoord) {
        //this.model.move(,targetCoord);
    }

    @Override
    public void actionsWhenPieceIsReleasedOnGui(GUICoord targetCoord) {
    }

    @Override
    public boolean isTour() {
        return tour;
    }

    @Override
    public void setTour(boolean tour) {
        this.tour = tour;
    }

    @Override
    public void initializeTour() {
        this.tour = true;
    }
}
