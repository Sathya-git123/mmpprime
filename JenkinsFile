pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        stage('Download Code From Github') {
            steps {
                git 'https://github.com/sudheer51/mmpprime.git'
            }
        }
        stage('Execute Selenium Tests') {
            steps {
               dir('mmpprime') 
               { 
                   bat 'dir'
                   bat 'mvn clean test'
               }
               
            }
             
        }
        
    }
}
