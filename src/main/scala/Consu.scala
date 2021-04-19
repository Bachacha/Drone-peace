import scala.io.Source
import java.util.Properties
import java.util.Timer
import java.util
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.consumer.ConsumerConfig
import scala.collection.JavaConverters._
import java.io._


object Consumer extends App {


  val TOPIC="DangerousPeople"

  val  props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("group.id", "consumergroup")
  props.put("auto.offset.reset", "latest")

  val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](props)
  consumer.subscribe(util.Collections.singletonList(TOPIC))

  def ReadInfo(lifetime: Int): Unit =  {
    def run(){
        println ("Drone searching new data.../n")
        val alert = consumer.poll(100)
        alert.asScala.foreach{
            alert =>println(alert.value())
        }
    }
    println ("End of searching.../n")
    ReadInfo(3000)
}
}