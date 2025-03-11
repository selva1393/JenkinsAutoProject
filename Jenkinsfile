pipeline {
    agent any

    tools {
        maven 'maven3'  // Ensure Maven is installed in Jenkins
    }

    environment {
        MAVEN_OPTS = "-Xmx1024m"  // Set memory options if needed
    }

    stages {
        stage('Checkout Code') {
            steps {
                script {
                    retry(3) {  // Retry up to 3 times instead of 5
                        checkout([
                            $class: 'GitSCM',
                            branches: [[name: '*/main']],
                            doGenerateSubmoduleConfigurations: false,
                            extensions: [[$class: 'CloneOption', noTags: false, reference: '', shallow: false, timeout: 10]],
                            userRemoteConfigs: [[
                                url: 'https://github.com/selva1393/JenkinsAutoProject.git',
                                credentialsId: 'cd82e4f5-98e2-4386-ad1b-bdd89810968c'  // Add this if your repo is private
                            ]]
                        ])
                    }
                }
            }
        }

        stage('Install Dependencies') {
            steps {
                sh 'mvn clean install -DskipTests'  // Skips tests during installation
            }
        }

        stage('Run Selenium Tests') {
            steps {
                sh 'mvn test'  // Runs your Selenium test cases
            }
        }

        stage('Publish Test Reports') {
            steps {
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/surefire-reports',
                    reportFiles: 'index.html',
                    reportName: 'Test Report'
                ])
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
