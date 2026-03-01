pipeline {
    agent {
            docker {
                image 'maven:3.9.6-eclipse-temurin-17'
                args '-v /var/run/docker.sock:/var/run/docker.sock'
            }
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/swarnendu-sekhar-das/scientific-calculator.git'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t ssd31/scientific-calculator:latest .'
            }
        }

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh '''
                        echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                        docker push ssd31/scientific-calculator:latest
                    '''
                }
            }
        }
    }

    post {
        success {
            emailext(
                subject: "BUILD SUCCESS: ${env.JOB_NAME}",
                body: "Pipeline executed successfully.\nBuild: ${env.BUILD_NUMBER}",
                to: "ss1999das@gmail.com"
            )
        }
        failure {
            emailext(
                subject: "BUILD FAILURE: ${env.JOB_NAME}",
                body: "Build failed. Check Jenkins console.",
                to: "ss1999das@gmail.com"
            )
        }
    }
}