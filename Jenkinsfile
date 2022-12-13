#!/usr/bin/env groovy

def gv

pipeline {
    agent any
    environment {

        DEPLOYMENT_SERVER_IP = "20.100.201.60"     // to modify with allcated @IP public
        DEPLOYMENT_SERVER_USER= "bilel"
        JENKINS_SERVER_IP ="20.4.49.224"            // to modify with allcated @IP public
        JENKINS_SERVER_USER="jenkins"
    }
    tools {
        maven 'maven'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"    // load the groovy file in a variable
                }
            }
        }

    stage('SonarQube Analyse') {
              steps {
                 script {
                     gv.sonarScan()     // quality tests
                 }
              }
            }
        stage("building image") {
            steps {
                script {
                    gv.buildImage()   //building docker image
                }
            }
        }
        stage("Deploying") {
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

            }
        }
        failure {
            script {
                echo 'ERROR'
                gv.cleanUntaggedImages("${JENKINS_SERVER_IP}","${JENKINS_SERVER_USER}")

            }
        }
    }
}