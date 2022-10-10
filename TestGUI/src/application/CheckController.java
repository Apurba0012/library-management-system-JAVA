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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.CheckOutRecord;
import library.CheckedOutException;
import library.InvalidItemException;
import library.InvalidMemberException;
import library.Item;
import library.Member;

public class CheckController {
	@FXML
	TextField itemidtf;
	@FXML
	TextField memidtf;
	@FXML
	TextField itemid1tf;
	@FXML
	TextField memid1tf;
	@FXML
	TextField itemid2tf;
	@FXML
	TextField memid2tf;
	@FXML
    ListView<String> listView;
	
	public void checkoutItem(ActionEvent action) {
		String t = itemidtf.getText();
		String m = memidtf.getText();
		try {
			Main.lib.checkOut(t, m);
			Main.lib.saveData();
		} catch (CheckedOutException | InvalidItemException | InvalidMemberException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			String a = "Enter Valid Data";
			listView.getItems().addAll(a);
		}
		itemidtf.clear();
		memidtf.clear();
	}
	
	public void extendCheckoutTime(ActionEvent action) {
		String t = itemid1tf.getText();
		String m = memid1tf.getText();
		try {
			Main.lib.extendCheckOut(t, m);
			Main.lib.saveData();
		} catch (CheckedOutException | InvalidItemException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			String a = "Enter Valid Data";
			listView.getItems().addAll(a);
		}
		itemid1tf.clear();
		memid1tf.clear();
	}
	public void checkoutRecordItemId(ActionEvent action) {
        String t = itemid2tf.getText();
        try {
            ObservableList<Item> list = FXCollections.observableArrayList(Main.lib.findItem(t));
            for(int i=0; i < list.size();i++) {
                listView.getItems().addAll(list.get(i).toString());
            }
        } catch (InvalidItemException e) {
            //e.printStackTrace();
        	String a = "Enter Valid Data";
			listView.getItems().addAll(a);
			
        }
        itemid2tf.clear();
    }
	 public void checkoutRecordmemberId(ActionEvent action) {
	        String m = memid2tf.getText();    
	            Member member;
	            try {
	                member =Main.lib.findMember(m);
	                ObservableList<CheckOutRecord> list = FXCollections.observableArrayList(member.getChekOutRecords());
	                for(int i=0; i < list.size();i++) {
	                   listView.getItems().addAll(list.get(i).toString());
	                }
	            } catch (InvalidMemberException e) {
	                // TODO Auto-generated catch block
	                //e.printStackTrace();
	            	String a = "Enter Valid Data";
	    			listView.getItems().addAll(a);
	            }


	        memid2tf.clear();
	    } 
	 public void clear(ActionEvent action) {
	        listView.getItems().clear();
		} 
	public void Back(ActionEvent action) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		Stage stage = (Stage)((Node)action.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}
