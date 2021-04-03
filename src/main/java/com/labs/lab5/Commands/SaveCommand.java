package com.labs.lab5.Commands;

import com.labs.lab5.App.Main;
import com.labs.lab5.AppUtils.ConsoleManager;
import com.labs.lab5.AppUtils.Repository;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static com.labs.lab5.AppUtils.RepositoryBuilder.disableWarning;


/**
 * Save repository to XML file (File name is in environment variable)
 */
public class SaveCommand extends AbstractCommand{

    private Repository repository;

    public SaveCommand(Repository repository) {
        super("save", "save repository to XML");
        this.repository = repository;
    }

    @Override
    public boolean execute(Object o) {
        disableWarning();
        XStream xstream = new XStream(new StaxDriver());
        String strXml = xstream.toXML(repository);

        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                new BufferedOutputStream(
                        new FileOutputStream(Main.getFileName(), true)))) {

            outputStreamWriter.write(strXml);

        } catch (IOException e) {
            ConsoleManager.replyUser("XML file writing failed.");
            return false;
        }

        return true;
    }
}
