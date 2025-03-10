pipeline {
    agent any  // Runs on any available Jenkins agent

    tools {
        maven 'maven3'  // Use the Maven installation configured in Jenkins
    }

    environment {
        BROWSER = "chrome"  // Define environment variable
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/selva1393/JenkinsAutoProject.git'  // Replace with your GitHub repo
            }
        }

        stage('Install Dependencies') {
            steps {
                sh 'mvn clean install'  // Builds the project & downloads dependencies
            }
        }

        stage('Run Selenium Tests') {
            steps {
                sh 'mvn test'  // Executes test cases
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'  // Publish JUnit test results
            }
        }
    }
}
