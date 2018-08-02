package com.nielsen.scala_demo.problem

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object BJImpr {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:/study/Hadoop/hadoop-common-2.2.0-bin-master")
    val sparkSession = SparkSession.builder()
      .master("local")
      .appName("ImprCalculation")
      .getOrCreate()
    val reader = sparkSession.read.option("header", "true").option("sep", "|")

    val impr28Df = reader.csv("C:/Users/shhu6001/Downloads/data/2018-01-28/NORMAL/FB/*.csv")
    val impr25Df = reader.csv("C:/Users/shhu6001/Downloads/data/2018-01-25/NORMAL/FB/*.csv")

    import sparkSession.implicits._
    val result = impr28Df.as("impr_28")
                .groupBy("impr_28.PLACEMENT_ID")
                .agg(sum("impr_28.IMPRESSIONS").as("total_impr_28"))
                .as("total_28")
                .join(impr25Df.as("impr_25")
                      .groupBy("impr_25.PLACEMENT_ID")
                      .agg(sum("impr_25.IMPRESSIONS").as("total_impr_25"))
                      .as("total_25"), col("total_28.PLACEMENT_ID") === col("total_25.PLACEMENT_ID"))
                .where(col("total_28.total_impr_28") < (col("total_25.total_impr_25")+ 100000))
                .select("total_28.PLACEMENT_ID","total_28.total_impr_28","total_25.total_impr_25")
                .as[TestData]
    
    result.show()
//    result.foreach(println(_))

  }

}

case class TestData(
  PLACEMENT_ID:   String,
  total_impr_28: String,
  total_impr_25: String
  
//  ,
//  CAMPAIGN_NAME: String,
//  IMPRESSIONS:   Double
  )