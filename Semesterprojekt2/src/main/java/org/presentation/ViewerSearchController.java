package org.presentation;

import domain.Credit;
import domain.Production;
import domain.TvCredits;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ViewerSearchController {
    public TableView listviewProductions;
    public TableView listviewCredits;
    public TextField textSearchBar;

    private TvCredits tvCredits;

    public void initialize(){
        tvCredits = TvCredits.getInstance();

        setTableViewProduction();
        setTableViewCredits();
    }


    private void setTableViewProduction(){

        listviewProductions.getColumns().clear();
        listviewProductions.getItems().clear();

        //creates a new column in the TableView with header "ID", type Production and cellValue String
        TableColumn<Production, String> col1 = new TableColumn<>("ID");
        //deciding what values go in the cells. Here it calls production.getId() to find value for the cell
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Production, String> col2 = new TableColumn<>("Title");
        col2.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Production, Date> col3 = new TableColumn<>("Release Date");
        col3.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        TableColumn<Production, String> col4 = new TableColumn<>("Length");
        col4.setCellValueFactory(new PropertyValueFactory<>("length"));

        TableColumn<Production, String> col5 = new TableColumn<>("Højde");
        col5.setCellValueFactory(new PropertyValueFactory<>("højde"));

        //adding columns to the tableview
        listviewProductions.getColumns().clear();
        listviewProductions.getColumns().add(col1);
        listviewProductions.getColumns().add(col2);
        listviewProductions.getColumns().add(col3);
        listviewProductions.getColumns().add(col4);


    }

    private void addAllProductions(){
        //adding data to the table view
        List<Production> productionList = tvCredits.getProductions();
        listviewProductions.getItems().addAll(productionList);
    }

    private void setTableViewCredits(){

        listviewCredits.getColumns().clear();
        listviewCredits.getItems().clear();


        //creates a new column in the TableView with header "ID", type Production and cellValue String
        TableColumn<Credit, String> col1 = new TableColumn<>("First Name");
        //deciding what values go in the cells. Here it calls production.getId() to find value for the cell
        col1.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Credit, String> col2 = new TableColumn<>("Last Name");
        col2.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Credit, String> col3 = new TableColumn<>("Role");
        col3.setCellValueFactory(new PropertyValueFactory<>("role"));

        TableColumn<Credit, String> col4 = new TableColumn<>("Credit Type");
        col4.setCellValueFactory(new PropertyValueFactory<>("creditType"));

        //adding columns to the tableview

        listviewCredits.getColumns().add(col1);
        listviewCredits.getColumns().add(col2);
        listviewCredits.getColumns().add(col3);
        listviewCredits.getColumns().add(col4);



    }

    private void addAllCredits(){
        //adding data to the table view
        List<Production> productionList = tvCredits.getProductions();
        List<Credit> credits = new ArrayList<>();
        for (Production prod :
                productionList) {
            credits.addAll(prod.getCredits());
            credits.add(null);
        }
        listviewCredits.getItems().addAll(credits);
    }
}
