/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author owner
 */
public class TimerPrint implements PropertyChangeListener {

   private TimeBean timeBean;
   private long last;

   public TimerPrint() {
      this.timeBean = new TimeBean();
      this.last = this.timeBean.getTime();
   }

   @Override
   public void propertyChange(PropertyChangeEvent evt) {
      long time = this.timeBean.getTime();
      if ((time - this.last) > 1000) {
         System.out.println("Time(ms) = " + time);
         this.last = time;
      }
   }

   public TimeBean getTimeBean() {
      return timeBean;
   }

   public void setTimeBean(TimeBean timeBean) {
      this.timeBean = timeBean;
   }

   public static void main(String[] args) {

      TimerPrint timerPrint = new TimerPrint();
      timerPrint.getTimeBean().addPropertyChangeListener(timerPrint);
      while (true) {
         timerPrint.getTimeBean().setTime(System.currentTimeMillis());
      }

   }

}
