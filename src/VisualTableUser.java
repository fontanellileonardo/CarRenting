import java.util.*;
import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;

public class VisualTableUser extends TableView<User>{
	private ObservableList<User> userList;
	
    public VisualTableUser(){
        
        TableColumn columnName = new TableColumn("NAME");
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn columnSurname = new TableColumn("SURNAME");
        columnSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        TableColumn columnEmail = new TableColumn("EMAIL");
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn columnCustomer = new TableColumn("CUSTOMER");
        columnCustomer.setCellValueFactory(new PropertyValueFactory<>("customer"));
        
        userList = FXCollections.observableArrayList();
        setItems(userList);
        getColumns().addAll(columnName, columnSurname, columnEmail, columnCustomer);
    }
	
    public void setTableUserStyle() { //da sistemare
        setFixedCellSize(40);
        setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        setPrefWidth(90);
        setMaxHeight(480);
    }
    
    
    public void UserListUpdate(List<User> users){
    	userList.clear();
    	userList.addAll(users);
    }

    public ObservableList<User> getUsers() {return userList;}
    
}