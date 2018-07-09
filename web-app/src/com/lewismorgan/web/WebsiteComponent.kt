package com.lewismorgan.web

import com.lewismorgan.web.bootstrap.dsl.container
import com.lewismorgan.web.bootstrap.nav.navigationItem
import com.lewismorgan.web.children.FontAwesomeSize
import com.lewismorgan.web.children.FontAwesomeStyleType
import com.lewismorgan.web.children.fontAwesome
import com.lewismorgan.web.misc.getSmoothScrollingHandler
import com.lewismorgan.web.wrappers.navHashLink
import kotlinx.html.id
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.a
import react.dom.div
import react.dom.section
import react.dom.small
import react.dom.span

class WebsiteComponent : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    child(WebsiteNavbarComponent::class) {
      attrs.collapsedMenuShown = true
      renderNavSectionItem("#home", "Home")
      renderNavSectionItem("#quotes", "Inspiration")
      renderNavSectionItem("#projects", "Projects")
      renderNavSectionItem("#education", "Education")
      renderNavSectionItem("#contact", "Contact")
    }
    div {
      attrs.id = "home"
      child(HeaderComponent::class) {}
    }
    div {
      attrs.id = "quotes"
      child(WelcomeComponent::class) {}
    }
    // the main contents for website
    div("mb-5 mt-5") {
      attrs.id = "projects"
      child(ProjectsComponent::class) {}
    }
    div {
      attrs.id = "education"
      child(EducationComponent::class) {}
    }
    div {
      attrs.id = "contact"
      child(ContactComponent::class) {}
    }
    child(FooterComponent::class) {}
    renderCopyright()
  }

  private fun RBuilder.renderNavSectionItem(href: String, name: String) {
    navigationItem {
      // TODO: NavHashLinks broken for active status see https://github.com/rafrex/react-router-hash-link/issues/29
      navHashLink("/$href", className = "nav-link", activeClassName = "active", scroll = getSmoothScrollingHandler()) {
        +name
      }
    }
  }

  private fun RBuilder.renderCopyright() {
    section {
      attrs.id = "copyright"
      div("copyright text-center py-4 bg-dark text-white") {
        container {
          small("footer-notes") {
            span {
              +"Copyright "
            }
            fontAwesome("copyright", FontAwesomeStyleType.REGULAR, FontAwesomeSize.XS)
            span {
              +" Lewis Morgan 2018. Source code is available on "
            }
            a("https://github.com/lewismorgan/lewisjmorgan") {
              +"GitHub"
            }
            span { +" " }
            fontAwesome("github", FontAwesomeStyleType.BRAND, FontAwesomeSize.DEFAULT, "fa-fw") {}
          }
        }
      }
    }
  }
}
