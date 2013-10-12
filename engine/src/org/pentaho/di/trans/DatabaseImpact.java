/*! ******************************************************************************
 *
 * Pentaho Data Integration
 *
 * Copyright (C) 2002-2013 by Pentaho : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.pentaho.di.trans;

import org.pentaho.di.core.RowMetaAndData;
import org.pentaho.di.core.row.ValueMeta;
import org.pentaho.di.core.row.ValueMetaInterface;
import org.pentaho.di.i18n.BaseMessages;

public class DatabaseImpact {
  private static Class<?> PKG = Trans.class; // for i18n purposes, needed by Translator2!! $NON-NLS-1$

  public static final int TYPE_IMPACT_NONE = 0;
  public static final int TYPE_IMPACT_READ = 1;
  public static final int TYPE_IMPACT_WRITE = 2;
  public static final int TYPE_IMPACT_READ_WRITE = 3;
  public static final int TYPE_IMPACT_TRUNCATE = 4;
  public static final int TYPE_IMPACT_DELETE = 5;
  public static final int TYPE_IMPACT_UPDATE = 6;

  public static final String[] typeDesc = { BaseMessages.getString( PKG, "DatabaseImpact.TypeDesc.Label.None" ),
    BaseMessages.getString( PKG, "DatabaseImpact.TypeDesc.Label.Read" ),
    BaseMessages.getString( PKG, "DatabaseImpact.TypeDesc.Label.Write" ),
    BaseMessages.getString( PKG, "DatabaseImpact.TypeDesc.Label.ReadOrWrite" ),
    BaseMessages.getString( PKG, "DatabaseImpact.TypeDesc.Label.Truncate" ),
    BaseMessages.getString( PKG, "DatabaseImpact.TypeDesc.Label.Delete" ),
    BaseMessages.getString( PKG, "DatabaseImpact.TypeDesc.Label.Update" ) };

  private String transname;
  private String stepname;
  private String dbname;
  private String table;
  private String field;
  private String valuename;
  private String valueorigin;
  private String sql;
  private String remark;
  private int type;

  public DatabaseImpact( int type, String transname, String stepname, String dbname, String table, String field,
      String valuename, String valueorigin, String sql, String remark ) {
    this.type = type;
    this.transname = transname;
    this.stepname = stepname;
    this.dbname = dbname;
    this.table = table;
    this.field = field;
    this.valuename = valuename;
    this.valueorigin = valueorigin;
    this.sql = sql;
    this.remark = remark;
  }

  public String getTransformationName() {
    return transname;
  }

  public String getStepName() {
    return stepname;
  }

  public String getValueOrigin() {
    return valueorigin;
  }

  public String getDatabaseName() {
    return dbname;
  }

  public String getTable() {
    return table;
  }

  public String getField() {
    return field;
  }

  public String getValue() {
    return valuename;
  }

  public String getSQL() {
    return sql;
  }

  public String getRemark() {
    return remark;
  }

  public String getTypeDesc() {
    return typeDesc[type];
  }

  public static final int getTypeDesc( String typedesc ) {
    for ( int i = 1; i < typeDesc.length; i++ ) {
      if ( typeDesc[i].equalsIgnoreCase( typedesc ) ) {
        return i;
      }
    }
    return TYPE_IMPACT_NONE;
  }

  public int getType() {
    return type;
  }

  public RowMetaAndData getRow() {
    RowMetaAndData r = new RowMetaAndData();
    r.addValue( new ValueMeta( BaseMessages.getString( PKG, "DatabaseImpact.RowDesc.Label.Type" ),
        ValueMetaInterface.TYPE_STRING ), getTypeDesc() );
    r.addValue( new ValueMeta( BaseMessages.getString( PKG, "DatabaseImpact.RowDesc.Label.Transformation" ),
        ValueMetaInterface.TYPE_STRING ), getTransformationName() );
    r.addValue( new ValueMeta( BaseMessages.getString( PKG, "DatabaseImpact.RowDesc.Label.Step" ),
        ValueMetaInterface.TYPE_STRING ), getStepName() );
    r.addValue( new ValueMeta( BaseMessages.getString( PKG, "DatabaseImpact.RowDesc.Label.Database" ),
        ValueMetaInterface.TYPE_STRING ), getDatabaseName() );
    r.addValue( new ValueMeta( BaseMessages.getString( PKG, "DatabaseImpact.RowDesc.Label.Table" ),
        ValueMetaInterface.TYPE_STRING ), getTable() );
    r.addValue( new ValueMeta( BaseMessages.getString( PKG, "DatabaseImpact.RowDesc.Label.Field" ),
        ValueMetaInterface.TYPE_STRING ), getField() );
    r.addValue( new ValueMeta( BaseMessages.getString( PKG, "DatabaseImpact.RowDesc.Label.Value" ),
        ValueMetaInterface.TYPE_STRING ), getValue() );
    r.addValue( new ValueMeta( BaseMessages.getString( PKG, "DatabaseImpact.RowDesc.Label.ValueOrigin" ),
        ValueMetaInterface.TYPE_STRING ), getValueOrigin() );
    r.addValue( new ValueMeta( BaseMessages.getString( PKG, "DatabaseImpact.RowDesc.Label.SQL" ),
        ValueMetaInterface.TYPE_STRING ), getSQL() );
    r.addValue( new ValueMeta( BaseMessages.getString( PKG, "DatabaseImpact.RowDesc.Label.Remarks" ),
        ValueMetaInterface.TYPE_STRING ), getRemark() );

    return r;
  }

}
