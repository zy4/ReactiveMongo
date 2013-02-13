package reactivemongo.core.commands

import reactivemongo.bson._
import DefaultBSONHandlers._
import reactivemongo.core.protocol.Response

/** Drop a database. */
class DropDatabase() extends Command[Boolean] {
  def makeDocuments =
    BSONDocument("dropDatabase" -> BSONInteger(1))

  object ResultMaker extends BSONCommandResultMaker[Boolean] {
    def apply(doc: BSONDocument) = {
      CommandError.checkOk(doc, Some("dropDatabase")).toLeft(true)
    }
  }
}