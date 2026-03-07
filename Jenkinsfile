pipeline {
    agent any

    tools {
            maven 'Maven-3'
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
        stage('Deploy with Ansible') {
            steps {
                sh '''
                source $WORKSPACE/.local/ansible-env/bin/activate
                ansible-playbook -i ansible/inventory.ini ansible/deploy.yml
                '''
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