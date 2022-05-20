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

public class FrmEditarCliente extends javax.swing.JFrame {

    private IFachada fachada;

    public FrmEditarCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.fachada = new Fachada();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        clienteNom = new javax.swing.JTextField();
        clienteTel = new javax.swing.JTextField();
        clienteDireccion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        txtIdCliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        fechaVentalbl = new javax.swing.JLabel();
        btnBuscarVenta = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVehiculos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnRegistrarCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        btnConsultarCliente = new javax.swing.JButton();
        btnCerrarSesion2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuAdmVehiculos = new javax.swing.JMenu();
        menuAdmVentas = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrar clientes");

        jPanel2.setBackground(new java.awt.Color(220, 220, 220));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Ingrese el ID del cliente que desea editar");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Informacion del Cliente:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Telefono");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Dirección");

        clienteNom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        clienteTel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clienteTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clienteTelKeyReleased(evt);
            }
        });

        clienteDireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnGuardar.setBackground(new java.awt.Color(51, 204, 0));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar cambios");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtIdCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdClienteKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("ID:");

        fechaVentalbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnBuscarVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarVenta.setText("Buscar");
        btnBuscarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVentaActionPerformed(evt);
            }
        });

        tablaVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Nombre", "Marca", "Modelo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaVehiculos.setEnabled(false);
        jScrollPane1.setViewportView(tablaVehiculos);
        if (tablaVehiculos.getColumnModel().getColumnCount() > 0) {
            tablaVehiculos.getColumnModel().getColumn(0).setResizable(false);
            tablaVehiculos.getColumnModel().getColumn(1).setResizable(false);
            tablaVehiculos.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Vehículos:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Editar Cliente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 69, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(111, 111, 111))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarVenta)
                        .addGap(157, 157, 157))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(fechaVentalbl))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(jLabel3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel7))
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(clienteNom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(clienteTel)
                                                .addComponent(clienteDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(btnGuardar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(btnBuscarVenta))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(fechaVentalbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clienteNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clienteTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clienteDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btnRegistrarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegistrarCliente.setText("Registrar Cliente");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        btnEditarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditarCliente.setText("Editar Cliente");
        btnEditarCliente.setEnabled(false);
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });

        btnConsultarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnConsultarCliente.setText("Consultar Cliente");
        btnConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarClienteActionPerformed(evt);
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

        jMenu1.setText("Administrar Clientes");
        jMenu1.setEnabled(false);
        jMenuBar1.add(jMenu1);

        menuAdmVehiculos.setText("Administrar Vehiculos");
        menuAdmVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAdmVehiculosMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuAdmVehiculos);

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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnRegistrarCliente)
                                .addGap(16, 16, 16))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEditarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnConsultarCliente, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrarSesion2)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnConsultarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(btnCerrarSesion2)
                        .addGap(9, 9, 9))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.editarCliente();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void editarCliente() {
        int idCliente = Integer.parseInt(this.txtIdCliente.getText());
        try {

            Cliente cliente = this.fachada.buscarPorIDCliente(idCliente);
            cliente.setNombre(this.clienteNom.getText());
            cliente.setDireccion(this.clienteDireccion.getText());
            cliente.setTelefono(this.clienteTel.getText());
            this.fachada.actualizarCliente(cliente);
            JOptionPane.showMessageDialog(this, "Cliente editado exitósamente",
                    "", JOptionPane.INFORMATION_MESSAGE);
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaVehiculos.getModel();
            modeloTabla.setRowCount(0);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void btnBuscarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVentaActionPerformed
        int idCliente = Integer.parseInt(this.txtIdCliente.getText());
        this.buscarClienteId(idCliente);
    }//GEN-LAST:event_btnBuscarVentaActionPerformed

    private void buscarClienteId(int idCliente) {
        try {
            Cliente cliente = this.fachada.buscarPorIDCliente(idCliente);
            if (cliente != null) {
                this.clienteNom.setText(cliente.getNombre());
                this.clienteDireccion.setText(cliente.getDireccion());
                this.clienteTel.setText(cliente.getTelefono());
                this.llenarTablaVehiculos(idCliente);
            } else {
                JOptionPane.showMessageDialog(this, "Cliente no encontrado",
                        "Advertencia", JOptionPane.ERROR_MESSAGE);
                this.txtIdCliente.setText("");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void llenarTablaVehiculos(int idCliente) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaVehiculos.getModel();
        modeloTabla.setRowCount(0);
        List<Relclientevehiculo> clienteVehiculo = this.fachada.buscarTodasRelclientevehiculo();
        for (Relclientevehiculo relclientevehiculo : clienteVehiculo) {
            int idrel = relclientevehiculo.getIdcliente().getIdcliente();
            if (idrel == idCliente) {
                Object[] fila = new Object[3];
                fila[0] = relclientevehiculo.getIdvehiculo().getNombre();
                fila[1] = relclientevehiculo.getIdvehiculo().getMarca();
                fila[2] = relclientevehiculo.getIdvehiculo().getModelo();
                modeloTabla.addRow(fila);
            }
        }

        this.centrarDatosTablaProductosBuscados();
    }

    private void centrarDatosTablaProductosBuscados() {
        DefaultTableCellRenderer columna = new DefaultTableCellRenderer();
        columna.setHorizontalAlignment(0);
        for (int i = 0; i < this.tablaVehiculos.getColumnCount(); i++) {
            this.tablaVehiculos.setDefaultRenderer(this.tablaVehiculos.getColumnClass(i), columna);
        }
    }

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        FrmRegistrarCliente frmRegCLiente = new FrmRegistrarCliente();
        frmRegCLiente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed

    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void menuAdmVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAdmVehiculosMouseClicked
        FrmRegistrarVehiculo frmAdmVehiculos = new FrmRegistrarVehiculo();
        frmAdmVehiculos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuAdmVehiculosMouseClicked

    private void menuAdmVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAdmVentasMouseClicked
        FrmRegistrarVenta frmRegistroVenta = new FrmRegistrarVenta();
        frmRegistroVenta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuAdmVentasMouseClicked

    private void btnConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarClienteActionPerformed
        FrmConsultarCliente frmconsulta = new FrmConsultarCliente();
        frmconsulta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnConsultarClienteActionPerformed

    private void txtIdClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdClienteKeyReleased
        String telefono = txtIdCliente.getText();
        boolean isNumeric = telefono.chars().allMatch(Character::isDigit);
        try {
            if (!isNumeric) {
                JOptionPane.showMessageDialog(this, "Debes singresar un numero",
                        "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                this.txtIdCliente.setText("");
            } else {
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtIdClienteKeyReleased

    private void clienteTelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clienteTelKeyReleased
        String telefono = clienteTel.getText();
        boolean isNumeric = telefono.chars().allMatch(Character::isDigit);
        try {
            if (!isNumeric) {
                JOptionPane.showMessageDialog(this, "Debes singresar un numero",
                        "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                this.clienteTel.setText("");
            } else {
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_clienteTelKeyReleased

    private void btnCerrarSesion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesion2ActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Cerrar la sesión actual?");
        if (respuesta == 0) {
            FrmInicioSesion inicioSesion = new FrmInicioSesion();
            inicioSesion.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnCerrarSesion2ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmEditarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEditarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEditarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEditarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEditarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarVenta;
    private javax.swing.JButton btnCerrarSesion2;
    private javax.swing.JButton btnConsultarCliente;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JTextField clienteDireccion;
    private javax.swing.JTextField clienteNom;
    private javax.swing.JTextField clienteTel;
    private javax.swing.JLabel fechaVentalbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenu menuAdmVehiculos;
    private javax.swing.JMenu menuAdmVentas;
    private javax.swing.JTable tablaVehiculos;
    private javax.swing.JTextField txtIdCliente;
    // End of variables declaration//GEN-END:variables
}
