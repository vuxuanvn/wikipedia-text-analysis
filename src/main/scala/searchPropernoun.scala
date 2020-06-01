import java.io.{File, PrintWriter}

import org.apache.spark.sql.{Column, SparkSession}

import scala.util.matching.Regex
import org.apache.spark.sql.functions._
import java.util.regex.Pattern


object searchPropernoun {
  def regexp_extractAll = udf((job: String, exp: String, groupIdx: Int) => {

    val regular : Regex = exp.r
    val matching = regular.findAllIn(job)
    var result = Set[String]()
    matching.foreach(x => result += x)
    result.mkString(",")
  })

  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder()
      .master("local[2]")
      .config("spark.executor.memory", "4G")
      .config("spark.driver.memory", "4G")
      .appName("Propernoun")
      .getOrCreate()

    val df = spark.read.json("test.json")

    val regex  = "([A-Z]|\\p{Lu})([a-z]|\\p{L})*( ([A-Z]|\\p{Lu})([a-z]|\\p{L})*)*"
    val text = df.select( df("section_texts"))
    val newDf = text.select(concat_ws("\n", col("section_texts"))as "raw_text")

    newDf.select("raw_text").show(false)
    val data = newDf.select(regexp_extractAll(newDf("raw_text"), lit(regex),lit(1)) as "properNoun")
    var properNoun : Set[String] = Set()
    data.select("properNoun").collect().foreach(x => x.toString().split(',').foreach(f => properNoun += f))
    
//    println(properNoun.size)
    val writer = new PrintWriter(new File("Result/search_propernouns.txt"))
    writer.write("Tìm kiếm các bài danh từ riêng(Chữ cái đầu tiên viết hoa) \n\n\n")
    properNoun.foreach(U => writer.write(U.replace("[","").replace("]","") + "\n"))
    writer.close()
  }
}
