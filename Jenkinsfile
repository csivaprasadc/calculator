
node {
    stage("Checkout") {
        git url: 'https://github.com/csivaprasadc/calculator.git'
    }
    stage("Compile") {
        sh "./gradlew compileJava"
    }
    stage("Static code analysis") {
        sh "./gradlew checkstyleMain"
        publishHTML(target:[
            reportDir: 'build/reports/checkstyle/',
            reportFiles: 'main.html',
            reportName: "CheckStyle Report"
        ])
    }
    stage("Unit test") {
        sh "./gradlew test"
    }
    stage("Code Coverage") {
        sh "./gradlew jacocoTestReport"
        publishHTML(target:[
            reportDir: 'build/reports/jacoco/test/html',
            reportFiles: 'index.html',
            reportName: "JaCoCo Report"
        ])
        sh "./gradlew jacocoTestCoverageVerification"
    }
    stage('Package') {
        sh "./gradlew build"
    }
    stage('Docker build') {
        sh "docker build -t csivaprasadc/calculator ."
    }
}