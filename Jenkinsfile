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
                bat 'mvn clean install -DskipTests'  // Skips tests during installation
            }
        }

        stage('Run Selenium Tests') {
            steps {
                bat 'mvn test'  // Runs your Selenium test cases
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
            script {
                def testResults = junit '**/target/surefire-reports/*.xml'
                def failedTests = testResults.failCount
                def totalTests = testResults.totalCount
                def passedTests = totalTests - failedTests
                emailext(
    to: 'recipient@example.com',
    subject: "Jenkins Build ${currentBuild.fullDisplayName} - Test Results",
    body: """
        <p>Build ${currentBuild.fullDisplayName} completed.</p>
        <p>Test Results:</p>
        <ul>
            <li>Total Tests: ${totalTests}</li>
            <li>Passed Tests: ${passedTests}</li>
            <li>Failed Tests: ${failedTests}</li>
        </ul>
        <p>For more details, check the Jenkins build: ${env.BUILD_URL}</p>
    """,
    mimeType: 'text/html',
    attachLog: true,
    attachmentsPattern: '**/target/*.jar'
)
                
            }
        }
    }
}
