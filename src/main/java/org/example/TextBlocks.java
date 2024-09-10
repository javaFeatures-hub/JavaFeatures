package org.example;

public class TextBlocks {
    // Text Blocks java 15 feature
    private final  static  String htmlContentString = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<body>\n" +
            "<h1>Hello, World!</h1>\n" +
            "</body>\n" +
            "</html>";

    private final  static    String htmlContentTextBlock = """
<!DOCTYPE html>
<html>
<body>
<h1>Hello, World!</h1>
</body>
</html>
""";
  private final  static String sqlQueryTextBlock = """
  WITH ProductSales AS (
                                                              SELECT
                                                                  p.product_category,
                                                                  o.order_id,
                                                                  SUM(oi.quantity * oi.unit_price) AS total_sales
                                                              FROM
                                                                  products p
                                                              JOIN
                                                                  order_items oi ON p.product_id = oi.product_id
                                                              JOIN
                                                                  orders o ON oi.order_id = o.order_id
                                                              GROUP BY
                                                                  p.product_category,
                                                                  o.order_id
                                                          ),
                                                          CategoryRevenue AS (
                                                              SELECT
                                                                  product_category,
                                                                  SUM(total_sales) AS category_revenue
                                                              FROM
                                                                  ProductSales
                                                              GROUP BY
                                                                  product_category
                                                          ),
                                                          AverageOrderValue AS (
                                                              SELECT
                                                                  AVG(total_sales) AS avg_order_value
                                                              FROM
                                                                  ProductSales
                                                          )
                                                          SELECT
                                                              cr.product_category,
                                                              cr.category_revenue,
                                                              aov.avg_order_value,
                                                              ps.product_id,
                                                              SUM(ps.total_sales) AS product_total_sales
                                                          FROM
                                                              CategoryRevenue cr
                                                          JOIN
                                                              ProductSales ps ON cr.product_category = ps.product_category
                                                          JOIN
                                                              AverageOrderValue aov ON 1 = 1
                                                          GROUP BY
                                                              cr.product_category,
                                                              cr.category_revenue,
                                                              aov.avg_order_value,
                                                              ps.product_id
                                                          ORDER BY
                                                              product_total_sales DESC
                                                          LIMIT 10;
""";

    public static void main(String[] args) {
        System.out.println("String HTML:-" + htmlContentString);
        System.out.println("Text Block HTML:-" + htmlContentTextBlock);
        System.out.println("Text Block sqlQueryTextBlock:-"+ sqlQueryTextBlock);
    }
}
