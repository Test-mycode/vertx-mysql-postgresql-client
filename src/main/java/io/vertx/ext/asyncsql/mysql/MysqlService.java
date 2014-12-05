package io.vertx.ext.asyncsql.mysql;

import io.vertx.codegen.annotations.GenIgnore;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.asyncsql.BaseSqlService;
import io.vertx.ext.asyncsql.DatabaseCommands;
import io.vertx.ext.asyncsql.mysql.impl.MysqlServiceImpl;
import io.vertx.serviceproxy.ProxyHelper;

/**
 * @author <a href="http://www.campudus.com">Joern Bernhardt</a>
 */
@VertxGen
@ProxyGen
public interface MysqlService extends BaseSqlService, DatabaseCommands {

  static MysqlService create(Vertx vertx, JsonObject config) {
    return new MysqlServiceImpl(vertx, config);
  }

  static MysqlService createEventBusProxy(Vertx vertx, String address) {
    return ProxyHelper.createProxy(MysqlService.class, vertx, address);
  }

  /**
   * Begins a transaction.
   *
   * @param transaction The transaction to be used.
   */
  void begin(Handler<AsyncResult<MysqlTransaction>> transaction);

  /**
   * Gets a connection and frees it on close.
   *
   * @param connection The connection that can be used.
   */
  void take(Handler<AsyncResult<MysqlConnection>> connection);

}
