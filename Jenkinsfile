pipeline {
    agent any
    stages {
        stage('Clean Workspace') {
            steps {
                sh 'rm -rf *'
            }
        }
        
        stage('Clone the repository') {
            steps {
                git branch: 'main', url: 'http://gitea:3000/admin/RepoDemoL2TestingBBT.git'
                sh 'tree'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Run a Test')
        {
            steps{
                sh 'mvn -Dtest=AppWBTTest,AppTest verify'
            }
        }
     
        stage('Publish Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }
}
