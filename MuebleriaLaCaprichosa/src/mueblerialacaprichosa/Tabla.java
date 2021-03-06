/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblerialacaprichosa;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class Tabla extends javax.swing.JFrame {
    Arbol ArbolMuebles;
    
    //Creamos el modelo (columnas)
    DefaultTableModel modelo = new DefaultTableModel(null, new Object[]{"CR","DESCRIPCION","DISEÑADOR","FECHA","CATEGORIA","MODELO"});
    //Creamos la tabla
    JTable tabla = new JTable(modelo);
    //Creamos un scroll y le agregamos la tabla
    JScrollPane ScrollTabla = new JScrollPane(tabla);
        
    /**
     * Funcion Recursiva para Ordenar los datos INORDEN
     * @param H Hoja con la que empezamos a Ordenar los datos
     */
    public void Ordenar(Hoja H){
        //izq - raiz - der
        if(H != null){
            Ordenar(H.getPIzquierda());
            
            //Funcion para agregar una nueva fila a la tabla
            modelo.addRow(new Object[]{
                H.getObjetoAsignado().getCR(),
                H.getObjetoAsignado().getDescripcion(),
                H.getObjetoAsignado().getDiseñador(),
                H.getObjetoAsignado().getFechaR(),
                H.getObjetoAsignado().getCategoria(),
                H.getObjetoAsignado().getModelo()
            });
            
            Ordenar(H.getPDerecha());
        }
    }
    
    
    public Tabla(Arbol ArbolMuebles) {
        //Variable contenedora de la raiz del Arbol que recibimos como parametro
        Hoja H = ArbolMuebles.Raiz;
        
        //Asignamos un margen y tamaño de la Tabla y Scroll
        ScrollTabla.setBounds(0, 0, 500, 300);
        //Agrega ScrollTabla a la ventana
        add(ScrollTabla);
        //Mandamos llamar la funcion para Ordenar los datos
        Ordenar(H);
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cerrarBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Tabla de Muebles");
        setBackground(new java.awt.Color(102, 204, 255));
        setBounds(new java.awt.Rectangle(100, 100, 0, 0));
        setForeground(new java.awt.Color(51, 204, 255));
        setPreferredSize(new java.awt.Dimension(530, 430));
        setType(java.awt.Window.Type.POPUP);

        cerrarBtn.setText("Cerrar");
        cerrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("* Ordenado Alfabeticamente por Categoria");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cerrarBtn)
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(295, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(389, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cerrarBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarBtnActionPerformed
        
        //Cerramos la ventana
        this.setVisible(false);
    }//GEN-LAST:event_cerrarBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrarBtn;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
