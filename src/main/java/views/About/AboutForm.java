package views.About;

import abstracts.MVC.Controller;
import abstracts.MVC.View;

import javax.swing.*;
import java.awt.*;

public class AboutForm {
    private JPanel jPanelMain;

    private JLabel jLabelMessage;
    private JButton jButtonGoToGitHubIssue;
    private JButton jButtonAccept;

    //Action commands
    public static final String J_BUTTON_GO_TO_GITHUB_ISSUE_COMMAND = "aboutView.aboutForm.jButtonGoToGitHubIssue";
    public static final String J_BUTTON_ACCEPT_COMMAND = "aboutView.aboutForm.jButtonAccept";

    public AboutForm (){
        GridBagConstraints c = new GridBagConstraints();
        jPanelMain = new JPanel(new GridBagLayout());

        jLabelMessage = new JLabel("<html><body><p align='center'>Moose Debug v1.0<br/><br/>Need Support?: make an issue GitHub.</p></body></html>", SwingConstants.CENTER);
        c.insets = new Insets(10,10,5,10);
        c.gridwidth=2;
        c.fill = GridBagConstraints.BOTH;
        c.weightx=1.0;
        c.weighty=1.0;
        jPanelMain.add(jLabelMessage,c);

        jButtonGoToGitHubIssue = new JButton("Go to GitHub Issues");
        jButtonGoToGitHubIssue.setActionCommand(J_BUTTON_GO_TO_GITHUB_ISSUE_COMMAND);
        c.insets = new Insets(5,10,10,10);
        c.gridwidth=1;
        c.fill = GridBagConstraints.NONE;
        c.weightx=0.1;
        c.weighty=0;
        c.gridx=0;
        c.gridy=1;
        c.anchor = GridBagConstraints.PAGE_END;
        jPanelMain.add(jButtonGoToGitHubIssue,c);

        jButtonAccept = new JButton("Accept");
        jButtonAccept.setActionCommand(J_BUTTON_ACCEPT_COMMAND);
        c.insets = new Insets(5,10,10,10);
        c.weightx=0.1;
        c.gridx=1;
        c.anchor = GridBagConstraints.PAGE_END;
        jPanelMain.add(jButtonAccept,c);
    }

    public void addController (Controller controller){
        jButtonGoToGitHubIssue.addActionListener(controller);
        jButtonAccept.addActionListener(controller);
    }

    public JPanel getjPanelMain() {
        return jPanelMain;
    }

    public void setjPanelMain(JPanel jPanelMain) {
        this.jPanelMain = jPanelMain;
    }

    public JLabel getjLabelMessage() {
        return jLabelMessage;
    }

    public void setjLabelMessage(JLabel jLabelMessage) {
        this.jLabelMessage = jLabelMessage;
    }

    public JButton getjButtonGoToGitHubIssue() {
        return jButtonGoToGitHubIssue;
    }

    public void setjButtonGoToGitHubIssue(JButton jButtonGoToGitHubIssue) {
        this.jButtonGoToGitHubIssue = jButtonGoToGitHubIssue;
    }

    public JButton getjButtonAccept() {
        return jButtonAccept;
    }

    public void setjButtonAccept(JButton jButtonAccept) {
        this.jButtonAccept = jButtonAccept;
    }
}
