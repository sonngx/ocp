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
                sh 'mvn -f samplewar/pom.xml' 
            }
        }
    }
}