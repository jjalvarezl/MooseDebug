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
                    if (Language.getInstance().setLanguage(newLocale[0], newLocale[1])){
                        //LanguageChooserView.getInstance().getLanguageChooserJDialog().setVisible(false);
                        JOptionPane.showMessageDialog(
                                null,
                                Language.getInstance().getResource().getString("JListLanguageSelectionLanguageSelectedMessage"),
                                Language.getInstance().getResource().getString("JListLanguageSelectionLanguageSelectedTitle"),
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    } else {
                        JOptionPane.showMessageDialog(
                                null,
                                Language.getInstance().getResource().getString("JListLanguageSelectionErrorNoLanguageSupportedMessage"),
                                Language.getInstance().getResource().getString("JListLanguageSelectionErrorNoLanguageSupportedTitle"),
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            Language.getInstance().getResource().getString("JListLanguageSelectionErrorNoLanguageSelectedMessage"),
                            Language.getInstance().getResource().getString("JListLanguageSelectionErrorNoLanguageSelectedTitle"),
                            JOptionPane.ERROR_MESSAGE
                    );
                }
                break;
        }
    }


}
