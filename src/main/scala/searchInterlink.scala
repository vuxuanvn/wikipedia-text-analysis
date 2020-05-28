import org.apache.commons.lang.StringEscapeUtils
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object searchInterlink {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder().master("local[4]")
      .appName("Spark SQL basic example")
      .getOrCreate()

    var path = "interlink.json"
    val rdd = spark.sparkContext.textFile(path)

    val xx = ", \"Hà Nội\""

    val newrdd = rdd.filter(x => StringEscapeUtils.unescapeJava(x).contains(xx)).
      map(S => S.split(",", 2)(0)).foreach(U => println(StringEscapeUtils.unescapeJava(U)))

  }
}