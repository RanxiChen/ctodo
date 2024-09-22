import mill._,scalalib._

object ctodo extends RootModule with ScalaModule {
    def scalaVersion = "2.11.12"
    def ivyDeps = Agg(
        ivy"com.lihaoyi::scalatags:0.12.0"
    )

    object test extends ScalaTests {
        def ivyDeps = Agg(ivy"com.lihaoyi::utest:0.8.1")
        def testFramework = "utest.runner.Framework"
    }
}