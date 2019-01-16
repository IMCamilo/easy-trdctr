package imcamilo.com.github

import com.google.cloud.translate.{Translate, TranslateException, Translation}
import org.scalatest._

class MainSpec extends FlatSpec with Matchers {

  "The greetin String" should "say welcome!" in {
    Hello.greeting shouldEqual "Welcome!"
  }

  "The askToconvert String" should "say traducir:" in {
    Hello.askToconvert shouldEqual "Traducir: "
  }

  "The translate val" should "shouldBe a Translate instance" in {
    Hello.transalate.asInstanceOf[Translate]
  }

  "The fromSourceToTarget" should "return a Error" in {
    val thrown = intercept[TranslateException] {
      Hello.fromSourceToTarget("")
    }
  }

}
