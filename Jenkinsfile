pipeline {
    agent any
    environment{
        PATH = "/opt/maven/apache-maven-3.8.6/bin:$PATH"

    }
    stages{
      stage("Git Clone"){
        steps{
            git credentialsId: 'GIT_HUB_CREDENTIALS', url: 'https://github.com/maftei/javaexpress.git'
        }
    }

    stage("Maven Build"){
        steps{
            sh "mvn clean install"
        }
    }
    stage("Sonar Analysis") {
        environment{
            scannerHome= tool "SonarQubeScanner"
        }
        steps{
            echo "Sonar analysis started"
            withSonarQubeEnv("SonarQubeJavaExpress"){
                sh "${scannerHome}/bin/sonar-scanner"
            }
        }
    }
    stage("Create Docker Image"){
        steps{

        sh 'docker version'
        sh 'docker build -t springjavaexpress-docker-demo .'
        sh 'docker image list'
        sh 'docker tag springjavaexpress-docker-demo andrei4455/springjavaexpress-docker-demo:springjavaexpress-docker-demo'
        }
    }
    stage("Docker Login"){
        steps{
            withCredentials([string(credentialsId: 'DOCKER_HUB_PASSWORD', variable: 'PASSWORD')]) {
                sh 'docker login -u andrei4455 -p $PASSWORD'
            }
        }
    }

    stage("Push Image to Docker Hub"){
        steps{
            sh 'docker push  andrei4455/springjavaexpress-docker-demo:springjavaexpress-docker-demo'
        }
    }

     stage ('Artifactory configuration') {
                steps {
                    rtServer (
                        id: "jfrog",
                        url: " https://jfrogest.jfrog.io/artifactory",
                        credentialsId: "jfrog"
                    )

                    rtMavenDeployer (
                        id: "MAVEN_DEPLOYER",
                        serverId: "jfrog",
                        releaseRepo: "rmaftei-libs-release-local",
                        snapshotRepo: "rmaftei-libs-release-local"
                    )

                    rtMavenResolver (
                        id: "MAVEN_RESOLVER",
                        serverId: "jfrog",
                        releaseRepo: "rmaftei-libs-release-local",
                        snapshotRepo: "rmaftei-libs-release-local"
                    )
                }
        }

		stage ('Deploy Artifacts') {
            steps {
                rtMavenRun (
                    tool: "M2_HOME", // Tool name from Jenkins configuration
                    pom: 'JavaExpress_master/pom.xml',
                    goals: 'clean install',
                    deployerId: "MAVEN_DEPLOYER",
                    resolverId: "MAVEN_RESOLVER"
                )
         }
    }

	stage ('Publish build info') {
            steps {
                rtPublishBuildInfo (
                    serverId: "jfrog"
             )
        }
    }
 }

}