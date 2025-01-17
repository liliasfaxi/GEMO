package tn.medtech.sweng.gemo.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tn.medtech.sweng.gemo.controller.InterventionController;
import tn.medtech.sweng.gemo.controller.ServiceController;
import tn.medtech.sweng.gemo.entities.Intervention;
import tn.medtech.sweng.gemo.entities.Service;

import java.io.IOException;

public class InterventionView {

    public static void insert(Scene scene) {

        Button insert = (Button) scene.lookup("#insert");
        TextField name = (TextField) scene.lookup("#name");
        insert.setOnAction(event -> {

            String nm = name.getText();

            InterventionController.insert(nm);
        });

    }

    public static void update(Scene scene) {
        Button update = (Button) scene.lookup("#update");
        TextField name = (TextField) scene.lookup("#name");
        TextField id = (TextField) scene.lookup("#id");
        update.setOnAction(event -> {

            String nm;
            nm = name.getText();
            int d = Integer.valueOf(id.getText());
            InterventionController.update(nm, d);
        });

    }

    public static void delete(Scene scene) {
        Button delete = (Button) scene.lookup("#delete");
        TextField id = (TextField) scene.lookup("#id");

        delete.setOnAction(event -> {

            int d = Integer.valueOf(id.getText());
            InterventionController.delete(d);
        });

    }


    public static void fillTable (Scene scene) {

        try{
            TableView table  = (TableView) scene.lookup("#table");

            //view
            InterventionController controller =new InterventionController();

            table.setItems(InterventionController.fillTable());


            TableColumn<Intervention,Integer> columnid = new TableColumn<Intervention,Integer>("id");
            columnid.setCellValueFactory(new PropertyValueFactory("id"));
            TableColumn<Intervention,String> columnname = new TableColumn<Intervention,String>("intervention");
            columnname.setCellValueFactory(new PropertyValueFactory("name"));

            table.getColumns().setAll(columnid, columnname);
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);//don't touch this!! remove it and table gets messed up! don't know what it does tho!!!

        } catch (Exception e){
            e.printStackTrace();
        }



    }

    public void winInfo(Scene scene){

        try {
            Button btnInfo = (Button) scene.lookup("#info");
            btnInfo.setOnAction(e -> {


                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/InfoDci.fxml"));
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
                InterventionView dview = new InterventionView();
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



