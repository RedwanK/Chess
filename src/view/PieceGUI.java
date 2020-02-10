package view;

import javafx.scene.image.Image;
import shared.PieceSquareColor;
import javafx.scene.image.ImageView;

public class PieceGUI extends ImageView implements ChessPieceGui {

    private PieceSquareColor couleur = null;
    public PieceGUI(PieceSquareColor pieceSquareColor, Image image){
        super();

        this.couleur= pieceSquareColor;
        this.setImage(image);
        this.setFitHeight(GuiFactory.height.getValue()/GuiFactory.nbLigne.getValue());
        this.setFitHeight(GuiFactory.height.getValue()/GuiFactory.nbColonne.getValue());

        //this.setY(GuiFactory.height.getValue()/GuiFactory.nbLigne.getValue());
        //this.setX(GuiFactory.height.getValue()/GuiFactory.nbColonne.getValue());
    }

    @Override
    public PieceSquareColor getCouleur() {
        return this.couleur;
    }
}
