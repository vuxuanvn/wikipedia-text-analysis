import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object searchText {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder()
      .master("local[2]")
      .config("spark.executor.memory", "4G")
      .config("spark.driver.memory", "4G")
      .appName("Spark SQL basic example")
      .getOrCreate()

    val df = spark.read.json("test.json")

    df.printSchema()
    df.createGlobalTempView("wiki")

    val newFrame = df.select(df("title"),explode(df("section_texts")) as("text"))
    val report = newFrame.select("title").where(newFrame("text").contains("Hà Nội"))
    report.select("title").groupBy("title").count().select("title").orderBy(asc("title")).show(5)
  }
}