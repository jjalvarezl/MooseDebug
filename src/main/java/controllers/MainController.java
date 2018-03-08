package controllers;

import abstracts.MVC.Controller;
import models.MooseRunnerModel;
import views.LanguageChooser.LanguageChooserView;
import views.Main.MainView;
import views.Main.TabElements;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;

public class MainController extends Controller {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println(actionEvent.getActionCommand());
        switch (actionEvent.getActionCommand()){
            case MainView.J_MENU_ITEM_LANGUAGE_COMMAND:
                LanguageChooserView.getInstance().getLanguageChooserJDialog().setVisible(true);
                break;
            default:
                JFileChooser fc = new JFileChooser();
                for (TabElements tabElements : MainView.getInstance().getMainForm().getTabbedPaneTabs()){
                    if (tabElements.pressedButtonIsHere(actionEvent.getSource())){
                        switch (actionEvent.getActionCommand()){
                            case TabElements.J_BUTTON_DELETE_COMMAND:
                                break;
                            case TabElements.J_BUTTON_RUN_STOP_COMMAND:
                                MooseRunnerModel mrm = new MooseRunnerModel(
                                        tabElements.getjTextFieldMooseExecutable().getText(),
                                        tabElements.getjTextFieldMooseImage().getText()
                                );
                                MainView.getInstance().addModel(mrm);
                                Thread thread = new Thread(mrm);
                                thread.start();
                                break;
                            case TabElements.J_BUTTON_SEARCH_MOOSE_EXECUTABLE_COMMAND:
                                fc.setCurrentDirectory(new File(System.getProperty("user.home")));
                                if (fc.showOpenDialog(MainView.getInstance().getjMainFrame()) == JFileChooser.APPROVE_OPTION){
                                    tabElements.getjTextFieldMooseExecutable().setText(fc.getSelectedFile().getAbsolutePath());
                                }
                                break;
                            case TabElements.J_BUTTON_SEARCH_MOOSE_IMAGE_COMMAND:
                                fc = new JFileChooser();
                                fc.setCurrentDirectory(new File(System.getProperty("user.home")));
                                fc.setFileFilter(new FileNameExtensionFilter("Moose Image", "image"));
                                fc.setAcceptAllFileFilterUsed(false);
                                if (fc.showOpenDialog(MainView.getInstance().getjMainFrame()) == JFileChooser.APPROVE_OPTION){
                                    tabElements.getjTextFieldMooseImage().setText(fc.getSelectedFile().getAbsolutePath());
                                }
                                /*JOptionPane.showMessageDialog(
                                        null,
                                        "Tab: "+MainView.getInstance().getMainForm().getTabbedPaneTabs().indexOf(tabElements),
                                        "Funciona",
                                        JOptionPane.INFORMATION_MESSAGE
                                );*/
                                break;
                        }
                    }
                }
                break;
        }
    }
}
