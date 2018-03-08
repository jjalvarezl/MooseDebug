package utils;

public class DataRetrieving {

    private String tabId;
    private String mooseOutput;
    private String mooseSuggestion;

    public DataRetrieving (){
        tabId = "";
        mooseOutput = "";
        mooseSuggestion = "";
    }

    public void appendMooseOutput (String mooseOutput){
        this.mooseOutput += mooseOutput;
    }

    public void appendMooseSuggestion (String mooseSuggestion){
        this.mooseSuggestion += mooseSuggestion;
    }

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId;
    }

    public String getMooseOutput() {
        return mooseOutput;
    }

    public void setMooseOutput(String mooseOutput) {
        this.mooseOutput = mooseOutput;
    }

    public String getMooseSuggestion() {
        return mooseSuggestion;
    }

    public void setMooseSuggestion(String mooseSuggestion) {
        this.mooseSuggestion = mooseSuggestion;
    }
}
