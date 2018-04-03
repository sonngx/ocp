pipeline {
    agent any 
    stages {
        stage('Stage 1') {
            steps {
                echo 'Hello world!' 
            }
        }
        stage ('Build') {
            steps {
                sh 'mvn clean install -f samplewar/pom.xml' 
            }
        }
    }
}