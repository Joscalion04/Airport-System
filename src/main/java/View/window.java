package View;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class window extends javax.swing.JFrame {

    public window() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("SIVU: Sistema de Vuelos");
    }

   public JButton  getBtn_Guardar(){return btn_guardar;}
   public JButton  getBtn_Limpiar(){return btn_Limpiar;}
   public JButton  getBtn_Buscar(){return btn_buscar;}
   
   public JTextField gettTxt_NumeroVuelo(){ return txt_NumeroVuelo; }
   public JTextField getTxt_NombreCiudad(){ return txt_CiudadBusqueda;}
   
   public JComboBox getCiudadesOrigen(){return box_CiudadOrigen;}
   public JComboBox getCiudadesDestino(){return box_CiudadDestino;}
   public JComboBox getHoraSalida(){return box_HoraSalida;}
   public JComboBox getHoraLlegada(){return box_HoraLlegada;}
   
   public JTable getTable(){return table_Vuelos;}
        
   public boolean parceable(String text){
       try{
           int n = Integer.parseInt(text);
           return true;
       }catch(NumberFormatException e){
           return false;
       }
   }
   
   public void setBlack(){
        label_Numero.setForeground(Color.BLACK);
        label_Origen.setForeground(Color.BLACK);
        label_Destino.setForeground(Color.BLACK);
        label_Salida.setForeground(Color.BLACK);
        label_Llegada.setForeground(Color.BLACK);
   }
   
   public boolean isGood(){
       if(txt_NumeroVuelo.getText().equals("") || !parceable(txt_NumeroVuelo.getText())){
           JOptionPane.showMessageDialog(null,"¡Por favor ingresar un dato numerico en el campo ''Numero'' ! ", "Dato Incorrecto o Vacio",JOptionPane.ERROR_MESSAGE);
           label_Numero.setForeground(Color.RED);
           return false;
       }
       if(box_CiudadOrigen.getSelectedItem().equals("Ninguna")){
           JOptionPane.showMessageDialog(null,"¡Por favor seleccione una opcion de  ''Origen'' ! ", "Dato Incorrecto o Vacio",JOptionPane.ERROR_MESSAGE);
           label_Origen.setForeground(Color.RED);
           return false;
       }
       if(box_CiudadDestino.getSelectedItem().equals("Ninguna")){
           JOptionPane.showMessageDialog(null,"¡Por favor seleccione una opcion de  ''Destino'' ! ", "Dato Incorrecto o Vacio",JOptionPane.ERROR_MESSAGE);
           label_Destino.setForeground(Color.RED);
           return false;
       }
       if(box_HoraSalida.getSelectedItem().equals("0")){
           JOptionPane.showMessageDialog(null,"¡Por favor seleccione una opcion de  ''Salida'' ! ", "Dato Incorrecto o Vacio",JOptionPane.ERROR_MESSAGE);
           label_Salida.setForeground(Color.RED);
           return false;
       }
       if( box_HoraLlegada.getSelectedItem().equals("0")){
           JOptionPane.showMessageDialog(null,"¡Por favor seleccione una opcion de  ''Llegada'' ! ", "Dato Incorrecto o Vacio",JOptionPane.ERROR_MESSAGE);
           label_Llegada.setForeground(Color.RED);
           return false;
       }
       this.setBlack();
       return true;
   }
   
   public boolean isClean(){
       if(box_CiudadDestino.getSelectedIndex() == 0 || box_CiudadOrigen.getSelectedIndex() == 0 || box_HoraLlegada.getSelectedIndex() == 0 || box_HoraSalida.getSelectedIndex() == 0 || txt_CiudadBusqueda.getText().equals("")){
           return true;
       }return false;
   }
   
   public void clean(){
       box_CiudadDestino.setSelectedIndex(0);
       box_CiudadOrigen.setSelectedIndex(0);
       box_HoraLlegada.setSelectedIndex(0);
       box_HoraSalida.setSelectedIndex(0);
       txt_CiudadBusqueda.setText("");
       txt_NumeroVuelo.setText("");
   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label_Numero = new javax.swing.JLabel();
        label_Origen = new javax.swing.JLabel();
        label_Destino = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        label_Salida = new javax.swing.JLabel();
        label_Llegada = new javax.swing.JLabel();
        label_CiudadBusqueda = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_NumeroVuelo = new javax.swing.JTextField();
        txt_CiudadBusqueda = new javax.swing.JTextField();
        box_CiudadOrigen = new javax.swing.JComboBox<>();
        box_CiudadDestino = new javax.swing.JComboBox<>();
        box_HoraSalida = new javax.swing.JComboBox<>();
        box_HoraLlegada = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btn_guardar = new javax.swing.JButton();
        btn_Limpiar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Vuelos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Vuelo");

        label_Numero.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_Numero.setText("Numero:");

        label_Origen.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_Origen.setText("Origen:");

        label_Destino.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_Destino.setText("Destino:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Busqueda");

        label_Salida.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_Salida.setText("Salida:");

        label_Llegada.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_Llegada.setText("Llegada:");

        label_CiudadBusqueda.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_CiudadBusqueda.setText("Ciudad:");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setText("Listado");

        box_CiudadOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguna" }));

        box_CiudadDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguna" }));

        box_HoraSalida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        box_HoraLlegada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        btn_guardar.setText("Guardar");

        btn_Limpiar.setText("Limpiar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_guardar)
                .addGap(18, 18, 18)
                .addComponent(btn_Limpiar)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar)
                    .addComponent(btn_Limpiar))
                .addContainerGap())
        );

        btn_buscar.setText("Buscar");

        table_Vuelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Numero", "Origen", "Salida", "Destino", "Llegada", "Duracion"
            }
        ));
        jScrollPane1.setViewportView(table_Vuelos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label_Destino)
                                            .addComponent(label_Origen))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(box_CiudadOrigen, 0, 121, Short.MAX_VALUE)
                                            .addComponent(box_CiudadDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_Numero)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_NumeroVuelo))))
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_Llegada)
                                    .addComponent(label_Salida))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(box_HoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(box_HoraLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(205, 205, 205)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 27, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel5))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(label_CiudadBusqueda)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_CiudadBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_buscar)
                            .addGap(36, 36, 36)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_Numero)
                            .addComponent(txt_NumeroVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_Salida)
                    .addComponent(box_CiudadOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_HoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_Origen))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_Destino)
                    .addComponent(label_Llegada)
                    .addComponent(box_CiudadDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_HoraLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_CiudadBusqueda)
                    .addComponent(txt_CiudadBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box_CiudadDestino;
    private javax.swing.JComboBox<String> box_CiudadOrigen;
    private javax.swing.JComboBox<String> box_HoraLlegada;
    private javax.swing.JComboBox<String> box_HoraSalida;
    private javax.swing.JButton btn_Limpiar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_CiudadBusqueda;
    private javax.swing.JLabel label_Destino;
    private javax.swing.JLabel label_Llegada;
    private javax.swing.JLabel label_Numero;
    private javax.swing.JLabel label_Origen;
    private javax.swing.JLabel label_Salida;
    private javax.swing.JTable table_Vuelos;
    private javax.swing.JTextField txt_CiudadBusqueda;
    private javax.swing.JTextField txt_NumeroVuelo;
    // End of variables declaration//GEN-END:variables
}
