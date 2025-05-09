//full gpt
pipeline {
    agent any

    environment {
        IMAGE = 'tuusuario/proyecto2-app'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh './mvnw clean package -DskipTests'
            }
        }
        stage('Docker Build') {
            steps {
                sh "docker build -t $IMAGE ."
            }
        }
        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh 'echo $PASS | docker login -u $USER --password-stdin'
                    sh "docker push $IMAGE"
                }
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker-compose down && docker-compose up -d'
            }
        }
    }
}