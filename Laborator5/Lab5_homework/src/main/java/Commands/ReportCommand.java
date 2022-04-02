package Commands;

import bibliography.Catalog;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand extends Command{
    public ReportCommand(Catalog catalog) {
        super(catalog);
        commandFormat = "report";
    }

    public void execute(String command) {
        try {
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
            configuration.setDirectoryForTemplateLoading(new File("./"));

            Map<String, Object> root = new HashMap<>();
            root.put("catalogLocation", catalog.getJsonPath());
            root.put("items", catalog.getItems());

            Template temp = configuration.getTemplate("report.ftl");

            Writer out = new OutputStreamWriter(new FileOutputStream("C:/Users/manub/IdeaProjects/Lab5_homework/src/main/resources/report.html"));
            temp.process(root, out);
        }
        catch (TemplateException | IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
