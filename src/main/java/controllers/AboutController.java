package controllers;

import abstracts.MVC.Controller;
import views.About.AboutForm;
import views.About.AboutView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;

public class AboutController extends Controller {
    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()){
            case AboutForm.J_BUTTON_ACCEPT_COMMAND:
                AboutView.getInstance().getjDialogMain().setVisible(false);
                break;
            case AboutForm.J_BUTTON_GO_TO_GITHUB_ISSUE_COMMAND:
                try {
                    URL url = new URL("https://github.com/jjalvarezl/MooseDebug/issues");
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                        desktop.browse(url.toURI());
                    }

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                break;
        }
    }
}
