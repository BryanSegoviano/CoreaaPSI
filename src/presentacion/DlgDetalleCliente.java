package presentacion;

import controles.ControlReglasNegocio;
import controles.IFachada;
import dominio.Vehiculo;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class DlgDetalleCliente extends javax.swing.JFrame {

    private List<Vehiculo> listaVehiculosCliente;
    private ControlReglasNegocio controlReglasNegocio;
    private IFachada fachada;

    public DlgDetalleCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.llenaTablaVehiculosCliente();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDetalleCliente = new javax.swing.JTable();
        btnVolverDetalleCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Vehiculos del cliente");

        tablaDetalleCliente.setModel(new javax.swing.table.DefaultTableModel(
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

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaDetalleCliente);

        btnVolverDetalleCliente.setBackground(new java.awt.Color(51, 204, 0));
        btnVolverDetalleCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVolverDetalleCliente.setText("Volver");
        btnVolverDetalleCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverDetalleClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(btnVolverDetalleCliente)))
                        .addGap(0, 117, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVolverDetalleCliente)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverDetalleClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverDetalleClienteActionPerformed
        FrmConsultarCliente frmCliente = new FrmConsultarCliente();
        frmCliente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverDetalleClienteActionPerformed

    public void llenaTablaVehiculosCliente() {
        FrmConsultarCliente frmConsultarClientes = new FrmConsultarCliente();

        this.listaVehiculosCliente = this.controlReglasNegocio.recuperaVehiculoCliente(frmConsultarClientes.idClienteElegido());
        List<Vehiculo> listaClientes = this.fachada.buscarTodasVehiculo();
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaDetalleCliente.getModel();
        modeloTabla.setRowCount(0);
        for (Vehiculo vehiculo : listaClientes) {
            Object[] fila = new Object[3];
            fila[0] = vehiculo.getNombre();
            fila[1] = vehiculo.getMarca();
            fila[2] = vehiculo.getModelo();
            modeloTabla.addRow(fila);
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
            java.util.logging.Logger.getLogger(DlgDetalleCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgDetalleCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgDetalleCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgDetalleCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DlgDetalleCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolverDetalleCliente;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaDetalleCliente;
    // End of variables declaration//GEN-END:variables
}
