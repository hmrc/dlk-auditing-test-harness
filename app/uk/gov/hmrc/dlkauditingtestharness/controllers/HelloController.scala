/*
 * Copyright 2021 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.dlkauditingtestharness.controllers

import org.slf4j.LoggerFactory
import play.api.mvc.MessagesControllerComponents
import uk.gov.hmrc.http.HeaderCarrier
import uk.gov.hmrc.play.audit.http.connector.AuditConnector
import uk.gov.hmrc.play.audit.model.DataEvent
import uk.gov.hmrc.play.bootstrap.frontend.controller.FrontendController

import javax.inject.{Inject, Singleton}
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class HelloController @Inject ()(mcc: MessagesControllerComponents, auditConnector: AuditConnector) extends FrontendController(mcc) {

  private val logger = LoggerFactory.getLogger(getClass)

  def hello = Action { implicit request =>
    logger.info("hello")
    implicit val hc = HeaderCarrier()
    auditConnector.sendEvent(DataEvent(auditSource = "dlk-auditing-test-harness", auditType = "ExplicitEvent"))
    Ok("Hello World")
  }

}
