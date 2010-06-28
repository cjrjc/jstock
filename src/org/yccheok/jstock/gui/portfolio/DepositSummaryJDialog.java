/*
 * JStock - Free Stock Market Software
 * Copyright (C) 2010 Yan Cheng CHEOK <yccheok@yahoo.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package org.yccheok.jstock.gui.portfolio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.MessageFormat;
import java.util.Arrays;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import org.yccheok.jstock.gui.JTableUtilities;
import org.yccheok.jstock.gui.MainFrame;
import org.yccheok.jstock.internationalization.GUIBundle;
import org.yccheok.jstock.portfolio.Commentable;
import org.yccheok.jstock.portfolio.DepositSummary;
import org.yccheok.jstock.portfolio.Utils;

/**
 *
 * @author yccheok
 */
public class DepositSummaryJDialog extends javax.swing.JDialog {

    /** Creates new form DepositSummaryJDialog */
    public DepositSummaryJDialog(java.awt.Frame parent, boolean modal, DepositSummary depositSummary) {
        super(parent, modal);
        // Clone another copy to avoid original copy from being corrupted.
        this.depositSummary = new DepositSummary(depositSummary);
        this.depositSummaryAfterPressingOK = null;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXHeader1 = new org.jdesktop.swingx.JXHeader();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/yccheok/jstock/data/gui"); // NOI18N
        setTitle(bundle.getString("DepositSummaryJDialog_CashDeposit")); // NOI18N
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));

        jXHeader1.setDescription(bundle.getString("DepositSummaryJDialog_Description")); // NOI18N
        jXHeader1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/32x32/money.png"))); // NOI18N
        jXHeader1.setTitle(bundle.getString("DepositSummaryJDialog_Deposit")); // NOI18N
        getContentPane().add(jXHeader1, java.awt.BorderLayout.PAGE_START);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16x16/apply.png"))); // NOI18N
        jButton1.setText(bundle.getString("DepositSummaryJDialog_OK")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16x16/button_cancel.png"))); // NOI18N
        jButton2.setText(bundle.getString("DepositSummaryJDialog_Cancel")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.BorderLayout(5, 5));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTable1.setModel(new DepositSummaryTableModel(this.depositSummary));
        org.yccheok.jstock.gui.table.CurrencyRenderer currencyRenderer = new org.yccheok.jstock.gui.table.CurrencyRenderer();
        currencyRenderer.setHorizontalAlignment(org.yccheok.jstock.gui.table.CurrencyRenderer.LEFT);
        jTable1.setDefaultEditor(Double.class, new org.yccheok.jstock.gui.table.NonNegativeEmptyDoubleEditor());
        jTable1.setDefaultRenderer(Double.class, currencyRenderer);
        // JTableCustomizer.setEditorForRow(jTable1, 1);
        // Do not use JTableCustomizer. We need to have our own implementation to decide 
        // row background color.
        JTableUtilities.setDateEditorAndRendererForRow(jTable1, 0);
        jTable1.setAutoCreateRowSorter(true);
        jTable1.addMouseListener(new TableRowPopupListener());
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16x16/filenew.png"))); // NOI18N
        jButton3.setText(bundle.getString("DepositSummaryJDialog_New")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16x16/editdelete.png"))); // NOI18N
        jButton4.setText(bundle.getString("DepositSummaryJDialog_Delete")); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(getDepositSummaryText());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel1, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-306)/2, (screenSize.height-373)/2, 306, 373);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        addNewDeposit();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        clearAllTablesSelection();
    }//GEN-LAST:event_formMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        deleteSelectedDeposit();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        if(KeyEvent.VK_DELETE == evt.getKeyCode()) {
            this.deleteSelectedDeposit();
            return;
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.depositSummaryAfterPressingOK = this.depositSummary;
        Utils.removeMeaninglessRecords(this.depositSummaryAfterPressingOK);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Returns deposit represented by this dialog.
     *
     * @return Deposit represented by this dialog
     */
    public DepositSummary getDepositSummary() {
        return this.depositSummary;
    }

    /**
     * Returns deposit represented by this dialog after OK button is pressed.
     * If OK button is not being pressed, <code>null</code> will be returned.
     *
     * @return Deposit represented by this dialog. <code>null</code> will be
     * returned if OK button is not being pressed
     */
    public DepositSummary getDepositSummaryAfterPressingOK() {
        return this.depositSummaryAfterPressingOK;
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.depositSummaryAfterPressingOK = null;
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
        // TODO add your handling code here:
        this.jLabel1.setText(this.getDepositSummaryText());
    }//GEN-LAST:event_jTable1PropertyChange

    private void addNewDeposit() {
        final int modelIndex = ((DepositSummaryTableModel)this.jTable1.getModel()).addNewDeposit();

        clearAllTablesSelection();

        final int selectedViewIndex = jTable1.getRowSorter().convertRowIndexToView(modelIndex);
        jTable1.getSelectionModel().setSelectionInterval(selectedViewIndex, selectedViewIndex);
        JTableUtilities.scrollToVisible(jTable1, selectedViewIndex, 0);
    }

    private void deleteSelectedDeposit() {
        int rows[] = jTable1.getSelectedRows();

        final DepositSummaryTableModel depositSummaryTableModel = (DepositSummaryTableModel)(jTable1.getModel());

        Arrays.sort(rows);

        for (int i = rows.length-1; i >= 0; i--) {
            int row = rows[i];

            if(row < 0) continue;

            final int modelIndex = jTable1.getRowSorter().convertRowIndexToModel(row);
            depositSummaryTableModel.removeRow(modelIndex);
        }
    }

    private void clearAllTablesSelection() {
        this.jTable1.getSelectionModel().clearSelection();
    }

    private String getSelectedSecondColumnString() {
        if (this.jTable1.getSelectedRowCount() != 1) {
            return null;
        }

        int viewIndex = this.jTable1.convertColumnIndexToView(1);
        String string = org.yccheok.jstock.portfolio.Utils.currencyNumberFormat(jTable1.getValueAt(jTable1.getSelectedRow(), viewIndex));
        return string;
    }

    private Commentable getSelectedCommentable() {
        if (this.jTable1.getSelectedRowCount() != 1) {
            return null;
        }

        int viewIndex = this.jTable1.getSelectedRow();
        int index = this.jTable1.convertRowIndexToModel(viewIndex);
        return ((DepositSummaryTableModel)jTable1.getModel()).getDeposit(index);
    }

    private void showCommentJDialog(Commentable commentable, String title) {
        if (commentable == null) {
            // Nothing to be shown.
            return;
        }

        final MainFrame mainFrame = MainFrame.getInstance();
        CommentJDialog commentJDialog = new CommentJDialog(mainFrame, true, commentable);
        commentJDialog.setTitle(title);
        commentJDialog.setLocationRelativeTo(this);
        commentJDialog.setVisible(true);
    }

    private JPopupMenu getMyJTablePopupMenu() {
        final JPopupMenu popup = new JPopupMenu();

        javax.swing.JMenuItem menuItem = new JMenuItem(java.util.ResourceBundle.getBundle("org/yccheok/jstock/data/gui").getString("DepositSummary_New"), new javax.swing.ImageIcon(getClass().getResource("/images/16x16/filenew.png")));

        menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addNewDeposit();
                }
        });

        popup.add(menuItem);

        final Commentable commentable = getSelectedCommentable();
        final String text = this.getSelectedSecondColumnString();
        if (commentable != null && text != null) {
            popup.addSeparator();

            menuItem = new JMenuItem(java.util.ResourceBundle.getBundle("org/yccheok/jstock/data/gui").getString("DepositSummary_Note..."), new javax.swing.ImageIcon(getClass().getResource("/images/16x16/sticky.png")));

            menuItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showCommentJDialog(commentable, MessageFormat.format(GUIBundle.getString("DepositSummaryJDialog_NoteFor"), text));
                    }
            });

            popup.add(menuItem);
        }

        if(jTable1.getSelectedRowCount() >= 1) {
            popup.addSeparator();

            menuItem = new JMenuItem(java.util.ResourceBundle.getBundle("org/yccheok/jstock/data/gui").getString("DELETE"), new javax.swing.ImageIcon(getClass().getResource("/images/16x16/editdelete.png")));

            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    deleteSelectedDeposit();
                }
            });

            popup.add(menuItem);
        }

        return popup;
    }

    private class TableRowPopupListener extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                getMyJTablePopupMenu().show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }

    private String getDepositSummaryText() {
        if (this.depositSummary != null) {
            return MessageFormat.format(GUIBundle.getString("DepositSummaryJDialog_TotalDepositIs"), org.yccheok.jstock.portfolio.Utils.currencyNumberFormat(this.depositSummary.getTotal()));
        }
        return "";
    }

    // Data structure hold by table.
    private DepositSummary depositSummary;
    // Final deposit result after pressing OK button.
    private DepositSummary depositSummaryAfterPressingOK = null;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private org.jdesktop.swingx.JXHeader jXHeader1;
    // End of variables declaration//GEN-END:variables

}
