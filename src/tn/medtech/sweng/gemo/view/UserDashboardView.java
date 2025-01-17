package tn.medtech.sweng.gemo.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.medtech.sweng.gemo.controller.UserController;

import java.io.IOException;

public class UserDashboardView {


    public UserDashboardView() {
    }

    public  static void update (Scene scene) {



    }



    public   void delete (Scene scene) {

        try{

            Button deletebutton =(Button) scene.lookup("#delete");
            Label label  = (Label) scene.lookup("#label");
            TextField id = (TextField) scene.lookup("#id");

            //view
            deletebutton.setOnAction(event -> {
                int d = Integer.valueOf(id.getText());//view

                UserController controller = new UserController() ;


                controller.delete(d);

                UserView.fillTable(scene);;//view
                label.setText("User Deleted Successfully!");

            });

        }catch (Exception e){
            e.printStackTrace();

        }

    }
    public void Dashboard(Scene scene){
        try {
            Button Dashboardprob=(Button)scene.lookup("#Dashboard");

            Dashboardprob.setOnAction(event -> {

                FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Dashboard.fxml"));
                Parent root = null;
                try {
                    root =  Loader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                UserDashboardView dview = new UserDashboardView();
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
