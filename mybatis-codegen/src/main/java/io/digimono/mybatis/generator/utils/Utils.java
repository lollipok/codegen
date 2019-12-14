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

package io.digimono.mybatis.generator.utils;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.internal.util.StringUtility;

/** @author yangyanju */
public final class Utils {

  private static final String PROP_ONLY_GENERATE_INSERT_SELECTIVE_METHOD =
      "onlyGenerateInsertSelectiveMethod";
  private static final String PROP_ONLY_GENERATE_UPDATE_SELECTIVE_METHOD =
      "onlyGenerateUpdateSelectiveMethod";
  private static final String PROP_GENERATE_EMPTY_JAVA_MAPPER = "generateEmptyJavaMapper";
  private static final String PROP_GENERATED_MAPPER_SUBPACKAGE = "generatedMapperSubpackage";
  private static final String PROP_GENERATED_MAPPER_SUFFIX = "generatedMapperSuffix";

  private Utils() {}

  public static boolean onlyGenerateInsertSelectiveMethod(
      Context context, IntrospectedTable introspectedTable) {
    String onlyGenerateInsertSelectiveMethod =
        introspectedTable.getTableConfigurationProperty(PROP_ONLY_GENERATE_INSERT_SELECTIVE_METHOD);

    if (!StringUtility.stringHasValue(onlyGenerateInsertSelectiveMethod)) {
      onlyGenerateInsertSelectiveMethod =
          context.getProperty(PROP_ONLY_GENERATE_INSERT_SELECTIVE_METHOD);
    }

    return StringUtility.isTrue(onlyGenerateInsertSelectiveMethod);
  }

  public static boolean onlyGenerateUpdateSelectiveMethod(
      Context context, IntrospectedTable introspectedTable) {
    String onlyGenerateUpdateSelectiveMethod =
        introspectedTable.getTableConfigurationProperty(PROP_ONLY_GENERATE_UPDATE_SELECTIVE_METHOD);

    if (!StringUtility.stringHasValue(onlyGenerateUpdateSelectiveMethod)) {
      onlyGenerateUpdateSelectiveMethod =
          context.getProperty(PROP_ONLY_GENERATE_UPDATE_SELECTIVE_METHOD);
    }

    return StringUtility.isTrue(onlyGenerateUpdateSelectiveMethod);
  }

  public static boolean generateEmptyJavaMapper(
      Context context, IntrospectedTable introspectedTable) {
    String generateEmptyJavaMapper =
        introspectedTable.getTableConfigurationProperty(PROP_GENERATE_EMPTY_JAVA_MAPPER);

    if (!StringUtility.stringHasValue(generateEmptyJavaMapper)) {
      generateEmptyJavaMapper = context.getProperty(PROP_GENERATE_EMPTY_JAVA_MAPPER);
    }

    return StringUtility.isTrue(generateEmptyJavaMapper);
  }

  public static String getGeneratedMapperSubpackage(Context context) {
    String subpackage = context.getProperty(PROP_GENERATED_MAPPER_SUBPACKAGE);
    if (StringUtility.stringHasValue(subpackage)) {
      return subpackage;
    } else {
      return "generated";
    }
  }

  public static String getGeneratedMapperSuffix(Context context) {
    String suffix = context.getProperty(PROP_GENERATED_MAPPER_SUFFIX);
    if (StringUtility.stringHasValue(suffix)) {
      return suffix;
    } else {
      return "Generated";
    }
  }
}
