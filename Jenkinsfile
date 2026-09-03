pipeline {
    agent any

    tools {
        maven 'Maven' 
    }

    stages {
        stage('Compile') {
            steps {
                bat 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }
}