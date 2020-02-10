package view;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import shared.GUICoord;
import shared.PieceSquareColor;

public class SquareGUI extends BorderPane implements ChessSquareGui {

    public SquareGUI (GUICoord gUICoord, PieceSquareColor squareColor) {
        super();

        // la couleur est d�finie par les valeurs par d�faut de configuration
        Color color = PieceSquareColor.BLACK.equals(squareColor) ?
                GuiFactory.blackSquareColor.getValue() : GuiFactory.whiteSquareColor.getValue();
        this.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @Override
    public GUICoord getCoord() {
        return null;
    }

    @Override
    public void resetColor(boolean isLight) {

    }
}
