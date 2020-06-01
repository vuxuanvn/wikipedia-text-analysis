import java.io.{File, PrintWriter}

import org.apache.spark.sql.SparkSession
import org.apache.commons.lang.StringEscapeUtils

object findAllArticle {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder().master("local[4]")
      .appName("Find all article")
      .getOrCreate()

    var path = "interlink.json"
    val file = spark.sparkContext.textFile(path)

    val xx= "\"title\": \"Việt Nam\""
    val newrdd = file.filter(x => StringEscapeUtils.unescapeJava(x).contains(xx))

    println(newrdd.count())

    val listLink = newrdd.map(S => S.split(",", 2)(1))
    val result = listLink.collect().map(x => x.slice(x.indexOf("{") + 1, x.indexOf("}"))).flatMap(c => c.split(','))
    val writer = new PrintWriter(new File("Result/search_innerArticle.txt"))
    writer.write("Tìm kiếm các bài viết có chứa cụm từ Hà Nội \nĐường dẫn\t: Tên bài viết\n")
    result.foreach(U => writer.write(StringEscapeUtils.unescapeJava(U) + "\n"))
    writer.close()
  }
}
