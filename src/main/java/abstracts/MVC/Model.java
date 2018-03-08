package abstracts.MVC;

import utils.DataRetrieving;

import java.util.Observable;

public abstract class Model extends Observable {
    protected DataRetrieving dataRetrieving;

    public Model (){
        dataRetrieving = new DataRetrieving();
    }

    public DataRetrieving retrieveData (){
        return dataRetrieving;
    }
}
