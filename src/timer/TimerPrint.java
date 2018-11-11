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

   public TimerPrint() {
      this.timeBean = new TimeBean();
   }

   @Override
   public void propertyChange(PropertyChangeEvent evt) {
      long time = this.timeBean.getTime();
      System.out.println("Time(ms) = " + time);
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
      long last = timerPrint.getTimeBean().getTime();

      while (true) {

         long time = System.currentTimeMillis();

         if ((time - last) > 1000) {
            timerPrint.getTimeBean().setTime(time);
            last = time;
         }

      }

   }

}
