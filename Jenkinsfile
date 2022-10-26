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
                        url: "https://jfrogest.jfrog.io/artifactory/",
                        credentialsId: "jfrog"
                    )

                    rtMavenDeployer (
                        id: "MAVEN_DEPLOYER",
                        serverId: "jfrog",
                        releaseRepo: "rmaftei-libs-release-local",
                        snapshotRepo: "rmaftei-libs-snapshot-local"
                    )

                    rtMavenResolver (
                        id: "MAVEN_RESOLVER",
                        serverId: "jfrog",
                        releaseRepo: "rmaftei-libs-release",
                        snapshotRepo: "rmaftei-libs-snapshot"
                    )
                }
        }

		stage ('Deploy Artifacts') {
            steps {
                rtMavenRun (
                    tool: "M2_HOME",
                    pom: 'pom.xml',
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

    stage('Build Helm Charts') {
        steps {
            dir('charts') {
            withCredentials([usernamePassword(credentialsId: 'jfrog', usernameVariable: 'username', passwordVariable: 'password')]) {
                 sh 'sudo /usr/local/bin/helm package webapp'
                 sh 'sudo /usr/local/bin/helm push-artifactory webapp-6.0.tgz https://jfrogest.jfrog.io/artifactory/rmaftei-helm-local/ --username $username --password $password'
    		  }
            }
            }
          }
 }

}
