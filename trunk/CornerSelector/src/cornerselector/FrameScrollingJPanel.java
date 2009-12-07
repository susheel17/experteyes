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
 * A frame play control.  !!!IMPORTANT!!! The class assume that the first frame is 1.
 * Created on September 10, 2007, 9:27 AM
 */
package cornerselector;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author  eeglab
 */
public class FrameScrollingJPanel extends javax.swing.JPanel
        implements FrameControlInterface {

    @Override
    public void requestFocus() {
        this.frameViewSlider.requestFocus();
    }

    @Override
    public synchronized void addKeyListener(KeyListener l) {
        super.addKeyListener(l);
        this.frameViewSlider.addKeyListener(l);
    }

    /** Creates new form FrameScrollingJPanel */
    public FrameScrollingJPanel() {
        initComponents();
    }
    /**
     * Frame change property name.  The Integer class is the value used
     */
    public static final String CURRENT_FRAME_CHANGE = "currentFrame";
    /**
     * Speed change property name. The Integer class is the value used
     */
    public static final String SPEED_CHANGE = "speed";
    private int firstFrameNumber = 1;
    /** This represent the maximum when taking frame skip into account */
    private int totalFrame = 1;
    private int frameRate = 1;
    /**
     * Holds value of property currentFrame.
     */
    private int currentFrame = 1;
    // For setting frame number in all interface to display correctly

    public void setFirstFrameNumber(int firstFrameNumber) {
        this.firstFrameNumber = firstFrameNumber;
        this.currentFrame = 0; // To triggger change
        setCurrentFrame(1);
    }

    public int getTotalFrame() {
        return this.frameViewSlider.getMaximum();
    }

    public void setTotalFrame(int totalFrame) {
        // Cap total frame for sanity
        totalFrame = Math.max(1, totalFrame);
        frameViewSlider.setMaximum(totalFrame);

        this.totalFrame = totalFrame;

        // Cap current frame to total frame if the current is larger
        if (this.getCurrentFrame() > totalFrame) {
            setCurrentFrame(totalFrame);
        }
    }

    void setFrameRate(int frameRate) {
        this.frameRate = frameRate;
        /* Reset total frame to match frame skip, don't use totalFrame since
         * it may not be a real maximum.  
         */
        setTotalFrame(this.frameViewSlider.getMaximum());
        this.frameViewSlider.setMinorTickSpacing(frameRate);
        this.frameViewSlider.setMajorTickSpacing(frameRate);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        frameNumberTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        frameViewSlider = new javax.swing.JSlider();

        jLabel1.setText("Frame");
        jLabel1.setFocusable(false);

        frameNumberTextField.setText("1");
        frameNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frameNumberTextFieldActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        frameViewSlider.setMinimum(1);
        frameViewSlider.setSnapToTicks(true);
        frameViewSlider.setMaximum(totalFrame);
        frameViewSlider.setValue(1);
        frameViewSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                frameViewSliderStateChanged(evt);
            }
        });
        frameViewSlider.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                frameViewSliderKeyPressed(evt);
            }
        });
        frameViewSlider.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                frameViewSliderMouseWheelMoved(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(frameViewSlider, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(frameViewSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(frameNumberTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                .add(jLabel1)
                .add(frameNumberTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void frameNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frameNumberTextFieldActionPerformed
        frameViewSlider.setValue(Integer.parseInt(frameNumberTextField.getText()) - this.firstFrameNumber);
    }//GEN-LAST:event_frameNumberTextFieldActionPerformed

    private void frameViewSliderMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_frameViewSliderMouseWheelMoved
        frameViewSlider.setValue(frameViewSlider.getValue() -
                evt.getWheelRotation() * this.frameRate);
    }//GEN-LAST:event_frameViewSliderMouseWheelMoved

    private void frameViewSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_frameViewSliderStateChanged
        // Only trigger all changes when the value is skip properly
        int frame = frameViewSlider.getValue();
        if ((frame -1) % frameRate == 0) {
            setCurrentFrame(frame);
        }
    }//GEN-LAST:event_frameViewSliderStateChanged

private void frameViewSliderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_frameViewSliderKeyPressed
    switch (evt.getKeyCode()) {
        case KeyEvent.VK_LEFT:
        case KeyEvent.VK_UP:
            frameViewSlider.setValue(frameViewSlider.getValue() - this.frameRate);
            break;
        case KeyEvent.VK_RIGHT:
        case KeyEvent.VK_DOWN:
            frameViewSlider.setValue(frameViewSlider.getValue() + this.frameRate);
            break;
    }
    evt.consume();
}//GEN-LAST:event_frameViewSliderKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField frameNumberTextField;
    private javax.swing.JSlider frameViewSlider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    /**
     * Getter for property currentFrame.
     * @return Value of property currentFrame.
     */
    public int getCurrentFrame() {
        return this.currentFrame;
    }

    /**
     * Setter for property currentFrame. This current frame is relative to 
     * the firstFrameNumber.  So 1 = firstFrameNumber
     * @param currentFrame New value of property currentFrame must be > 0.
     */
    public void setCurrentFrame(int currentFrame) {
        // Only response when there is a change
        if (this.currentFrame != currentFrame) {
            // Cap the frame
            if (currentFrame > totalFrame) {
                currentFrame = totalFrame;
            }
            if (currentFrame < 1) {
                currentFrame = 1;
            }
            int oldCurrentFrame = this.currentFrame;
            this.currentFrame = currentFrame;

            frameNumberTextField.setText(String.valueOf(currentFrame));

            firePropertyChange(CURRENT_FRAME_CHANGE,
                    new Integer(oldCurrentFrame),
                    new Integer(currentFrame));
        }
    }

    public int getFrameRate() {
        return this.frameRate;
    }
}
