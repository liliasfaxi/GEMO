package tn.medtech.sweng.gemo.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tn.medtech.sweng.gemo.controller.UserPendingController;
import tn.medtech.sweng.gemo.entities.UserPending;

import java.io.IOException;

public class UserPendingView {



    public void winInfo(Scene scene){

        try {
            Button btnInformation = (Button) scene.lookup("#btnInformation");
            btnInformation.setOnAction(e -> {


                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/UserPendingInfo.fxml"));
                Parent root1 = null;
                try {
                    root1 = (Parent) fxmlLoader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Stage stage = new Stage();
                stage.setTitle("Information");
                stage.setScene(new Scene(root1));
                stage.show();

            });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void UserInfo(Scene scene2){

        try {
            Button btnUser = (Button) scene2.lookup("#btnUser");

            btnUser.setOnAction((ActionEvent e) -> {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/UserInfo.fxml"));
                Parent root2 = null;
                try {
                    root2 =  fxmlLoader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Scene scen = new Scene(root2);
                Stage stage = new Stage();
                stage.setTitle("Users");
                stage.setScene(scen);
                stage.show();

                UserView.fillTable(scen);

            });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void fillTable (Scene scene) {

        try{
            TableView table  = (TableView) scene.lookup("#table");

            //view
            UserPendingController controller =new UserPendingController();

            table.setItems(controller.fillTable());


            TableColumn<UserPending,Integer> columnid = new TableColumn<UserPending,Integer>("Id");
            columnid.setCellValueFactory(new PropertyValueFactory("id"));
            TableColumn<UserPending,String> columnfirstname = new TableColumn<UserPending,String>("FirstName");
            columnfirstname.setCellValueFactory(new PropertyValueFactory("FirstName"));
            TableColumn<UserPending,String> columnlastname = new TableColumn<UserPending,String>("LastName");
            columnlastname.setCellValueFactory(new PropertyValueFactory("LastName"));
            TableColumn<UserPending,String> columnusername = new TableColumn<UserPending,String>("UserName");
            columnusername.setCellValueFactory(new PropertyValueFactory("UserName"));
            TableColumn<UserPending,String> columnstatus = new TableColumn<UserPending,String>("Status");
            columnstatus.setCellValueFactory(new PropertyValueFactory("status"));
            TableColumn<UserPending,String> columnemail = new TableColumn<UserPending,String>("email");
            columnemail.setCellValueFactory(new PropertyValueFactory("email"));
            TableColumn<UserPending,String> columnpassword = new TableColumn<UserPending,String>("password");
            columnpassword.setCellValueFactory(new PropertyValueFactory("password"));
            TableColumn<UserPending,Boolean> columnadmin = new TableColumn<UserPending,Boolean>("Admin");
            columnadmin.setCellValueFactory(new PropertyValueFactory("admin"));

            table.getColumns().setAll(columnid, columnfirstname,columnlastname,columnusername,columnemail,columnpassword,columnadmin);
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        } catch (Exception e){
            e.printStackTrace();
        }

    }


    public  static void reject (Scene scene) {

        try{

            Button btnReject =(Button) scene.lookup("#btnReject");
            Label txtStatus  = (Label) scene.lookup("#txtStatus");
            Label txtStatus2  = (Label) scene.lookup("#txtStatus2");
            TableView table  = (TableView) scene.lookup("#table");
            TextField txtId = (TextField) scene.lookup("#txtId");

            //view
            btnReject.setOnAction(event -> {
                int d = Integer.valueOf(txtId.getText());//view

                UserPendingController controller = new UserPendingController() ;
                if(controller.checkId(d)) {

                    controller.reject(d);
                    fillTable(scene);//view
                    txtStatus2.setText("");
                    txtStatus.setText("User Rejected Successfully!");
                }

                else {
                    txtStatus.setText("");
                    txtStatus2.setText("This ID does not exist!");
                }

            });


        }catch (Exception e){
            e.printStackTrace();

        }

    }

    public  static void accept (Scene scene) {

        try{

            Button btnAccept =(Button) scene.lookup("#btnAccept");
            Label txtStatus  = (Label) scene.lookup("#txtStatus");
            Label txtStatus2  = (Label) scene.lookup("#txtStatus2");
            TableView table  = (TableView) scene.lookup("#table");
            TextField txtId = (TextField) scene.lookup("#txtId");

            //view
            btnAccept.setOnAction(event -> {
               System.out.println("clicked!!");System.out.println("clicked!!");System.out.println("clicked!!");
                int d = Integer.valueOf(txtId.getText());//view

                UserPendingController controller = new UserPendingController() ;
                if(controller.checkId(d)) {

                    controller.accept(d);
                    fillTable(scene);//view
                    txtStatus2.setText("");
                    txtStatus.setText("User has been Accepted !!");
                }

                else {
                    txtStatus.setText("");
                    txtStatus2.setText("This ID does not exist!");
                }

            });


        }catch (Exception e){
            e.printStackTrace();

        }

    }

    public void Dashboard(Scene scene){
        try {
            Button Dashboard=(Button)scene.lookup("#Dashboard");

            Dashboard.setOnAction(event -> {

                FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Dashboard.fxml"));
                Parent root = null;
                try {
                    root =  Loader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                UserPendingView dview = new UserPendingView();
                String u=dview.SessionStorage(scene);

                Scene sc2 = new Scene(root, 849, 494);
                Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
                newstage.setScene(sc2);
                newstage.show();
                Label username =(Label)sc2.lookup("#username");
                username.setText(u);
                DashboardView view = new DashboardView();
                view.dci(sc2);
                view.med(sc2);
                view.problem(sc2);
                view.service(sc2);
                view.service(sc2);
                view.userpending(sc2);
                view.user(sc2);
                view.Home(sc2);
                view.intervention(sc2);

            });

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public String SessionStorage(Scene scene){

        Label username =(Label)scene.lookup("#username");

        String u= username.getText();


        return  u;
    }
}

