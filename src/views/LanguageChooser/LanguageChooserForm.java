package views.LanguageChooser;

import abstracts.MVC.Controller;

import javax.swing.*;

public class LanguageChooserForm {
    private JList jListLanguages;
    private JPanel jPanelMain;
    private JButton jButtonAccept;
    private JButton jButtonCancel;

    public static final String J_BUTTON_ACCEPT_COMMAND = "LanguageChooserForm.jButtonAccept";
    public static final String J_BUTTON_CANCEL_COMMAND = "LanguageChooserForm.jButtonCancel";

    public LanguageChooserForm () {
        jButtonAccept.setActionCommand(J_BUTTON_ACCEPT_COMMAND);
        jButtonCancel.setActionCommand(J_BUTTON_CANCEL_COMMAND);
    }

    public JPanel getJPanelMain() {
        return jPanelMain;
    }

    public void setJPanelMain(JPanel jPanelMain) {
        this.jPanelMain = jPanelMain;
    }

    public JList getJListLanguages() {
        return jListLanguages;
    }

    public void setJListLanguages(JList jListLanguages) {
        this.jListLanguages = jListLanguages;
    }

    public JButton getJButtonAccept() {
        return jButtonAccept;
    }

    public void setJButtonAccept(JButton jButtonAccept) {
        this.jButtonAccept = jButtonAccept;
    }

    public JButton getJButtonCancel() {
        return jButtonCancel;
    }

    public void setJButtonCancel(JButton jButtonCancel) {
        this.jButtonCancel = jButtonCancel;
    }

    public void addController (Controller controller){
        jButtonAccept.addActionListener(controller);
        jButtonCancel.addActionListener(controller);
    }
}
