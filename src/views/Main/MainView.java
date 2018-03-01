package views.Main;

import abstracts.MVC.Controller;
import abstracts.MVC.Model;
import abstracts.MVC.View;
import models.ConfigurationModel;
import utils.Language;
import views.LanguageChooser.LanguageChooserView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Observable;

public class MainView extends View {
    private JFrame mooseDebugger;

    //Declarando los menus
    private JMenuItem languageJMenuItem;

    public MainView () {
        mooseDebugger = new JFrame(Language.getInstance().getResource().getString("FormTitle"));
        mooseDebugger.setContentPane(new MainForm().getjPanelMain());
        mooseDebugger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMenuToMainForm();
        configureEvents();
        mooseDebugger.pack();
        mooseDebugger.setLocationRelativeTo(null);
        mooseDebugger.setVisible(true);
    }

    private void addMenuToMainForm (){

        //Making the bar
        JMenuBar mainFormJMenuBar = new JMenuBar();
        JMenu fileJMenu = new JMenu(Language.getInstance().getResource().getString("fileJMenu"));
        fileJMenu.setMnemonic(KeyStroke.getKeyStroke(Language.getInstance().getResource().getString("fileJMenuMnemotecnic")).getKeyCode());
        JMenu newJMenuItem = new JMenu(Language.getInstance().getResource().getString("newJMenuItem"));
        newJMenuItem.setMnemonic(KeyStroke.getKeyStroke(Language.getInstance().getResource().getString("newJMenuItemMnemotecnic")).getKeyCode());
        JMenuItem mooseInstanceJMenuItem = new JMenuItem(Language.getInstance().getResource().getString("mooseInstanceJMenuItem"));
        mooseInstanceJMenuItem.setMnemonic(KeyStroke.getKeyStroke(Language.getInstance().getResource().getString("mooseInstanceJMenuItemMnemotecnic")).getKeyCode());
        JMenuItem exitMenuItem = new JMenuItem(Language.getInstance().getResource().getString("exitMenuItem"));
        exitMenuItem.setMnemonic(KeyStroke.getKeyStroke(Language.getInstance().getResource().getString("exitMenuItemMnemotecnic")).getKeyCode());
        JMenu editJMenu = new JMenu(Language.getInstance().getResource().getString("editJMenu"));
        editJMenu.setMnemonic(KeyStroke.getKeyStroke(Language.getInstance().getResource().getString("editJMenuMnemotecnic")).getKeyCode());
        JMenuItem copyOutputJMenuItem = new JMenuItem(Language.getInstance().getResource().getString("copyOutputJMenuItem"));
        copyOutputJMenuItem.setMnemonic(KeyStroke.getKeyStroke(Language.getInstance().getResource().getString("copyOutputJMenuItemMnemotecnic")).getKeyCode());
        JMenu preferencesJMenu = new JMenu(Language.getInstance().getResource().getString("preferencesJMenu"));
        preferencesJMenu.setMnemonic(KeyStroke.getKeyStroke(Language.getInstance().getResource().getString("preferencesJMenuMnemotecnic")).getKeyCode());
        languageJMenuItem = new JMenuItem(Language.getInstance().getResource().getString("languageJMenuItem"));
        languageJMenuItem.setMnemonic(KeyStroke.getKeyStroke(Language.getInstance().getResource().getString("languageJMenuItemMnemotecnic")).getKeyCode());
        JMenu helpJMenu = new JMenu(Language.getInstance().getResource().getString("helpJMenu"));
        helpJMenu.setMnemonic(KeyStroke.getKeyStroke(Language.getInstance().getResource().getString("helpJMenuMnemotecnic")).getKeyCode());
        JMenuItem aboutJMenuItem = new JMenuItem(Language.getInstance().getResource().getString("aboutJMenuItem"));
        aboutJMenuItem.setMnemonic(KeyStroke.getKeyStroke(Language.getInstance().getResource().getString("aboutJMenuItemMnemotecnic")).getKeyCode());

        //Adding elements to mainFormJMenuBar
        helpJMenu.add(aboutJMenuItem);
        editJMenu.add(copyOutputJMenuItem);
        preferencesJMenu.add(languageJMenuItem);
        editJMenu.add(preferencesJMenu);
        newJMenuItem.add(mooseInstanceJMenuItem);
        fileJMenu.add(newJMenuItem);
        fileJMenu.add(exitMenuItem);
        mainFormJMenuBar.add(fileJMenu);
        mainFormJMenuBar.add(editJMenu);
        mainFormJMenuBar.add(helpJMenu);

        //Adding mainFormJMenuBar to mainForm
        mooseDebugger.setJMenuBar(mainFormJMenuBar);
    }

    private void configureEvents() {

        // Programing what actions listeners will do

        //Action Menu -> Edit -> Preferences -> Language
        ActionListener languageJMenuItemActionListener = actionEvent -> {
            LanguageChooserView.getInstance().getLanguageChooserJDialog().setVisible(true);
        };

        // Set action listeners to their respective gui components
        languageJMenuItem.addActionListener(languageJMenuItemActionListener);
    }



    @Override
    public void update(Observable observable, Object o) {
        System.out.println("Update from MainView");
    }

    @Override
    public void addController(Controller controller) {

    }
}
