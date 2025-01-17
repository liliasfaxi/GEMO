package tn.medtech.sweng.gemo.view;

import javafx.application.Application;

import java.io.IOException;
import java.lang.Exception;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.*;
import javafx.stage.Stage;
import tn.medtech.sweng.gemo.controller.VisitController;

public class VisitView {


    public VisitView() {
    }


    public static void add(Scene scene) {

        Button add = (Button) scene.lookup("#add");
         TextField idp = (TextField) scene.lookup("#idp");
         TextField ids = (TextField) scene.lookup("#ids");
         TextField comment = (TextField) scene.lookup("#comment");
         TextField context = (TextField) scene.lookup("#context");
         DatePicker date = (DatePicker) scene.lookup("#date");
        Label label = (Label) scene.lookup("#label");

         TextField idint = (TextField) scene.lookup("#idint");
         TextField iddci = (TextField) scene.lookup("#iddci");
         TextField idprob = (TextField) scene.lookup("#idprob");
        Label username =(Label)scene.lookup("#username");





        try {


            add.setOnAction(event -> {

                int ids1 = Integer.parseInt(ids.getText());
                int idp1 = Integer.parseInt(idp.getText());
                String date1 = date.getValue().toString();
                String comment1 = comment.getText();
                String context1 = context.getText();
                int idint1 = Integer.parseInt(idint.getText());
                int iddci1 = Integer.parseInt(iddci.getText());
                int idprob1 = Integer.parseInt(idprob.getText());
                String u= username.getText();

                VisitController ctrrl = new VisitController();

                ctrrl.add(idp1, date1, comment1, ids1,idint1,context1,iddci1,idprob1,u);
                label.setText("Added successfully !!");


            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(Scene scene) {

        Button update = (Button) scene.lookup("#update");
        final TextField idp = (TextField) scene.lookup("#idp");
        final TextField ids = (TextField) scene.lookup("#ids");
        final TextField comment = (TextField) scene.lookup("#comment");
        final DatePicker date = (DatePicker) scene.lookup("#date");
        Label label = (Label) scene.lookup("#label");
        final TextField id = (TextField) scene.lookup("#id");

        update.setOnAction(event -> {

            try {

                int ids1 = Integer.parseInt(ids.getText());
                int idp1 = Integer.parseInt(idp.getText());
                String date1 = date.getValue().toString();
                String comment1 = comment.getText();
                int idd;
                idd = Integer.valueOf(id.getText());
                if (VisitController.exist(idd)) {
                    VisitController.update(idp1, date1, comment1, ids1, idd);
                    label.setText("Updated successfully !!");
                } else {
                    label.setText("this ID doesn't exist !!");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    public void ServiceLoad(Scene scene) {

        try {
            Button serviceload = (Button) scene.lookup("#serviceload");
            serviceload.setOnAction(e -> {


                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/fxml/serviceload.fxml"));
                Parent root1 = null;
                try {
                    root1 = (Parent) fxmlLoader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Stage stage = new Stage();
                stage.setTitle("Services");
                Scene sc2 = new Scene(root1);
                stage.setScene(sc2);
                stage.show();
                ServiceView.fillTable(sc2);




            });
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void DciLoad(Scene scene) {

        try {
            Button DciLoad = (Button) scene.lookup("#dciload");
            DciLoad.setOnAction(e -> {


                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/fxml/DciLoad.fxml"));
                Parent root1 = null;
                try {
                    root1 = (Parent) fxmlLoader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Stage stage = new Stage();
                stage.setTitle("DCI");
                Scene sc2 = new Scene(root1);
                stage.setScene(sc2);
                stage.show();
                DciView.fillTable(sc2);

            });
        } catch(Exception e) {
            e.printStackTrace();
        }

    }


    public void interload(Scene scene) {

        try {
            Button interload = (Button) scene.lookup("#interload");
            interload.setOnAction(e -> {


                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/fxml/interload.fxml"));
                Parent root1 = null;
                try {
                    root1 = (Parent) fxmlLoader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Stage stage = new Stage();
                stage.setTitle("Interventions");
                Scene sc2 = new Scene(root1);
                stage.setScene(sc2);
                stage.show();
                InterventionView.fillTable(sc2);

            });
        } catch(Exception e) {
            e.printStackTrace();
        }

    }


    public void patientload(Scene scene) {

        try {
            Button patientload = (Button) scene.lookup("#patientload");
            patientload.setOnAction(e -> {


                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/fxml/patientload.fxml"));
                Parent root1 = null;
                try {
                    root1 = (Parent) fxmlLoader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Stage stage = new Stage();
                stage.setTitle("Patients");
                Scene sc2 = new Scene(root1);
                stage.setScene(sc2);
                stage.show();
                PatientView.fillTable(sc2);

            });
        } catch(Exception e) {
            e.printStackTrace();
        }

    }




    public void problemload(Scene scene) {

        try {
            Button problemload = (Button) scene.lookup("#problemload");
            problemload.setOnAction(e -> {


                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/fxml/problemload.fxml"));
                Parent root1 = null;
                try {
                    root1 = (Parent)fxmlLoader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Stage stage = new Stage();
                stage.setTitle("Problems");
                Scene sc2 = new Scene(root1);
                stage.setScene(sc2);
                stage.show();
                ProblemView.fillTable(sc2);


            });
        } catch(Exception e) {
            e.printStackTrace();
        }

    }


    public void homebtn(Scene scene) {

        try {
            Button homebtn = (Button) scene.lookup("#homebtn");
            homebtn.setOnAction(e -> {


                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/fxml/Home.fxml"));
                Parent root1 = null;
                try {
                    root1 = fxmlLoader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                VisitView sview = new VisitView();
                String u=sview.SessionStorage(scene);

                Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
                stage.setTitle("Home Page");
                Scene sc2 = new Scene(root1);
                stage.setScene(sc2);
                stage.show();
                Label username =(Label)sc2.lookup("#username");
                username.setText(u);
                SearchView searchView=new SearchView();
                searchView.fillCombobox(sc2);
                searchView.filltable(sc2);
                searchView.getLoad(sc2);
                searchView.addPatient(sc2);
                searchView.addVisit(sc2);
                searchView.logout(sc2);
                searchView.Dashboard(sc2);


            });
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public String SessionStorage(Scene scene){

        Label username =(Label)scene.lookup("#username");

        String u= username.getText();


        return  u;
    }
}
