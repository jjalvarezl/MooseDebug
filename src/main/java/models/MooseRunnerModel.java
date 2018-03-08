package models;

import abstracts.MVC.Model;
import utils.DataRetrieving;
import utils.Language;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MooseRunnerModel extends Model implements Runnable{

    String[] commands;

    public MooseRunnerModel (String mooseExecPath, String mooseImagePath){
        super();
        commands = new String[]{mooseExecPath, mooseImagePath};
    }

    private void suggestionConstructor (String mooseOutput){
        String suggestions = dataRetrieving.getMooseSuggestion();
        suggestions += (mooseOutput.startsWith("pthread_setschedparam failed")) ? Language.getResource().getString("pthreadSetschedparamFailed"):"";
        dataRetrieving.appendMooseSuggestion(suggestions);
    }

    @Override
    public void run() {
        Runtime rt = Runtime.getRuntime();
        Process proc;
        try {
            proc = rt.exec(commands);
            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(proc.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(proc.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            String s;
            dataRetrieving.appendMooseOutput("***Standard Output***\n\n");
            boolean flag = true;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                suggestionConstructor(s);
                dataRetrieving.setMooseOutput(s+"\n");
                flag = false;
            }
            if (flag)
                { dataRetrieving.appendMooseOutput("No output retrieved"); }
            else
                { flag = true; }

            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            dataRetrieving.appendMooseOutput("\n\n***Standard Error***\n\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
                suggestionConstructor(s);
                dataRetrieving.setMooseOutput(s+"\n");
                flag = false;
            }
            if (flag)
                { dataRetrieving.appendMooseOutput("No error retrieved"); }
            setChanged();
            notifyObservers();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
