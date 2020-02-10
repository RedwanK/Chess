package view;

import controller.ChessController;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import shared.GUICoord;
import shared.PieceSquareColor;

import java.util.List;

public class GridView extends GridPane implements ChessView {

    private ChessController controller = null;
    private Canvas selectedPieceGui;					// la pi�ce � d�placer
    private int selectedPieceIndex;						// index de la pi�ce avant d�placement

    private int nbCol;
    private int nbLig;                			// le nb de ligne et de colonne du damier
    private double height;								// taille du damier en pixel

    private EventHandler<MouseEvent> squareListener;   	// l'�couteur d'�v�nements souris sur les carr�s du damier
    private EventHandler<MouseEvent> pieceListener;   	// l'�couteur d'�v�nements souris sur les pi�ces

    public GridView (ChessController controller) {
        super();

        this.nbCol = GuiFactory.nbColonne.getValue();
        this.nbLig = GuiFactory.nbLigne.getValue();
        this.height = GuiFactory.height.getValue();

        this.controller = controller;

//        this.squareListener = new SquareListener();
//        this.pieceListener = new PieceListener();

        // initialisation du damier
        this.addSquaresOnCheckersBoard();
    }

    private void addSquaresOnCheckersBoard () {

        PieceGUI piece = null;
        SquareGUI square = null;
        PieceSquareColor squareColor = null;

        for (int ligne = 0; ligne < this.nbLig; ligne++) {

            for (int col = 0; col < this.nbCol; col++) {

                // cr�ation d'un Pane
                square =(SquareGUI) GuiFactory.createSquare(col, ligne);

                // ajout d'un �couteur sur le carr�
                //square.setOnMouseClicked(squareListener);

                // gestion de la taille des Pane
                square.setPrefHeight(this.height/this.nbLig);	// TODO - � remplacer : bad practice
                square.setPrefWidth(this.height/this.nbCol);	// TODO - � remplacer : bad practice

                piece =(PieceGUI) GuiFactory.createPiece(col, ligne);

                // ajout du carre sur le damier
                if(piece != null) {
                    square.getChildren().add(piece);
                }

                this.add(square, col, ligne);
            }
        }
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
