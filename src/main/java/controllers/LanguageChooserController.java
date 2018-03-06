package controllers;


import abstracts.MVC.Controller;
import utils.Language;
import views.LanguageChooser.LanguageChooserForm;
import views.LanguageChooser.LanguageChooserView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LanguageChooserController extends Controller {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()){

            case LanguageChooserForm.J_BUTTON_CANCEL_COMMAND:
                LanguageChooserView.getInstance().getLanguageChooserJDialog().setVisible(false);
                break;

            case LanguageChooserForm.J_BUTTON_ACCEPT_COMMAND:

                Integer index = LanguageChooserView.getInstance().getLanguageChooserForm().getJListLanguages().getSelectedIndex();
                if (index != -1) {
                    String [] newLocale = LanguageChooserView.getInstance().getLanguagesCountriesMap().get(index);
                    System.out.println(newLocale[0]+newLocale[1]);
                    if (Language.setLanguage(newLocale[0], newLocale[1])){
                        Language.setResource(LanguageChooserForm.class.getName());
                        //LanguageChooserView.getInstance().getLanguageChooserJDialog().setVisible(false);
                        JOptionPane.showMessageDialog(
                                null,
                                Language.getResource().getString("JListLanguageSelectionLanguageSelectedMessage"),
                                Language.getResource().getString("JListLanguageSelectionLanguageSelectedTitle"),
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    } else {
                        JOptionPane.showMessageDialog(
                                null,
                                Language.getResource().getString("JListLanguageSelectionErrorNoLanguageSupportedMessage"),
                                Language.getResource().getString("JListLanguageSelectionErrorNoLanguageSupportedTitle"),
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            Language.getResource().getString("JListLanguageSelectionErrorNoLanguageSelectedMessage"),
                            Language.getResource().getString("JListLanguageSelectionErrorNoLanguageSelectedTitle"),
                            JOptionPane.ERROR_MESSAGE
                    );
                }
                break;
        }
    }


}
