package models;

import abstracts.MVC.Model;
import utils.DataRetrieving;
import utils.Language;
import views.Main.MainForm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MooseRunnerModel extends Model implements Runnable{

    String[] commands;

    public MooseRunnerModel (String tabId, String mooseExecPath, String mooseImagePath){
        super();
        dataRetrieving.setTabId(tabId);
        commands = new String[]{mooseExecPath, mooseImagePath};
    }

    private void suggestionConstructor (String mooseOutput){
        String suggestions = dataRetrieving.getMooseSuggestion();
        Language.setResource(MainForm.class.getName());
        suggestions += (mooseOutput.startsWith("pthread_setschedparam failed")) ? Language.getResource().getString("pthreadSetschedparamFailed")+"\n\n":"";
        suggestions += (mooseOutput.startsWith("Error. Could not determine platform's libc path for VM.")) ? Language.getResource().getString("libcMissed")+"\n\n":"";
        suggestions += (mooseOutput.startsWith("could not find display driver vm-display-X11")) ? Language.getResource().getString("vmDisplayX11DisplayDriverMissed")+"\n\n" : "";
        System.out.println("SUGGESTIONS: "+suggestions);
        System.out.println("LINE READED: "+mooseOutput);
        dataRetrieving.setMooseSuggestion(suggestions);
        if (mooseOutput.contains("check that")){
            System.out.print("ENTRA!!!!");
            StringTokenizer st = new StringTokenizer(mooseOutput, " ");
            String myPath="";
            int counter=0;
            while (st.hasMoreElements()) {
                String current = ((String) st.nextElement());
                counter++;
                if (counter == 4){
                    myPath = current;
                }
            }
            System.out.println ("myPath: "+myPath);
            processCommand(new String[]{"ldd", myPath});
        }
    }

    @Override
    public void run() {
        processCommand(commands);
        setChanged();
        notifyObservers();
    }

    private void processCommand (String[] commands){
        System.out.println("Comando: "+commands[0]+" "+commands[1]);
        String[] stdErrorOutputs = executeCommand(commands);
        if (commands[0].equals("ldd")){
            System.out.println("LDD output: "+stdErrorOutputs[0]);
            dataRetrieving.appendMooseSuggestion(stdErrorOutputs[0]);
        } else {
            //Processing standard output
            dataRetrieving.appendMooseOutput("***Standard Output***\n\n");
            boolean flagStandardOutput = true;
            StringTokenizer st = new StringTokenizer(stdErrorOutputs[0], "\n");
            while (st.hasMoreElements()) {
                suggestionConstructor((String) st.nextElement());
                flagStandardOutput = false;
            }
            if (flagStandardOutput) { dataRetrieving.appendMooseOutput("No output retrieved"); }
            else { dataRetrieving.appendMooseOutput(stdErrorOutputs[0]); }

            //Processing error output
            boolean flagErrorOutput = true;
            dataRetrieving.appendMooseOutput("\n\n***Standard Error***\n\n");
            st = new StringTokenizer(stdErrorOutputs[1], "\n");
            while (st.hasMoreElements()) {
                suggestionConstructor((String) st.nextElement());
                flagErrorOutput = false;
            }
            if (flagErrorOutput) { dataRetrieving.appendMooseOutput("No output retrieved"); }
            else { dataRetrieving.appendMooseOutput(stdErrorOutputs[1]); }

            if (flagErrorOutput && flagStandardOutput){
                dataRetrieving.appendMooseSuggestion("Everything worked fine :).");
            }
        }

        System.out.println("Moose Output: "+dataRetrieving.getMooseOutput());
        System.out.println("Moose Suggestion: "+dataRetrieving.getMooseSuggestion());
    }

    private String[] executeCommand (String[] commands){
        Runtime rt = Runtime.getRuntime();
        Process proc;
        String[] stdErrorOutputs = new String[2];

        try {
            proc = rt.exec(commands);
            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(proc.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(proc.getErrorStream()));

            String s;
            stdErrorOutputs[0] = "";
            stdErrorOutputs[1] = "";
            while ((s = stdInput.readLine()) != null) {
                stdErrorOutputs[0] += s+"\n";
            }

            while ((s = stdError.readLine()) != null) {
                stdErrorOutputs[1] += s+"\n";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("executeCommand Outputs INIT:\n\n--"+stdErrorOutputs[0]+"\n\n"+stdErrorOutputs[1]+"--executeCommand Outputs ENDING");
        return stdErrorOutputs;
    }
}
