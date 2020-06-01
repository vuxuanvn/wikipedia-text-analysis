import java.io.{File, PrintWriter}

import org.apache.commons.lang.StringEscapeUtils
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object searchInterlink {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder().master("local[4]")
      .appName("Searching article")
      .getOrCreate()

    var path = "interlink.json"
    val rdd = spark.sparkContext.textFile(path)

    val str = ", \"Hà Nội\""

    val writer = new PrintWriter(new File("Result/Articles_contain_link.txt"))
    writer.write("Tìm kiếm các bài viết có chứa liên kết đến bài viết Hà Nội\n")
    val newrdd = rdd.filter(x => StringEscapeUtils.unescapeJava(x).contains(str)).
      map(S => S.split(",", 2)(0))
    newrdd.collect().toSeq.foreach(U => writer.write(StringEscapeUtils.unescapeJava(U)  + "\n"))
    writer.close()
  }
}