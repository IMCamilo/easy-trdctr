package imcamilo.com.github

import com.google.api.client.googleapis.json.GoogleJsonResponseException
import com.google.cloud.translate.Translate.TranslateOption
import com.google.cloud.translate.{TranslateException, TranslateOptions, Translation}

import scala.io.StdIn

object Hello extends StringMessages with App with Util{
  println(greeting)
  print(askToconvert)
  val testSource = StdIn.readLine
  val res = fromSourceToTarget(testSource)
  printf("Origin: %s%n", res)
  printf("Target: %s%n", res.getTranslatedText)
}

trait StringMessages {
  lazy val greeting: String = "Welcome!"
  lazy val askToconvert: String = "Traducir: "
}

trait Util {
  lazy val transalate = TranslateOptions.getDefaultInstance.getService
  def fromSourceToTarget(text:String): Translation = {
    var translationDone : Translation = null
    try {
      translationDone = transalate.translate(
        text,
        TranslateOption.sourceLanguage("es"),
        TranslateOption.targetLanguage("en")
      )
    } catch {
      case te: TranslateException =>
        println("ouch!")
        System.exit(0)
    }
    translationDone
  }

}