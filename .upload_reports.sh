ARTIFACTS_DIR="./build/reports/allure-report"
ARTIFACTS_FILE=${TRAVIS_JOB_NUMBER}_log.tar.gz

ls $ARTIFACTS_DIR
echo "Compressing build artifacts"
cd $ARTIFACTS_DIR
tar -zcvf $ARTIFACTS_DIR *
echo "check file exists"
ls | grep $ARTIFACTS_FILE
echo "uploading to transfer.sh"
curl --upload-file $ARTIFACTS_FILE https://transfer.sh/$ARTIFACTS_FILE