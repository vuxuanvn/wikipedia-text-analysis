import java.io.{File, PrintWriter}

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object searchText {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder()
      .master("local[2]")
      .config("spark.executor.memory", "4G")
      .config("spark.driver.memory", "4G")
      .appName("Searching text")
      .getOrCreate()

    val df = spark.read.json("test.json")

    df.printSchema()
    df.createGlobalTempView("wiki")

    val newFrame = df.select(df("title"),explode(df("section_texts")) as("text"))
    val report = newFrame.select("title").where(newFrame("text").contains("Hà Nội"))
    report.select("title").groupBy("title").count().select("title").
      orderBy(asc("title"))
    val writer = new PrintWriter(new File("Result/search_text.txt"))
    writer.write("Tìm kiếm các bài viết có chứa cụm từ Hà Nội \n")
    report.groupBy("title").count().select("title").collect().foreach(U => writer.write(U  + "\n"))
    writer.close()
  }
}