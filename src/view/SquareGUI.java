package view;

import javafx.scene.layout.BorderPane;
import shared.GUICoord;
import shared.PieceSquareColor;

public class SquareGUI extends BorderPane implements ChessSquareGui {

    public SquareGUI (GUICoord gUICoord, PieceSquareColor squareColor) {

    }
    @Override
    public GUICoord getCoord() {
        return null;
    }

    @Override
    public void resetColor(boolean isLight) {

    }
}
