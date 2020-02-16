/*
 * Initial Author
 *      Michael J. Lutz
 *
 * Other Contributers
 *
 * Acknowledgements
 */

/*
 * Class for a simple computer based weather station that reports the current
 * temperature (in Celsius) every second. The station is attached to a
 * sensor that reports the temperature as a 16-bit number (0 to 65535)
 * representing the Kelvin temperature to the nearest 1/100th of a degree.
 *
 * This class is implements Runnable so that it can be embedded in a Thread
 * which runs the periodic sensing.
 *
 * The class also extends Observable so that it can notify registered
 * objects whenever its state changes. Convenience functions are provided
 * to access the temperature in different schemes (Celsius, Kelvin, etc.)
 */
import java.util.Observable ;

public class WeatherStation extends Observable implements Runnable {

   private final KelvinTempSensor sensor ; // Temperature sensor.
   private final Barometer barometer;

   private final long PERIOD = 1000 ;      // 1 sec = 1000 ms
   private final int KTOC = -27315 ;       // Kelvin to Celsius conversion.

   private int currentReading ;
   private double currentPressure;

   /*
    * When a WeatherStation object is created, it in turn creates the sensor
    * object it will use.
    */
   public WeatherStation(ITempSensor isensor, IBarometer ibarometer) {
      sensor = isensor ;
      currentReading = sensor.reading() ;
      
      barometer = ibarometer;
      currentPressure = barometer.pressure();
   }
   
   
   /*
    * The "run" method called by the enclosing Thread object when started.
    * Repeatedly sleeps a second, acquires the current temperature from its
    * sensor, and notifies registered Observers of the change.
    */
   public void run() {
      while( true ) {
         try {
            Thread.sleep(PERIOD) ;
         } catch (Exception e) {}    // ignore exceptions
      
         /*
          * Get next reading and notify any Observers.
          */
         synchronized(this) {
            currentReading = sensor.reading() ;
         }
         
         synchronized(this) {
            currentPressure = barometer.pressure();
         }
         
         setChanged() ;
         notifyObservers() ;
      }
   }

   /*
    * Return the current reading in degrees celsius as a
    * double precision number.
    */
   public synchronized double getCelsius() {
      return (currentReading + KTOC) / 100.0 ;
   }

   /*
    * Return the current reading in degrees Kelvin as a
    * double precision number.
    */
   public synchronized double getKelvin() {
      return currentReading / 100.0 ;
   }
   
   
   public synchronized double getFahrenheit() {
      return currentReading / 100.0 * 1.8 - 459.67;
   }
   
   public synchronized double getInches(){
      return currentPressure;
   }
   
   public synchronized double getMillibars(){
      return currentPressure  * 33.864;
   }
   
   /*
    * Start the application.
    */
    public static void main(String[] args) {
      WeatherStation ws = new WeatherStation(new KelvinTempSensorAdapter(), new Barometer()) ;
      Thread thread = new Thread(ws) ;
      TextUI ui = new TextUI(ws) ;
      SwingUI sui = new SwingUI(ws);
   
      thread.start() ;
   }
}
