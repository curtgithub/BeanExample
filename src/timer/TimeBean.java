/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 *
 * @author owner
 */
public class TimeBean implements Serializable {

   private long time;
   private PropertyChangeSupport pcs;

   public TimeBean() {
      this.time = 0l;
      this.pcs = new PropertyChangeSupport(this);
   }

   public long getTime() {
      return time;
   }

   public void setTime(long time) {
      pcs.firePropertyChange("time", this.time, time);
      this.time = time;
   }

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      pcs.addPropertyChangeListener(listener);
   }
}
