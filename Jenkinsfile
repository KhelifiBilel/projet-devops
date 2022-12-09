#!/usr/bin/env groovy

def gv

pipeline {
    agent any
    environment {
    //webhook
        DEPLOYMENT_SERVER_IP = "20.100.201.60"     // to modify
        DEPLOYMENT_SERVER_USER= "bilel"
        JENKINS_SERVER_IP ="20.4.49.224"            // to modify
        JENKINS_SERVER_USER="jenkins"
    }
    tools {
        maven 'maven'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
      //unit test
            stage('UNIT test'){

                       steps{
                          sh 'mvn test'
                             }
                   }
 stage('SonarQube Testing') {
              steps {
                 script {
                     gv.sonarScan()
                 }
              }
            }
        stage("build image") {
            steps {
                script {
                    gv.buildImage()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    gv.deployApp("${DEPLOYMENT_SERVER_IP}","${DEPLOYMENT_SERVER_USER}")
                }
            }
        }

    }

    post {
        success {
            script {
                echo 'removing the old images from the Jenkins server..'
                gv.cleanUntaggedImages("${JENKINS_SERVER_IP}","${JENKINS_SERVER_USER}")
                //emailext body: 'Your backend pipeline finished the buit and deployment of the project successfully', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Success of digihunt pipeline stages'
                // test
            }
        }
        failure {
            script {
                echo 'removing the old images from the Jenkins server..'
                gv.cleanUntaggedImages("${JENKINS_SERVER_IP}","${JENKINS_SERVER_USER}")
                //emailext body: 'Your backend pipeline failed the built and deployment of the project successfully', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Failure of digihunt pipeline stages'

            }
        }
    }
}