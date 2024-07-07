package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class model {
     private DefaultTableModel TableModelo1;
     private listCiudades Ciudades;
     private listVuelos Vuelos;

    public model(DefaultTableModel TableModelo1, listCiudades Ciudades, listVuelos Vuelos) {
        this.TableModelo1 = TableModelo1;
        this.Ciudades = Ciudades;
        this.Vuelos = Vuelos;
    }

    public model() {
        this.TableModelo1 = new DefaultTableModel();
        this.Ciudades = new listCiudades();
        this.Vuelos = new listVuelos();
        this.cargarXML();
        this.setModel();
        this.StartModel();
    }

    public DefaultTableModel getTableModelo1() {
        return TableModelo1;
    }

    public void setTableModelo1(DefaultTableModel TableModelo1) {
        this.TableModelo1 = TableModelo1;
    }

    public listCiudades getCiudades() {
        return Ciudades;
    }

    public void setCiudades(listCiudades Ciudades) {
        this.Ciudades = Ciudades;
    }

    public listVuelos getVuelos() {
        return Vuelos;
    }

    public void setVuelos(listVuelos Vuelos) {
        this.Vuelos = Vuelos;
    }
    
    private void setModel(){
        TableModelo1.addColumn("Numero");
        TableModelo1.addColumn("Origen");
        TableModelo1.addColumn("Salida");
        TableModelo1.addColumn("Destino");
        TableModelo1.addColumn("Llegada");
        TableModelo1.addColumn("Duracion");
    }
    
    public void StartModel() {
        for (int i = 0; i < Vuelos.Size(); i++) {
            Object[] filAux = Vuelos.retornaFila(i);
            TableModelo1.addRow(filAux);
        }
    }
    
    public void insertarVuelo(vuelo Aux) {
        Vuelos.agregarVuelo(Aux);
        insertarFilaModelo1(Vuelos.retornaFila(Vuelos.Size() - 1));
    }

    public void insertarFilaModelo1(Object[] filaAux) {
        TableModelo1.addRow(filaAux);
    }

    public void borrarRegistroModelo1(int linea) {
        TableModelo1.removeRow(linea);
        Vuelos.eliminarVuelo(Vuelos.getElemento(linea).getNumero());
    }
    
    public void guardarXML(){
        Element Data = new Element("data"); // root Element
        Document Doc = new Document(Data);
        Element Ciudades = new Element("Ciudades"); 
        Data.addContent(Ciudades);
        for(ciudad aux : this.Ciudades.getColeccion()){
               try{
                   Element Ciudad = new Element("Ciudad");
                   Element id = new Element("id"); id.setText(aux.getId()); Ciudad.addContent(id);
                   Element nombre = new Element("nombre"); nombre.setText(aux.getNombre()); Ciudad.addContent(nombre);
                   Element gmt = new Element("gmt"); gmt.setText(aux.getGmt()+""); Ciudad.addContent(gmt);
                   Ciudades.addContent(Ciudad);
                   XMLOutputter XML = new XMLOutputter();
                   XML.setFormat(Format.getPrettyFormat());;
                   XML.output(Doc,new FileWriter("data.xml"));
               }catch (IOException ex) {
                   System.err.println(ex.getMessage());
               }
           }
        
        Element Vuelos = new Element("Vuelos");
           Data.addContent(Vuelos);
           for(vuelo aux : this.Vuelos.getColeccion()){
               try {
                   Element vueloAux =  new Element("Vuelo");
                   Element numero = new Element("numero"); numero.setText(aux.getNumero()+""); vueloAux.addContent(numero);
                   Element origen = new Element("origen"); origen.setText(aux.getOrigen().getId()); vueloAux.addContent(origen);
                   Element destino = new Element("destino"); destino.setText(aux.getDestino().getId()); vueloAux.addContent(destino);
                   Element horaSalida = new Element("horaSalida"); horaSalida.setText(aux.getHoraSalida()+""); vueloAux.addContent(horaSalida);
                   Element horaLlegada = new Element("horaLlegada"); horaLlegada.setText(aux.getHoraLlegada()+""); vueloAux.addContent(horaLlegada);
                   Vuelos.addContent(vueloAux);
                   XMLOutputter XML = new XMLOutputter();
                   XML.setFormat(Format.getPrettyFormat());
                   XML.output(Doc,new FileWriter("data.xml"));
               } catch (IOException ex) {
                   System.err.println(ex.getMessage());
               }
           }
        
    }
    
    public void cargarCiudades(){
       try {
            File inputFile = new File("data.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            Element root = document.getRootElement();
            List<Element> ciudades = root.getChild("Ciudades").getChildren("Ciudad");
            for (Element ciudad : ciudades) {
                String id = ciudad.getChildText("id");
                String nombre = ciudad.getChildText("nombre"); 
                int gmt = Integer.parseInt( ciudad.getChildText("gmt")); 
                ciudad aux = new ciudad(nombre,id,gmt);
                Ciudades.agregarCiudad(aux);
            }
        } catch (IOException | JDOMException e) {
            e.printStackTrace();
        }
        
    }
    
    public void cargarVuelos(){
        try {
            File inputFile = new File("data.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            Element root = document.getRootElement();
           System.out.print(Ciudades.toString());
            List<Element> vuelos = root.getChild("Vuelos").getChildren("Vuelo");
            for (Element vuelo : vuelos) {
                int numeroVuelo = Integer.parseInt(vuelo.getChildText("numero")); ;
                ciudad origenaux = Ciudades.buscarCiudad(vuelo.getChildTextTrim("origen"));
                ciudad destinoaux = Ciudades.buscarCiudad(vuelo.getChildTextTrim("destino"));
                int horaSalida = Integer.parseInt(vuelo.getChildText("horaSalida")); 
                int horaLlegada = Integer.parseInt(vuelo.getChildText("horaLlegada")); 
                vuelo aux = new vuelo(numeroVuelo,origenaux,destinoaux,horaSalida,horaLlegada);
                Vuelos.agregarVuelo(aux);
            }
        } catch (IOException | JDOMException e) {
            e.printStackTrace();
        }
    }
    
    public void cargarXML(){
        this.cargarCiudades();;
        this.cargarVuelos();
    }
}
