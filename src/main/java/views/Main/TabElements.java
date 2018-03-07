package views.Main;

import abstracts.MVC.Controller;

import javax.swing.*;
import java.awt.*;

public class TabElements {
    private String tabId;

    //All jswing components of a single tab
    private JPanel mainPanel;
    private JTextArea jTextAreaMooseOutput;
    private JScrollPane jScrollPaneLeftSide;
    private JPanel jPanelRightSide;
    private JLabel jLabelMooseExecutable;
    private JTextField jTextFieldMooseExecutable;
    private JButton jButtonSearchMooseExecutable;
    private JLabel jLabelMooseImage;
    private JTextField jTextFieldMooseImage;
    private JButton jButtonSearchMooseImage;
    private JTextArea jTextAreaSuggestions;
    private JScrollPane jScrollPaneJLabelSuggestions;
    private JButton jButtonRunStop;
    private JButton jButtonDelete;
    private JSplitPane jSplitPane;

    //All action commands
    public static final String J_BUTTON_SEARCH_MOOSE_EXECUTABLE_COMMAND= "jButtonSearchMooseExecutable";
    public static final String J_BUTTON_SEARCH_MOOSE_IMAGE_COMMAND= "jButtonSearchMooseImage";
    public static final String J_BUTTON_RUN_STOP_COMMAND= "jButtonRunStop";
    public static final String J_BUTTON_DELETE_COMMAND= "jButtonDelete";

    public TabElements () {
        setMainPanel(new JPanel());
        getMainPanel().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;

        //Left side of the board
        setjTextAreaMooseOutput(new JTextArea());
        getjTextAreaMooseOutput().setEditable(false);
        getjTextAreaMooseOutput().setLineWrap(true);
        getjTextAreaMooseOutput().setWrapStyleWord(true);
        setjScrollPaneLeftSide(new JScrollPane(getjTextAreaMooseOutput()));
        getjScrollPaneLeftSide().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //Right side of the board
        setjPanelRightSide(new JPanel());
        getjPanelRightSide().setLayout(new GridBagLayout());

        constraints.gridy = 0;//First row

        setjLabelMooseExecutable(new JLabel());
        getjLabelMooseExecutable().setText("Executable path");
        constraints.weightx=1.0;
        constraints.gridx = 0;
        getjPanelRightSide().add(getjLabelMooseExecutable(), constraints);

        setjTextFieldMooseExecutable(new JTextField());
        constraints.gridx = 1;
        getjPanelRightSide().add(getjTextFieldMooseExecutable(), constraints);

        setjButtonSearchMooseExecutable(new JButton("Buscar"));
        constraints.gridx = 2;
        getjPanelRightSide().add(getjButtonSearchMooseExecutable(), constraints);


        constraints.gridy = 1;//Second row

        setjLabelMooseImage(new JLabel());
        getjLabelMooseImage().setText("Image path");
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        getjPanelRightSide().add(getjLabelMooseImage(), constraints);

        setjTextFieldMooseImage(new JTextField());
        constraints.gridx = 1;
        getjPanelRightSide().add(getjTextFieldMooseImage(), constraints);

        setjButtonSearchMooseImage(new JButton("Buscar"));
        constraints.gridx = 2;
        getjPanelRightSide().add(getjButtonSearchMooseImage(), constraints);


        constraints.gridy = 2;//Third row

        constraints.weightx=1.0;
        constraints.weighty=1.0;
        setjTextAreaSuggestions(new JTextArea());
        getjTextAreaSuggestions().setEditable(false);
        setjScrollPaneJLabelSuggestions(new JScrollPane(getjTextAreaSuggestions()));
        constraints.weightx  = 0.0;
        constraints.gridx = 0;
        constraints.gridwidth=3;//# of columns to fill
        constraints.ipady = 200;
        getjPanelRightSide().add(getjScrollPaneJLabelSuggestions(),constraints);

        constraints.gridy = 3;//Fourth row

        setjButtonRunStop(new JButton("Run - Stop"));
        constraints.ipady = 0;
        constraints.gridx= 1;
        constraints.gridwidth=-3;
        constraints.weightx  = 0.5;
        constraints.weighty=0.0;
        getjPanelRightSide().add(getjButtonRunStop(),constraints);

        setjButtonDelete(new JButton("Delete"));
        constraints.ipady = 0;
        constraints.gridx= 2;
        getjPanelRightSide().add(getjButtonDelete(),constraints);


        //Grouping all components
        setjSplitPane(new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                getjScrollPaneLeftSide(),
                getjPanelRightSide()
        ));
        getjSplitPane().setDividerLocation(300);
        constraints.weightx=1.0;
        constraints.weighty=1.0;

        //Add JSplitPane to final mainPanel
        getMainPanel().add(getjSplitPane(),constraints);

        //Setting action command for each button
        jButtonDelete.setActionCommand(J_BUTTON_DELETE_COMMAND);
        jButtonRunStop.setActionCommand(J_BUTTON_RUN_STOP_COMMAND);
        jButtonSearchMooseExecutable.setActionCommand(J_BUTTON_SEARCH_MOOSE_EXECUTABLE_COMMAND);
        jButtonSearchMooseImage.setActionCommand(J_BUTTON_SEARCH_MOOSE_IMAGE_COMMAND);
    }

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JTextArea getjTextAreaMooseOutput() {
        return jTextAreaMooseOutput;
    }

    public void setjTextAreaMooseOutput(JTextArea jTextAreaMooseOutput) {
        this.jTextAreaMooseOutput = jTextAreaMooseOutput;
    }

    public JScrollPane getjScrollPaneLeftSide() {
        return jScrollPaneLeftSide;
    }

    public void setjScrollPaneLeftSide(JScrollPane jScrollPaneLeftSide) {
        this.jScrollPaneLeftSide = jScrollPaneLeftSide;
    }

    public JPanel getjPanelRightSide() {
        return jPanelRightSide;
    }

    public void setjPanelRightSide(JPanel jPanelRightSide) {
        this.jPanelRightSide = jPanelRightSide;
    }

    public JLabel getjLabelMooseExecutable() {
        return jLabelMooseExecutable;
    }

    public void setjLabelMooseExecutable(JLabel jLabelMooseExecutable) {
        this.jLabelMooseExecutable = jLabelMooseExecutable;
    }

    public JTextField getjTextFieldMooseExecutable() {
        return jTextFieldMooseExecutable;
    }

    public void setjTextFieldMooseExecutable(JTextField jTextFieldMooseExecutable) {
        this.jTextFieldMooseExecutable = jTextFieldMooseExecutable;
    }

    public JButton getjButtonSearchMooseExecutable() {
        return jButtonSearchMooseExecutable;
    }

    public void setjButtonSearchMooseExecutable(JButton jButtonSearchMooseExecutable) {
        this.jButtonSearchMooseExecutable = jButtonSearchMooseExecutable;
    }

    public JLabel getjLabelMooseImage() {
        return jLabelMooseImage;
    }

    public void setjLabelMooseImage(JLabel jLabelMooseImage) {
        this.jLabelMooseImage = jLabelMooseImage;
    }

    public JTextField getjTextFieldMooseImage() {
        return jTextFieldMooseImage;
    }

    public void setjTextFieldMooseImage(JTextField jTextFieldMooseImage) {
        this.jTextFieldMooseImage = jTextFieldMooseImage;
    }

    public JButton getjButtonSearchMooseImage() {
        return jButtonSearchMooseImage;
    }

    public void setjButtonSearchMooseImage(JButton jButtonSearchMooseImage) {
        this.jButtonSearchMooseImage = jButtonSearchMooseImage;
    }

    public JTextArea getjTextAreaSuggestions() {
        return jTextAreaSuggestions;
    }

    public void setjTextAreaSuggestions(JTextArea jTextAreaSuggestions) {
        this.jTextAreaSuggestions = jTextAreaSuggestions;
    }

    public JScrollPane getjScrollPaneJLabelSuggestions() {
        return jScrollPaneJLabelSuggestions;
    }

    public void setjScrollPaneJLabelSuggestions(JScrollPane jScrollPaneJLabelSuggestions) {
        this.jScrollPaneJLabelSuggestions = jScrollPaneJLabelSuggestions;
    }

    public JButton getjButtonRunStop() {
        return jButtonRunStop;
    }

    public void setjButtonRunStop(JButton jButtonRunStop) {
        this.jButtonRunStop = jButtonRunStop;
    }

    public JButton getjButtonDelete() {
        return jButtonDelete;
    }

    public void setjButtonDelete(JButton jButtonDelete) {
        this.jButtonDelete = jButtonDelete;
    }

    public JSplitPane getjSplitPane() {
        return jSplitPane;
    }

    public void setjSplitPane(JSplitPane jSplitPane) {
        this.jSplitPane = jSplitPane;
    }

    public Boolean pressedButtonIsHere (Object object){
        return(
                jButtonSearchMooseImage.equals(object) ||
                jButtonRunStop.equals(object) ||
                jButtonSearchMooseExecutable.equals(object) ||
                jButtonDelete.equals(object)
        ) ? true:false;
    }

    public void addController (Controller controller){
        //Adding the controller to each button
        jButtonDelete.addActionListener(controller);
        jButtonRunStop.addActionListener(controller);
        jButtonSearchMooseExecutable.addActionListener(controller);
        jButtonSearchMooseImage.addActionListener(controller);
    }
}
