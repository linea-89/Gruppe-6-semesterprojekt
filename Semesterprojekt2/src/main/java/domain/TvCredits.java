package domain;

import Interfaces.*;
import data.DataFacade;

import java.util.Date;
import java.util.List;

//Controllerklasse

public final class TvCredits {


    //Singleton object that is acessed in all controllers
    private static final TvCredits INSTANCE = new TvCredits();

    private static DataLayerInterface dataconnect;

    private TvCredits(){
        dataconnect = DataFacade.getInstance();

        // bruges til test af program - opretter 2 produktioner.
        //dataconnect.createTestProductions();
    }

    public static TvCredits getInstance(){
        return INSTANCE;
    }

    public List<Production> getProductions() {
        return dataconnect.getProductions();
    }

    //base case of *required fields
    public Production createProduction(java.lang.String id, java.lang.String name, Date releaseDate) {
        return new Production(id, name, releaseDate);
    }

    public void saveProduction(Production prod) {
        dataconnect.createProduction(prod);
    }

    public boolean updateProduction(java.lang.String productionID, Production replaceProduction) {
        return dataconnect.updateProduction(productionID, replaceProduction);
    }

        public Credit createCredit(CreditName creditName, java.lang.String role, String creditType) {
        return new Credit(creditName, role, creditType);
    }

    public void addCredit (Production production, Credit credit) {
        production.addCredit(credit);
    }

    public void addCredit (String productionId, Credit credit){
        List<Production> productions = dataconnect.getProductions();
        for (Production prod :
                productions) {
            if(prod.getId().equals(productionId)){
                prod.addCredit(credit);
                break;
            }
        }
    }
    public void deleteCredit(Credit credit) {
        List<Production> productions = dataconnect.getProductions();
        for (Production prod :
                productions) {
            if(prod.hasCredit(credit)){
                prod.removeCredit(credit);
            }
        }
    }

    //get production from ID
    public Production getProduction(String text) {
        List<Production> productions = dataconnect.getProductions();
        for (Production prod :
                productions) {
            if (prod.getId().equals(text)) {
               return prod;
            }
        }
        return null;
    }

    public List<String> getCreditTypes(){
        return dataconnect.getCreditTypes();
    }

    public List<String> getProductionTypes(){
        return dataconnect.getProductionTypes();
    }

    public List<String> getLanguages(){
        return dataconnect.getLanguages();
    }

    public List<String> getGenres(){
        return dataconnect.getGenres();
    }



    public static void main(java.lang.String[] args) {

        TvCredits tvCredits = TvCredits.getInstance();

        List<Production> testProductions = tvCredits.getProductions();
        System.out.println(testProductions);
    }








/*
    private Administrator facade;

    public TvCredits(){
        facade = new Administrator();
    }


    //Calling implementation in associated classes.
    @Override
    public void verifyProduction(Production production) {
        facade.verifyProduction(production);
    }

    @Override
    public void addProduction(int ID, String Name, Date date) {
        facade.addProduction(ID, Name, date);
    }

    @Override
    public void addCredit(Production production) {
        facade.addCredit(production);
    }

    @Override
    public void search(String searchString) {
        facade.search(searchString);
    }

    @Override
    public void searchProduction(String searchString) {
        facade.searchProduction(searchString);
    }

    @Override
    public void searchCredit(String searchString) {
        facade.searchCredit(searchString);
    }
*/

    // private Producer producerObj = new Producer(1,"Test", "Testsen");
   // private Administrator administrator = new Administrator(2,"Teste", "Testesen");


}
