package domain;

import data.DataFacade;
import data.DataLayerInterface;

import java.util.Date;
import java.util.List;

//Controllerklasse FACADE

public final class TvCreditsFacade implements TvCreditsInterface {

    //Singleton object that is acessed in all controllers
    private static final TvCreditsFacade INSTANCE = new TvCreditsFacade();

    private static DataLayerInterface dataconnect;

    private TvCreditsFacade() {
        dataconnect = DataFacade.getInstance();
    }

    public static TvCreditsFacade getInstance() {
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

    public boolean updateProduction(int productionID, Production replaceProduction) {
        return dataconnect.updateProduction(productionID, replaceProduction);
    }

    public Credit createCredit(CreditName creditName, java.lang.String role, String creditType) {
        return new Credit(creditName, role, creditType);
    }

    public void addCredit(Production production, Credit credit) {
        production.addCredit(credit);
    }

    public void addCredit(String productionId, Credit credit) {
        List<Production> productions = dataconnect.getProductions();
        for (Production prod :
                productions) {
            if (prod.getProductionReference().equals(productionId)) {
                prod.addCredit(credit);
                break;
            }
        }
    }

    public void deleteCredit(Credit credit) {
        List<Production> productions = dataconnect.getProductions();
        for (Production prod :
                productions) {
            if (prod.hasCredit(credit)) {
                prod.removeCredit(credit);
            }
        }
    }

    //get production from ID
    public Production getProduction(String text) {
        List<Production> productions = dataconnect.getProductions();
        for (Production prod :
                productions) {
            if (prod.getProductionReference().equals(text)) {
                return prod;
            }
        }
        return null;
    }

    public List<String> getCreditTypes() {
        return dataconnect.getAllCreditTypes();
    }

    public List<String> getProductionTypes() {
        return dataconnect.getAllProductionTypes();
    }

    public List<String> getLanguages() {
        return dataconnect.getAllLanguages();
    }

    public List<String> getGenres() {
        return dataconnect.getAllGenres();
    }




    public static void main(java.lang.String[] args) {

        TvCreditsFacade tvCreditsFacade = TvCreditsFacade.getInstance();

        List<Production> testProductions = tvCreditsFacade.getProductions();
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