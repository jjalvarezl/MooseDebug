package views.About;

import abstracts.MVC.Controller;
import abstracts.MVC.View;

import javax.swing.*;
import java.util.Observable;

public class AboutView extends View{
    // Singleton
    private static final AboutView INSTANCE = new AboutView();

    private AboutForm aboutForm;
    private JDialog jDialogMain;

    public static AboutView getInstance() {
        return INSTANCE;
    }

    private AboutView (){
        aboutForm = new AboutForm();
        jDialogMain = new JDialog();
        jDialogMain.setResizable(false);
        jDialogMain.setContentPane(aboutForm.getjPanelMain());
        jDialogMain.setLocationRelativeTo(null);
        jDialogMain.setTitle("About");
        jDialogMain.pack();
    }

    @Override
    public void addController(Controller controller) {
        aboutForm.addController(controller);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public AboutForm getAboutForm() {
        return aboutForm;
    }

    public void setAboutForm(AboutForm aboutForm) {
        this.aboutForm = aboutForm;
    }

    public JDialog getjDialogMain() {
        return jDialogMain;
    }

    public void setjDialogMain(JDialog jDialogMain) {
        this.jDialogMain = jDialogMain;
    }
}
