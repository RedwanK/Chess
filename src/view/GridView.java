package view;

import controller.ChessController;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import shared.GUICoord;
import shared.PieceSquareColor;

import java.util.List;

public class GridView extends GridPane implements ChessView {
    private PieceGUI img;
    public GridView(ChessController chessController) {
        super();
        SquareGUI square = null;

        for (int ligne = 0; ligne < GuiFactory.nbLigne.getValue(); ligne++) {

            for (int col = 0; col < GuiFactory.nbColonne.getValue(); col++) {

                square = (SquareGUI) GuiFactory.createSquare(col, ligne);
                Pane target = square;
                target.setPrefHeight(GuiFactory.height.getValue()/GuiFactory.nbLigne.getValue());
                target.setPrefWidth(GuiFactory.width.getValue()/GuiFactory.nbLigne.getValue());
                this.add(target, col, ligne);

                PieceGUI pieceGUI = (PieceGUI) GuiFactory.createPiece(col, ligne);

                if(pieceGUI != null) {
                    //pieceGUI.setFitHeight(GuiFactory.height.getValue()/GuiFactory.nbLigne.getValue());
                    //pieceGUI.setFitWidth(GuiFactory.width.getValue()/GuiFactory.nbLigne.getValue());
                    target.getChildren().add(pieceGUI);


                    // Drag and drop
                    pieceGUI.setOnDragDetected(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent event) {
                            /* drag was detected, start drag-and-drop gesture*/

                            /* allow any transfer mode */
                            Dragboard db = pieceGUI.startDragAndDrop(TransferMode.ANY);
                            pieceGUI.setVisible(false);

                            /* put a image on dragboard */
                            ClipboardContent content = new ClipboardContent();
                            content.putImage(pieceGUI.getImage());
                            db.setContent(content);

                            img = pieceGUI;
                            event.consume();
                        }
                    });

                    pieceGUI.setOnDragDone(new EventHandler <DragEvent>() {
                        public void handle(DragEvent event) {
                            /* the drag-and-drop gesture ended */
                            /* if the data was successfully moved, clear it */
                            pieceGUI.setVisible(true);

                            event.consume();
                        }
                    });

                }
                target.setOnDragOver(new EventHandler <DragEvent>() {
                    public void handle(DragEvent event) {
                        /* data is dragged over the target */
                        /* accept it only if it is  not dragged from the same node
                         * and if it has a string data */
                        if (event.getGestureSource() != target) {
                            /* allow for both copying and moving, whatever user chooses */
                            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                        }
                        event.consume();
                    }
                });

                target.setOnDragEntered(new EventHandler <DragEvent>() {
                    public void handle(DragEvent event) {
                        /* the drag-and-drop gesture entered the target */
                        /* show to the user that it is an actual gesture target */
                        if (event.getGestureSource() != target) {
                            target.setBorder(new Border(new BorderStroke(Color.BLACK,
                                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
                        }

                        event.consume();
                    }
                });

                target.setOnDragDropped(new EventHandler <DragEvent>() {
                    public void handle(DragEvent event) {
                        /* data dropped */
                        /* if there is a string data on dragboard, read it and use it */
                        Dragboard db = event.getDragboard();
                        boolean success = false;

                        if(db.hasImage()){
                            target.getChildren().add(img);
                            success = true;
                        }

                        /* let the source know whether the string was successfully
                         * transferred and used */
                        event.setDropCompleted(success);
                        img.setVisible(true);
                        event.consume();
                    }
                });

                target.setOnDragExited(new EventHandler <DragEvent>() {
                    public void handle(DragEvent event) {
                        /* mouse moved away, remove the graphical cues */
                        target.setBorder(null);
                        event.consume();
                    }
                });


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
/*
public class GridView extends GridPane implements ChessView {

    private ChessController controller = null;
    private PieceGUI img = null;
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

        //this.squareListener = new SquareListener();
        //this.pieceListener = new PieceListener();

        // initialisation du damier
        this.addSquaresAndPiecesOnCheckersBoard();
    }

    private void addSquaresAndPiecesOnCheckersBoard () {

//        PieceGUI piece = null;
        SquareGUI square = null;
        PieceSquareColor squareColor = null;

        for (int ligne = 0; ligne < this.nbLig; ligne++) {

            for (int col = 0; col < this.nbCol; col++) {

                // cr�ation d'un Pane
                square =(SquareGUI) GuiFactory.createSquare(col, ligne);
                Pane target = square;
                //square.setOnDragDropped(this.squareListener);

                // gestion de la taille des Pane
                square.setPrefHeight(this.height/this.nbLig);	// TODO - � remplacer : bad practice
                square.setPrefWidth(this.height/this.nbCol);	// TODO - � remplacer : bad practice
                this.add(target, col, ligne);

                PieceGUI piece =(PieceGUI) GuiFactory.createPiece(col, ligne);

                // ajout du carre sur le damier
                if(piece != null) {
                    target.getChildren().add(piece);

                    // ajout d'un �couteur de souris
                    // si la pi�ce est s�lectionn�e, elle sera supprim� de son emplacement actuel
                    // et repositionn�e sur une autre case
                    //piece.setOnDragDetected(this.pieceListener);
                    // Drag and drop
                    piece.setOnDragDetected(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent event) {
                            */
/* drag was detected, start drag-and-drop gesture*//*


                            PieceGUI piecegui = (PieceGUI) event.getSource();
                            */
/* allow any transfer mode *//*

                            Dragboard db = piecegui.startDragAndDrop(TransferMode.ANY);
                            piecegui.setVisible(false);

                            */
/* put a image on dragboard *//*

                            ClipboardContent content = new ClipboardContent();
                            content.putImage(piecegui.getImage());
                            db.setContent(content);

                            img = piecegui;
                            event.consume();
                        }
                    });

                    piece.setOnDragDone(new EventHandler <DragEvent>() {
                        public void handle(DragEvent event) {
                            */
/* the drag-and-drop gesture ended *//*

                            */
/* if the data was successfully moved, clear it *//*

                            piece.setVisible(true);

                            event.consume();
                        }
                    });

                }

                target.setOnDragOver(new EventHandler <DragEvent>() {
                    public void handle(DragEvent event) {
                        System.out.println("DragOver");
                        */
/* data is dragged over the target *//*

                        */
/* accept it only if it is  not dragged from the same node
                         * and if it has a string data *//*

                        PieceGUI square = (PieceGUI) event.getGestureSource();
                        SquareGUI tempPiece = (SquareGUI) event.getSource();
                        Pane targetElement = (Pane) tempPiece;

                        if (square.getParent() != targetElement) {
                            System.out.println("zobzobss");
                            */
/* allow for both copying and moving, whatever user chooses *//*

                            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                        }
                        event.consume();
                    }
                });

                target.setOnDragEntered(new EventHandler <DragEvent>() {
                    public void handle(DragEvent event) {
                        */
/* the drag-and-drop gesture entered the target *//*

                        */
/* show to the user that it is an actual gesture target *//*

                        PieceGUI square = (PieceGUI) event.getGestureSource();
                        SquareGUI tempPiece = (SquareGUI) event.getSource();
                        Pane targetElement = (Pane) tempPiece;

                        if (square.getParent() != targetElement) {
                            targetElement.setBorder(new Border(new BorderStroke(Color.BLACK,
                                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
                        }

                        event.consume();
                    }
                });

                target.setOnDragDropped(new EventHandler <DragEvent>() {
                    public void handle(DragEvent event) {
                        */
/* data dropped *//*

                        System.out.println("onDragDropped");
                        piece.setVisible(true);
                        */
/* if there is a string data on dragboard, read it and use it *//*

                        //Dragboard db = event.getDragboard();

//                        target.getChildren().add(piece);
                        */
/* let the source know whether the string was successfully
                         * transferred and used *//*

                        event.setDropCompleted(true);

                        event.consume();
                    }
                });
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

    */
/**
     * @author francoise.perrin
     *
     * Objet qui �coute les �v�nements Souris sur les cases du damier
     * et agit en cons�quence
     *//*

    private class SquareListener implements EventHandler<DragEvent> {

        @Override
        public void handle (DragEvent event) {
                    */
/* data dropped *//*

                    System.out.println("onDragDropped");
                    */
/* if there is a string data on dragboard, read it and use it *//*

                    Dragboard db = event.getDragboard();
                    SquareGUI square = (SquareGUI) event.getTarget();
                    PieceGUI piece = (PieceGUI) event.getSource();
                    boolean success = false;

                        square.getChildren().remove(piece);
                        success = true;

                    */
/* let the source know whether the string was successfully
                     * transferred and used *//*

                    event.setDropCompleted(success);

                    event.consume();
        }
    }

    */
/**
     * @author francoise.perrin
     *
     * Objet qui �coute les �v�nements Souris sur les cases du damier
     * et agit en cons�quence
     *//*

    private class PieceListener implements EventHandler<MouseEvent> {

        @Override
        public void handle (MouseEvent mouseEvent) {
            */
/* allow any transfer mode *//*

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
*/
