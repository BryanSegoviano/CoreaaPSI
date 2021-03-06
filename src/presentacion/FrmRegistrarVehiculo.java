/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import controles.Fachada;
import controles.IFachada;
import dominio.Cliente;
import dominio.Relclientevehiculo;
import dominio.Vehiculo;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author l3tal
 */
public class FrmRegistrarVehiculo extends javax.swing.JFrame {

    private IFachada fachada;

    public FrmRegistrarVehiculo() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.fachada = new Fachada();
        this.cargarTablaClientes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistrarVehiculo = new javax.swing.JButton();
        btnEditarVehiculo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnGuardarVehiculo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtVehiculoNombre = new javax.swing.JTextField();
        txtMarcaVehiculo = new javax.swing.JTextField();
        txtModeloVehiculo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        btnConsultarVehiculo = new javax.swing.JButton();
        btnCerrarSesion2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAdmClientes = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        menuAdmVentas = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrar vehiculos");

        btnRegistrarVehiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegistrarVehiculo.setText("Registrar Veh??culo");
        btnRegistrarVehiculo.setEnabled(false);
        btnRegistrarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVehiculoActionPerformed(evt);
            }
        });

        btnEditarVehiculo.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarVehiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditarVehiculo.setText("Editar Veh??culo");
        btnEditarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarVehiculoActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(220, 220, 220));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Registrar Veh??culo");

        btnGuardarVehiculo.setBackground(new java.awt.Color(51, 204, 0));
        btnGuardarVehiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardarVehiculo.setText("Guardar vehiculo");
        btnGuardarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarVehiculoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Informaci??n del veh??culo");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Ingrese los datos del nuevo cliente");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Marca:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Modelo:");

        txtVehiculoNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtMarcaVehiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtModeloVehiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtModeloVehiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtModeloVehiculoKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("??A que cliente le pertenece?");

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Direcci??n", "Tel??fono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtModeloVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(23, 23, 23)
                                .addComponent(txtMarcaVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtVehiculoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGuardarVehiculo)
                .addGap(199, 199, 199))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMarcaVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtVehiculoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtModeloVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarVehiculo)
                .addContainerGap())
        );

        btnConsultarVehiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnConsultarVehiculo.setText("Consultar Veh??culo");
        btnConsultarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarVehiculoActionPerformed(evt);
            }
        });

        btnCerrarSesion2.setBackground(new java.awt.Color(255, 0, 0));
        btnCerrarSesion2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCerrarSesion2.setText("Cerrar Sesion");
        btnCerrarSesion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesion2ActionPerformed(evt);
            }
        });

        menuAdmClientes.setText("Administrar Clientes");
        menuAdmClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAdmClientesMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuAdmClientes);

        jMenu2.setText("Administrar Vehiculos");
        jMenu2.setEnabled(false);
        jMenuBar1.add(jMenu2);

        menuAdmVentas.setText("Administrar Ventas");
        menuAdmVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAdmVentasMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuAdmVentas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnRegistrarVehiculo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditarVehiculo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConsultarVehiculo, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnCerrarSesion2)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(btnRegistrarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnEditarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnConsultarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion2)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVehiculoActionPerformed

    }//GEN-LAST:event_btnRegistrarVehiculoActionPerformed

    private void btnEditarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarVehiculoActionPerformed
        FrmEditarVehiculo frmEditarVehiculo = new FrmEditarVehiculo();
        frmEditarVehiculo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEditarVehiculoActionPerformed

    private void btnGuardarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarVehiculoActionPerformed
        this.registrarVehiculo();
    }//GEN-LAST:event_btnGuardarVehiculoActionPerformed

    private void menuAdmVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAdmVentasMouseClicked
        FrmRegistrarVenta frmRegistroVenta = new FrmRegistrarVenta();
        frmRegistroVenta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuAdmVentasMouseClicked

    private void menuAdmClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAdmClientesMouseClicked
        FrmRegistrarCliente frmRegistrarCliente = new FrmRegistrarCliente();
        frmRegistrarCliente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuAdmClientesMouseClicked

    private void btnConsultarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarVehiculoActionPerformed
        FrmConsultarVehiculo frmConsultarVehiculo = new FrmConsultarVehiculo();
        frmConsultarVehiculo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnConsultarVehiculoActionPerformed

    private void txtModeloVehiculoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloVehiculoKeyReleased
        String id = txtModeloVehiculo.getText();
        boolean isNumeric = id.chars().allMatch(Character::isDigit);
        try {
            if (!isNumeric) {
                JOptionPane.showMessageDialog(this, "Debes singresar un numero",
                        "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                this.txtModeloVehiculo.setText("");
            } else {
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtModeloVehiculoKeyReleased

    private void btnCerrarSesion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesion2ActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, "??Cerrar la sesi??n actual?");
        if (respuesta == 0) {
            FrmInicioSesion inicioSesion = new FrmInicioSesion();
            inicioSesion.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnCerrarSesion2ActionPerformed

    private void registrarVehiculo() {
        int renglonElegido = this.tablaClientes.getSelectedRow();

        if (renglonElegido == -1) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un cliente",
                    "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String nombre = this.txtVehiculoNombre.getText();
            String marca = this.txtMarcaVehiculo.getText();
            String modelo = this.txtModeloVehiculo.getText();
            Vehiculo vehiculo = new Vehiculo(modelo, nombre, marca);
            this.fachada.guardarVehiculo(vehiculo);

            Integer idCliente = (Integer) this.tablaClientes.getValueAt(renglonElegido, 0);
            Cliente cliente = this.fachada.buscarPorIDCliente(idCliente);
            Relclientevehiculo relClientevehiculo = new Relclientevehiculo(cliente, vehiculo);
            this.fachada.guardarRelclientevehiculo(relClientevehiculo);
            JOptionPane.showMessageDialog(this, "Vehiculo guardado exit??samente",
                    "", JOptionPane.INFORMATION_MESSAGE);
            this.vaciarCampos();
        }
    }

    public void vaciarCampos(){
        this.txtMarcaVehiculo.setText("");
        this.txtModeloVehiculo.setText("");
        this.txtVehiculoNombre.setText("");
    }
    
    public void cargarTablaClientes() {
        List<Cliente> listaClientes = this.fachada.buscarTodasCliente();
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaClientes.getModel();
        modeloTabla.setRowCount(0);
        for (Cliente cliente : listaClientes) {
            Object[] fila = new Object[4];
            fila[0] = cliente.getIdcliente();
            fila[1] = cliente.getNombre();
            fila[2] = cliente.getDireccion();
            fila[3] = cliente.getTelefono();
            modeloTabla.addRow(fila);
        }
        this.centrarDatosTablaClientes();
    }

    private void centrarDatosTablaClientes() {
        DefaultTableCellRenderer columna = new DefaultTableCellRenderer();
        columna.setHorizontalAlignment(0);
        for (int i = 0; i < this.tablaClientes.getColumnCount(); i++) {
            this.tablaClientes.setDefaultRenderer(this.tablaClientes.getColumnClass(i), columna);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegistrarVehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion2;
    private javax.swing.JButton btnConsultarVehiculo;
    private javax.swing.JButton btnEditarVehiculo;
    private javax.swing.JButton btnGuardarVehiculo;
    private javax.swing.JButton btnRegistrarVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenu menuAdmClientes;
    private javax.swing.JMenu menuAdmVentas;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtMarcaVehiculo;
    private javax.swing.JTextField txtModeloVehiculo;
    private javax.swing.JTextField txtVehiculoNombre;
    // End of variables declaration//GEN-END:variables
}
