package tn.medtech.sweng.gemo.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.medtech.sweng.gemo.daoimpl.SearchDaoImpl;
import tn.medtech.sweng.gemo.entities.Search;

import java.util.List;
import javax.jws.Oneway;
public class SearchController {
    public ObservableList fillProblemlist(){
        SearchDaoImpl dao=new SearchDaoImpl();
        ObservableList a;
        a=dao.fillProblemlist();
        return a;
    }
    public ObservableList fillMedlist(){
        SearchDaoImpl dao=new SearchDaoImpl();
        ObservableList a;
        a=dao.fillMedList();
        return a;
    }
    public ObservableList fillInterlit(){
        ObservableList a;
        SearchDaoImpl dao=new SearchDaoImpl();
        a=dao.fillInterventionList();
        return a;
    }
    public ObservableList SearchbProblem(String val){

        SearchDaoImpl dao=new SearchDaoImpl();
        List<Search> searches=dao.SearchByProblem(val);
        ObservableList<Search> oblsearches=FXCollections.observableArrayList();
        for(Search p: searches){
            oblsearches.add(p);
        }
        return oblsearches;
    }
    public ObservableList SearchbContexte(String val){
        SearchDaoImpl dao=new SearchDaoImpl();
        List<Search> searches=dao.SearchByContext(val);
        ObservableList<Search> oblsearches=FXCollections.observableArrayList();
        for(Search p: searches){
            oblsearches.add(p);
        }
        return oblsearches;
    }
    public ObservableList SearchByCom(String val){
        SearchDaoImpl dao=new SearchDaoImpl();
        List<Search> searches=dao.SearchByComment(val);
        ObservableList<Search> oblsearches=FXCollections.observableArrayList();
        for(Search p: searches){
            oblsearches.add(p);
        }
        return oblsearches;
    }
    public ObservableList SearchByDci(String val){
        SearchDaoImpl dao=new SearchDaoImpl();
        List<Search> searches=dao.SearchByDCI(val);
        ObservableList<Search> oblsearches=FXCollections.observableArrayList();
        for(Search p: searches){
            oblsearches.add(p);
        }
        return oblsearches;
    }
    public ObservableList SearchByService(String val){
        SearchDaoImpl dao=new SearchDaoImpl();
        List<Search> searches=dao.SearchByService(val);
        ObservableList<Search> oblsearches=FXCollections.observableArrayList();
        for(Search p: searches){
            oblsearches.add(p);
        }
        return oblsearches;
    }
    public ObservableList SearchByDate(String val){
        SearchDaoImpl dao=new SearchDaoImpl();
        List<Search> searches=dao.SearchByDate(val);
        ObservableList<Search> oblsearches=FXCollections.observableArrayList();
        for(Search p: searches){
            oblsearches.add(p);
        }
        return oblsearches;
    }
    public ObservableList SearchByPat(String val){
        SearchDaoImpl dao=new SearchDaoImpl();
        List<Search> searches=dao.SearchByPatient(val);
        ObservableList<Search> oblsearches=FXCollections.observableArrayList();
        for(Search p: searches){
            oblsearches.add(p);
        }
        return oblsearches;
    }
    public ObservableList SearchByMed(String val){
        SearchDaoImpl dao=new SearchDaoImpl();
        List<Search> searches=dao.SearchByMed(val);
        ObservableList<Search> oblsearches=FXCollections.observableArrayList();
        for(Search p: searches){
            oblsearches.add(p);
        }
        return oblsearches;
    }
    public ObservableList SearchByIntervention(String val){
        SearchDaoImpl dao=new SearchDaoImpl();
        List<Search> searches=dao.SearchByIntervention(val);
        ObservableList<Search> oblsearches=FXCollections.observableArrayList();
        for(Search p: searches){
            oblsearches.add(p);
        }
        return oblsearches;
    }



}