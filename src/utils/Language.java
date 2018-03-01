package utils;

import models.ConfigurationModel;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Singleton class used in every form
 */

public class Language {

    private static final Language INSTANCE = new Language();
    private static Locale locale;
    private ResourceBundle rb;

    private Language () {
        // Restoring language configuration
        String idiom = ConfigurationModel.getInstance().getString(ConfigurationModel.IDIOM);
        String country = ConfigurationModel.getInstance().getString(ConfigurationModel.COUNTRY);
        setLanguage(idiom,country);
    }

    /**
     * Language resources must be divided by each jswing form.
     * We standardized this calling the resource with the same class name of the form
     * To access a language resource just pass the class name of the form
     * or create a new one as same as the new form that you want to create
     *
     * @param guiClassName
     */
    public static void setResource (String guiClassName) {
        if (locale == null){
            locale = Locale.getDefault();
        }
        Language.getInstance().rb = ResourceBundle.getBundle(guiClassName, locale);
    }

    public static ResourceBundle getResource () {
        return Language.getInstance().rb;
    }

    public static Language getInstance() {
        return INSTANCE;
    }

    public static boolean setLanguage (String idiom, String country){
        boolean isLocaleSaved = !(idiom.equals(ConfigurationModel.NOT_FOUNDED_STRING) || country.equals(ConfigurationModel.NOT_FOUNDED_STRING));
        locale = isLocaleSaved ? new Locale(idiom, country) : Locale.getDefault();

        // Saving configuration.
        ConfigurationModel.getInstance().putString(ConfigurationModel.IDIOM, idiom);
        ConfigurationModel.getInstance().putString(ConfigurationModel.COUNTRY, country);
        System.out.println("Observers: "+ConfigurationModel.getInstance().countObservers());
        if (ConfigurationModel.getInstance().countObservers()>0) {
            ConfigurationModel.getInstance().notifyObservers("Cambié!!");
        }

        return isLocaleSaved;
    }
}
