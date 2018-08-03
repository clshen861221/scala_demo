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
    val imprDf = reader.csv("C:/Users/shhu6001/Downloads/data/2018-01-25/NORMAL/FB/2072,6.csv")
    val dmaDf = reader.csv("C:/Users/shhu6001/Downloads/data/STATIC_DATA/DESIGNATED_MARKET_AREA.csv").filter(col("DESIGNATED_MARKET_AREA_NAME") === "Beijing")
    val cmpgDf = reader.csv("C:/Users/shhu6001/Downloads/data/2018-01-25/METADATA/campaign.csv")

    import sparkSession.implicits._
    //    dmaDf.select("REPORTABLE_DESIGNATED_MARKET_AREA_ID","DESIGNATED_MARKET_AREA_NAME").show
    val result = imprDf.as("impr")
      .join(dmaDf.as("dma"), col("dma.REPORTABLE_DESIGNATED_MARKET_AREA_ID") === col("impr.DESIGNATED_MARKET_AREA_ID"))
      .join(cmpgDf, "CAMPAIGN_ID")
      .groupBy("CAMPAIGN_ID", "CAMPAIGN_NAME")
      .agg(sum("IMPRESSIONS").as("IMPRESSIONS"))
      .as[TestData]

    result.show()
    result.foreach(println(_))

  }

}

case class TestData(
  CAMPAIGN_ID:   String,
  CAMPAIGN_NAME: String,
  IMPRESSIONS:   Double)