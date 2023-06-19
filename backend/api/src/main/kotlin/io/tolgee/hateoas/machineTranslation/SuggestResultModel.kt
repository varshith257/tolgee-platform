package io.tolgee.hateoas.machineTranslation

import io.swagger.v3.oas.annotations.media.Schema
import io.tolgee.constants.MtServiceType
import io.tolgee.hateoas.key.KeyModel
import org.springframework.hateoas.RepresentationModel
import java.io.Serializable

@Suppress("unused")
class SuggestResultModel(
  @Schema(
    description = "String translations provided by enabled services. (deprecated, use `result` instead)",
    example = """
    {
      "GOOGLE": "This was translated by Google",
      "TOLGEE": "This was translated by Tolgee Translator",
    }
  """,
    deprecated = true
  )
  val machineTranslations: Map<MtServiceType, String?>?,
  val translationCreditsBalanceBefore: Long,
  val translationCreditsBalanceAfter: Long,

  @Schema(
    description = "Results provided by enabled services.",
    example = """
    {
      "GOOGLE": {
        "output": "This was translated by Google",
        "contextDescription": null
      },
      "TOLGEE": {
        "output": "This was translated by Tolgee Translator",
        "contextDescription": "This is an example in swagger"
      } 
    }
  """
  )
  val result: Map<MtServiceType, TranslationItemModel?>?,

  @Schema(
    description = "Extra credits are neither refilled nor reset every period." +
      " User's can refill them on Tolgee cloud."
  )
  val translationExtraCreditsBalanceBefore: Long,

  @Schema(
    description = "Extra credits are neither refilled nor reset every period." +
      " User's can refill them on Tolgee cloud."
  )
  val translationExtraCreditsBalanceAfter: Long,
) : RepresentationModel<KeyModel>(), Serializable
