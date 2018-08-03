package com.nielsen.scala_demo.problem

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object CalculatePlacement {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:/study/Hadoop/hadoop-common-2.2.0-bin-master")
    val sparkSession = SparkSession.builder()
      .master("local")
      .appName("ImprCalculation")
      .getOrCreate()
    val reader = sparkSession.read.option("header", "true").option("sep", "|")

    val impr28Df = reader.csv("C:/Users/shhu6001/Downloads/data/2018-01-28/NORMAL/FB/*.csv")
    val impr25Df = reader.csv("C:/Users/shhu6001/Downloads/data/2018-01-25/NORMAL/FB/*.csv")
    val cmpgDf = reader.csv("C:/Users/shhu6001/Downloads/data/2018-01-28/METADATA/CAMPAIGN/*.csv")

    import sparkSession.implicits._

    val result = impr28Df.as("data_28").groupBy("data_28.CAMPAIGN_ID","data_28.PLACEMENT_ID").agg(sum("data_28.IMPRESSIONS").as("c_total_impr_28")).as("t_total_28")
                .join(impr25Df.as("data_25").groupBy("data_25.CAMPAIGN_ID","data_25.PLACEMENT_ID").agg(sum("data_25.IMPRESSIONS").as("c_total_impr_25")).as("t_total_25")
                    , col("t_total_28.CAMPAIGN_ID") === col("t_total_25.CAMPAIGN_ID") && col("t_total_28.PLACEMENT_ID") === col("t_total_25.PLACEMENT_ID"))
                .join(impr28Df.as("data_unmeasured_28")
                      .where(col("data_unmeasured_28.DEMOGRAPHIC_ID") === 25000)
                      .groupBy("data_unmeasured_28.CAMPAIGN_ID","data_unmeasured_28.PLACEMENT_ID")
                      .agg(sum("data_unmeasured_28.IMPRESSIONS").as("c_total_unmeasured_impr_28"))
                      .as("t_total_unmeasured_28")
                      ,col("t_total_28.CAMPAIGN_ID") === col("t_total_unmeasured_28.CAMPAIGN_ID") && col("t_total_28.PLACEMENT_ID") === col("t_total_unmeasured_28.PLACEMENT_ID")
                      )
                .where(col("t_total_28.c_total_impr_28") < (col("t_total_25.c_total_impr_25")+ 100000) && (col("t_total_unmeasured_28.c_total_unmeasured_impr_28")/col("t_total_28.c_total_impr_28")) > 0.03)
                .join(cmpgDf.as("data_cmp"), col("t_total_28.CAMPAIGN_ID") === col("data_cmp.CAMPAIGN_ID"),"left")
                .select("t_total_28.CAMPAIGN_ID","data_cmp.CAMPAIGN_NAME","t_total_28.PLACEMENT_ID","t_total_28.c_total_impr_28","t_total_25.c_total_impr_25","t_total_unmeasured_28.c_total_unmeasured_impr_28")
                .as[PlacementData]
    
    
    result.show()
//    result.foreach(println(_))

  }
 
}

case class PlacementData(
  CAMPAIGN_ID: String,
  CAMPAIGN_NAME: String,
  PLACEMENT_ID:   String,
  c_total_impr_28: String,
  c_total_impr_25: String,
  c_total_unmeasured_impr_28: String
  
//  ,
//  CAMPAIGN_NAME: String,
//  IMPRESSIONS:   Double
  )