package views.About;

import abstracts.MVC.Controller;
import abstracts.MVC.View;
import utils.Language;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Observable;
import java.util.ResourceBundle;

public class AboutView extends View{
    // Singleton
    private static final AboutView INSTANCE = new AboutView();

    private AboutForm aboutForm;
    private JDialog jDialogMain;
    private ResourceBundle rb;

    public static AboutView getInstance() {
        return INSTANCE;
    }

    private AboutView (){
        aboutForm = new AboutForm();
        jDialogMain = new JDialog();

        //Form display.
        jDialogMain.setResizable(false);
        jDialogMain.setContentPane(aboutForm.getjPanelMain());
        jDialogMain.setLocationRelativeTo(null);

        //Content initialization
        initFormContent();

        //Setting icon to jframe
        try {
            Image img = ImageIO.read(getClass().getResourceAsStream("icon"));
            jDialogMain.setIconImage(img);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initFormContent() {
        Language.setResource(AboutForm.class.getName());
        rb = Language.getResource();

        jDialogMain.setTitle(rb.getString("FormTitle"));
        aboutForm.getjLabelMessage().setText(rb.getString("jLabelMessage"));
        aboutForm.getjButtonGoToGitHubIssue().setText(rb.getString("jButtonGoToGitHubIssue"));
        aboutForm.getjButtonAccept().setText(rb.getString("jButtonAccept"));

        jDialogMain.pack();
    }

    @Override
    public void addController(Controller controller) {
        aboutForm.addController(controller);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Update from AboutView");
        initFormContent();
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
