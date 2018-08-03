package com.nielsen.scala_demo.problem

object ProcessCsv {

//  def main(args: Array[String]): Unit = {
//    val dmaFile = "C:/Users/shhu6001/Downloads/data/STATIC_DATA/DESIGNATED_MARKET_AREA.csv"
//    val campaignMetadataFile = "C:/Users/shhu6001/Downloads/data/2018-01-25/METADATA/campaign.csv"
//    val dataFile = "C:/Users/shhu6001/Downloads/data/2018-01-25/NORMAL/FB/2072,6.csv"
//    val cityName = "Beijing"
//    val campaignId = "2072"
//    val result = calculateImpression(dmaFile, campaignMetadataFile, dataFile, cityName, campaignId)
//    println(result._1 + "|" + result._2 + "|" + result._3)
//  }
//
//  def calculateImpression(dmaFile: String, campaignMetadataFile: String, dataFile: String, cityName: String, campaignId: String) = {
//    val dma_id = io.Source.fromFile(dmaFile).getLines().filter(line => line.split("[|]").contains(cityName)).next().split("[|]").apply(0)
//    val campaign_name = io.Source.fromFile(campaignMetadataFile).getLines().filter(line => line.split("[|]").contains(campaignId)).next().split("[|]").apply(2)
//    val impression = io.Source.fromFile(dataFile).getLines().filter(line => line.split("[|]").contains(dma_id)).map(_.split("[|]").apply(8)).reduceLeft((x, y) => (x.toLong + y.toLong).toString)
//    (campaignId, campaign_name, impression.toLong)
//  }
}