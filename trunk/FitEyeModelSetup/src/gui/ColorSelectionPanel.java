/*
 * Copyright (c) 2009 by Thomas Busey and Ruj Akavipat
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the Experteyes nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Thomas Busey and Ruj Akavipat ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Thomas Busey and Ruj Akavipat BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
/*
 * ColorSelectionPanel.java
 *
 * Created on April 9, 2008, 8:09 PM
 */
package gui;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author  SQ
 */
public class ColorSelectionPanel extends javax.swing.JPanel
        implements ColorCaptureListener {

    private boolean dirty = false;
    private static final int DEFAULT_SIGMA = 11;
    private static final double DEFAULT_SHARPENINGFACTOR = 0.9;

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }
    private int sigma = 0;
    private double sharpeningFactor = 0d;
    public static int SIGMA_MAX = 40;
    public static double SHARPENINGFACTOR_MAX = 5d;
    public static String SIGMA_SLIDER_NAME = "sigma";
    public static String SHARPENINGFACTOR_SLIDER_NAME = "sharpeningfactor";
    private boolean blockSliderChange = false;

    /** Creates new form ColorSelectionPanel */
    public ColorSelectionPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        autoTestModelCheckBox = new javax.swing.JCheckBox();
        detectPupilAngleCheckBox = new javax.swing.JCheckBox();
        crIsCircleCheckBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pupilGrayLevelSlider = new javax.swing.JSlider();
        pupilColorTextField = new javax.swing.JTextField();
        pupilDropperToggleButton = new javax.swing.JToggleButton();
        crlGrayLevelSlider = new javax.swing.JSlider();
        crColorTextField = new javax.swing.JTextField();
        crDropperToggleButton = new javax.swing.JToggleButton();
        backgroundGrayLevelSlider = new javax.swing.JSlider();
        backgroundColorTextField = new javax.swing.JTextField();
        backgroundDropperToggleButton = new javax.swing.JToggleButton();
        pupilColorHighlightedCheckBox = new javax.swing.JCheckBox();
        crColorHighlightedCheckBox = new javax.swing.JCheckBox();
        unsharpCheckBox = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sharpeningFactorSlider = new javax.swing.JSlider();
        sigmaSlider = new javax.swing.JSlider();
        sigmaTextField = new javax.swing.JTextField();
        shaprningFactorTextField = new javax.swing.JTextField();

        autoTestModelCheckBox.setText("Automatically Test Model");

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("resources/ColorSelectionPanel"); // NOI18N
        detectPupilAngleCheckBox.setText(bundle.getString("Detect Pupil Angle")); // NOI18N

        crIsCircleCheckBox.setText(bundle.getString("CR is circle")); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(5, 5, 5)
                .add(autoTestModelCheckBox)
                .add(5, 5, 5)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(crIsCircleCheckBox)
                    .add(detectPupilAngleCheckBox)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(5, 5, 5)
                        .add(autoTestModelCheckBox))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(5, 5, 5)
                        .add(detectPupilAngleCheckBox)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(crIsCircleCheckBox)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Pupil Gray Level:"); // NOI18N

        jLabel2.setText("Cornia Reflection Gray Level:"); // NOI18N

        jLabel3.setText("Background Grey Level:"); // NOI18N

        pupilGrayLevelSlider.setMajorTickSpacing(30);
        pupilGrayLevelSlider.setMaximum(255);
        pupilGrayLevelSlider.setMinorTickSpacing(10);
        pupilGrayLevelSlider.setValue(126);
        pupilGrayLevelSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pupilGrayLevelSliderStateChanged(evt);
            }
        });

        pupilColorTextField.setBackground(new java.awt.Color(126, 126, 126));
        pupilColorTextField.setEditable(false);

        pupilDropperToggleButton.setText("Dropper"); // NOI18N
        pupilDropperToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pupilDropperToggleButtonActionPerformed(evt);
            }
        });

        crlGrayLevelSlider.setMajorTickSpacing(30);
        crlGrayLevelSlider.setMaximum(255);
        crlGrayLevelSlider.setMinorTickSpacing(10);
        crlGrayLevelSlider.setValue(126);
        crlGrayLevelSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                crlGrayLevelSliderStateChanged(evt);
            }
        });

        crColorTextField.setBackground(new java.awt.Color(126, 126, 126));
        crColorTextField.setEditable(false);

        crDropperToggleButton.setText("Dropper"); // NOI18N
        crDropperToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crDropperToggleButtonActionPerformed(evt);
            }
        });

        backgroundGrayLevelSlider.setMajorTickSpacing(30);
        backgroundGrayLevelSlider.setMaximum(255);
        backgroundGrayLevelSlider.setMinorTickSpacing(10);
        backgroundGrayLevelSlider.setValue(126);
        backgroundGrayLevelSlider.setPreferredSize(new java.awt.Dimension(100, 24));
        backgroundGrayLevelSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                backgroundGrayLevelSliderStateChanged(evt);
            }
        });

        backgroundColorTextField.setBackground(new java.awt.Color(126, 126, 126));
        backgroundColorTextField.setEditable(false);

        backgroundDropperToggleButton.setText("Dropper"); // NOI18N
        backgroundDropperToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backgroundDropperToggleButtonActionPerformed(evt);
            }
        });

        pupilColorHighlightedCheckBox.setForeground(new java.awt.Color(51, 153, 0));
        pupilColorHighlightedCheckBox.setText("Highlight"); // NOI18N

        crColorHighlightedCheckBox.setForeground(new java.awt.Color(255, 102, 0));
        crColorHighlightedCheckBox.setText("Highlight"); // NOI18N

        unsharpCheckBox.setText("Unsharpen");
        unsharpCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unsharpCheckBoxActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 58));

        jLabel4.setText("Radius:");

        jLabel5.setText("Sharpening:");

        sharpeningFactorSlider.setMaximum(200);
        sharpeningFactorSlider.setValue(0);
        sharpeningFactorSlider.setEnabled(false);
        sharpeningFactorSlider.setMinimumSize(new java.awt.Dimension(10, 29));
        sharpeningFactorSlider.setName(SHARPENINGFACTOR_SLIDER_NAME);
        sharpeningFactorSlider.setPreferredSize(new java.awt.Dimension(100, 24));
        sharpeningFactorSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sharpeningFactorSliderStateChanged(evt);
            }
        });

        sigmaSlider.setMaximum(SIGMA_MAX);
        sigmaSlider.setValue(0);
        sigmaSlider.setEnabled(false);
        sigmaSlider.setMinimumSize(new java.awt.Dimension(10, 29));
        sigmaSlider.setName(SIGMA_SLIDER_NAME);
        sigmaSlider.setPreferredSize(new java.awt.Dimension(100, 24));
        sigmaSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sigmaSliderStateChanged(evt);
            }
        });

        sigmaTextField.setText("0");
        sigmaTextField.setEnabled(false);
        sigmaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sigmaTextFieldActionPerformed(evt);
            }
        });

        shaprningFactorTextField.setText("0");
        shaprningFactorTextField.setEnabled(false);
        shaprningFactorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shaprningFactorTextFieldActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel4)
                    .add(jLabel5))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(sharpeningFactorSlider, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .add(sigmaSlider, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(sigmaTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(shaprningFactorTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(sigmaTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(sigmaSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(shaprningFactorTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(sharpeningFactorSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );

        sigmaSlider.getAccessibleContext().setAccessibleName("");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, pupilGrayLevelSlider, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, crlGrayLevelSlider, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, backgroundGrayLevelSlider, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 81, Short.MAX_VALUE)
                        .add(pupilColorHighlightedCheckBox)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(pupilColorTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(pupilDropperToggleButton))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .add(jLabel3)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 136, Short.MAX_VALUE)
                                .add(backgroundColorTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(jLabel2)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(crColorHighlightedCheckBox)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(crColorTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(backgroundDropperToggleButton)
                            .add(crDropperToggleButton)))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, unsharpCheckBox)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pupilDropperToggleButton)
                    .add(pupilColorTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pupilColorHighlightedCheckBox))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pupilGrayLevelSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(crDropperToggleButton)
                    .add(crColorTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(crColorHighlightedCheckBox))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(crlGrayLevelSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(backgroundDropperToggleButton)
                        .add(backgroundColorTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(backgroundGrayLevelSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(unsharpCheckBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void pupilGrayLevelSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pupilGrayLevelSliderStateChanged
        int grayValue = pupilGrayLevelSlider.getValue();

        // Set the label color accordingly
        this.pupilColorTextField.setBackground(new Color(
                grayValue, grayValue, grayValue));

        // Mark data as dirty
        this.dirty = true;
    }//GEN-LAST:event_pupilGrayLevelSliderStateChanged

    private void crlGrayLevelSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_crlGrayLevelSliderStateChanged
        int grayValue = crlGrayLevelSlider.getValue();

        // Set the label color accordingly
        this.crColorTextField.setBackground(new Color(
                grayValue, grayValue, grayValue));

        // Mark data as dirty
        this.dirty = true;
    }//GEN-LAST:event_crlGrayLevelSliderStateChanged

    private void backgroundGrayLevelSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_backgroundGrayLevelSliderStateChanged
        int grayValue = backgroundGrayLevelSlider.getValue();

        // Set the label color accordingly
        this.backgroundColorTextField.setBackground(new Color(
                grayValue, grayValue, grayValue));

        // Mark data as dirty
        this.dirty = true;
    }//GEN-LAST:event_backgroundGrayLevelSliderStateChanged

    private void pupilDropperToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pupilDropperToggleButtonActionPerformed
        crDropperToggleButton.setSelected(false);
        backgroundDropperToggleButton.setSelected(false);
    }//GEN-LAST:event_pupilDropperToggleButtonActionPerformed

    private void crDropperToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crDropperToggleButtonActionPerformed
        backgroundDropperToggleButton.setSelected(false);
        pupilDropperToggleButton.setSelected(false);
    }//GEN-LAST:event_crDropperToggleButtonActionPerformed

    private void backgroundDropperToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backgroundDropperToggleButtonActionPerformed
        crDropperToggleButton.setSelected(false);
        pupilDropperToggleButton.setSelected(false);
    }//GEN-LAST:event_backgroundDropperToggleButtonActionPerformed

    private void sigmaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sigmaTextFieldActionPerformed
        // Set value in slider
        try {
            int v = (int) Double.parseDouble(this.sigmaTextField.getText());
            // Cap value
            setSigmaSlider(v);
        } catch (NumberFormatException numberFormatException) {
        }
        this.sigmaTextField.setText(String.valueOf(this.sigma));
    }//GEN-LAST:event_sigmaTextFieldActionPerformed

    private void shaprningFactorTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shaprningFactorTextFieldActionPerformed

        // Set value in slider
        try {
            int oldSliderValue = this.sharpeningFactorSlider.getValue();

            double v = Double.parseDouble(this.shaprningFactorTextField.getText());
            setSharpeningFactor(v);

            if (oldSliderValue == this.sharpeningFactorSlider.getValue()) {
                // Trigger change
                ChangeListener[] l =
                        this.sharpeningFactorSlider.getChangeListeners();
                ChangeEvent e = new ChangeEvent(this.sharpeningFactorSlider);
                for (int i = 0; i < l.length; i++) {
                    l[i].stateChanged(e);
                }
            }

        } catch (NumberFormatException numberFormatException) {
            this.shaprningFactorTextField.setText(
                    String.valueOf(this.sharpeningFactor));
        }
    }//GEN-LAST:event_shaprningFactorTextFieldActionPerformed

    private void sigmaSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sigmaSliderStateChanged
        if (this.blockSliderChange) {
            this.blockSliderChange = false;
        } else {
            int v = this.sigmaSlider.getValue();
            // change the text in text field
            this.sigmaTextField.setText(String.valueOf(v));
            this.sigma = v;
        }
        // Mark data as dirty
        this.dirty = true;
    }//GEN-LAST:event_sigmaSliderStateChanged

    private void sharpeningFactorSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sharpeningFactorSliderStateChanged
        if (this.blockSliderChange) {
            this.blockSliderChange = false;
        } else {
            double v = (double) this.sharpeningFactorSlider.getValue();
            if (v > 100) {
                // Do linear from 100
                v = 1d + (v - 100d) * (SHARPENINGFACTOR_MAX - 1) / 100;
            } else {
                v = v / 100d;
            }

            // change the text in text field
            this.shaprningFactorTextField.setText(String.valueOf(v));
            this.sharpeningFactor = v;
        }
        // Mark data as dirty
        this.dirty = true;
    }//GEN-LAST:event_sharpeningFactorSliderStateChanged

private void unsharpCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unsharpCheckBoxActionPerformed
    boolean enable = this.unsharpCheckBox.isSelected();
    setUnshrapenConfigEnable(enable);
    if (enable) {
        // Set default values
        setSigma(DEFAULT_SIGMA);
        setSharpeningFactor(DEFAULT_SHARPENINGFACTOR);
    }

    // Trigger change
    ChangeListener[] l =
            this.sharpeningFactorSlider.getChangeListeners();
    ChangeEvent e = new ChangeEvent(this.sharpeningFactorSlider);
    for (int i = 0; i < l.length; i++) {
        l[i].stateChanged(e);
    }
}//GEN-LAST:event_unsharpCheckBoxActionPerformed

    private void setUnshrapenConfigEnable(boolean enable) {
        this.shaprningFactorTextField.setEnabled(enable);
        this.sharpeningFactorSlider.setEnabled(enable);
        this.sigmaSlider.setEnabled(enable);
        this.sigmaTextField.setEnabled(enable);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox autoTestModelCheckBox;
    private javax.swing.JTextField backgroundColorTextField;
    private javax.swing.JToggleButton backgroundDropperToggleButton;
    private javax.swing.JSlider backgroundGrayLevelSlider;
    private javax.swing.JCheckBox crColorHighlightedCheckBox;
    private javax.swing.JTextField crColorTextField;
    private javax.swing.JToggleButton crDropperToggleButton;
    private javax.swing.JCheckBox crIsCircleCheckBox;
    private javax.swing.JSlider crlGrayLevelSlider;
    private javax.swing.JCheckBox detectPupilAngleCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JCheckBox pupilColorHighlightedCheckBox;
    private javax.swing.JTextField pupilColorTextField;
    private javax.swing.JToggleButton pupilDropperToggleButton;
    private javax.swing.JSlider pupilGrayLevelSlider;
    private javax.swing.JTextField shaprningFactorTextField;
    private javax.swing.JSlider sharpeningFactorSlider;
    private javax.swing.JSlider sigmaSlider;
    private javax.swing.JTextField sigmaTextField;
    private javax.swing.JCheckBox unsharpCheckBox;
    // End of variables declaration//GEN-END:variables

    public void addDropperActionListener(ActionListener listener) {
        pupilDropperToggleButton.addActionListener(listener);
        crDropperToggleButton.addActionListener(listener);
        backgroundDropperToggleButton.addActionListener(listener);
    }

    public void setPupilGrayValue(int grayValue) {
        this.pupilGrayLevelSlider.setValue(grayValue);
    }

    public void setCRGrayValue(int grayValue) {
        this.crlGrayLevelSlider.setValue(grayValue);
    }

    public void setBackgroundGrayValue(int grayValue) {
        this.backgroundGrayLevelSlider.setValue(grayValue);
    }

    public int getPupilGrayValue() {
        return this.pupilGrayLevelSlider.getValue();
    }

    public int getCRGrayValue() {
        return this.crlGrayLevelSlider.getValue();
    }

    public int getBackgroundGrayValue() {
        return this.backgroundGrayLevelSlider.getValue();
    }

    public void setColor(int grayValue) {
        if (this.pupilDropperToggleButton.isSelected()) {
            setPupilGrayValue(grayValue);
        }
        if (this.crDropperToggleButton.isSelected()) {
            setCRGrayValue(grayValue);
        }
        if (this.backgroundDropperToggleButton.isSelected()) {
            setBackgroundGrayValue(grayValue);
        }
    }

    public boolean isDropperSelected() {
        return this.pupilDropperToggleButton.isSelected() ||
                this.crDropperToggleButton.isSelected() ||
                this.backgroundDropperToggleButton.isSelected();
    }

    /**
     * Add listener to the action on Auto Test Model check box
     */
    public void addAutoTestModelCheckBoxActionListener(ActionListener listener) {
        this.autoTestModelCheckBox.addActionListener(listener);
    }

    public void addSliderChangeListener(ChangeListener listener) {
        this.pupilGrayLevelSlider.addChangeListener(listener);
        this.crlGrayLevelSlider.addChangeListener(listener);
        this.backgroundGrayLevelSlider.addChangeListener(listener);
        this.sigmaSlider.addChangeListener(listener);
        this.sharpeningFactorSlider.addChangeListener(listener);
    }

    public void addHighlightCheckBoxActionListener(ActionListener listener) {
        this.pupilColorHighlightedCheckBox.addActionListener(listener);
        this.crColorHighlightedCheckBox.addActionListener(listener);
    }

    public void addDetectPupilAngleChangeListener(ChangeListener listener) {
        this.detectPupilAngleCheckBox.addChangeListener(listener);
    }

    public void addCRIsCircleChangeListener(ChangeListener listener) {
        this.crIsCircleCheckBox.addChangeListener(listener);
    }

    public boolean isAutoTestModelSelected() {
        return this.autoTestModelCheckBox.isSelected();
    }

    public boolean isPupilColorHeighlighted() {
        return this.pupilColorHighlightedCheckBox.isSelected();
    }

    public boolean isCRColorHeighlighted() {
        return this.crColorHighlightedCheckBox.isSelected();
    }

    public boolean isDetectingPupilAngle() {
        return this.detectPupilAngleCheckBox.isSelected();
    }

    public void setDetectPupilAngle(boolean b) {
        this.detectPupilAngleCheckBox.setSelected(b);
    }

    public boolean isCRIsCircle() {
        return this.crIsCircleCheckBox.isSelected();
    }

    public void setCRIsCircle(boolean b) {
        this.crIsCircleCheckBox.setSelected(b);
    }

    public void unselectAllDropperButtons() {
        this.backgroundDropperToggleButton.setSelected(false);
        this.crDropperToggleButton.setSelected(false);
        this.pupilDropperToggleButton.setSelected(false);
    }

    public int getSigma() {
        if (this.unsharpCheckBox.isSelected()) {
            return sigma;
        } else {
            return 0;
        }
    }

    /** 
     * Setting value will enable unsharp config.
     */
    public void setSigma(int sigma) {
        setSigmaSlider(sigma);
        if (sigma > 0) {
            this.unsharpCheckBox.setSelected(true);
            setUnshrapenConfigEnable(true);
        }else{
            // Turn unsharpen off
            this.unsharpCheckBox.setSelected(false);
            setUnshrapenConfigEnable(false);
        }
        this.sigmaTextField.setText(String.valueOf(sigma));
    }

    public double getSharpeningFactor() {
        if (this.unsharpCheckBox.isSelected()) {
            return sharpeningFactor;
        } else {
            return 0;
        }

    }

    /** Setting value will not change enable/disable state of  unsharp config */
    public void setSharpeningFactor(double sharpeningFactor) {
        setSharpeningFactorSlider(sharpeningFactor);
        this.shaprningFactorTextField.setText(String.valueOf(this.sharpeningFactor));
        //this.unsharpCheckBox.setSelected(true);
        //setUnshrapenConfigEnable(true);
    }
    
    private void setSigmaSlider(int v) {
        v = Math.max(v, 0);
        v = Math.min(v, SIGMA_MAX);
        this.blockSliderChange = true;
        this.sigma = v;
        this.sigmaSlider.setValue(v);
    }

    private void setSharpeningFactorSlider(double v) {
        // Cap value
        v = Math.max(v, 0d);
        v = Math.min(v, SHARPENINGFACTOR_MAX);
        int sliderV;
        if (v > 1d) {
            sliderV = (int) ((v - 1d) / (SHARPENINGFACTOR_MAX - 1) * 100 + 100);
        } else {
            sliderV = (int) (v * 100);
        }

        this.sharpeningFactor = v;
        this.blockSliderChange = true;
        this.sharpeningFactorSlider.setValue(sliderV);
    }
}
