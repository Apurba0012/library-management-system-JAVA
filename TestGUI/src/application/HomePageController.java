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

public class HomePageController {
	@FXML
	TextField itemidtf;
	@FXML
	TextField titletf;
	@FXML
	TextField authortf;
	@FXML
    Label mylbl;
	@FXML
    ListView<String> listView;
	 public void librarian(ActionEvent action) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Libarian.fxml"));
		Stage stage = (Stage)((Node)action.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void member(ActionEvent action) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Member.fxml"));
		Stage stage = (Stage)((Node)action.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void searchID(ActionEvent action) {
    	String id = itemidtf.getText();
    	try {
    		ObservableList<Item>list = FXCollections.observableArrayList(Main.lib.findItem(id));
    		for(int i=0; i < list.size();i++) {
                listView.getItems().addAll(list.get(i).toString());
             }
		} catch (InvalidItemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mylbl.setText("Enter Valid ID");
			//System.out.println("Enter Valid ID");
		}
    	itemidtf.clear();
    }
	public void exit(ActionEvent action) {
		System.exit(0);
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
	}

