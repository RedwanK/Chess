package view;

import controller.ChessController;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import shared.GUICoord;
import shared.PieceSquareColor;

import java.util.List;

public class GridView extends GridPane implements ChessView {

    private ChessController controller = null;
    private PieceGUI selectedPieceGui;					// la pi�ce � d�placer
    private int selectedPieceIndex;						// index de la pi�ce avant d�placement

    private int nbCol;
    private int nbLig;                			// le nb de ligne et de colonne du damier
    private double height;								// taille du damier en pixel

    private EventHandler<DragEvent> squareListener;   	// l'�couteur d'�v�nements souris sur les carr�s du damier
    private EventHandler<MouseEvent> pieceListener;   	// l'�couteur d'�v�nements souris sur les pi�ces

    public GridView (ChessController controller) {
        super();

        this.nbCol = GuiFactory.nbColonne.getValue();
        this.nbLig = GuiFactory.nbLigne.getValue();
        this.height = GuiFactory.height.getValue();

        this.controller = controller;

        this.squareListener = new SquareListener();
        this.pieceListener = new PieceListener();

        // initialisation du damier
        this.addSquaresAndPiecesOnCheckersBoard();
    }

    private void addSquaresAndPiecesOnCheckersBoard () {

        PieceGUI piece = null;
        SquareGUI square = null;
        PieceSquareColor squareColor = null;

        for (int ligne = 0; ligne < this.nbLig; ligne++) {

            for (int col = 0; col < this.nbCol; col++) {

                // cr�ation d'un Pane
                square =(SquareGUI) GuiFactory.createSquare(col, ligne);

                // ajout d'un �couteur sur le carr�
                square.setOnDragDropped(this.squareListener);

                // gestion de la taille des Pane
                square.setPrefHeight(this.height/this.nbLig);	// TODO - � remplacer : bad practice
                square.setPrefWidth(this.height/this.nbCol);	// TODO - � remplacer : bad practice

                piece =(PieceGUI) GuiFactory.createPiece(col, ligne);

                // ajout du carre sur le damier
                if(piece != null) {
                    // ajout d'un �couteur de souris
                    // si la pi�ce est s�lectionn�e, elle sera supprim� de son emplacement actuel
                    // et repositionn�e sur une autre case
                    piece.setOnDragDetected(this.pieceListener);
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
        System.out.println("INIT");
        System.out.println(initCoord);
        System.out.println("FINISH");
        System.out.println(targetCoord);
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

    private PieceGUI getSelectedPiece() {
        return this.selectedPieceGui;
    }
    private int getSelectedPieceIndex() {
        return this.selectedPieceIndex;
    }

    private void setSelectedPiece (PieceGUI selectedPieceGui) {
        this.selectedPieceGui =  selectedPieceGui;
    }
    private void setSelectedPieceIndex (int selectedPieceIndex) {
        this.selectedPieceIndex =  selectedPieceIndex;
    }

    /**
     * @author francoise.perrin
     *
     * Objet qui �coute les �v�nements Souris sur les cases du damier
     * et agit en cons�quence
     */
    private class SquareListener implements EventHandler<DragEvent> {

        @Override
        public void handle (DragEvent event) {
            // D�placement de la pi�ce s�lectionn�e
            GridView.this.movePiece(
                    new GUICoord((int) GridView.this.getSelectedPiece().getLayoutX(),
                            (int) GridView.this.getSelectedPiece().getLayoutY()),
                    new GUICoord((int) event.getX(),(int) event.getY())
            );
            GridView.this.setSelectedPiece(null);
            // On �vite que le parent ne r�cup�re l'event
            event.consume();
        }
    }

    /**
     * @author francoise.perrin
     *
     * Objet qui �coute les �v�nements Souris sur les cases du damier
     * et agit en cons�quence
     */
    private class PieceListener implements EventHandler<MouseEvent> {

        @Override
        public void handle (MouseEvent mouseEvent) {
            /* allow any transfer mode */
            Dragboard db = GridView.this.startDragAndDrop(TransferMode.ANY);

            GridView.this.setSelectedPiece((PieceGUI) mouseEvent.getSource());

            ClipboardContent content = new ClipboardContent();
            PieceGUI piece = (PieceGUI) mouseEvent.getSource();
            content.putImage(piece.getImage());
            db.setContent(content);

            mouseEvent.consume();
        }

    }
}
