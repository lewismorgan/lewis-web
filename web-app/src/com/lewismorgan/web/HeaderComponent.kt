package com.lewismorgan.web

import kotlinx.html.classes
import kotlinx.html.title
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.h1
import react.dom.header
import react.dom.i
import react.dom.img
import react.dom.li
import react.dom.span
import react.dom.ul

/**
 * Created by lewis on 6/25/18.
 */
class HeaderComponent : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    header("masthead bg-primary text-center") {
      div("container") {
        // TODO Use gravatar to get the image
        img("( ͡° ͜ʖ ͡°)", "/me.png") {
          attrs.title = "( ͡° ͜ʖ ͡°)"
          attrs.classes += "img-fluid mx-auto rounded-circle mb-3"
        }
        div("container") {
          h1 { +"Lewis Morgan" }
          ul("list-stack") {
            li("list-stack-item") {
              span { +"Student " }
              fontAwesome("user-graduate", FontAwesomeStyleType.SOLID)
            }
            li("list-stack-item") {
              span { +"Developer " }
              fontAwesome("code", FontAwesomeStyleType.SOLID)
            }
            li("list-stack-item") {
              span { +"Star Wars Fanatic " }
              i("swg swg-deathstar") {}
            }
          }
        }
      }
    }
  }
}