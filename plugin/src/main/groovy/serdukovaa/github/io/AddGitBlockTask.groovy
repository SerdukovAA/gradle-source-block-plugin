package serdukovaa.github.io

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Created by Serdyukov_A on 04.05.2017.
 */
class AddGitBlockTask extends DefaultTask {

    @TaskAction
    def addGitSourceBlock() {
        if(project.hasProperty("git")){
            String gitUrl = project.getProperties().get("git")
            println("Start upload sourceBlock : "+gitUrl)
            String blockPath = getProjectName(gitUrl)

        }else{
            throw new Exception("\n\n Please pass 'git' parameter: \n\n gradle addGitSourceBlock  -Pgit=http://gitnub.com/awsome-progject.git ")
        }

    }


    static String getProjectName(String gitUrl){
     int iSlash = gitUrl.lastIndexOf('/') + 1
     int idPoint = gitUrl.lastIndexOf('.')
     return gitUrl.substring(iSlash,idPoint)
    }
}
