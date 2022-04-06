/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package presentacion;

import controles.ControlReglasNegocio;
import controles.Fachada;
import dominio.Pieza;
import dominio.Servicio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author dahir
 */
public class DlgDetalleServicio extends javax.swing.JDialog {

    private Servicio servicio;
    private Pieza pieza;
    private final Fachada fachada;
    private ControlReglasNegocio controlReglasNegocio;
    private List<Pieza> listaPiezas;
    private int cantidadPieza;

    public DlgDetalleServicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.fachada = new Fachada();
        this.controlReglasNegocio = new ControlReglasNegocio();
        this.listaPiezas = new ArrayList<>();
        this.llenarComboboxPiezas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        ConceptoTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbPieza = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cantidadTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        costoTF = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        existenciaTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        checkboxPieza = new javax.swing.JCheckBox();
        checkBoxPiezaNueva = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalles del servicio");
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Concepto:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Pieza:");

        cbPieza.setEnabled(false);
        cbPieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPiezaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Cantidad:");

        cantidadTF.setEnabled(false);
        cantidadTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadTFActionPerformed(evt);
            }
        });
        cantidadTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cantidadTFKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Costo:");

        costoTF.setName(""); // NOI18N
        costoTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                costoTFKeyReleased(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(0, 204, 0));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 51, 51));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        existenciaTF.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Existencia:");

        checkboxPieza.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkboxPieza.setText("¿Es una pieza?");
        checkboxPieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxPiezaActionPerformed(evt);
            }
        });

        checkBoxPiezaNueva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkBoxPiezaNueva.setText("¿Es pieza nueva?");
        checkBoxPiezaNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxPiezaNuevaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkboxPieza)
                                .addGap(60, 60, 60)
                                .addComponent(checkBoxPiezaNueva)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAgregar)
                                .addGap(69, 69, 69)
                                .addComponent(btnCancelar)))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ConceptoTF))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(34, 34, 34)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(costoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cantidadTF, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(41, 41, 41)
                                    .addComponent(cbPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(existenciaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 13, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxPieza)
                    .addComponent(checkBoxPiezaNueva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ConceptoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(existenciaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cantidadTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(costoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (this.validarCampos()) {
            this.agregar();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Debe ingresar el concepto y su costo.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void agregar() {
        String concepto = this.ConceptoTF.getText();
        String costo = this.costoTF.getText();
        Double costoConvertido = Double.parseDouble(costo);
        if (this.esPiezaNueva() || !this.esPieza()) {
            this.setServicio(new Servicio(new Date(), costoConvertido, concepto));

        } else {
            int cantidad = Integer.parseInt(this.cantidadTF.getText());
            Pieza piezaNueva = (Pieza) this.cbPieza.getSelectedItem();
            piezaNueva.setCantidad(cantidad);
            piezaNueva.setCosto(costoConvertido);
            this.setPieza(piezaNueva);

        }

        this.ConceptoTF.setText("");
        this.costoTF.setText("");
        this.dispose();

    }

    private boolean validarCampos() {
        String concepto = this.ConceptoTF.getText();
        String costo = this.costoTF.getText();
        if (this.esPieza()) {
            if (costo.equalsIgnoreCase("")) {
                return false;
            }
            if (this.isNumericDouble(costo) == false) {
                return false;
            }
        } else {
            if (concepto.equalsIgnoreCase("") || costo.equalsIgnoreCase("")) {
                return false;
            }

            if (this.isNumericDouble(costo) == false) {
                return false;
            }
        }

        return true;
    }

    private boolean isNumericDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException error) {
            return false;
        }
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbPiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPiezaActionPerformed
        this.cargarCantidadPieza();
    }//GEN-LAST:event_cbPiezaActionPerformed

    private void checkboxPiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxPiezaActionPerformed
        this.esPieza();
    }//GEN-LAST:event_checkboxPiezaActionPerformed

    private void costoTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costoTFKeyReleased

    }//GEN-LAST:event_costoTFKeyReleased

    private void cantidadTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadTFKeyReleased
        String cantidadSolicitada = cantidadTF.getText();
        boolean isNumeric = cantidadSolicitada.chars().allMatch(Character::isDigit);
        try {
            if (!isNumeric) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un numero",
                        "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                this.cantidadTF.setText("");
            } else {
                int cantidadSolicitadaInt = Integer.parseInt(cantidadSolicitada);
                if (cantidadSolicitadaInt > cantidadPieza) {
                    JOptionPane.showMessageDialog(this, "La cantidad solicitada es mayor a la que se tiene en existencia",
                            "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                    this.cantidadTF.setText("");
                }
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_cantidadTFKeyReleased

    private void checkBoxPiezaNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxPiezaNuevaActionPerformed
        esPiezaNueva();
    }//GEN-LAST:event_checkBoxPiezaNuevaActionPerformed

    private void cantidadTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadTFActionPerformed

    public boolean esPieza() {
        boolean esPieza = checkboxPieza.isSelected();
        if (esPieza) {
            this.ConceptoTF.setEnabled(false);
            this.cbPieza.setEnabled(true);
            this.cantidadTF.setEnabled(true);
            this.checkBoxPiezaNueva.setEnabled(true);
            return true;
        } else {
            this.ConceptoTF.setEnabled(true);
            this.cbPieza.setEnabled(false);
            this.cantidadTF.setEnabled(false);
            this.costoTF.setEnabled(true);
            this.checkBoxPiezaNueva.setEnabled(false);
            return false;
        }
    }

    public boolean esPiezaNueva() {
        boolean esPiezaInventario = checkBoxPiezaNueva.isSelected();
        if (esPiezaInventario) {
            this.cantidadTF.setEnabled(true);
            this.costoTF.setEnabled(true);
            this.ConceptoTF.setEnabled(true);
            this.cbPieza.setEnabled(false);
            return true;
        } else {
            this.ConceptoTF.setEnabled(false);
            this.cbPieza.setEnabled(true);
            return false;
        }
    }

    public Servicio getServicio() {
        return this.servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Pieza getPieza() {
        return this.pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }

    private void llenarComboboxPiezas() {
        this.listaPiezas = fachada.buscarTodasPieza();
        for (Pieza pieza : listaPiezas) {
            if (controlReglasNegocio.validaExistenciaPiezas(pieza.getIdpieza())) {
                this.cbPieza.addItem(pieza);
            }
        }
    }

    private void cargarCantidadPieza() {
        cantidadPieza = listaPiezas.get(this.cbPieza.getSelectedIndex()).getCantidad();
        String cantidadString = String.valueOf(cantidadPieza);
        this.existenciaTF.setText(cantidadString);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ConceptoTF;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField cantidadTF;
    private javax.swing.JComboBox<Pieza> cbPieza;
    private javax.swing.JCheckBox checkBoxPiezaNueva;
    private javax.swing.JCheckBox checkboxPieza;
    private javax.swing.JTextField costoTF;
    private javax.swing.JTextField existenciaTF;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
