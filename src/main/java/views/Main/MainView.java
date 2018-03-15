package views.Main;

import abstracts.MVC.Controller;
import abstracts.MVC.Model;
import abstracts.MVC.View;
import models.ConfigurationModel;
import utils.DataRetrieving;
import utils.Language;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

public class MainView extends View {
    // Singleton
    private static final MainView INSTANCE = new MainView();

    //Components
    private JFrame jMainFrame;

    private MainForm mainForm;

    //Menu buttons declarations
    private JMenuItem jMenuItemLanguage;
    private JMenuItem jMenuItemExit;
    private JMenuItem jMenuItemMooseInstance;
    private JMenuItem jMenuItemAbout;
    private JMenuItem jMenuItemCopyMooseOutput;
    private JMenuItem jMenuItemCopySuggestionsOutput;

    //Menu container declarations
    JMenuBar jMenuBarMainForm;
    JMenu jMenuFile;
    JMenu jMenuNew;
    JMenu jMenuEdit;
    JMenu jMenuCopy;
    JMenu jMenuPreferences;
    JMenu jMenuHelp;

    //Action commands
    public static final String J_MENU_ITEM_LANGUAGE_COMMAND = "mainView.jMenuItemLanguage";
    public static final String J_MENU_ITEM_EXIT_COMMAND = "mainView.jMenuItemExit";
    public static final String J_MENU_ITEM_MOOSE_INSTANCE = "mainView.jMenuItemMooseInstance";
    public static final String J_MENU_ITEM_ABOUT = "mainView.jMenuItemAbout";
    public static final String J_MENU_ITEM_COPY_MOOSE_OUTPUT = "mainView.jMenuItemCopyMooseOutput";
    public static final String J_MENU_ITEM_COPY_SUGGESTIONS_OUTPUT = "mainView.jMenuItemCopySuggestionsOutput";

    public MainView () {
        super();
        jMainFrame = new JFrame();
        mainForm = new MainForm();
        jMainFrame.setContentPane(mainForm.getjPanelMain());
        jMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFormContent();
        jMainFrame.setMinimumSize(new Dimension(600,400));
        jMainFrame.setLocationRelativeTo(null);

        //Setting icon to jframe
        try {
            Image img = ImageIO.read(getClass().getResourceAsStream("icon"));
            jMainFrame.setIconImage(img);
        } catch (IOException e) {
            e.printStackTrace();
        }

        restoreConfiguration ();
    }

    private void addMenuToMainForm (){

        //Making the bar
        jMenuBarMainForm = new JMenuBar();
        jMenuFile = new JMenu();
        jMenuNew = new JMenu();
        jMenuItemMooseInstance = new JMenuItem();
        jMenuItemMooseInstance.setActionCommand(J_MENU_ITEM_MOOSE_INSTANCE);
        jMenuItemExit = new JMenuItem();
        jMenuItemExit.setActionCommand(J_MENU_ITEM_EXIT_COMMAND);
        jMenuEdit = new JMenu();
        jMenuCopy = new JMenu();
        jMenuItemCopyMooseOutput = new JMenuItem();
        jMenuItemCopyMooseOutput.setActionCommand(J_MENU_ITEM_COPY_MOOSE_OUTPUT);
        jMenuItemCopySuggestionsOutput = new JMenuItem();
        jMenuItemCopySuggestionsOutput.setActionCommand(J_MENU_ITEM_COPY_SUGGESTIONS_OUTPUT);
        jMenuPreferences = new JMenu();
        jMenuItemLanguage = new JMenuItem();
        jMenuItemLanguage.setActionCommand(J_MENU_ITEM_LANGUAGE_COMMAND);
        jMenuHelp = new JMenu();
        jMenuItemAbout = new JMenuItem();
        jMenuItemAbout.setActionCommand(J_MENU_ITEM_ABOUT);

        setTextToView();

        //Adding elements to mainFormJMenuBar
        jMenuHelp.add(jMenuItemAbout);
        jMenuEdit.add(jMenuCopy);
        jMenuCopy.add(jMenuItemCopyMooseOutput);
        jMenuCopy.add(jMenuItemCopySuggestionsOutput);
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

    private void setTextToView(){
        Language.setResource(MainForm.class.getName());
        jMainFrame.setTitle(Language.getResource().getString("FormTitle"));
        jMenuFile.setText(Language.getResource().getString("jMenuFile"));
        jMenuFile.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuFileMnemotecnic")).getKeyCode());
        jMenuNew.setText(Language.getResource().getString("jMenuNew"));
        jMenuNew.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuNewMnemotecnic")).getKeyCode());
        jMenuItemMooseInstance.setText(Language.getResource().getString("jMenuItemMooseInstance"));
        jMenuItemMooseInstance.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuItemMooseInstanceMnemotecnic")).getKeyCode());
        jMenuItemExit.setText(Language.getResource().getString("jMenuItemExit"));
        jMenuItemExit.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuItemExitMnemotecnic")).getKeyCode());
        jMenuEdit.setText(Language.getResource().getString("jMenuEdit"));
        jMenuEdit.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuEditMnemotecnic")).getKeyCode());
        jMenuCopy.setText(Language.getResource().getString("jMenuCopy"));
        jMenuCopy.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuCopyMnemotecnic")).getKeyCode());
        jMenuItemCopyMooseOutput.setText(Language.getResource().getString("jMenuItemCopyMooseOutput"));
        jMenuItemCopyMooseOutput.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuItemCopyMooseOutputMnemotecnic")).getKeyCode());
        jMenuItemCopySuggestionsOutput.setText(Language.getResource().getString("jMenuItemCopySuggestionsOutput"));
        jMenuItemCopySuggestionsOutput.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuItemCopySuggestionsOutputMnemotecnic")).getKeyCode());
        jMenuPreferences.setText(Language.getResource().getString("jMenuPreferences"));
        jMenuPreferences.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuPreferencesMnemotecnic")).getKeyCode());
        jMenuItemLanguage.setText(Language.getResource().getString("jMenuItemLanguage"));
        jMenuItemLanguage.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuItemLanguageMnemotecnic")).getKeyCode());
        jMenuHelp.setText(Language.getResource().getString("jMenuHelp"));
        jMenuHelp.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuHelpMnemotecnic")).getKeyCode());
        jMenuItemAbout.setText(Language.getResource().getString("jMenuItemAbout"));
        jMenuItemAbout.setMnemonic(KeyStroke.getKeyStroke(Language.getResource().getString("jMenuItemAboutMnemotecnic")).getKeyCode());
    }

    private void initFormContent() {
        addMenuToMainForm();
    }

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
            int index = getIndexByTabId(dataRetrieving.getTabId());
            mainForm.getTabbedPaneTabs().get(index).getjTextAreaSuggestions().append(
                    dataRetrieving.getMooseSuggestion()
            );
            mainForm.getTabbedPaneTabs().get(index).getjTextAreaMooseOutput().append(
                    dataRetrieving.getMooseOutput()
            );
        } else {
            System.out.println("Update from MainView");
            setTextToView();
        }
    }

    @Override
    public void addController(Controller controller) {
        // Setting controller to the JMenuItem objects.
        jMenuItemLanguage.addActionListener(controller);
        jMenuItemExit.addActionListener(controller);
        jMenuItemMooseInstance.addActionListener(controller);
        jMenuItemCopyMooseOutput.addActionListener(controller);
        jMenuItemCopySuggestionsOutput.addActionListener(controller);
        jMenuItemAbout.addActionListener(controller);

        // Setting controller to the jMainFrame object.
        jMainFrame.addWindowListener(controller);

        // Passing object to the mainForm object.
        mainForm.addController(controller);
    }

    public int getIndexByTabId(String tabId){
        for (TabElements te: mainForm.getTabbedPaneTabs()){
            if (te.getTabId().equals(tabId)){
                return mainForm.getTabbedPaneTabs().indexOf(te);
            }
        }
        return -1;
    }

    public void restoreConfiguration (){
        int numberOfTabs = ConfigurationModel.getInt("numberOfTabs");
        if (numberOfTabs>0){
            for (int i = 0; i < numberOfTabs; i++){
                mainForm.addTab(ConfigurationModel.getString("tab"+i+".tabId"));
                System.out.println(ConfigurationModel.getString("tab"+i+".tabId"));
                mainForm.getTabbedPaneTabs().get(i).getjTextFieldMooseExecutable().setText(ConfigurationModel.getString("tab"+i+".jTextFieldMooseExecutable"));
                System.out.println(ConfigurationModel.getString("tab"+i+".jTextFieldMooseExecutable"));
                mainForm.getTabbedPaneTabs().get(i).getjTextFieldMooseImage().setText(ConfigurationModel.getString("tab"+i+".jTextFieldMooseImage"));
                System.out.println(ConfigurationModel.getString("tab"+i+".jTextFieldMooseImage"));
            }
        } else {
            configureDefaultTab();
        }
        System.out.println("Configurations restored");
    }

    public void saveConfiguration (){
        int numberOfTabs = mainForm.getTabbedPaneTabs().size();
        ConfigurationModel.putInt("numberOfTabs", mainForm.getTabbedPaneTabs().size());
        for (int i = 0; i < numberOfTabs; i++){
            ConfigurationModel.putString("tab"+i+".tabId", mainForm.getTabbedPaneTabs().get(i).getTabId());
            System.out.println(ConfigurationModel.getString("tab"+i+".tabId"));
            ConfigurationModel.putString("tab"+i+".jTextFieldMooseExecutable", mainForm.getTabbedPaneTabs().get(i).getjTextFieldMooseExecutable().getText());
            System.out.println(ConfigurationModel.getString("tab"+i+".jTextFieldMooseExecutable"));
            ConfigurationModel.putString("tab"+i+".jTextFieldMooseImage", mainForm.getTabbedPaneTabs().get(i).getjTextFieldMooseImage().getText());
            System.out.println(ConfigurationModel.getString("tab"+i+".jTextFieldMooseImage"));
        }
        System.out.println("Configurations saved");
    }

    public void configureDefaultTab() {
        mainForm.addTab("Instance 1");
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
