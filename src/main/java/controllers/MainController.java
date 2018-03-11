package controllers;

import abstracts.MVC.Controller;
import models.MooseRunnerModel;
import views.About.AboutView;
import views.LanguageChooser.LanguageChooserView;
import views.Main.MainView;
import views.Main.TabElements;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.awt.datatransfer.*;
import java.awt.Toolkit;


public class MainController extends Controller {

    @Override
    public void windowClosing (WindowEvent event){
        MainView.getInstance().saveConfiguration();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println(actionEvent.getActionCommand());
        String stringToCopy;
        int i;
        Clipboard clipboard;
        switch (actionEvent.getActionCommand()){
            case MainView.J_MENU_ITEM_LANGUAGE_COMMAND:
                LanguageChooserView.getInstance().getLanguageChooserJDialog().setVisible(true);
                break;
            case MainView.J_MENU_ITEM_EXIT_COMMAND:
                System.exit(0);
                break;
            case MainView.J_MENU_ITEM_MOOSE_INSTANCE:
                String idTab = JOptionPane.showInputDialog("Please set the new tab's name");
                if (idTab!=null) {
                    System.out.println(idTab);
                    if (MainView.getInstance().getMainForm().isTabIdSettedAlready(idTab)) {
                        JOptionPane.showMessageDialog(
                                null,
                                "You have another tab called \"" + idTab + "\" too, please set another name",
                                "Error",
                                JOptionPane.ERROR_MESSAGE
                        );
                    } else {
                        MainView.getInstance().getMainForm().addTab(idTab);
                    }
                }
                break;
            case MainView.J_MENU_ITEM_ABOUT:
                AboutView.getInstance().getjDialogMain().setVisible(true);
                break;
            case MainView.J_MENU_ITEM_COPY_SUGGESTIONS_OUTPUT:
                i = MainView.getInstance().getMainForm().getTabbedPane().getSelectedIndex();
                stringToCopy = MainView.getInstance().getMainForm().getTabbedPaneTabs().get(i).getjTextAreaSuggestions().getText();
                clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(new StringSelection(stringToCopy), null);
                System.out.println("Suggestions output copied to clipboard: "+stringToCopy);
                break;
            case MainView.J_MENU_ITEM_COPY_MOOSE_OUTPUT:
                i = MainView.getInstance().getMainForm().getTabbedPane().getSelectedIndex();
                stringToCopy = MainView.getInstance().getMainForm().getTabbedPaneTabs().get(i).getjTextAreaMooseOutput().getText();
                clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(new StringSelection(stringToCopy), null);
                System.out.println("Moose output copied to clipboard: "+stringToCopy);
                break;
            default:
                JFileChooser fc = new JFileChooser();
                for (int j = 0; j<MainView.getInstance().getMainForm().getTabbedPaneTabs().size(); j++){
                    TabElements tabElements = MainView.getInstance().getMainForm().getTabbedPaneTabs().get(j);
                    if (tabElements.pressedButtonIsHere(actionEvent.getSource())){
                        switch (actionEvent.getActionCommand()){
                            case TabElements.J_BUTTON_DELETE_COMMAND:
                                System.out.println("ENTRA ELIMINAR!!!");
                                int reply = JOptionPane.showConfirmDialog(null, "Are you sure to delete this tab?", "Question", JOptionPane.YES_NO_OPTION);
                                if (reply == JOptionPane.YES_OPTION) {
                                    i = MainView.getInstance().getMainForm().getTabbedPaneTabs().indexOf(tabElements);
                                    MainView.getInstance().getMainForm().getTabbedPane().remove(i);
                                    MainView.getInstance().getMainForm().getTabbedPaneTabs().remove(tabElements);
                                    if (MainView.getInstance().getMainForm().getTabbedPaneTabs().size()==0){
                                        MainView.getInstance().configureDefaultTab();
                                    }
                                }
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
