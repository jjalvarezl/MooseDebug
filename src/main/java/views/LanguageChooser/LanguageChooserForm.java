package views.LanguageChooser;

import abstracts.MVC.Controller;

import javax.swing.*;
import java.awt.*;

public class LanguageChooserForm {
    private JList jListLanguages;
    private JPanel jPanelMain;
    private JButton jButtonAccept;
    private JButton jButtonCancel;

    public static final String J_BUTTON_ACCEPT_COMMAND = "LanguageChooserForm.jButtonAccept";
    public static final String J_BUTTON_CANCEL_COMMAND = "LanguageChooserForm.jButtonCancel";

    public LanguageChooserForm () {
        initForm();
        jButtonAccept.setActionCommand(J_BUTTON_ACCEPT_COMMAND);
        jButtonCancel.setActionCommand(J_BUTTON_CANCEL_COMMAND);
    }

    private void initForm() {
        jPanelMain= new JPanel();
        jPanelMain.setLayout(new GridBagLayout());
        jPanelMain.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        GridBagConstraints c = new GridBagConstraints();

        jListLanguages = new JList();
        //jListLanguages.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
        //jListLanguages.add(Box.createRigidArea(new Dimension(0,5)));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 50;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        jPanelMain.add(jListLanguages,c);

        //Reset to default for next gui components
        c.ipady = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.NONE;

        jButtonAccept = new JButton();
        jButtonAccept.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        c.gridx = 0;
        c.gridy = 1;
        jPanelMain.add(jButtonAccept,c);

        jButtonCancel = new JButton();
        jButtonCancel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        //c.weightx=0.5;
        c.gridx = 1;
        c.gridy = 1;
        jPanelMain.add(jButtonCancel,c);
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
