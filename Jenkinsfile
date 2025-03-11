pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                script {
                    retry(5) {  // Retry up to 5 times
                        checkout([
                            $class: 'GitSCM',
                            branches: [[name: '*/main']],
                            doGenerateSubmoduleConfigurations: false,
                            extensions: [[$class: 'CloneOption', noTags: false, reference: '', shallow: false, timeout: 10]],
                            userRemoteConfigs: [[url: 'https://github.com/your-repo.git']]
                        ])
                    }
                }
            }
        }

        stage('Install Dependencies') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                sh 'mvn test'  // Runs your Selenium test cases
            }
        }
    }
}
