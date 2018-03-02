package views.Main;

import javax.swing.*;

public class MainForm {
    private JPanel jPanelMain;

    public MainForm() {
        //this.$$$setupUI$$$();
        initForm();
    }

    private void initForm() {
        jPanelMain = new JPanel();
    }

    public JPanel getjPanelMain() {
        return jPanelMain;
    }

    public void setjPanelMain(JPanel jPanelMain) {
        this.jPanelMain = jPanelMain;
    }



}
