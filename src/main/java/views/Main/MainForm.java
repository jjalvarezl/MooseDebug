package views.Main;

import abstracts.MVC.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MainForm {
    private JPanel jPanelMain;

    private JTabbedPane tabbedPane;

    private TabElements tabElementsTemplate;

    private Controller controller;

    //Array list of tabs
    private ArrayList<TabElements> tabbedPaneTabs;

    public MainForm() {
        //this.$$$setupUI$$$();
        try {
            initForm();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private void initForm() throws CloneNotSupportedException {
        jPanelMain = new JPanel();
        jPanelMain.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        tabbedPane = new JTabbedPane();
        tabbedPaneTabs = new ArrayList<>();
        TabElements tabElements1 = new TabElements();
        TabElements tabElements2 = new TabElements();
        TabElements tabElements3 = new TabElements();
        tabElements1.setTabId("Instancia 1");
        tabElements2.setTabId("Instancia 2");
        tabElements3.setTabId("Instancia 3");
        System.out.println(tabElements1.getTabId());
        System.out.println(tabElements2.getTabId());
        tabbedPane.addTab("Instancia 1", tabElements1.getMainPanel());
        tabbedPane.addTab("Instancia 2", tabElements2.getMainPanel());
        tabbedPane.addTab("Instancia 3", tabElements3.getMainPanel());
        tabbedPaneTabs.add(tabElements1);
        tabbedPaneTabs.add(tabElements2);
        tabbedPaneTabs.add(tabElements3);
        //tabbedPane.remove(1);
        tabbedPane.getSelectedIndex();

        jPanelMain.add(tabbedPane, constraints);
    }

    public JPanel getjPanelMain() {
        return jPanelMain;
    }

    public void setjPanelMain(JPanel jPanelMain) {
        this.jPanelMain = jPanelMain;
    }

    public void addController (Controller controller) {
        this.controller = controller;
        for (TabElements tabElements: tabbedPaneTabs){
            tabElements.addController(controller);
        }
    }

    public ArrayList<TabElements> getTabbedPaneTabs() {
        return tabbedPaneTabs;
    }

    public void setTabbedPaneTabs(ArrayList<TabElements> tabbedPaneTabs) {
        this.tabbedPaneTabs = tabbedPaneTabs;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        jPanelMain = new JPanel();
        jPanelMain.setLayout(new GridBagLayout());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return jPanelMain;
    }
}
