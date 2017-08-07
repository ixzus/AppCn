
************project build.gradle
classpath 'com.jfrog.bintray.gradle:gradle-bintray-plugin:1.0'
classpath 'com.github.dcendents:android-maven-gradle-plugin:1.4.1'

*******module build.gradle

apply plugin: 'com.github.dcendents.android-maven'
apply plugin: 'com.jfrog.bintray'
//jcenter
def siteUrl = 'https://github.com/ixzus/AppCn'
def gitUrl = 'https://github.com/ixzus/AppCn.git'

version = "0.0.3"
group = "com.ixzus.applib"
task sourcesJar(type: Jar) {
    from android.sourceSets.main.java.srcDirs
    classifier = 'sources'
}
task javadoc(type: Javadoc) {
    source = android.sourceSets.main.java.srcDirs
    classpath += project.files(android.getBootClasspath().join(File.pathSeparator))
}
task javadocJar(type: Jar, dependsOn: javadoc) {
    classifier = 'javadoc'
    from javadoc.destinationDir
}
artifacts {
    archives javadocJar
    archives sourcesJar
}
install {
    repositories.mavenInstaller {
        // This generates POM.xml with proper parameters
        pom {
            project {
                packaging 'aar'
                name 'AppLib For Android'
                url siteUrl
                // Set your license
                licenses {
                    license {
                        name 'The Apache Software License, Version 2.0'
                        url 'http://www.apache.org/licenses/LICENSE-2.0.txt'
                    }
                }
                developers {
                    developer { //填写的一些基本信息
                        id 'ixzus'
                        name 'iandroid'
                        email 'iandroid@foxmail.com'
                    }
                }
                scm {
                    connection gitUrl
                    developerConnection gitUrl
                    url siteUrl
                }
            }
        }
    }
}

Properties properties = new Properties()
properties.load(project.rootProject.file('local.properties').newDataInputStream())
bintray {
    user = properties.getProperty("bintrayUser")
    key = properties.getProperty("bintrayApiKey")
    configurations = ['archives']
    pkg {
        repo = "applib"               //跟上面创建的Maven仓库名字保持一致
        name = "applibrary"                //发布到JCenter上的项目名字
        websiteUrl = siteUrl
        vcsUrl = gitUrl
        licenses = ["Apache-2.0"]
        publish = true
    }
}
