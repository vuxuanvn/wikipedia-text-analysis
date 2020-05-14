import org.apache.spark.sql.SparkSession
import org.apache.commons.lang.StringEscapeUtils

object regular {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder().master("local[4]")
      .appName("Spark SQL basic example")
      .getOrCreate()

    var path = "interlink.json"
    val file = spark.sparkContext.textFile(path)

//    val Reg = """.*\{.*\}""".r
//    val Records = file.filter(x => {
//      (Reg.pattern.matcher(x).matches)
//    })
    val xx= "\"title\": \"Hà Nội\""
    val newrdd = file.filter(x => StringEscapeUtils.unescapeJava(x).contains(xx))

    println(newrdd.count())

//    newrdd.foreach(U => println(U))
    val listLink = newrdd.map(S => S.split(",", 2)(1))
    listLink.collect().map(x => x.slice(x.indexOf("{") + 1, x.indexOf("}"))).flatMap(c => c.split(',')).foreach(U => println(StringEscapeUtils.unescapeJava(U)))
//    val badSingleRecords = fileRDD.filter(x => !(singleReg.pattern.matcher(x(1)).matches))
//    val validSingle = validSingleRecords.map(x => (x(0),x(1),x(2)))
//    val badSingle = badSingleRecords.map(x => (x(0),x(1),x(2)))


  }
}
