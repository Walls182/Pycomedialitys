
package VeterinariaDogtor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Ventana extends javax.swing.JFrame {
     public int tab=0;
     public Ventana() {
       initComponents();
       Conectar os = new Conectar();
       os.llenarTablas(list_tablas);
       list_tablas.setVisible(false);
    }
    /**
     * Creates new form Ventana
     */
  
     public void mostrar(String tabla){
        String sql = "select * from " +tabla;
        Statement st;
        Conectar conn = new Conectar();
        Connection Conectar = conn.getConnection();
        
        DefaultTableModel model = new DefaultTableModel();
        switch(tabla){
            case "citas":
        model.addColumn("idcitas");
        
        
        visor.setModel(model);
        
        String [] citas = new String [1];
        try{
            st = Conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                citas[0]=rs.getString(1);
                model.addRow(citas);
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
                break;
                
            case "cliente":
                model.addColumn("idCiente");
                model.addColumn("nombre");
                model.addColumn("apellido");
                model.addColumn("telefono");
        
        visor.setModel(model);
        
        String [] datoscli = new String [4];
        try{
            st = Conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datoscli[0]=rs.getString(1);
                datoscli[1]=rs.getString(2);
                datoscli[2]=rs.getString(3);
                datoscli[3]=rs.getString(4);
                model.addRow(datoscli);
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
                break;
                
            case "mascotas":
                model.addColumn("idmascotas");
                model.addColumn("alias");
                model.addColumn("idcliente");
                model.addColumn("especie");
                model.addColumn("raza");
                model.addColumn("pelo");
                model.addColumn("nacimiento");
                model.addColumn("idveterinario");
                model.addColumn("idservicios");
                model.addColumn("idcitas");
                visor.setModel(model);
        
        String [] mas = new String [10];
        try{
            st = Conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                mas[0]=rs.getString(1);
                mas[1]=rs.getString(2);
                mas[2]=rs.getString(3);
                mas[3]=rs.getString(4);
                mas[4]=rs.getString(5);
                mas[5]=rs.getString(6);
                mas[6]=rs.getString(7);
                mas[7]=rs.getString(8);
                mas[8]=rs.getString(9);
                mas[9]=rs.getString(10);
                model.addRow(mas);
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
                break;
                
            case "servicios":
                model.addColumn("idservicios");
                model.addColumn("hospitalizacion");
                model.addColumn("vacunacion");
                model.addColumn("esterilizacion");
                model.addColumn("peluqueria");
                visor.setModel(model);
        
        String [] tipo = new String [3];
        try{
            st = Conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                tipo[0]=rs.getString(1);
                tipo[1]=rs.getString(2);
                tipo[2]=rs.getString(3);
                tipo[3]=rs.getString(4);
                tipo[4]=rs.getString(5);
                model.addRow(tipo);
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
                break;
            case "veterinarios":
                model.addColumn("idveterinario");
                model.addColumn("nombre");
                model.addColumn("apellido");
                model.addColumn("correo");
                visor.setModel(model);
        
        String [] vet = new String [4];
        try{
            st =Conectar .createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                vet[0]=rs.getString(1);
                vet[1]=rs.getString(2);
                vet[2]=rs.getString(3);
                vet[3]=rs.getString(4);
                model.addRow(vet);
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
                break;
        }
        
    }
    public void eliminar(String tabla, String columna, String valor){
        Statement st;
       Conectar  conn = new Conectar();
        Connection Conectar  = conn.getConnection();
                //select * from tipo where nombre_tipo = 'pupi'
                String sql = "delete from " + tabla + " where " + columna + " = '" + valor + "'";
                System.out.println(sql);
        try{
            st = Conectar.createStatement();
            st.executeUpdate(sql);
            
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error " +e.toString());
        }
        JOptionPane.showMessageDialog(null, "Borrado de la base de datos");
        mostrar(tabla);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jpaneltabla = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        visor = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Veterinarios = new javax.swing.JButton();
        jButtonServicios = new javax.swing.JButton();
        jButtonMascotas = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButtonCliente = new javax.swing.JButton();
        jButtonCitas = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButtonAgregar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtoneliminar = new javax.swing.JButton();
        list_tablas = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(249, 217, 154));

        jpaneltabla.setBackground(new java.awt.Color(173, 213, 250));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Datos");

        visor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(visor);

        javax.swing.GroupLayout jpaneltablaLayout = new javax.swing.GroupLayout(jpaneltabla);
        jpaneltabla.setLayout(jpaneltablaLayout);
        jpaneltablaLayout.setHorizontalGroup(
            jpaneltablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpaneltablaLayout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpaneltablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpaneltablaLayout.setVerticalGroup(
            jpaneltablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpaneltablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 102, 0));
        jLabel1.setText("Administrativo Psicomedialitys");

        jPanel5.setBackground(new java.awt.Color(250, 95, 73));

        Veterinarios.setText("Veterinarios");
        Veterinarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VeterinariosActionPerformed(evt);
            }
        });

        jButtonServicios.setText("Servicios");
        jButtonServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonServiciosActionPerformed(evt);
            }
        });

        jButtonMascotas.setText("Operaciones");
        jButtonMascotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMascotasActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("¿Que quieres modificar?");

        jButtonCliente.setText("Cliente");
        jButtonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClienteActionPerformed(evt);
            }
        });

        jButtonCitas.setText("Citas");
        jButtonCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCitasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Veterinarios))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonMascotas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCitas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCliente)
                .addGap(12, 12, 12)
                .addComponent(jButtonMascotas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonServicios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Veterinarios)
                .addGap(55, 55, 55))
        );

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(149, 184, 246));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("¿Que quieres hacer?");

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtoneliminar.setText("Eliminar");
        jButtoneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoneliminarActionPerformed(evt);
            }
        });

        list_tablas.setBorder(javax.swing.BorderFactory.createTitledBorder("Tablas"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtoneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(list_tablas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(20, 20, 20)
                .addComponent(list_tablas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAgregar)
                .addGap(18, 18, 18)
                .addComponent(jButtonModificar)
                .addGap(18, 18, 18)
                .addComponent(jButtoneliminar)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addComponent(jpaneltabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpaneltabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addGap(420, 420, 420))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        switch(tab){
            case 1:
                //Objeto del formulario dueños
                Citas ci = new Citas();
                ci.setVisible(true);
                
                break;
            case 2:
                Familiar cli = new Familiar();
                cli.setVisible(true);
                break;
            case 3:
                ope2 mas= new ope2();
                mas.setVisible(true);
                break;
            case 4:
               Servicios ser  = new Servicios();
                ser.setVisible(true);
                break;
            case 5:
                Psicologo vet = new Psicologo();
                vet.setVisible(true);
                break;
        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClienteActionPerformed
        mostrar("cliente");   
        tab=2;
    }//GEN-LAST:event_jButtonClienteActionPerformed

    private void jButtonMascotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMascotasActionPerformed
        mostrar("mascotas");   
        tab=3;
    }//GEN-LAST:event_jButtonMascotasActionPerformed

    private void jButtonServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonServiciosActionPerformed
        mostrar("servicio");   
        tab=4;
    }//GEN-LAST:event_jButtonServiciosActionPerformed

    private void VeterinariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VeterinariosActionPerformed
        mostrar("veterinario");   
        tab=5;
    }//GEN-LAST:event_VeterinariosActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        JOptionPane.showMessageDialog(null, "esto todavia no es programado xd pero el de eliminar si");
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtoneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoneliminarActionPerformed
         String valor = JOptionPane.showInputDialog(null,"Ingrese el dato o nombre a eliminar");
        switch(tab){
            case 1:
                eliminar("citas","idcitas",valor);
                
                break;
            case 2:
                eliminar("cliente","idcliente",valor);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "esta tabla tiene llaves foraneas, no se puede eliminar");//mascotas contiene las llaves foraneas creo 
                break;
            case 4:
                eliminar("servicio","idservicios",valor);
                break;
            case 5:
                eliminar("veterinario","idveterinario",valor);
        }
    }//GEN-LAST:event_jButtoneliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCitasActionPerformed
        mostrar("citas");   
        tab=1;
    }//GEN-LAST:event_jButtonCitasActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Veterinarios;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonCitas;
    private javax.swing.JButton jButtonCliente;
    private javax.swing.JButton jButtonMascotas;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonServicios;
    private javax.swing.JButton jButtoneliminar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jpaneltabla;
    private javax.swing.JComboBox<String> list_tablas;
    private javax.swing.JTable visor;
    // End of variables declaration//GEN-END:variables
}
