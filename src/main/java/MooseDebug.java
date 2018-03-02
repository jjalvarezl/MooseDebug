import controllers.LanguageChooserController;
import models.ConfigurationModel;
import utils.Language;
import views.LanguageChooser.LanguageChooserView;
import views.Main.MainForm;
import views.Main.MainView;

public class MooseDebug {
    private static MainView mainView;

    public static void main (String args[]){
        Language.setResource(MainForm.class.getName());
        mainView = new MainView();
        mainView.addModel(ConfigurationModel.getInstance());
        LanguageChooserView.getInstance().addController(new LanguageChooserController());
        LanguageChooserView.getInstance().addModel(ConfigurationModel.getInstance());
    }
}
