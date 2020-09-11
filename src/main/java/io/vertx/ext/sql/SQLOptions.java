/*
 * Copyright (c) 2011-2014 The original author or authors
 * ------------------------------------------------------
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 *
 *     The Eclipse Public License is available at
 *     http://www.eclipse.org/legal/epl-v10.html
 *
 *     The Apache License v2.0 is available at
 *     http://www.opensource.org/licenses/apache2.0.php
 *
 * You may elect to redistribute this code under either of these licenses.
 */
package io.vertx.ext.sql;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

/**
 * Represents the options one can use to customize the unwrapped connection/statement/resultset types
 *
 * @author <a href="mailto:plopes@redhat.com">Paulo Lopes</a>
 */
@DataObject(generateConverter = true)
public class SQLOptions {

  // connection
  private boolean readOnly;
  private String catalog;
  private TransactionIsolation transactionIsolation;
  private ResultSetType resultSetType;
  private ResultSetConcurrency resultSetConcurrency;
  // backwards compatibility
  private boolean autoGeneratedKeys = true;
  private JsonArray autoGeneratedKeysIndexes;
  private String schema;
  // statement
  private int queryTimeout;
  // resultset
  private FetchDirection fetchDirection;
  private int fetchSize;

  /**
   * Default constructor
   */
  public SQLOptions() {
  }

  /**
   * Copy constructor
   *
   * @param other  the result to copy
   */
  public SQLOptions(SQLOptions other) {
    this.readOnly = other.isReadOnly();
    this.catalog = other.getCatalog();
    this.transactionIsolation = other.getTransactionIsolation();
    this.resultSetType = other.getResultSetType();
    this.resultSetConcurrency = other.getResultSetConcurrency();
    this.autoGeneratedKeys = other.isAutoGeneratedKeys();
    this.autoGeneratedKeysIndexes = other.getAutoGeneratedKeysIndexes();
    this.schema = other.getSchema();
    this.queryTimeout = other.getQueryTimeout();
    this.fetchDirection = other.getFetchDirection();
    this.fetchSize = other.getFetchSize();
  }

  /**
   * Constructor from JSON
   *
   * @param json  the json
   */
  public SQLOptions(JsonObject json) {
    SQLOptionsConverter.fromJson(json, this);
  }

  public boolean isReadOnly() {
    return readOnly;
  }

  public SQLOptions setReadOnly(boolean readOnly) {
    this.readOnly = readOnly;
    return this;
  }

  public String getCatalog() {
    return catalog;
  }

  public SQLOptions setCatalog(String catalog) {
    this.catalog = catalog;
    return this;
  }

  public TransactionIsolation getTransactionIsolation() {
    return transactionIsolation;
  }

  public SQLOptions setTransactionIsolation(TransactionIsolation transactionIsolation) {
    this.transactionIsolation = transactionIsolation;
    return this;
  }

  public ResultSetType getResultSetType() {
    return resultSetType;
  }

  public SQLOptions setResultSetType(ResultSetType resultSetType) {
    this.resultSetType = resultSetType;
    return this;
  }

  public ResultSetConcurrency getResultSetConcurrency() {
    return resultSetConcurrency;
  }

  public SQLOptions setResultSetConcurrency(ResultSetConcurrency resultSetConcurrency) {
    this.resultSetConcurrency = resultSetConcurrency;
    return this;
  }

  public boolean isAutoGeneratedKeys() {
    return autoGeneratedKeys;
  }

  public SQLOptions setAutoGeneratedKeys(boolean autoGeneratedKeys) {
    this.autoGeneratedKeys = autoGeneratedKeys;
    return this;
  }

  public String getSchema() {
    return schema;
  }

  public SQLOptions setSchema(String schema) {
    this.schema = schema;
    return this;
  }

  public int getQueryTimeout() {
    return queryTimeout;
  }

  public SQLOptions setQueryTimeout(int queryTimeout) {
    this.queryTimeout = queryTimeout;
    return this;
  }

  public FetchDirection getFetchDirection() {
    return fetchDirection;
  }

  public SQLOptions setFetchDirection(FetchDirection fetchDirection) {
    this.fetchDirection = fetchDirection;
    return this;
  }

  public int getFetchSize() {
    return fetchSize;
  }

  public SQLOptions setFetchSize(int fetchSize) {
    this.fetchSize = fetchSize;
    return this;
  }

  public JsonArray getAutoGeneratedKeysIndexes() {
    return autoGeneratedKeysIndexes;
  }

  public SQLOptions setAutoGeneratedKeysIndexes(JsonArray autoGeneratedKeysIndexes) {
    this.autoGeneratedKeysIndexes = autoGeneratedKeysIndexes;
    return this;
  }
}
