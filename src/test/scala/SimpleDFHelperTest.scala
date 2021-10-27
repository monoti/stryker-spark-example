import org.apache.spark.sql.{DataFrame, SparkSession}
import org.scalatest.funsuite.AnyFunSuite

class SimpleDFHelperTest extends AnyFunSuite {
  val spark: SparkSession = SparkSession.builder
    .master("local[*]")
    .getOrCreate()
  import spark.implicits._

  val df: DataFrame = Seq((10, "C"), (1, "CC"), (2, "CCC")).toDF("col1", "col2")

  test("filter method should select only col1 equals to 10 and col2 does not equal to B") {
    val filteredDF = SimpleDFHelper.filter(df)
    val expectedDF = Seq((10, "C")).toDF("col1", "col2")
    assert(filteredDF.collect() === expectedDF.collect())
  }

  test("between method should select only col1 >= 10 or col2 <= B") {
    val filteredDF = SimpleDFHelper.filter(df)
    val expectedDF = Seq((10, "C")).toDF("col1", "col2")
    assert(filteredDF.collect() === expectedDF.collect())
  }
}
