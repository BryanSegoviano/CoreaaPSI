package presentacion;

import controles.ControlReglasNegocio;
import controles.Fachada;
import controles.IFachada;
import dominio.Relclientevehiculo;
import dominio.Vehiculo;
import java.util.List;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class DlgDetalleCliente extends javax.swing.JFrame {

    private int idCliente;
    private IFachada fachada;

    public DlgDetalleCliente(int idCliente) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.idCliente = idCliente;
        this.fachada = new Fachada();
        this.llenarTablaVehiculos(this.idCliente);
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
        setTitle("Lista de vehiculos");

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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addComponent(btnVolverDetalleCliente)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
        this.dispose();
    }//GEN-LAST:event_btnVolverDetalleClienteActionPerformed

    private void llenarTablaVehiculos(int idCliente) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaDetalleCliente.getModel();
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
        for (int i = 0; i < this.tablaDetalleCliente.getColumnCount(); i++) {
            this.tablaDetalleCliente.setDefaultRenderer(this.tablaDetalleCliente.getColumnClass(i), columna);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolverDetalleCliente;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaDetalleCliente;
    // End of variables declaration//GEN-END:variables
}
