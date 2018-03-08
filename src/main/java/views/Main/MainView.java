package views.Main;

import abstracts.MVC.Controller;
import abstracts.MVC.Model;
import abstracts.MVC.View;
import utils.DataRetrieving;
import utils.Language;
import views.LanguageChooser.LanguageChooserView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

public class MainView extends View {
    // Singleton
    private static final MainView INSTANCE = new MainView();

    //Components
    private JFrame jMainFrame;

    private MainForm mainForm;

    //Menu buttons declarations
    private JMenuItem jMenuItemLanguage;

    //Action commands
    public static final String J_MENU_ITEM_LANGUAGE_COMMAND = "jMenuItemLanguage";

    public MainView () {
        super();
        jMainFrame = new JFrame();
        mainForm = new MainForm();
        jMainFrame.setContentPane(mainForm.getjPanelMain());
        jMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFormContent();
        jMainFrame.setMinimumSize(new Dimension(600,400));
        jMainFrame.setLocationRelativeTo(null);
    }

    private void addMenuToMainForm (){

        //Making the bar
        JMenuBar jMenuBarMainForm = new JMenuBar();
        JMenu jMenuFile = new JMenu(Language.getResource().getString("jMenuFile"));
        jMenuFile.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuFileMnemotecnic")).getKeyCode());
        JMenu jMenuNew = new JMenu(Language.getResource().getString("jMenuNew"));
        jMenuNew.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuNewMnemotecnic")).getKeyCode());
        JMenuItem jMenuItemMooseInstance = new JMenuItem(Language.getResource().getString("jMenuItemMooseInstance"));
        jMenuItemMooseInstance.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuItemMooseInstanceMnemotecnic")).getKeyCode());
        JMenuItem jMenuItemExit = new JMenuItem(Language.getResource().getString("jMenuItemExit"));
        jMenuItemExit.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuItemExitMnemotecnic")).getKeyCode());
        JMenu jMenuEdit = new JMenu(Language.getResource().getString("jMenuEdit"));
        jMenuEdit.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuEditMnemotecnic")).getKeyCode());
        JMenuItem jMenuItemCopyOutput = new JMenuItem(Language.getResource().getString("jMenuItemCopyOutput"));
        jMenuItemCopyOutput.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuItemCopyOutputMnemotecnic")).getKeyCode());
        JMenu jMenuPreferences = new JMenu(Language.getResource().getString("jMenuPreferences"));
        jMenuPreferences.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuPreferencesMnemotecnic")).getKeyCode());
        jMenuItemLanguage = new JMenuItem(Language.getResource().getString("jMenuItemLanguage"));
        jMenuItemLanguage.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuItemLanguageMnemotecnic")).getKeyCode());
        jMenuItemLanguage.setActionCommand(J_MENU_ITEM_LANGUAGE_COMMAND);
        JMenu jMenuHelp = new JMenu(Language.getResource().getString("jMenuHelp"));
        jMenuHelp.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuHelpMnemotecnic")).getKeyCode());
        JMenuItem jMenuItemAbout = new JMenuItem(Language.getResource().getString("jMenuItemAbout"));
        jMenuItemAbout.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuItemAboutMnemotecnic")).getKeyCode());

        //Adding elements to mainFormJMenuBar
        jMenuHelp.add(jMenuItemAbout);
        jMenuEdit.add(jMenuItemCopyOutput);
        jMenuPreferences.add(jMenuItemLanguage);
        jMenuEdit.add(jMenuPreferences);
        jMenuNew.add(jMenuItemMooseInstance);
        jMenuFile.add(jMenuNew);
        jMenuFile.add(jMenuItemExit);
        jMenuBarMainForm.add(jMenuFile);
        jMenuBarMainForm.add(jMenuEdit);
        jMenuBarMainForm.add(jMenuHelp);

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
        //configureEvents();
    }

    /*private void configureEvents() {

        // Programing what actions listeners will do

        //Action Menu -> Edit -> Preferences -> Language
        ActionListener jMenuItemLanguageActionListener = actionEvent -> {
            LanguageChooserView.getInstance().getLanguageChooserJDialog().setVisible(true);
        };

        // Set action listeners to their respective gui components
        jMenuItemLanguage.addActionListener(jMenuItemLanguageActionListener);
    }*/

    /**
     * Singleton.
     *
     * @return this
     */
    public static MainView getInstance() {
        return INSTANCE;
    }

    @Override
    public void update(Observable observable, Object o) {
        Model model = models.get(models.indexOf(observable));
        DataRetrieving dataRetrieving = model.retrieveData();
        if (dataRetrieving != null){
            /*if (((String) o).startsWith("pthread_setschedparam failed")){
                Language.setResource(MainForm.class.getName());
                mainForm.getTabbedPaneTabs().get(0).getjTextAreaSuggestions().append(
                        Language.getResource().getString("pthreadSetschedparamFailed")
                );
            }
            models.indexOf(observable);*/
            mainForm.getTabbedPaneTabs().get(0).getjTextAreaSuggestions().append(
                    dataRetrieving.getMooseSuggestion()
            );
            mainForm.getTabbedPaneTabs().get(0).getjTextAreaMooseOutput().append(
                    dataRetrieving.getMooseOutput()
            );
        } else {
            System.out.println("Update from MainView");
            initFormContent();
        }
    }

    @Override
    public void addController(Controller controller) {
        jMenuItemLanguage.addActionListener(controller);
        mainForm.addController(controller);
    }

    public MainForm getMainForm() {
        return mainForm;
    }

    public void setMainForm(MainForm mainForm) {
        this.mainForm = mainForm;
    }

    public JFrame getjMainFrame() {
        return jMainFrame;
    }

    public void setjMainFrame(JFrame jMainFrame) {
        this.jMainFrame = jMainFrame;
    }
}
