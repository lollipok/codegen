/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.lollipok.mybatis.generator.internal;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

import java.util.Properties;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * @author yangyanju
 * @version 1.0
 * @date 2019-03-29
 */
public class CustomizedCommentGeneratorImpl extends DefaultCommentGenerator {

  private boolean suppressAllComments;

  @Override
  public void addConfigurationProperties(Properties properties) {
    super.addConfigurationProperties(properties);
    suppressAllComments =
        isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
  }

  @Override
  public void addComment(XmlElement xmlElement) {}

  @Override
  public void addFieldComment(Field field, IntrospectedTable introspectedTable) {}

  @Override
  public void addFieldComment(
      Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {}

  @Override
  public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {}

  @Override
  public void addGetterComment(
      Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
    if (suppressAllComments) {
      return;
    }

    StringBuilder sb = new StringBuilder();

    method.addJavaDocLine("/**");
    sb.append(" * ");
    sb.append(introspectedColumn.getRemarks());
    method.addJavaDocLine(sb.toString());

    method.addJavaDocLine(" *");

    sb.setLength(0);
    sb.append(" * @return ");
    sb.append(introspectedTable.getFullyQualifiedTable());
    sb.append('.');
    sb.append(introspectedColumn.getActualColumnName());
    sb.append(" ");
    sb.append(introspectedColumn.getRemarks());
    method.addJavaDocLine(sb.toString());

    addJavadocTag(method, false);

    method.addJavaDocLine(" */");
  }

  @Override
  public void addSetterComment(
      Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
    if (suppressAllComments) {
      return;
    }

    StringBuilder sb = new StringBuilder();

    method.addJavaDocLine("/**");
    sb.append(" * ");
    sb.append(introspectedColumn.getRemarks());
    method.addJavaDocLine(sb.toString());

    method.addJavaDocLine(" *");

    Parameter param = method.getParameters().get(0);
    sb.setLength(0);
    sb.append(" * @param ");
    sb.append(param.getName());
    sb.append(" ");
    sb.append(introspectedColumn.getRemarks());
    method.addJavaDocLine(sb.toString());

    addJavadocTag(method, false);

    method.addJavaDocLine(" */");
  }
}