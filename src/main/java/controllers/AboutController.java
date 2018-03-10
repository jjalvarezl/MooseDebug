package controllers;

import abstracts.MVC.Controller;
import views.About.AboutForm;

import java.awt.event.ActionEvent;

public class AboutController extends Controller {
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case AboutForm.J_BUTTON_ACCEPT_COMMAND:
                break;
            case AboutForm.J_BUTTON_GO_TO_GITHUB_ISSUE_COMMAND:
                break;
        }
    }
}
