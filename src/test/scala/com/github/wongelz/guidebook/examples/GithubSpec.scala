package com.github.wongelz.guidebook.examples

import com.github.wongelz.guidebook.Browsers.{Chrome, Firefox}
import com.github.wongelz.guidebook.Guidebook
import org.scalatest.OptionValues._

class GithubSpec extends Guidebook {

  usingBrowsers(Chrome(headless = true)) {
    "Anonymous users" when {
      "exploring a repository" can {
        "open a repository" in {
          go to "https://www.github.com/wongelz/guidebook"

          eventually {
            find(tagName("h1")).value.text mustBe "wongelz/guidebook"
          }
        }

        "see the list of issues" in {
          click on partialLinkText("Issues")

          eventually {
            pageSource must include("New issue")
          }
        }

        "see the list of pull requests" in {
          click on partialLinkText("Pull requests")

          eventually {
            pageSource must include("New pull request")
          }
        }

        "see the projects" in {
          click on partialLinkText("Projects")

          eventually {
            pageSource must include("Organize your issues with project boards")
          }
        }

        "see the security overview" in {
          click on partialLinkText("Security")

          eventually {
            find(tagName("h2")).value.text mustBe "Security overview"
          }
        }

        "see the repository insights" in {
          click on linkText("Insights")

          eventually {
            find(linkText("Contributors")) mustBe defined
            find(linkText("Commits")) mustBe defined
          }
        }
      }
    }
  }
}
