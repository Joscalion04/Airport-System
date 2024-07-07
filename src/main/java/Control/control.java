package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.*;
import View.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class control implements ActionListener, MouseListener{

    private window ventana;
    private model modelo;

    public control(window ventana, model modelo) {
        this.ventana = ventana;
        this.modelo = modelo;
        ventana.getTable().setModel(modelo.getTableModelo1());
    }

    public control() {
        this.ventana = new window();
        this.modelo = new model();
        ventana.getTable().setModel(modelo.getTableModelo1());
        this.activarPanel();
        this.pushComboBox();
    }
    
    public void activarPanel(){
        this.ventana.getBtn_Buscar().addActionListener(this);
        this.ventana.getBtn_Guardar().addActionListener(this);
        this.ventana.getBtn_Limpiar().addActionListener(this);
        this.ventana.getTable().addMouseListener(this);
    }
    
    public void pushComboBox(){
        for(ciudad aux : modelo.getCiudades().getColeccion()){
              this.ventana.getCiudadesDestino().addItem(aux.getNombre()+" ( "+aux.getGmt()+" ) ");
              this.ventana.getCiudadesOrigen().addItem(aux.getNombre()+" ( "+aux.getGmt()+" ) ");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(ventana.getBtn_Guardar())){
            if(ventana.isGood()){
                  vuelo aux = new vuelo();
                  aux.setNumero(Integer.parseInt(ventana.gettTxt_NumeroVuelo().getText()));
                  ciudad origen = modelo.getCiudades().buscaCiudadPos(ventana.getCiudadesOrigen().getSelectedIndex()); aux.setOrigen(origen); 
                  ciudad destino = modelo.getCiudades().buscaCiudadPos(ventana.getCiudadesDestino().getSelectedIndex()); aux.setDestino(destino); 
                  aux.setHoraSalida(Integer.parseInt((String) ventana.getHoraSalida().getSelectedItem())); 
                  aux.setHoraLlegada(Integer.parseInt((String) ventana.getHoraLlegada().getSelectedItem())); 
                  if(modelo.getVuelos().existeVuelo(aux)){
                      if(ventana.getTable().getSelectedRow() == 0){
                         JOptionPane.showMessageDialog(null,"¡ El numero de vuelo ya existe, por favor ingresar un numero de vuelo diferente ! ", "Vuelo Ya Existente",JOptionPane.ERROR_MESSAGE);
                      }{
                        modelo.getVuelos().actualizarVuelo(aux);
                        modelo.guardarXML();
                      }
                  }else{
                     modelo.insertarVuelo(aux);
                     modelo.guardarXML();
                  }
            }
        }else if(e.getSource().equals(ventana.getBtn_Buscar())){
            if(ventana.getTxt_NombreCiudad().getText().equals("")){
                JOptionPane.showMessageDialog(null,"¡Por favor ingresar un dato en el campo ''Nombre'' ! ", "Dato Vacio",JOptionPane.ERROR_MESSAGE);
            }else{
                TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo.getTableModelo1());
                ventana.getTable().setRowSorter(sorter);
                RowFilter<TableModel, Integer> filter = RowFilter.regexFilter(this.ventana.getTxt_NombreCiudad().getText());
                sorter.setRowFilter(filter);
            }
        }else if(e.getSource().equals(ventana.getBtn_Limpiar())){
            if(ventana.isClean()){
                int opcion = JOptionPane.showOptionDialog(null,"¿Estas seguro que quieres continuar? Se perderan todos los datos sin guardar","Datos Sin Guardar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,new Object[]{"Sí", "No"},"No");
                if(opcion == JOptionPane.YES_OPTION){ 
                    ventana.clean(); 
                }
            }
        }    

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int selectedRow = ventana.getTable().getSelectedRow();
            if (selectedRow != -1) {
                  vuelo aux = modelo.getVuelos().getElemento(ventana.getTable().getSelectedRow());
                  ventana.gettTxt_NumeroVuelo().setText(aux.getNumero()+"");ventana.gettTxt_NumeroVuelo().setEnabled(false);
                  ventana.getCiudadesDestino().setSelectedItem(aux.getDestino().getNombre()+" ( "+aux.getDestino().getGmt()+" ) ");
                  ventana.getCiudadesOrigen().setSelectedItem(aux.getOrigen().getNombre()+" ( "+aux.getOrigen().getGmt()+" ) ");
                  ventana.getHoraLlegada().setSelectedItem(aux.getHoraLlegada()+"");
                  ventana.getHoraSalida().setSelectedItem(aux.getHoraSalida()+"");
            }
    }

    @Override
    public void mousePressed(MouseEvent e) { }
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

}
