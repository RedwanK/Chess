package view;

import controller.ChessController;
import controller.ControllerLocal;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import shared.GUICoord;

import java.util.List;

public class View extends GridPane implements ChessView {

    public View(ChessController controller) {
        super();

        // le damier compos� de carr�s noirs et blancs
        // sur lesquels sont positionn�s des pi�ces noires ou blanches
        GridView board = new GridView(controller);

        // gestion de la taille du damier
        double height =(double) GuiFactory.height.getValue();			// TODO - � remplacer (atelier 4) : bad practice
        board.setPrefSize( height, height);			// TODO - � remplacer (atelier 4) : bad practice

        // cr�ation d'un fond d'�cran qui contiendra le damier + les axes (atelier 2)
        BorderPane checkersBoard = new BorderPane();

        // ajout du damier au centre du fond d'�cran
        checkersBoard.setCenter(board);

        // ajout du fond d'�cran � la vue
        this.add(checkersBoard, 0, 1);
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
