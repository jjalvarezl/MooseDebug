package controllers;

import abstracts.MVC.Controller;
import models.MooseRunnerModel;
import utils.Language;
import views.LanguageChooser.LanguageChooserView;
import views.Main.MainForm;
import views.Main.MainView;
import views.Main.TabElements;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class MainController extends Controller {

    @Override
    public void windowClosing (WindowEvent event){
        MainView.getInstance().saveConfiguration();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println(actionEvent.getActionCommand());
        switch (actionEvent.getActionCommand()){
            case MainView.J_MENU_ITEM_LANGUAGE_COMMAND:
                LanguageChooserView.getInstance().getLanguageChooserJDialog().setVisible(true);
                break;
            case MainView.J_MENU_ITEM_EXIT_COMMAND:
                System.exit(0);
                break;
            case MainView.J_MENU_ITEM_MOOSE_INSTANCE:
                // TODO: make new view to ask for the new instance name
                break;
            case MainView.J_MENU_ITEM_ABOUT:
                // TODO: make About's new view
                break;
            case MainView.J_MENU_ITEM_COPY_SUGGESTIONS_OUTPUT:
                // TODO: make suggestions information copied on clipboard
                break;
            case MainView.J_MENU_ITEM_COPY_MOOSE_OUTPUT:
                // TODO: make moose output information copied on clipboard
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
                                        tabElements.getTabId(),
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
                                break;
                        }
                    }
                }
                break;
        }
    }
}
