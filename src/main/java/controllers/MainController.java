package controllers;

import abstracts.MVC.Controller;
import views.LanguageChooser.LanguageChooserView;
import views.Main.MainView;
import views.Main.TabElements;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainController extends Controller {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println(actionEvent.getActionCommand());
        switch (actionEvent.getActionCommand()){
            case MainView.J_MENU_ITEM_LANGUAGE_COMMAND:
                LanguageChooserView.getInstance().getLanguageChooserJDialog().setVisible(true);
                break;
            default:
                for (TabElements tabElements : MainView.getInstance().getMainForm().getTabbedPaneTabs()){
                    if (tabElements.pressedButtonIsHere(actionEvent.getSource())){
                        switch (actionEvent.getActionCommand()){
                            case TabElements.J_BUTTON_DELETE_COMMAND:
                                break;
                            case TabElements.J_BUTTON_RUN_STOP_COMMAND:
                                break;
                            case TabElements.J_BUTTON_SEARCH_MOOSE_EXECUTABLE_COMMAND:
                                break;
                            case TabElements.J_BUTTON_SEARCH_MOOSE_IMAGE_COMMAND:
                                JOptionPane.showMessageDialog(
                                        null,
                                        "Tab: "+MainView.getInstance().getMainForm().getTabbedPaneTabs().indexOf(tabElements),
                                        "Funciona",
                                        JOptionPane.INFORMATION_MESSAGE
                                );
                                break;
                        }
                    }
                }
                break;
        }
    }
}
