package view;

import javafx.scene.image.Image;
import shared.PieceSquareColor;
import javafx.scene.image.ImageView;

public class PieceGUI extends ImageView implements ChessPieceGui {

    public PieceGUI(PieceSquareColor pieceSquareColor, Image image){
        super();
    }

    @Override
    public PieceSquareColor getCouleur() {
        return null;
    }
}
