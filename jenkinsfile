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
//     stage("Sonar Analysis") {
//         environment{
//             scannerHome= tool "SonarQubeScanner"
//         }
//         steps{
//             echo "Sonar analysis started"
//             withSonarQubeEnv("Maftei"){
//                 sh "${scannerHome}/bin/sonar-scanner"
//             }
//         }
//     }
//     stage("Create Docker Image"){
//         steps{
//
//         sh 'docker version'
//         sh 'docker build -t springjavaexpress-docker-demo .'
//         sh 'docker image list'
//         sh 'docker tag springjavaexpress-docker-demo andrei4455/springjavaexpress-docker-demo:springjavaexpress-docker-demo'
//         }
//     }
//     stage("Docker Login"){
//         steps{
//             withCredentials([string(credentialsId: 'DOCKER_HUB_PASSWORD', variable: 'PASSWORD')]) {
//                 sh 'docker login -u andrei4455 -p $PASSWORD'
//             }
//         }
//     }
//
//     stage("Push Image to Docker Hub"){
//         steps{
//             sh 'docker push  andrei4455/springjavaexpress-docker-demo:springjavaexpress-docker-demo'
//         }
//     }
 }

}
