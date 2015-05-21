package empleados.librerias;



import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.ArraylistEF;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.empleadofijo;

public class jsonsecundario {

	
	public static void guardarjson_EF() {
        String PATH;

        try {
            XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
            xstreamjson.setMode(XStream.NO_REFERENCES);
            xstreamjson.alias("actividades", empleadofijo.class);

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));

            int seleccion = fileChooser.showSaveDialog(null);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();

                if (!PATH.endsWith(".json")) {
                    PATH = PATH + ".json";
                }

                Gson gson = new Gson();
                String json = gson.toJson(ArraylistEF.ef);
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(json.toString());
                fileXml.close();

                JOptionPane.showMessageDialog(null,
                        "Archivo JSON guardado con éxito", "Archivo JSON",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "Error al grabar el JSON",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static ArrayList<empleadofijo> abrirjson1_EF() {
        String PATH;
        empleadofijo a;

        try {
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("actividades", empleadofijo.class);

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));

            int seleccion = fileChooser.showOpenDialog(null);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();

                ArraylistEF.ef.clear();

                JsonReader lector = new JsonReader(new FileReader(PATH));
                JsonParser parseador = new JsonParser();
                JsonElement raiz = parseador.parse(lector);

                Gson json = new Gson();
                JsonArray lista = raiz.getAsJsonArray();

                for (JsonElement elemento : lista) {
                    a = json.fromJson(elemento, empleadofijo.class);
                    ArraylistEF.ef.add(a);
                }

                JOptionPane.showMessageDialog(null,
                        "Archivo JSON abierto con éxito", "Archivo JSON",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (HeadlessException | FileNotFoundException | JsonIOException | JsonSyntaxException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el JSON",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        return ArraylistEF.ef;
    }
}
