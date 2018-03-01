package views.LanguageChooser;

import abstracts.MVC.Controller;
import abstracts.MVC.Model;
import abstracts.MVC.View;
import models.ConfigurationModel;
import utils.Language;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.*;

public class LanguageChooserView extends View {
    // Singleton
    private static final LanguageChooserView INSTANCE = new LanguageChooserView();

    private JDialog languageChooserJDialog;
    private LanguageChooserForm languageChooserForm;
    private ResourceBundle rb;
    Map<Integer, String[]> languagesCountriesMap;

    private LanguageChooserView (){
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
        Language.getInstance().setResource(LanguageChooserForm.class.getSimpleName());
        rb = Language.getInstance().getResource();

        languageChooserJDialog.setTitle(rb.getString("FormTitle"));
        languagesCountriesMap= new HashMap<>();
        languagesCountriesMap.put(0, new String[]{"en", "US"});
        languagesCountriesMap.put(1, new String[]{"es", "CO"});
        Vector<String> languages = new Vector<>();
        languages.add("English (en_US)");
        languages.add("Español (es_CO)");
        languageChooserForm.getJListLanguages().setListData(languages);
        languageChooserForm.getJButtonAccept().setText(rb.getString("jButtonAccept"));
        languageChooserForm.getJButtonCancel().setText(rb.getString("jButtonCancel"));
        languageChooserJDialog.setContentPane(languageChooserForm.getJPanelMain());
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

    public Map<Integer, String[]> getLanguagesCountriesMap() {
        return languagesCountriesMap;
    }

    public void setLanguagesCountriesMap(Map<Integer, String[]> languagesCountriesMap) {
        this.languagesCountriesMap = languagesCountriesMap;
    }
}
