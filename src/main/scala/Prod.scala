import scala.io.Source
import org.apache.kafka.clients.producer._
import java.util.Properties
import java.util.Timer


object Prod extends App {


  // Kafka initialization
  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  val producer = new KafkaProducer[String, String](props)
  val TOPIC="DangerousPeople"


    // Producer
    def Drone (lifetime : Int): Unit = {
        val path = "/Users/chenphilipe/Desktop/prod/scala-drones/data.csv"

        val send  = new java.util.TimerTask {
            def run() = {        
                Source.fromFile(path).getLines().drop(1).foreach {record => 
                    val iddrone = record.split(",") {0}
                    val dronebattery = record.split(",") {1}
                    val long = record.split(",") {2}
                    val lat = record.split(",") {3}
                    val fname = record.split(",") {4}
                    val lname= record.split(",") {5}
                    val isdangerous = record.split(",") {6}
                    Thread.sleep(500)

                    if (isdangerous == "true") 
                {       
                        println (s"Potential dangereous people detected by $iddrone !")
                        val detected = f"Drone number $iddrone (Battery : $dronebattery %%), $fname $lname is potentially dangerous. Position : ($lat, $long)"
                        val alerts = new ProducerRecord (TOPIC, detected)
                        producer.send(alerts)
                }
            }
        }
    }
        val step = new java.util.Timer()
        step.schedule(send, lifetime, lifetime)
    }
    Drone(1000)
}