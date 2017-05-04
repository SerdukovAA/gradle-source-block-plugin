package org.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by Serdyukov_A on 04.05.2017.
 */

class GreetingPlugin implements Plugin<Project> {
    void apply(Project project) {
        // Add the 'greeting' extension object
        project.extensions.create("greeting", GreetingPluginExtension)
        // Add a task that uses the configuration
        project.task('hello2') {
            doLast {
                println project.greeting.message
            }
        }
    }
}

class GreetingPluginExtension {
    def String message = 'Hello from GreetingPlugin'
}