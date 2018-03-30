import controllers.AboutController;
import controllers.LanguageChooserController;
import controllers.MainController;
import models.ConfigurationModel;
import utils.Language;
import views.About.AboutView;
import views.LanguageChooser.LanguageChooserView;
import views.Main.MainForm;
import views.Main.MainView;

public class MooseDebug {

    public static void main (String args[]){
        Language.setResource(MainForm.class.getName());
        MainView.getInstance().addModel(ConfigurationModel.getInstance());
        MainView.getInstance().addController(new MainController());
        MainView.getInstance().getjMainFrame().setVisible(true);
        LanguageChooserView.getInstance().addController(new LanguageChooserController());
        LanguageChooserView.getInstance().addModel(ConfigurationModel.getInstance());
        AboutView.getInstance().addController(new AboutController());
        AboutView.getInstance().addModel(ConfigurationModel.getInstance());
    }
}
