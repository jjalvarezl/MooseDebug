package abstracts.MVC;

import java.util.Observer;

public abstract class View implements Observer  {

    public void addModel(Model model) {
        model.addObserver(this);
    }

    public abstract void addController (Controller controller);

}
