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

description = "Mybatis Generator Gradle Plugin"

// https://docs.gradle.org/current/userguide/plugins.html#sec:plugin_markers
gradlePlugin {
    plugins {
        create("mbGeneratorPlugin") {
            id = "io.github.digimono.mybatis-generator"
            implementationClass = "io.digimono.gradle.plugin.MBGeneratorPlugin"
        }
    }
}

pluginBundle {
    website = "https://github.com/digimono/codegen.git"
    vcsUrl = "https://github.com/digimono/codegen.git"

    (plugins){
        "mbGeneratorPlugin"{
            displayName = "Mybatis Generator Plugin"
            description = "${project.description}"
            tags = listOf("mybatis", "generator", "mybatis generator")
            version = "${project.version}"
        }
    }
}
