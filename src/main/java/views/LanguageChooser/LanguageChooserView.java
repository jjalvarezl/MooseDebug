package views.LanguageChooser;

import abstracts.MVC.Controller;
import abstracts.MVC.View;
import utils.Language;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;

public class LanguageChooserView extends View {
    // Singleton
    private static final LanguageChooserView INSTANCE = new LanguageChooserView();

    private JDialog languageChooserJDialog;
    private LanguageChooserForm languageChooserForm;
    private ResourceBundle rb;
    private HashMap<Integer, String[]> languagesCountriesMap;

    private LanguageChooserView (){
        super();
        languageChooserJDialog = new JDialog();
        languageChooserForm = new LanguageChooserForm();

        //Content initialization
        initFormContent();

        //Form display.
        languageChooserJDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        languageChooserJDialog.pack();
        languageChooserJDialog.setLocationRelativeTo(null);
        languageChooserJDialog.setVisible(false);
    }

    @Override
    public void addController(Controller controller) {
        languageChooserForm.addController(controller);

    }

    private void initFormContent(){
        Language.setResource(LanguageChooserForm.class.getName());
        rb = Language.getResource();

        languageChooserJDialog.setTitle(rb.getString("FormTitle"));
        languagesCountriesMap= new HashMap<>();
        languagesCountriesMap.put(0, new String[]{"en", "US"});
        languagesCountriesMap.put(1, new String[]{"es", "CO"});
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("English (en_US)");
        model.addElement("Español (es_CO)");
        languageChooserForm.getJListLanguages().setModel(model);

        /*model.addElement("English (en_US)");
        model.addElement("Español (es_CO)");*/
        languageChooserForm.getJButtonAccept().setText(rb.getString("jButtonAccept"));
        languageChooserForm.getJButtonCancel().setText(rb.getString("jButtonCancel"));
        languageChooserJDialog.setContentPane(languageChooserForm.getJPanelMain());

        //Setting icon to jframe
        try {
            Image img = ImageIO.read(getClass().getResourceAsStream("../../images/icon"));
            languageChooserJDialog.setIconImage(img);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Observer update function
     *
     * @param observable that fired this fucntion
     * @param o is an object value
     */
    @Override
    public void update(Observable observable, Object o) {
        System.out.println("Update from LanguageChooserView");
        initFormContent();
    }

    /**
     * Singleton.
     *
     * @return this
     */
    public static LanguageChooserView getInstance() {
        return INSTANCE;
    }

    // Getters and setters

    public JDialog getLanguageChooserJDialog() {
        return languageChooserJDialog;
    }

    public void setLanguageChooserJDialog(JDialog languageChooserJDialog) {
        this.languageChooserJDialog = languageChooserJDialog;
    }

    public LanguageChooserForm getLanguageChooserForm() {
        return languageChooserForm;
    }

    public void setLanguageChooserForm(LanguageChooserForm languageChooserForm) {
        this.languageChooserForm = languageChooserForm;
    }

    public HashMap<Integer, String[]> getLanguagesCountriesMap() {
        return languagesCountriesMap;
    }

    public void setLanguagesCountriesMap(HashMap<Integer, String[]> languagesCountriesMap) {
        this.languagesCountriesMap = languagesCountriesMap;
    }
}
