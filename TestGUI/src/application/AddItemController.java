package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddItemController {
	@FXML
    TextField itemidtf;
    @FXML
    TextField titletf;
    @FXML
    TextField catagorytf;
    @FXML
    TextField authortf;
    @FXML
    TextField pubNametf;
    @FXML
    TextField pubDatetf;
    @FXML
    CheckBox box1;
    @FXML
    CheckBox box2;
    @FXML
    CheckBox box3;
public void addItem(ActionEvent action) {
    	
    	ArrayList<String> authors = new ArrayList<>();
    	if(box1.isSelected()) {
    		String iid = itemidtf.getText();
        	String tit = titletf.getText();
        	authors.add(authortf.getText());
        	String cat = catagorytf.getText();
        	int pubD = Integer.parseInt(pubDatetf.getText()); 
        	String pubN = pubNametf.getText();
        	String itype = ("Book");
        	Main.lib.addItem(itype, iid, tit, cat, authors, pubD, pubN);
        	Main.lib.saveData();
    	}
    	if(box2.isSelected()) {
    		String iid = itemidtf.getText();
        	String tit = titletf.getText();
        	authors.add(authortf.getText());
        	String cat = catagorytf.getText();
        	int pubD = Integer.parseInt(pubDatetf.getText()); 
        	String jourN = pubNametf.getText();
        	String itype = ("Publication");
        	Main.lib.addItem(itype, iid, tit, cat, authors, pubD, jourN);
        	Main.lib.saveData();
    	}
    	if(box3.isSelected()) {
    		//pubNametf.setEditable(false);
    		String iid = itemidtf.getText();
        	String tit = titletf.getText();
        	authors.add(authortf.getText());
        	String cat = catagorytf.getText();
        	int pubD = Integer.parseInt(pubDatetf.getText());
        	Main.lib.addItem(iid, tit, cat, authors, pubD);
        	Main.lib.saveData();
    	}
    	Clear(action);
    }
    public void Clear(ActionEvent action) {
    	itemidtf.clear();
        titletf.clear();
        catagorytf.clear();
        authortf.clear();
        pubNametf.clear();
        pubDatetf.clear();
        box1.setSelected(false);
        box2.setSelected(false);
        box3.setSelected(false);
    }
	public void Back(ActionEvent action3) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Libarian.fxml"));
		Stage stage = (Stage)((Node)action3.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
