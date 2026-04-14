pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                url: 'https://github.com/PrathwishShetty03/MyMavenSeleniumFirefox.git'
            }
        }

        stage('Install Chrome & Dependencies') {
            steps {
                sh '''
                echo "Checking Chrome..."

                if ! command -v google-chrome > /dev/null
                then
                    echo "Installing Chrome..."
                    sudo apt update
                    sudo apt install -y wget unzip

                    wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
                    sudo apt install -y ./google-chrome-stable_current_amd64.deb
                fi

                echo "Chrome Version:"
                google-chrome --version

                echo "Installing required libraries..."
                sudo apt-get install -y libxss1 libappindicator1 libindicator7 fonts-liberation libnss3 lsb-release xdg-utils
                '''
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Run Application') {
            steps {
                sh '''
                echo "Running using Maven..."
                mvn exec:java -Dexec.mainClass="com.example.App"
                '''
            }
        }
    }

    post {
        success {
            echo ' Build and execution SUCCESSFUL!'
        }
        failure {
            echo ' Build FAILED!'
        }
    }
}
