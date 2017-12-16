
node {
    stage("Checkout") {
        git url: 'https://github.com/csivaprasadc/calculator.git'
    }
    stage("Compile") {
        sh "./gradlew compileJava"
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
}