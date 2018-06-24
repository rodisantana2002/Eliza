/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajustline.control;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 *
 * @author rodolfosmac
 */
public final class ctrlTextTransfer implements ClipboardOwner {

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        //nada a afzer
    }

    public void setClipboardContents(String aString){
        StringSelection stringSelection = new StringSelection(aString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, this);
    }

    public String getClipboardContents() {
        String result = "";
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      
        Transferable contents = clipboard.getContents(null);
        boolean hasTransferableText = ((contents != null) && (contents.isDataFlavorSupported(DataFlavor.stringFlavor)));
        if (hasTransferableText) {            
            try {
                result = (String)contents.getTransferData(DataFlavor.stringFlavor);
            }
            catch (UnsupportedFlavorException | IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    
} 

