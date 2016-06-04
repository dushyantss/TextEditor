package dushyant.texteditor.controllers;

import dushyant.texteditor.Main;
import dushyant.texteditor.helpers.ParStyle;
import dushyant.texteditor.helpers.TextStyle;
import org.fxmisc.richtext.StyledTextArea;

/**
 * Created by Dushyant Singh Shekhawat
 * on 04-06-2016.
 */

public class EditorController {
    private StyledTextArea<ParStyle, TextStyle> area;

    private Main main;

    public EditorController() {
        area = new StyledTextArea<>(ParStyle.EMPTY, (textFlow, parStyle) -> textFlow.setStyle(parStyle.toCss()),
                TextStyle.EMPTY.updateFontFamily("Calibri").updateFontSize(12), (textExt, textStyle) -> textExt.setStyle(textStyle.toCss()));
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public StyledTextArea<ParStyle, TextStyle> getArea() {
        return area;
    }
}
