pipeline {
    environment {
    registry = "ravi8002/devops-project-image"
    registryCredential = 'docker-hub-credentials'
    dockerImage = ''
    dockerImageLatest = ''
  }
      agent any
      stages {
            stage('Init') {
                  steps {
                        echo 'I am executing calculator program via pipeline'
                  }
            }
            stage('Cloning Git') {
                steps {
                    git 'https://github.com/ravi1singh/EcommerceSpringBoot.git'
                        }
            }
            stage('Build') {
                  steps {
                        sh 'mvn -f pom.xml clean package'
                  }
		
            }
             stage('Building image') {
                steps{
		            sh "pwd"
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                    dockerImageLatest = docker.build registry + ":latest"
                    }
                }
            }
            stage('Deploy Image') {
      steps{
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
            dockerImageLatest.push()
          }
        }
      }
    }
    stage('Remove Unused docker image') {
      steps{
        sh "docker rmi $registry:$BUILD_NUMBER"
      }
    }
    stage('Execute Rundeck job') {
        steps {
          script {
            step([$class: "RundeckNotifier",
                  includeRundeckLogs: true,
                  jobId: "22759f1b-1fa8-4de4-8bfc-a2d6b72e444c",
                  rundeckInstance: "Rundeck",
                  shouldFailTheBuild: true,
                  shouldWaitForRundeckJob: true,
                  tailLog: true])
            //echo "Rundeck JOB goes here"
          }
        }
    }
            
      }
}
