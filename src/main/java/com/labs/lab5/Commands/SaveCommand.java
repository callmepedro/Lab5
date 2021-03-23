package com.labs.lab5.Commands;

import com.labs.lab5.AppUtils.ConsoleManager;
import com.labs.lab5.AppUtils.Repository;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import sun.misc.Unsafe;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;

public class SaveCommand extends AbstractCommand{

    private Repository repository;

    private static void disableWarning() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Unsafe u = (Unsafe) theUnsafe.get(null);

            Class cls = Class.forName("jdk.internal.module.IllegalAccessLogger");
            Field logger = cls.getDeclaredField("logger");
            u.putObjectVolatile(cls, u.staticFieldOffset(logger), null);
        } catch (Exception e) {
            // ignore
        }
    }

    public SaveCommand(Repository repository) {
        super("save", "save repository to XML");
        this.repository = repository;
    }

    @Override
    public boolean execute() {
        disableWarning();
        XStream xstream = new XStream(new StaxDriver());
        String strXml = xstream.toXML(repository);

        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                new BufferedOutputStream(
                        new FileOutputStream("repository.xml", true)))) {

            outputStreamWriter.write(strXml);

        } catch (IOException e) {
            ConsoleManager.replyUser("Repository is not saved");
            return false;
        }

        return true;
    }
}
