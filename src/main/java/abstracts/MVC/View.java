package abstracts.MVC;

import java.util.ArrayList;
import java.util.Observer;

public abstract class View implements Observer  {
    protected ArrayList<Model> models;

    public View (){
        models = new ArrayList<>();
    }

    public void addModel(Model model) {
        models.add(model);
        model.addObserver(this);
    }

    public abstract void addController (Controller controller);

}
