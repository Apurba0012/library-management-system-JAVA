package application;

import java.io.IOException;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.InvalidItemException;
import library.Item;

public class LibarianPageController {
	@FXML
    TextField itemidtf;
    @FXML
    TextField titletf;
    @FXML
    TextField authortf;
    @FXML
    Label mylbl;
    @FXML
    TextField spacificItemtf;
    @FXML
    ListView<String> listView;
    @FXML
    TextField itemid2tf;
    
    public void searchID(ActionEvent action) {
    	String id = itemidtf.getText();
    	try {
    		ObservableList<Item>list = FXCollections.observableArrayList(Main.lib.findItem(id));
    		for(int i=0; i < list.size();i++) {
                listView.getItems().addAll(list.get(i).toString());
             }
		} catch (InvalidItemException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			String a = "Enter Valid Id";
			listView.getItems().addAll(a);
		}
    	itemidtf.clear();
    }
	public void searchWithTitleAndAuthor(ActionEvent action) {
    	String t = titletf.getText();
    	String a = authortf.getText();
    	ObservableList<Item>list = FXCollections.observableArrayList(Main.lib.findItems(t,a));
		for(int i=0; i < list.size();i++) {
            listView.getItems().addAll(list.get(i).toString());
         }
    	titletf.clear();
    	authortf.clear();
		}
	public void displayAll(ActionEvent action) {
		String display = "";
		for (Item data : Main.lib.getItems()) {
			display = display + data.toString() + "\n";
		}
		listView.getItems().addAll(display);
	}
	public void displaySpecificTypesItems(ActionEvent action) {
		String type = spacificItemtf.getText();
		ObservableList<Item>list = FXCollections.observableArrayList(Main.lib.findItems(type));
		for(int i=0; i < list.size();i++) {
            listView.getItems().addAll(list.get(i).toString());
         }
		spacificItemtf.clear();
	}
	public void checkInItem(ActionEvent action) {
		String t = itemid2tf.getText();
		try {
			Main.lib.checkIn(t);
			Main.lib.saveData();
		} catch (InvalidItemException e) {
			String a = "Enter valid Data";
			listView.getItems().addAll(a);
			
		}
		itemid2tf.clear();
	}
	public void addItem(ActionEvent action) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AddItem.fxml"));
		Stage stage = (Stage)((Node)action.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void clear(ActionEvent action) {
		itemidtf.clear();
        titletf.clear();
        authortf.clear();
        listView.getItems().clear();
	}
	public void addMember(ActionEvent action) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AddMember.fxml"));
		Stage stage = (Stage)((Node)action.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void check(ActionEvent action) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Check.fxml"));
		Stage stage = (Stage)((Node)action.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void Back(ActionEvent action) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		Stage stage = (Stage)((Node)action.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}
