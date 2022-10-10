package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.InvalidMemberException;
import library.Member;

public class AddMemberController {
	@FXML
    TextField memNtf;
	@FXML
    TextField memIdtf;
	@FXML
    Label mylbl;
	public void addMember(ActionEvent action) {
		String mn = memNtf.getText();
		String mid = memIdtf.getText();
		Member member = null;
		try {
			member = Main.lib.findMember(mid);
		} catch (InvalidMemberException e) {
			// TODO Auto-generated catch block
			//e.getMessage();
		}
		if (member == null) {
			Main.lib.addMember(mid, mn);
			Main.lib.saveData();
		} else {
			mylbl.setText("Enter Valid ID");
			//System.out.println("Enter Valid ID");
		}
		Clear(action);
	}
	public void Clear(ActionEvent action) {
		memNtf.clear();
		memIdtf.clear();
	}
	public void Back(ActionEvent action) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Libarian.fxml"));
		Stage stage = (Stage)((Node)action.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
