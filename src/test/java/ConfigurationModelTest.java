import org.junit.Assert;
import org.junit.Test;
import utils.Language;
import views.LanguageChooser.LanguageChooserForm;
import views.LanguageChooser.LanguageChooserView;

public class ConfigurationModelTest extends Assert {

    @Test
    public void test1(){
        Language.setResource(LanguageChooserForm.class.getName());
        Language.setLanguage("en", "US");
        System.out.println(Language.getResource().getString("FormTitle"));
        assertTrue(Language.getResource().getString("FormTitle").equals("Language"));
    }
}
