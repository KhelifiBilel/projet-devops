#!/usr/bin/env groovy

def gv

pipeline {
    agent any
    environment {
        DEPLOYMENT_SERVER_IP = "192.168.136.129"
        DEPLOYMENT_SERVER_USER= "khalil"
        JENKINS_SERVER_IP ="192.168.136.128"
        JENKINS_SERVER_USER="admin"
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