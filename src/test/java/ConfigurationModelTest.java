import org.junit.Assert;
import org.junit.Test;
import views.LanguageChooser.LanguageChooserView;

public class ConfigurationModelTest extends Assert {

    @Test
    public void test1(){
        assertEquals(LanguageChooserView.getInstance(),LanguageChooserView.getInstance());
    }
}
