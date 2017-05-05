package serdukovaa.github.io

import org.eclipse.jgit.api.Git
import org.junit.Test
import serdukovaa.github.io.gradle.FindDependenciesVisitor
import serdukovaa.github.io.gradle.GradleDependencyUpdater

import java.nio.charset.StandardCharsets
import java.nio.file.Files

/**
 * Created by Serdyukov_A on 05.05.2017.
 */
class AddGitBlockTaskTest {

    @Test
    void cloneTest(){
        String url = "https://github.com/SerdukovAA/gradle-source-block-plugin.git";
        String path = AddGitBlockTask.getProjectName(url);

        File pathDir = new File(path);
        if(pathDir.exists()){
            pathDir.deleteDir();
        }

        Git git = Git.cloneRepository()
                .setURI(url)
                .setDirectory(new File(path))
                .setCloneAllBranches( true )
                .call()

        println(git.getProperties())

        git.getRepository().close()

        File gitDir = new File( path+"/.git")
        if(gitDir.exists()){
            gitDir.deleteDir();
        }
        File ideaDir = new File( path+"/.idea")
        if(ideaDir.exists()){
            ideaDir.deleteDir();
        }

    }

    @Test
    void pathTest(){
        String path = AddGitBlockTask.getProjectName("git@github.com:SerdukovAA/gradle-source-block-plugin.git")
        System.out.println(path);
    }


    @Test
    void addDependenceSkipComment() throws IOException {
        final File inputFile = new File("D:\\lerning\\gradle-source-block-plugin\\consumer\\build.gradle");
        GradleDependencyUpdater updater = new GradleDependencyUpdater(inputFile);
        updater.insertDependency(
                "\tcompile group: \"com.liferay\", name:\"com.liferay.bookmarks.api\", version:\"1.0.0\"");
        Files.write( inputFile.toPath(), updater.getGradleFileContents(), StandardCharsets.UTF_8 );
    }

    @Test
    void editFileProperty() throws IOException {
        String path = "D:\\lerning\\gradle-source-block-plugin\\consumer\\settings.gradle";
        def f = new File(path)
        f.append('include '+new Date()+'\n')
    }



}
