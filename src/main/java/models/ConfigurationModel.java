package models;

import abstracts.MVC.Model;
import utils.DataRetrieving;

import java.util.prefs.Preferences;

/**
 * Singleton class used in every form
 */


public class ConfigurationModel extends Model {
    private static final ConfigurationModel INSTANCE = new ConfigurationModel();

    //General variables
    public static final String NOT_FOUNDED_STRING = "NotFounded";
    public static final Integer NOT_FOUNDED_INT = -1;

    //Language keys
    public static final String IDIOM = "Language.idiom";
    public static final String COUNTRY = "Language.country";


    private Preferences preferences;

    private ConfigurationModel() {
        super();
        setPreferences(Preferences.userNodeForPackage(ConfigurationModel.class));
        System.out.println("Node's absolute path: "+getPreferences().absolutePath());
    }

    @Override
    public DataRetrieving retrieveData() {
        return null;
    }

    public static ConfigurationModel getInstance() {
        return INSTANCE;
    }

    //Functions for saving configurations

    public static void putString (String key, String value){
        ConfigurationModel.getInstance().getPreferences().put(key, value);
        ConfigurationModel.getInstance().setChanged();
    }

    public static String getString (String key){
        return ConfigurationModel.getInstance().getPreferences().get(key, NOT_FOUNDED_STRING);
    }

    public static void putInt (String key, String value){
        ConfigurationModel.getInstance().getPreferences().put(key, value);
    }

    public static Integer getInt (String key){
        return ConfigurationModel.getInstance().getPreferences().getInt(key, NOT_FOUNDED_INT);
    }

    //Getters and setters
    private Preferences getPreferences() {
        return preferences;
    }

    private void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }
}
