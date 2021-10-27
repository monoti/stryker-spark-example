import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

object SimpleDFHelper {
  def filter(df: DataFrame): DataFrame = {
    import df.sparkSession.implicits._
    df.where($"col1" === 10 and col("col2") =!= "B")
  }

  def between(df: DataFrame): DataFrame = {
    import df.sparkSession.implicits._
    df.where($"col1" >= 10 or col("col2") <= "B")
  }

}