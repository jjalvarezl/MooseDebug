package views.Main;

import abstracts.MVC.Controller;
import abstracts.MVC.View;
import utils.Language;
import views.LanguageChooser.LanguageChooserView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;

public class MainView extends View {
    //Components
    private JFrame jMainFrame;
    private MainForm mainForm;

    //Menu buttons declarations
    private JMenuItem languageJMenuItem;

    //Action commands
    //public static final String

    public MainView () {
        jMainFrame = new JFrame();
        mainForm = new MainForm();
        jMainFrame.setContentPane(mainForm.getjPanelMain());
        jMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFormContent();
        jMainFrame.setMinimumSize(new Dimension(600,400));
        jMainFrame.setLocationRelativeTo(null);
        jMainFrame.setVisible(true);
    }

    private void addMenuToMainForm (){

        //Making the bar
        JMenuBar jMenuBarMainForm = new JMenuBar();
        JMenu jMenuFile = new JMenu(Language.getResource().getString("jMenuFile"));
        jMenuFile.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuFileMnemotecnic")).getKeyCode());
        JMenu newJMenuItem = new JMenu(Language.getResource().getString("newJMenuItem"));
        newJMenuItem.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("newJMenuItemMnemotecnic")).getKeyCode());
        JMenuItem mooseInstanceJMenuItem = new JMenuItem(Language.getResource().getString("mooseInstanceJMenuItem"));
        mooseInstanceJMenuItem.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("mooseInstanceJMenuItemMnemotecnic")).getKeyCode());
        JMenuItem exitMenuItem = new JMenuItem(Language.getResource().getString("exitMenuItem"));
        exitMenuItem.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("exitMenuItemMnemotecnic")).getKeyCode());
        JMenu editJMenu = new JMenu(Language.getResource().getString("editJMenu"));
        editJMenu.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("editJMenuMnemotecnic")).getKeyCode());
        JMenuItem copyOutputJMenuItem = new JMenuItem(Language.getResource().getString("copyOutputJMenuItem"));
        copyOutputJMenuItem.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("copyOutputJMenuItemMnemotecnic")).getKeyCode());
        JMenu preferencesJMenu = new JMenu(Language.getResource().getString("preferencesJMenu"));
        preferencesJMenu.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("preferencesJMenuMnemotecnic")).getKeyCode());
        languageJMenuItem = new JMenuItem(Language.getResource().getString("languageJMenuItem"));
        languageJMenuItem.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("languageJMenuItemMnemotecnic")).getKeyCode());
        //languageJMenuItem.setActionCommand();
        JMenu helpJMenu = new JMenu(Language.getResource().getString("helpJMenu"));
        helpJMenu.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("helpJMenuMnemotecnic")).getKeyCode());
        JMenuItem aboutJMenuItem = new JMenuItem(Language.getResource().getString("aboutJMenuItem"));
        aboutJMenuItem.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("aboutJMenuItemMnemotecnic")).getKeyCode());

        //Adding elements to mainFormJMenuBar
        helpJMenu.add(aboutJMenuItem);
        editJMenu.add(copyOutputJMenuItem);
        preferencesJMenu.add(languageJMenuItem);
        editJMenu.add(preferencesJMenu);
        newJMenuItem.add(mooseInstanceJMenuItem);
        jMenuFile.add(newJMenuItem);
        jMenuFile.add(exitMenuItem);
        jMenuBarMainForm.add(jMenuFile);
        jMenuBarMainForm.add(editJMenu);
        jMenuBarMainForm.add(helpJMenu);

        //Adding mainFormJMenuBar to mainForm
        jMainFrame.setJMenuBar(jMenuBarMainForm);
        jMainFrame.invalidate();
        jMainFrame.validate();
        jMainFrame.repaint();
    }

    private void initFormContent(){
        Language.setResource(MainForm.class.getName());
        jMainFrame.setTitle(Language.getResource().getString("FormTitle"));
        addMenuToMainForm();
        configureEvents();

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
        initFormContent();
    }

    @Override
    public void addController(Controller controller) {

    }
}
